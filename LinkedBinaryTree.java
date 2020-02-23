import javafx.scene.Node;

public class LinkedBinaryTree < E > extends AbstractBinaryTree < E > {

  //---------------- nested Node class ----------------
  /** Nested static class for a binary tree node. */
  protected static class Node < E > implements Position < E > {
    private E element; // an element stored at this node
    private Node < E > parent; // a reference to the parent node (if any)
    private Node < E > nodeA; // a reference to the left child (if any)
    private Node < E > nodeC; // a reference to the right child (if any)
    private Node < E > nodeG;
    private Node < E > nodeT;
    private Node < E > nodeDol;
    private int level;
    /**
     * Constructs a node with the given element and neighbors.
     *
     * @param e  the element to be stored
     * @param above       reference to a parent node
     * @param leftChild   reference to a left child node
     * @param rightChild  reference to a right child node
     */
    public Node(E e, Node < E > above, Node < E > nodeA, Node < E > nodeC, Node < E > nodeG, Node < E > nodeT, Node < E > nodeDol,int level2) {
      element = e;
      parent = above;
      nodeA = nodeA;
      nodeC = nodeC;
      nodeG = nodeG;
      nodeT = nodeT;
      nodeDol = nodeDol;
      level=level2;
    }

    public String toString() {
      return "" + getElement();
    }
    public int getLevel() {
      return level;
    }

    // accessor methods
    public E getElement() {
      return element;
    }
    public Node < E > getParent() {
      return parent;
    }
    public Node < E > getNodeA() {
      return nodeA;
    }
    public Node < E > getNodeC() {
      return nodeC;
    }
    public Node < E > getNodeG() {
      return nodeG;
    }
    public Node < E > getNodeT() {
      return nodeT;
    }
    public Node < E > getNodeDol() {
      return nodeDol;
    }
    public boolean hasNodeA() {
      return nodeA != null;
    }
    public boolean hasNodeC() {
      return nodeC != null;
    }
    public boolean hasNodeG() {
      return nodeG != null;
    }
    public boolean hasNodeT() {
      return nodeT != null;
    }
    public boolean hasNodeDol() {
      return nodeDol != null;
    }

    // update methods
    public void setElement(E e) {
      element = e;
    }
    public void setLevel(int e) {
      level = e;
    }
    public void setParent(Node < E > parentNode) {
      parent = parentNode;
    }
    public void setNodeA(Node < E > leftChild) {
      nodeA = leftChild;
    }
    public void setNodeC(Node < E > rightChild) {
      nodeC = rightChild;
    }
    public void setNodeG(Node < E > parentNode) {
      nodeG = parentNode;
    }
    public void setNodeT(Node < E > leftChild) {
      nodeT = leftChild;
    }
    public void setNodeDol(Node < E > rightChild) {
      nodeDol = rightChild;
    }
  } //----------- end of nested Node class -----------

  /** Factory function to create a new node storing element e. */
  protected Node < E > createNode(E e, Node < E > parent, Node < E > nodeA, Node < E > nodeC, Node < E > nodeG, Node < E > nodeT, Node < E > nodeDol,int level2) {
    return new Node < E > (e, parent, nodeA, nodeC, nodeG, nodeT, nodeDol,level2);
  }

  // LinkedBinaryTree instance variables
  /** The root of the binary tree */
  protected Node < E > root = null; // root of the tree

  /** The number of nodes in the binary tree */
  private int size = 0; // number of nodes in the tree
  String parentString = "";

  // constructor
  /** Construts an empty binary tree. */
  public LinkedBinaryTree() {} // constructs an empty binary tree

  // nonpublic utility
  /**
   * Verifies that a Position belongs to the appropriate class, and is
   * not one that has been previously removed. Note that our current
   * implementation does not actually verify that the position belongs
   * to this particular list instance.
   *
   * @param p   a Position (that should belong to this tree)
   * @return    the underlying Node instance for the position
   * @throws IllegalArgumentException if an invalid position is detected
   */
  protected Node < E > validate(Position < E > p) throws IllegalArgumentException {
    if (!(p instanceof Node))
      throw new IllegalArgumentException("Not valid position type");
    Node < E > node = (Node < E > ) p; // safe cast
    if (node.getParent() == node) // our convention for defunct node
      throw new IllegalArgumentException("p is no longer in the tree");
    return node;
  }

  // accessor methods (not already implemented in AbstractBinaryTree)
  /**
   * Returns the number of nodes in the tree.
   * @return number of nodes in the tree
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Returns the root Position of the tree (or null if tree is empty).
   * @return root Position of the tree (or null if tree is empty)
   */
  @Override
  public Position < E > root() {
    return root;
  }

  /**
   * Returns the Position of p's parent (or null if p is root).
   *
   * @param p    A valid Position within the tree
   * @return Position of p's parent (or null if p is root)
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   */
  @Override
  public Position < E > parent(Position < E > p) throws IllegalArgumentException {
    Node < E > node = validate(p);
    return node.getParent();
  }


  public Position < E > nodeA(Position < E > p) throws IllegalArgumentException {
    Node < E > node = validate(p);
    return node.getNodeA();
  }
  public Position < E > right(Position < E > p) throws IllegalArgumentException {
    Node < E > node = validate(p);
    return node;
  }
  public Position < E > left(Position < E > p) throws IllegalArgumentException {
    Node < E > node = validate(p);
    return node;
  }
  public Position < E > nodeC(Position < E > p) throws IllegalArgumentException {
    Node < E > node = validate(p);
    return node.getNodeC();
  }
  public Position < E > nodeG(Position < E > p) throws IllegalArgumentException {
    Node < E > node = validate(p);
    return node.getNodeG();
  }
  public Position < E > nodeT(Position < E > p) throws IllegalArgumentException {
    Node < E > node = validate(p);
    return node.getNodeT();
  }
  public Position < E > nodeDol(Position < E > p) throws IllegalArgumentException {
    Node < E > node = validate(p);
    return node.getNodeDol();
  }


  public Position < E > addRoot(E e) throws IllegalStateException {
    if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
    root = createNode(e, null, null, null, null, null, null,0);
    size = 1;
    return root;
  }


  public Position < E > addNodeA(Position < E > p, E e)
  throws IllegalArgumentException {
    Node < E > parent = validate(p);
    if (parent.getNodeA() != null)
      throw new IllegalArgumentException("p already has a left child");
    Node < E > child = createNode(e, parent, null, null, null, null, null,parent.getLevel()+1);
    parent.setNodeA(child);
    size++;
    return child;
  }

  /**
   * Creates a new right child of Position p storing element e and returns its Position.
   *
   * @param p   the Position to the right of which the new element is inserted
   * @param e   the new element
   * @return the Position of the new element
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   * @throws IllegalArgumentException if p already has a right child
   */
  public Position < E > addNodeC(Position < E > p, E e)
  throws IllegalArgumentException {
    Node < E > parent = validate(p);
    if (parent.getNodeC() != null)
      throw new IllegalArgumentException("p already has a right child");
    Node < E > child = createNode(e, parent, null, null, null, null, null,parent.getLevel()+1);
    parent.setNodeC(child);
    size++;
    return child;
  }
  public Position < E > addNodeG(Position < E > p, E e)
  throws IllegalArgumentException {
    Node < E > parent = validate(p);
    if (parent.getNodeG() != null)
      throw new IllegalArgumentException("p already has a right child");
    Node < E > child = createNode(e, parent, null, null, null, null, null,parent.getLevel()+1);
    parent.setNodeG(child);
    size++;
    return child;
  }
  public Position < E > addNodeT(Position < E > p, E e)
  throws IllegalArgumentException {
    Node < E > parent = validate(p);
    if (parent.getNodeT() != null)
      throw new IllegalArgumentException("p already has a right child");
    Node < E > child = createNode(e, parent, null, null, null, null, null,parent.getLevel()+1);
    parent.setNodeT(child);
    size++;
    return child;
  }
  public Position < E > addNodeDol(Position < E > p, E e)
  throws IllegalArgumentException {
    Node < E > parent = validate(p);
    if (parent.getNodeDol() != null)
      throw new IllegalArgumentException("p already has a right child");
    Node < E > child = createNode(e, parent, null, null, null, null, null,parent.getLevel()+1);
    parent.setNodeDol(child);
    size++;
    return child;
  }

  /**
   * Replaces the element at Position p with element e and returns the replaced element.
   *
   * @param p   the relevant Position
   * @param e   the new element
   * @return the replaced element
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   */
  public E set(Position < E > p, E e) throws IllegalArgumentException {
    Node < E > node = validate(p);
    E temp = node.getElement();
    node.setElement(e);
    return temp;
  }

  /**
   * Attaches trees t1 and t2, respectively, as the left and right subtree of the
   * leaf Position p. As a side effect, t1 and t2 are set to empty trees.
   *
   * @param p   a leaf of the tree
   * @param t1  an independent tree whose structure becomes the left child of p
   * @param t2  an independent tree whose structure becomes the right child of p
   * @throws IllegalArgumentException if p is not a valid Position for this tree
   * @throws IllegalArgumentException if p is not a leaf
   */
  /*public void attach(Position<E> p, LinkedBinaryTree<E> t1,
                    LinkedBinaryTree<E> t2) throws IllegalArgumentException {
    Node<E> node = validate(p);
    if (isInternal(p)) throw new IllegalArgumentException("p must be a leaf");
    size += t1.size() + t2.size();
    if (!t1.isEmpty()) {                  // attach t1 as left subtree of node
      t1.root.setParent(node);
      node.setLeft(t1.root);
      t1.root = null;
      t1.size = 0;
    }
    if (!t2.isEmpty()) {                  // attach t2 as right subtree of node
      t2.root.setParent(node);
      node.setRight(t2.root);
      t2.root = null;
      t2.size = 0;
    }
                    }*/

  /**
   * Removes the node at Position p and replaces it with its child, if any.
   *
   * @param p   the relevant Position
   * @return element that was removed
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   * @throws IllegalArgumentException if p has two children.
   */
  public E remove(Position < E > p) throws IllegalArgumentException {
    Node < E > node = validate(p);
    Node < E > child;
    if (numChildren(p) == 5)
      throw new IllegalArgumentException("p has two children");
    if (node.getNodeA() != null) {
      child = node.getNodeA();
    } else if (node.getNodeC() != null) {
      child = node.getNodeC();
    } else if (node.getNodeG() != null) {
      child = node.getNodeG();
    } else if (node.getNodeT() != null) {
      child = node.getNodeT();
    } else {
      child = node.getNodeDol();
    }
    //Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight() );
    if (child != null)
      child.setParent(node.getParent()); // child's grandparent becomes its parent
    if (node == root)
      root = child; // child becomes root
    else {
      Node < E > parent = node.getParent();
      if (node == parent.getNodeA())
        parent.setNodeA(child);
      else if (node == parent.getNodeC())
        parent.setNodeC(child);
      else if (node == parent.getNodeG())
        parent.setNodeG(child);
      else if (node == parent.getNodeT())
        parent.setNodeT(child);
      else
        parent.setNodeDol(child);
    }
    size--;
    E temp = node.getElement();
    node.setElement(null); // help garbage collection
    node.setNodeA(null);
    node.setNodeC(null);
    node.setNodeG(null);
    node.setNodeT(null);
    node.setNodeDol(null);
    node.setParent(node); // our convention for defunct node
    return temp;
  }
  public Node<E> search2(String input){
    Node<E> asd=compare(root,input);
    if(asd==null){
      System.err.println("The sequence is not this tree");
      return null;
    }
      else  {
        return asd;
      }
  }
int yay=0;
  public Node<E> search(String input){
    yay=1;
    if(input.substring(input.length()-1).equals("$")){
      String asd2=input.substring(0,input.length()-1);
      Node<E> asd=compare(root,asd2);
      if(asd==null){
      System.err.println("The sequence is not this tree");
      return null;
    }
      else  {
        return asd;
      }
    }
    else{
      compare2(root,input);
    }
      return null;
  }
  

  Node< E > compare(Node < E > node, String input) {
    Node<E> k=null;
    String key=(String) node.getElement();
    if(input.equals(key)){
      if(yay==1){
        yay=0;
        System.out.println("Found  " + input);
      }
        return node;
    }
    else{
      if(k==null && node.hasNodeA()){
          k=compare(node.getNodeA(),input);
        }
      if(k==null && node.hasNodeC()){
         k=compare(node.getNodeC(), input);
      }if(k==null && node.hasNodeG()){
         k=compare(node.getNodeG(), input);
      }if(k==null && node.hasNodeT()){
          k=compare(node.getNodeT(), input);
      }if(k==null && node.hasNodeDol()){
          k=compare(node.getNodeDol(), input);
      }
    return k;
      }
  }
  void compare2(Node < E > node, String input) {
    Node<E> k=null;
    String deneme="";
    String key=(String) node.getElement();
    if(key==null)
      key="";
    if(key.length()>=input.length()){
    deneme=key.substring(0, input.length());
    //System.out.println("Deneme: "+deneme);
    if(input.equals(deneme)){
        System.out.println(key);
    }
    else{
      if(k==null && node.hasNodeA()){
          compare2(node.getNodeA(), input);
        }
      if(k==null && node.hasNodeC()){
         compare2(node.getNodeC(), input);
      }if(k==null && node.hasNodeG()){
         compare2(node.getNodeG(), input);
      }if(k==null && node.hasNodeT()){
          compare2(node.getNodeT(), input);
      }if(k==null && node.hasNodeDol()){
          compare2(node.getNodeDol(), input);
        }
      }
    }
    else{
     if(k==null && node.hasNodeA()){
          compare2(node.getNodeA(), input);
        }
      if(k==null && node.hasNodeC()){
         compare2(node.getNodeC(), input);
      }if(k==null && node.hasNodeG()){
         compare2(node.getNodeG(), input);
      }if(k==null && node.hasNodeT()){
          compare2(node.getNodeT(), input);
      }if(k==null && node.hasNodeDol()){
          compare2(node.getNodeDol(), input);
        }
    }
  }
  int k=0;
      int insert=0;
  void insertion(String input) {
    if(k==0){
      System.out.println("İnserted to level 0");
      k=1;
    }
      insertionAux(root,input,0);
  }
    void insertionAux(Node<E> node,String input,int k){
      insert=1;
      if(input.length()==k){
           addNodeDol(node, (E) input);
         }
      else{
         String input2=input.substring(k,k+1);
       // System.out.println( input+" : "+input2);
        if(input2.compareTo("A")==0){
          if(node.hasNodeA()){
            String nodeStr="";
            if(node.getNodeA().getElement()!=null)
              nodeStr=node.getNodeA().getElement().toString();
            //System.out.println(nodeStr);
           if(!nodeStr.equals("")){
            insertionAux(node.getNodeA(), nodeStr, k+1);
            insertionAux(node.getNodeA(),input,k+1);
            node.getNodeA().setElement(null);
           }
           else 
              node.getNodeA().setElement((E) input);
          }
          else
            addNodeA(node,(E) input);
        }
        else if(input2.compareTo("C")==0){
          if(node.hasNodeC()){
            String nodeStr="";
            if(node.getNodeC().getElement()!=null)
              nodeStr=node.getNodeC().getElement().toString();
            //System.out.println(nodeStr);
           if(!nodeStr.equals("")){
            insertionAux(node.getNodeC(), nodeStr, k+1);
            insertionAux(node.getNodeC(),input,k+1);
            node.getNodeC().setElement(null);
           }
           else 
              node.getNodeC().setElement((E) input);
          }
          else
            addNodeC(node, (E) input);
        }
        else if(input2.compareTo("G")==0){
          if(node.hasNodeG()){
            String nodeStr="";
            if(node.getNodeG().getElement()!=null)
              nodeStr=node.getNodeG().getElement().toString();
            //System.out.println(nodeStr);
           if(!nodeStr.equals("")){
            insertionAux(node.getNodeG(), nodeStr, k+1);
            insertionAux(node.getNodeG(),input,k+1);
            node.getNodeG().setElement(null);
           }
           else 
              node.getNodeG().setElement((E) input);
          }
          else
            addNodeG(node, (E) input);
        }
        else if(input2.compareTo("T")==0){
          if(node.hasNodeT()){
            String nodeStr="";
            if(node.getNodeT().getElement()!=null)
              nodeStr=node.getNodeT().getElement().toString();
            //System.out.println(nodeStr);
           if(!nodeStr.equals("")){
            insertionAux(node.getNodeT(), nodeStr, k+1);
            insertionAux(node.getNodeT(),input,k+1);
            node.getNodeT().setElement(null);
           }
           else 
              node.getNodeT().setElement((E) input);
          }
          else
            addNodeT(node, (E) input);
        }
        else{
          System.err.println("This not suitable type");
        }
    }
  } 

    void remove(String input){
        Node<E> sibling=null;
        Node<E> node=search2(input);
        if(node!=null){
        int numberofSibling=numberChild(node.parent);
        if(node!=null && numberofSibling==1)
        remove(node);
        else if(node!=null && numberofSibling>2)
        remove(node);
        else{
          sibling=findSibling(node);
          //System.out.println("Sibling's element : " +sibling.getElement());
          remove(node);
          String siblingStr=sibling.getElement().toString();
          //System.out.println(siblingStr);
          remove(sibling);
          insertion(siblingStr);

        }
      }
      
    }

    void display(){

      //System.out.println("Display");
      displayAux(root);
    }
     void displayLength(){
      //System.out.println("Display");
      displayLengthAux(root);
    }

    void displayAux(Node<E> node){
      int kasim=0;
      int levels=node.getLevel();
      String nodeStr="";
      if(node.getElement()!=null)
        nodeStr = node.getElement().toString();
     // System.out.println(node.getLevel());
        for(int i=0;i<node.getLevel();i++){
          System.out.print(".");
        }
        if(hasChild(node) && nodeStr.equals(""))
            System.out.println("I");
        else if(!hasChild(node) && nodeStr.equals("")) 
            System.out.println("E");
        else{
          System.out.println("["+node.getElement()+"]");
          kasim=1;
        }
          if(node.hasNodeA())
            displayAux(node.getNodeA());
          else if(kasim==0 ){
            for(int i=0;i<levels+1;i++){
            System.out.print(".");
        }System.out.println("E");
          }
          if(node.hasNodeC())
            displayAux(node.getNodeC());
          else if(kasim==0 ){
            for(int i=0;i<levels+1;i++){
            System.out.print(".");
        }System.out.println("E");
          }
          if(node.hasNodeG())
            displayAux(node.getNodeG());
          else if(kasim==0 ){
            for(int i=0;i<levels+1;i++){
            System.out.print(".");
        }System.out.println("E");
          }
          if(node.hasNodeT())
            displayAux(node.getNodeT());
          else if(kasim==0 ){
            for(int i=0;i<levels+1;i++){
            System.out.print(".");
        }System.out.println("E");
          }
          if(node.hasNodeDol())
            displayAux(node.getNodeDol());
          else if(kasim==0 ){
            for(int i=0;i<levels+1;i++){
            System.out.print(".");
        }System.out.println("E");
          }
      
    }
    void displayLengthAux(Node<E> node){
      int kasim=0;
      int levels=node.getLevel();
      String nodeStr="";
      int asd=0;
      if(node.getElement()!=null){
        nodeStr = node.getElement().toString();
         asd=nodeStr.length();
      }
        for(int i=0;i<node.getLevel();i++){
          System.out.print(".");
        }
        if(hasChild(node) && nodeStr.equals(""))
            System.out.println("I");
        else if(!hasChild(node) && nodeStr.equals("")) 
            System.out.println("E");
        else{
          System.out.println("["+node.getElement()+"]    "+asd);
          kasim=1;
        }
          if(node.hasNodeA())
            displayLengthAux(node.getNodeA());
          else if(kasim==0){
            for(int i=0;i<levels+1;i++){
            System.out.print(".");
        }System.out.println("E");
          }
          if(node.hasNodeC())
            displayLengthAux(node.getNodeC());
          else if(kasim==0){
            for(int i=0;i<levels+1;i++){
            System.out.print(".");
        }System.out.println("E");
          }
          if(node.hasNodeG())
            displayLengthAux(node.getNodeG());
          else if(kasim==0){
            for(int i=0;i<levels+1;i++){
            System.out.print(".");
        }System.out.println("E");
          }
          if(node.hasNodeT())
            displayLengthAux(node.getNodeT());
          else if(kasim==0){
            for(int i=0;i<levels+1;i++){
            System.out.print(".");
        }System.out.println("E");
          }
          if(node.hasNodeDol())
            displayLengthAux(node.getNodeDol());
          else if(kasim==0){
            for(int i=0;i<levels+1;i++){
            System.out.print(".");
        }System.out.println("E");
          }
      
    }
    void resize(Node<E> node){
      if(node.hasNodeA() && node.hasNodeC() && node.hasNodeG() && node.hasNodeT() && node.hasNodeDol()){
      if(node.getNodeA().getElement().toString().equals("") && node.getNodeC().getElement().toString().equals("") &&  node.getNodeG().getElement().toString().equals("")  && node.getNodeT().getElement().toString().equals("")  && node.getNodeDol().getElement().toString().equals("")){
        remove(node);
      }
      else {
        resize(node.getNodeA());
        resize(node.getNodeC());
        resize(node.getNodeG());
        resize(node.getNodeT());
      }
    }
    }
    boolean hasChild(Node<E> node){
      if(node.hasNodeA())
        return true;
      else if(node.hasNodeC())
        return true;
      else if(node.hasNodeG())
        return true;
      else if(node.hasNodeT())
        return true;
      else if(node.hasNodeDol())
        return true;
      else 
        return false;
    }
    int numberChild(Node<E> node){
      int k=0;
      if(node.hasNodeA())
        k++;
      if(node.hasNodeC())
        k++;
      if(node.hasNodeG())
        k++;
      if(node.hasNodeT())
        k++;
      if(node.hasNodeDol())
        k++;
        return k;
    }
    int childLevel(Node<E> node){
      Node<E> parent = node.parent;
      if(parent.hasNodeA())
        return parent.getNodeA().getLevel();
      else if(parent.hasNodeC())
        return parent.getNodeC().getLevel();
      else if(parent.hasNodeG())
        return parent.getNodeG().getLevel();
      else if(parent.hasNodeT())
        return parent.getNodeT().getLevel();
      else if(parent.hasNodeDol())
        return parent.getNodeDol().getLevel();
      else 
        return 0;
    }
    Node<E> findSibling(Node<E> node){
      Node<E> sibling=null;
      Node<E> parent=node.parent;
      if(parent.hasNodeA() && parent.getNodeA()!=node)
          sibling=parent.getNodeA();
      else if(parent.hasNodeC() && parent.getNodeC()!=node)
          sibling=parent.getNodeC();
      else if(parent.hasNodeG() && parent.getNodeG()!=node)
          sibling=parent.getNodeG();
      else if(parent.hasNodeT() && parent.getNodeT()!=node)
          sibling=parent.getNodeT();
      else if(parent.hasNodeDol() && parent.getNodeDol()!=node)
          sibling=parent.getNodeDol();
      else
        System.out.println("Not suitable sibling");
      return sibling;
    }
}