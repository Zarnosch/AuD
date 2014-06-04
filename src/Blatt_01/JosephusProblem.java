package Blatt_01;

import Blatt_01.Queue;



public class JosephusProblem {
	public static <T> Queue<T> josephus(T[] children, int numbSyl) {
		Queue<T> circle = new Queue<T> ();
		Queue<T> rest = new Queue<T> ();

		for (int i = 0; i<children.length; i++)
		{
			circle.enqueue(children[i]);
		}

		for (int i = 0; circle.is_empty() == false;)
		{
			if (i!= numbSyl - 1)
			{
				T x = circle.dequeue(); 
				circle.enqueue(x);
				System.out.println(circle);
				i++;
			}
			else 
			{
				T y = circle.dequeue();
				rest.enqueue(y);
				i = 0;
			}
		}
		return rest;
	}
	public static void main(String[] args) {
		Integer list []  = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		int syl = 7;
		System.out.println(josephus(list, syl));
	}
}