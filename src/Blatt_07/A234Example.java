package Blatt_07;

import aud.A234Tree;
import aud.example.A234TreeExample;
import aud.util.DotViewer;

/*****************
answer a)
Ein 2-3-4 Baum enthält immer 1-3 Keys und hat 2, 3 oder 4 Kinder

answer b)
insertion1: 2, 6, 4, 14, 16, 8, 12, 20, 10, 18
Bottom up:

1) insert 2, 6, 4
	(2|4|6)

2) insert 14, 16:

       (4)
      
  (2)      (6|14|16)

3) insert 8, 12, 20:

       (4|14)
       
4) insert 10:

       (4|8|12)
       
  (2)    (6)    (10|12)   (16|20)

5) insert 18

               (8)
              
       (4)              (14)
      
    (2)  (6)      (10|12)    (16|18|20)
_____________________________________________________
Top Down:
1)    
	(2|4|6)

2) insert 8, 10:

       4
   2       6,8,10

3) insert 12, 14:

      4,8
 2     6     10,12,14

4) insert 16:

     4,8,12
 2   6   10   14,16

5) insert 18

      8
  4       12
2    6   10   14,16,18

6) insert 20

        8
  4          12,16
2    6    10   14   18,20
       
			       		 
*********************/

public class A234Example {
   public static void main(String[] args) {
      // TODO: Test with DotViewer and SingleStepper
	   A234Tree treeBottomUp = new A234Tree();
	   treeBottomUp.insert(2);
	   treeBottomUp.checkConsistency();
	   treeBottomUp.insert(6);
	   treeBottomUp.checkConsistency();
	   treeBottomUp.insert(4);
	   treeBottomUp.checkConsistency();
	   treeBottomUp.insert(14);
	   treeBottomUp.checkConsistency();
	   treeBottomUp.insert(16);
	   treeBottomUp.checkConsistency();
	   treeBottomUp.insert(8);
	   treeBottomUp.checkConsistency();
	   treeBottomUp.insert(12);
	   treeBottomUp.checkConsistency();
	   treeBottomUp.insert(20);
	   treeBottomUp.checkConsistency();
	   treeBottomUp.insert(10);
	   treeBottomUp.checkConsistency();
	   treeBottomUp.insert(18);	   
	   treeBottomUp.checkConsistency();
	   
	   DotViewer.displayWindow(treeBottomUp, "treeBottomUp: 2, 6, 4, 14, 16, 8, 12, 20, 10, 18");
	   
	   A234Tree tree2= new A234Tree();
	   tree2.insert(2);
	   tree2.checkConsistency();
	   tree2.insert(4);
	   tree2.checkConsistency();
	   tree2.insert(6);
	   tree2.checkConsistency();
	   tree2.insert(8);
	   tree2.checkConsistency();
	   tree2.insert(10);
	   tree2.checkConsistency();
	   tree2.insert(12);
	   tree2.checkConsistency();
	   tree2.insert(14);
	   tree2.checkConsistency();
	   tree2.insert(16);
	   tree2.checkConsistency();
	   tree2.insert(18);
	   tree2.checkConsistency();
	   tree2.insert(20);	   
	   tree2.checkConsistency();
	   
	   DotViewer.displayWindow(tree2, "2, 4, 6, 8, 10, 12, 14, 16, 18, 20");
	   
	   
   }
}
