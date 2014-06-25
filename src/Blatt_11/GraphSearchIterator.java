package Blatt_11;

import java.util.LinkedList;

import aud.Stack;
import aud.example.graph.*;
import aud.graph.AbstractEdge;

public class GraphSearchIterator extends MyGraph implements Iterable<MyNode> {
	
	GraphSearchIterator(boolean directed){
		super(directed);
	}
	public class DFSIterator implements java.util.Iterator<MyNode> {

		private Stack<MyNode> st = new Stack<MyNode>();
		private LinkedList<Integer> marked = new LinkedList<Integer>();
		DFSIterator(MyNode node) {
			st.push(node);
			marked.add(node.index());
		}

		public boolean hasNext() {
			return !st.is_empty();
		}

		public MyNode next() {
			MyNode temp = st.pop();
			for (AbstractEdge e: temp.graph().edges()) {
				if (temp.compareTo(e.source()) == 0) {
					MyNode d = (MyNode) e.destination();
					if (!marked.contains(d.index())) {
						st.push(d);
						marked.add(d.index());
					}
				} else if (temp.compareTo(e.destination()) == 0) {
					MyNode d = (MyNode) e.source();
					if (!marked.contains(d.index())) {
						st.push(d);
						marked.add(d.index());
					}
				}
			}
			return temp;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public DFSIterator iterator() {
		return new DFSIterator(getSomeNode());
	}

	public static void main(String args[]) {
		GraphSearchIterator g = new GraphSearchIterator(false);
		MyNode[] n = { new MyNode(), g.addNode(), g.addNode(), g.addNode(),
				g.addNode(), g.addNode(), g.addNode(), g.addNode(), g.addNode() };

		for (int i = 0; i < n.length; ++i)
			n[i].setLabel("" + i);

		g.addEdge(n[1], n[2]);
		g.addEdge(n[1], n[3]);
		g.addEdge(n[1], n[6]);
		g.addEdge(n[1], n[7]);
		g.addEdge(n[1], n[8]);
		g.addEdge(n[2], n[8]);
		g.addEdge(n[3], n[8]);
		g.addEdge(n[4], n[5]);
		g.addEdge(n[4], n[6]);
		g.addEdge(n[5], n[6]);
		g.addEdge(n[5], n[7]);
		g.addEdge(n[5], n[8]);
		
				
		for (MyNode node: g) {
			System.out.println(node.getLabel());
		}
	}
}
