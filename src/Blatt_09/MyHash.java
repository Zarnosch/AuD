package Blatt_09;

import java.io.*;

public class MyHash {
   public class BucketArray {
    // do not change because of Backendtest
	protected String[] arr;
	protected int col;

	public BucketArray(int size) {
		col = 0;
		arr = new String[size];
	}

	public boolean insert(int pos, String s) {
		if (arr[pos] == null) {
			arr[pos] = s;
			return true;
		}
		col++;
		return false;
	}

	public int getCollisions() {
		return col;
	}

	public String toString() {
		String res = new String();

		for (String s : arr)
			res += s + "\n";

		return res;
	}
   }

   public BucketArray e;  // use only this array!!
   int size;

   public MyHash(int size) {
	this.size = size;
	e = new BucketArray(size);
   }

   public void insert(String s) {
	   int insertionpoint = 0;
	   int j = 1;
	   byte[] temp = s.getBytes();
	   for(int i = 0; i < temp.length; i++){
		   insertionpoint += temp[i];
		   insertionpoint *= temp[i];
		   if(i > 0 && i < temp.length - 1){
			   insertionpoint += temp[i];
			   insertionpoint *= temp[i];
		   }
		   else{
			   insertionpoint *= 2011 * temp[i];
		   }
	   }
		  // Quadratisches sondieren mit einer Primzahl die relativ nah an der Array-Größe ist
	   while(e.arr[Math.abs(insertionpoint%e.arr.length)] != null){
		   e.col++;
		   insertionpoint += 2011*j;
	   }
	   
	   insertionpoint = Math.abs(insertionpoint % e.arr.length);
	   e.insert(insertionpoint, s);
   }
   
   public static void main(String[] args) {
      // Idea for test
	int size = 1249;  // only an example (backend test)
	MyHash hash = new MyHash(size);
	try {
	   DataInput s = new DataInputStream(new FileInputStream("C:/Users/Anonym/Documents/GitHub/Eclipse_Workspace/AuD/src/ww1.txt"));
	   String line;
	   while ((line = s.readLine()) != null) {
		hash.insert(line);
	   }
        } catch (IOException e) {
		System.out.println("File not found");
	}
	System.out.println(hash.e.toString());
	System.out.println("Collisions: " + hash.e.getCollisions() + "\n");
   }
}
