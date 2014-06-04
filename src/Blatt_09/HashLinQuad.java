package Blatt_09;

import org.apache.batik.apps.rasterizer.Main;

public class HashLinQuad {

	private int[] table;
	private int size; // current number of elements
	private int capacity;
	private int collisions;

	public HashLinQuad(){
		this.collisions = 0;
		this.capacity = 20;
		table = new int[20];
	}
	public HashLinQuad(int capacity){
		this.collisions = 0;
		this.capacity = capacity;
		table = new int[capacity];
	
	}
	public int addLin(int obj){
		int insertionpoint = obj%capacity;
		int i = 1;
		while(table[insertionpoint] != 0){
			this.collisions ++;
			insertionpoint += 1;
			insertionpoint %= capacity;
			if(i > capacity){
				return collisions;
			}
		}
		table[insertionpoint] = obj;
		return collisions;
	}
	public int addQuad(int obj){
		int insertionpoint = obj%capacity;
		int i = 1;
		while(table[insertionpoint] != 0){
			insertionpoint += i;
			insertionpoint %= capacity;
			this.collisions ++;
			if(i > capacity){
				return collisions;
			}
		}
		table[insertionpoint] = obj;
		return collisions;
	}
	
	public String toSting(){
		String str ="[";
		for(int i = 0; i < this.capacity; i++){
			str += this.table[i] + ", ";
		}
		return str += "]";
	}

	public static void main(String[] args) {
		HashLinQuad test1 = new HashLinQuad(1249);
		HashLinQuad test2 = new HashLinQuad(1249);
		//Linear
		int c1 = 0;
		for(int i = 0; i < test1.capacity; i++){
			c1 += test1.addLin(i+i);
		}
		System.out.println(test1.toSting());
		System.out.println("Linear collisions: " + c1);

		//Quadratic
		int c2 = 0;
		for(int i = 0; i < test2.capacity; i++){
			c2 += test2.addLin(i);
		}
		System.out.println(test2.toSting());
		System.out.println("Quadratic Collisions: " + c2);
			
	}
}
