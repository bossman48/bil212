import java.util.Set;
import java.util.HashSet;
import java.util.*;

/**
 * A collection of graph algorithms.
 */
public class GraphAlgorithms {
	
  /**
   * Performs depth-first search of the unknown portion of Graph g starting at Vertex u.
   *
   * @param g Graph instance
   * @param u Vertex of graph g that will be the source of the search
   * @param known is a set of previously discovered vertices
   * @param forest is a map from nonroot vertex to its discovery edge in DFS forest
   *
   * As an outcome, this method adds newly discovered vertices (including u) to the known set,
   * and adds discovery graph edges to the forest.
   */
  public static <V,E> void DFS(Graph<V,E> g, Vertex<V> u,
                    Set<Vertex<V>> known, Map<Vertex<V>,Edge<E>> forest) {
    known.add(u);                              // u has been discovered
    
    for (Edge<E> e : g.outgoingEdges(u)) {     // for every outgoing edge from u
      Vertex<V> v = g.opposite(u, e);
      if (!known.contains(v)) {
        forest.put(v, e);                      // e is the tree edge that discovered v
        DFS(g, v, known, forest);              // recursively explore from v
       // System.out.println(u.getElement());
      }
    }
  }

 

  /**
   * Performs DFS for the entire graph and returns the DFS forest as a map.
   *
   * @return map such that each nonroot vertex v is mapped to its discovery edge
   * (vertices that are roots of a DFS trees in the forest are not included in the map).
   */
  public static <V,E> Map<Vertex<V>,Edge<E>> DFSComplete(Graph<V,E> g) {
    Set<Vertex<V>> known = new HashSet<>();
    Map<Vertex<V>,Edge<E>> forest = new ProbeHashMap<>();
    for (Vertex<V> u : g.vertices()){
      if (!known.contains(u))
        DFS(g, u, known, forest);   
        System.out.println(u.getElement());         // (re)start the DFS process at u
    }
    return forest;
  }

 /**
   * Returns an ordered list of edges comprising the directed path from u to v.
   * If v is unreachable from u, or if u equals v, an empty path is returned.
   *
   * @param g Graph instance
   * @param u Vertex beginning the path
   * @param v Vertex ending the path
   */
  public static <V,E> PositionalList<Edge<E>> findPath(Graph<V,E> g, Vertex<V> u, Vertex<V> v) {
	  LinkedPositionalList<Edge<E>> list =new LinkedPositionalList<>();
	  if(g.getEdge(u, v)!=null)
		  list.addLast(g.getEdge(u, v));
	  else{
		  Iterator<Edge<E>> edges= g.outgoingEdges(u).iterator();
		  while(edges.hasNext()){
			  Edge<E> edge=edges.next();
			  list.addLast(edge);
			  if(findPath(g,g.opposite(u,edge),v)!=null){
				  for(Position<Edge<E>> p : findPath(g,g.opposite(u,edge),v).positions())
					  list.addLast(p.getElement());	  
				  break;
			  }
			  else{
				  list.remove(list.last());
			  }
		  }
	  }
	  if(list.size()!=0)
		  return list;
	  return null;
  }
}