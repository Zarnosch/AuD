package Blatt_09;

import java.util.ArrayList;

public class IceBox{
	ArrayList<Food> [] table_;
	int size_;
	int capacity_;
	int collisions_;

	public IceBox(){
		table_ = new ArrayList[10];
		size_ = 0;
		capacity_ = 10;
		collisions_ = 0;
	}
	public IceBox(int capacity){
		table_ = new ArrayList[capacity];
		size_ = 0;
		capacity_ = capacity;
		collisions_ = 0;
	}

	public void add(Food obj) {
		int insertionpoint = obj.hashCode()%capacity_;
		if(table_[insertionpoint] == null){
			table_[insertionpoint] = new ArrayList<Food>();
		}
			table_[insertionpoint].add(obj);				
	}
	
	public boolean contains(Food obj) {
		int insertionpoint = obj.hashCode()%capacity_;
		if(table_[insertionpoint].contains(obj)){
		return true;
		}
		else return false;

	}
	public static void main(String[] args) {
		// Le Food
		Food apfel = new Food("Obst","Apfel", 5);
		Food kiwi = new Food("Obst","Kiwi", 5);
		Food gurke = new Food("Obst","Gurke", 5);
		Food salat = new Food("Obst","Salat", 5);
		Food fleisch = new Food("Fleisch","Rinderhack", 20);
		Food käse = new Food("Milchprodukt","Käse", 50);
		Food brot = new Food("Backware","Brot", 1);
		Food döner = new Food("FastFood","Döner", 20);
		// Le Box
		IceBox box = new IceBox();
		//Befüllen
		box.add(apfel);
		box.add(döner);
		box.add(brot);
		box.add(käse);
		box.add(fleisch);
		box.add(salat);
		box.add(gurke);
		box.add(kiwi);
		System.out.println(box.contains(apfel));
		System.out.println(box.contains(döner));
	}
}