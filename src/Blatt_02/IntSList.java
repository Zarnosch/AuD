package Blatt_02;

import aud.SList;
import Blatt_02.Predicate;

public class IntSList {
	SList<Integer> li;
	public IntSList() {
		li = new SList<Integer>();
	}
	public String toString() {
		return li.toString();
	}
	public void push_front(int obj){
		li.push_front(obj);
	}
	public IntSList filter(Predicate p){
		if (p==null) 
			throw new NullPointerException(); 

		IntSList predList = new IntSList(); 

		if (li.empty() == true) 
		{
			return predList; 
		} 

		SList<Integer>.Iterator iterator = li.iterator(); 
		while (iterator.hasNext()) 
		{ 
			Integer e = iterator.next(); 
			if (p.test(e)) 
				predList.push_front(e); 
		} 

		return predList; 
	}

	public static void main(String args[]) {
		// TODO: test
		int[] array = {85,72,93,81,74,42} ;
		IntSList list = new IntSList();
		Predicate even = new Predicate(){ 
			public boolean test(int element){return element % 2 == 0; } 
		}; 
		for(int i = 0; i < array.length; i++){
			list.push_front(array[i]);
		}
		IntSList filtered = new IntSList();
		filtered = list.filter(even);
		System.out.println(list.toString());
		System.out.println(filtered);
	}

}
