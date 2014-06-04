package Blatt_03;

import aud.DList;

public class MyDList<T> extends DList<T> {
   public MyDList() {
      super();
   }
   public void append(MyDList<T> li) {
      // TODO: implementation
	   for(T element : li){
		   this.push_back(element);
	   }
   }

   public void insert(int n, MyDList<T> li) {
      // TODO: implementation
	   for(T element : li){
		   this.insert(n, element);
		   n++;
	   }

   }

   public static void main(String[] args) {
      // TODO: implementation
	   	MyDList<Integer> lineOne = new MyDList<>();
	   	for(int i = 0; i < 10; i++){
	   		lineOne.push_front(0+i);
	   	}
	   	
	   	MyDList<Integer> lineTwo = new MyDList<>();
	   	for(int i = 0; i < 10; i++){
	   		lineTwo.push_front(100+i);
	   	}
	   	
	   	System.out.println(lineOne.toString());
	   	//lineOne.append(lineTwo);
	   	System.out.println(lineOne.toString());
	   	lineOne.insert(3, lineTwo);
	   	System.out.println(lineOne);
   }
}
