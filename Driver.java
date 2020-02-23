import java.util.Iterator;

public class Driver {
	public static void main(String[] args){
		AdjacencyMapGraph<String,String> adjacenyMapGraph = new AdjacencyMapGraph<>(true); // directed or undirected
		Vertex<String> ele201 = adjacenyMapGraph.insertVertex("ele201");
		Vertex<String> ele202 = adjacenyMapGraph.insertVertex("ele202");
		Vertex<String> ele231 = adjacenyMapGraph.insertVertex("ele231");
		Vertex<String> ele331 = adjacenyMapGraph.insertVertex("ele331");
		Edge<String> edge1 = adjacenyMapGraph.insertEdge(ele201,ele202,"ele202");
		Edge<String> edge2 = adjacenyMapGraph.insertEdge(ele201,ele231,"ele231"); 
		Edge<String> edge3 = adjacenyMapGraph.insertEdge(ele231,ele331,"ele331");
		Edge<String> edge4 = adjacenyMapGraph.insertEdge(ele202,ele331,"ele331");
		GraphAlgorithms graphAlgos =new GraphAlgorithms(); 
		Vertex<String> ele431 = adjacenyMapGraph.insertVertex("ele431");
		Edge<String> edge5 = adjacenyMapGraph.insertEdge(ele331,ele431,"ele431");
		System.out.println(adjacenyMapGraph.toString());
		Map<Vertex<String>,Edge<String>> forest=graphAlgos.DFSComplete(adjacenyMapGraph);
		int size=forest.size();
		/*while(size>0){
			System.out.println(forest.getKey());
			size--;
		}*/
		System.out.println();
		PositionalList<Edge<String>> list =graphAlgos.findPath(adjacenyMapGraph,ele202,ele431);
		if(list==null)
			System.out.println("PATH is not found");
		else
			for(Position<Edge<String>> p : list.positions())
				if(!p.equals(list.last()))
					System.out.print(p.getElement().getElement()+" -> ");
				else
					System.out.print(p.getElement().getElement());
		System.out.println();
	}
}