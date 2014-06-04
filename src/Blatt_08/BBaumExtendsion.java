package Blatt_08;

import aud.BTree;
import aud.KTreeNode;
import aud.util.DotViewer;

public class BBaumExtendsion extends BTree {
	/********************
a. B-Baum mit m = 2 und der Höhe 3
Maximale Kinder 2m+1 = 5; Minimale Kinder m+1 = 3;

Maximale Schlüssel:
Höhe 1: 4
Höhe 2: 4*5 = 20
Höhe 3: 4*25 = 100
=> 124

Minimale Schlüssel:
Höhe 1: 1 
Höhe 2: 5 
Höhe 3: 11
=> 1 + 5 + 11 = 17




	 ********************/
int counter = 0;
int m_ = 0;
	public BBaumExtendsion(int m, int entries) {
		super(m);
		m_ = m;
		counter += entries;
	}

	public int height(){
		int height = 0;
		height = LogBaseX((counter+1)/2, m_);
		return height;
	}
	
	public static int LogBaseX(int x, int base){
       return (int) (Math.log(x) / Math.log(base));
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]  insertions = {7, 19, 23, 4, 12, 17, 8, 11, 2 , 9, 13};
		BBaumExtendsion tree = new BBaumExtendsion(64, insertions.length + 1000000);

		for(int i : insertions){
			tree.insert(i);
		}
		
		for( int i = 0; i < 1000000; i++){
			tree.insert(i);			
		}
		DotViewer.displayWindow(tree,  "7, 19, 23, 4, 12, 17, 8, 11, 2 , 9, 13");
//		System.out.println(tree.toString());
//		System.out.println(tree.toDot());
		System.out.println("Die Höhe ist: " + tree.height());
	}

}
