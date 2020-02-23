public class LinkedBST<E> implements SimpleBST {

	  //---------------- nested Node class ----------------
	  /** Nested static class for a binary tree node. */
	  protected static class Node<E> implements Position<E> {
	    private E element;          // an element stored at this node
	    private Node<E> parent;     // a reference to the parent node (if any)
	    private Node<E> left;       // a reference to the left child (if any)
	    private Node<E> right;      // a reference to the right child (if any)

	    /**
	     * Constructs a node with the given element and neighbors.
	     *
	     * @param e  the element to be stored
	     * @param above       reference to a parent node
	     * @param leftChild   reference to a left child node
	     * @param rightChild  reference to a right child node
	     */
	    public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
	      element = e;
	      parent = above;
	      left = leftChild;
	      right = rightChild;
	    }

	    public String toString() {
	    	return "" + getElement();
	    }
	    
	    // accessor methods
	    public E getElement() { return element; }
	    public Node<E> getParent() { return parent; }
	    public Node<E> getLeft() { return left; }
	    public Node<E> getRight() { return right; }

	    // update methods
	    public void setElement(E e) { element = e; }
	    public void setParent(Node<E> parentNode) { parent = parentNode; }
	    public void setLeft(Node<E> leftChild) { left = leftChild; }
	    public void setRight(Node<E> rightChild) { right = rightChild; }
	  } //----------- end of nested Node class -----------
	  
	  /** Factory function to create a new node storing element e. */
	  protected Node<E> createNode(E e, Node<E> parent,
	                                  Node<E> left, Node<E> right) {
	    return new Node<E>(e, parent, left, right);
	  }
	  
	  /** The root of the binary tree */
	  protected Node<E> root = null;     // root of the tree

	  /** The number of nodes in the binary tree */
	  private int size = 0;              // number of nodes in the tree
	  
	  public LinkedBST(){
		  root=new Node<E>(null,null,null,null);
	  }
	  
	  @Override
	  public int size() {
		  return size;
	  }

	  @Override
	  public boolean isEmpty() {
		  return size()==0;
	  }
	  @Override
	  public boolean contains( Comparable element){
		  String target=element.toString();
		  return containsAux(root,target);
	  }
	  public boolean containsAux(Node<E> node,String target){
			if(node==null){
				//System.err.println("Bu node bos");
				return false;
			}
			else{
			if(node.getElement().toString().compareTo(target)<0){
					return containsAux(node.getLeft(),target);
			}
			else if(node.getElement().toString().compareTo(target)>0){
					return containsAux(node.getRight(),target);
			}
			else 
				return true;
		}
	  }

	  @Override
	  public void insert(Comparable element) {
		  if(root.getElement()==null){
			  root.setElement((E)element);
			  size++;
		  }
		  else
			  insertAux(root,element);
	  }

	  private void insertAux(Node<E> node,Comparable element){
		  if(element.compareTo(node.getElement())<0)
			  if(node.getLeft()==null){
				  Node<E> l=createNode((E)element,node,null,null);
				  node.setLeft(l);
				  size++;
			  }
			  else{
				  node=node.getLeft();
				  insertAux(node,element);
			  }
		  else if(element.compareTo(node.getElement())>0)
			  if(node.getRight()==null){
				  Node<E> r=createNode((E)element,node,null,null);
				  node.setRight(r);
				  size++;
			  }
			  else{
				  node=node.getRight();
				  insertAux(node,element);
			  }
		  else{
			  System.out.println("Duplicate!");
		  }
	  }
	  
	  @Override
	  public String toStringInOrder() {
		  toStringInOrderAux(root);
		  return null;
	  }
	  
	  private void toStringInOrderAux(Node<E> node){
		  if(node!=null){
			  toStringInOrderAux(node.getLeft());
			  System.out.print(node.getElement()+" ");
			  toStringInOrderAux(node.getRight());
		  }
	  }

	  @Override
	  public String toStringPreOrder() {
		  toStringPreOrderAux(root);
		  return null;
	  }
	  
	  private void toStringPreOrderAux(Node<E> node){
		  if(node!=null){
			  System.out.print(node.getElement()+" ");
			  toStringPreOrderAux(node.getLeft());
			  toStringPreOrderAux(node.getRight());
		  }
	  }
}