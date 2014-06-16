package Blatt_10;
/*
a)

8 -> 1(1) -> 2(1) -> 3(1) -> 5(1) -> 6(2) -> 7(2) -> 4(2)

Beim Startknoten begonnen, werden immer alle verknüpften Knoten
(aufsteigend) durchsucht. Ist der gesuchte Wert nicht dabei, wird
wieder mit dem kleinsten Knoten begonnen und die n?chsten abgesucht.
Ist der Knoten wieder nicht dabei, wiederholt sich der Algorithmus
bis der Wert gefunden wurde oder die Suche erfolglos war.

b)

Beim Startknoten angefangen, sucht der Algorithmus den n?chsten Knoten
mit dem kleinsten Wert. Von ihm aus wird wieder der n?chste kleinste
Knoten gesucht. Wenn es keinen weiteren KNoten mehr gibt, geht der
Algorithmus zur?ck bis zur letzten Verzweigung und durchsucht den
n?chst kleineren Knoten bis der Knoten gefunden wurde oder die Suche
erfolglos war.

8 -> 1 -> 2 (Sackgasse, zurück zur 1)
    1 -> 3 (Sackgasse, zurück zur 1)
    1 -> 6 -> 4 -> 5 -> 7 ( Ende, alle Werte durchsucht)
c)
 */
import aud.example.graph.*;

public class TBSuche
{
	public static MyNode Anfang;

	public static MyGraph graph()
	{
		MyGraph g = new MyGraph(false); // false weil ungerichteter Graph

		MyNode a = g.addNode();
		a.setLabel("1");
		MyNode b = g.addNode();
		b.setLabel("2");
		MyNode c = g.addNode();
		c.setLabel("3");
		MyNode d = g.addNode();
		d.setLabel("4");
		MyNode e = g.addNode();
		e.setLabel("5");
		MyNode f = g.addNode();
		f.setLabel("6");
		MyNode h = g.addNode();
		h.setLabel("7");
		MyNode i = g.addNode();
		i.setLabel("8");

		Anfang = i;

		g.addEdge(a, b);
		g.addEdge(a, c);
		g.addEdge(a, f);
		g.addEdge(a, h);
		g.addEdge(a, i);
		g.addEdge(b, i);
		g.addEdge(c, i);
		g.addEdge(d, e);
		g.addEdge(d, f);
		g.addEdge(e, f);
		g.addEdge(e, h);
		g.addEdge(e, i);

		return g;
	}

	public static void main(String args[])
	{
		TraversalExample tex = new TraversalExample();
		MyGraph g = graph();

		Traversal tsuche = new DepthFirstSearch(g); // Tiefensuche einfach rekursiv
		tsuche.singlestepper = tex;
		tex.traversal = tsuche;
		tsuche.nsteps = 1;

		tsuche.start(Anfang);
		tex.halt("Ende");

		g = graph();

		Traversal bsuche = new BreadthFirstSearch(g); // Breitensuche
		bsuche.singlestepper = tex;
		tex.traversal = bsuche;
		bsuche.nsteps = 1;

		bsuche.start(Anfang);
		tex.halt("Ende");

	}
}