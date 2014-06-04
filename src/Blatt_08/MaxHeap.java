package Blatt_08;

import java.util.*;

public class MaxHeap<T extends Comparable<T>> {
	private ArrayList<T> heap;  // or Vector
	int size;
	public MaxHeap() {
		heap = new ArrayList();
		heap.add(null);
		size +=1;
		heap.add(null);
	}

	public MaxHeap(T[] a) {
		heap = new ArrayList(a.length+1);
		heap.add(null);
		for(int i = 1; i <= a.length; i++){
			heap.add(1, a[i-1]);
			size +=1;
//			downHeap(1);
		}
		for(int j = 1; j < a.length; j++){
			downHeap(j);
		}
	}	

	public ArrayList<T> getHeap(){
		return heap;
	}
	public int size() {
		return heap.size();
	}
	public boolean is_empty() {      
		return heap.get(1) == null;
	}
	public void downHeap(int k) {
		T x = heap.get(k);
		while(k <= (size/2)){
			int j = (2*k);
			if(j < size && heap.get(j).compareTo(heap.get(j+1)) < 0){
				j = j+1;								
			}
			if(x.compareTo(heap.get(j)) >= 0){
				break;
			}			
			heap.set(k, heap.get(j));
			k = j;			
		}
		heap.set(k, x);
	}
	public void insert(T obj) {
		size +=1;
		heap.add(size, obj);
		upHeap(size);
	}
	private void upHeap(int k) {
		T x = heap.get(k);
		while(k > 1 && x.compareTo(heap.get(k/2)) >= 1){
			heap.set(k, heap.get(k/2));
			k= k/2;
		}
		heap.set(k, x);
	}
	public void swapMax(){
		T temp = heap.get(1);
		heap.set(1, heap.get(size));
		heap.set(size, temp);
		this.size--;
	}
	public void heapSort(){
		for(int i = 1; i < this.size; ){
			this.swapMax();
			this.downHeap(i);
		}
	}

	public String toString() {
		String str = "[";
		for(int i = 1; i < heap.size(); i++){
			str += heap.get(i) + ", ";
		}
		str += "]";
		return str;
	}

	public static void main(String[] args) {
		String [] a = {"X", "T", "O", "G", "S", "M", "N", "A", "E", "R", "A", "I"};
		Integer[] b = {1, 2, 3, 4, 9, 6, 7, 8};
		MaxHeap herb = new MaxHeap(a);
		//		System.out.println(herb.is_empty());
		MaxHeap bo = new MaxHeap(b);
		//		System.out.println(herb.toString());
//		System.out.println(bo.toString());
//		bo.insert(10);
		System.out.println(bo.toString());
		bo.heapSort();
		System.out.println(bo.toString());
	}

}
