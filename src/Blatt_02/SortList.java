package Blatt_02;

import aud.SList;

public class SortList<T extends Comparable<T>> {


	private SList<T> list;

	public String toString() {

		// could be usefull
		return list.toString();
	}

	public SortList() {
		// TODO: implementation
		list = new SList<>();
	}

	public boolean insert(T obj) {
		// TODO: implementation
		boolean temp = false;
		for(int i = 0; i < list.size(); i++){
			if(list.at(i).compareTo(obj) == 0){
				return false;
			}
			else if(list.at(i).compareTo(obj) == -1 && list.at(i+1).compareTo(obj) == 1){
				list.insert(i+1, obj);
				temp = true;
				break;
			}
		}
		return temp;
	}
	public static void main(String args[]) {
		SortList<Integer> testList = new SortList<Integer>(); 
		  
        Integer[] intList = {0,9,1,8,2,7,3,6,4,5,877654,1223456,1234444459,0,9,8,7,6,5,4,3,2,1,00}; 
  
        for (int i = 0; i < intList.length; i++) 
        { 
            testList.insert(intList[i]); 
        } 
  
        System.out.println(testList.toString()); 
	}
}
/*
	  vorbedingung: Liste darf nicht leer sein und platz des Elements ist noch nicht gefunden
 */