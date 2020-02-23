/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.ArrayList;
import java.util.Comparator;

import javax.lang.model.element.Element;
import javax.swing.text.Position;

//import LinkedBinaryTree.Node;

/**
 * An implementation of a priority queue using an array-based heap.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class LinkedHeapPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {
  /** primary collection of priority queue entries */
  protected ArrayList<Entry<K,V>> heap = new ArrayList<>();
  protected LinkedBinaryTree<Entry<K,V>> tree = new LinkedBinaryTree<>();
  protected LinkedBinaryTree<Integer> tree2 = new LinkedBinaryTree<>();

  /** Creates an empty priority queue based on the natural ordering of its keys. */
  public LinkedHeapPriorityQueue() { super(); }

  /**
   * Creates an empty priority queue using the given comparator to order keys.
   * @param comp comparator defining the order of keys in the priority queue
   */
  public LinkedHeapPriorityQueue(Comparator<K> comp) { super(comp); }



  /**
   * Creates a priority queue initialized with the respective
   * key-value pairs.  The two arrays given will be paired
   * element-by-element. They are presumed to have the same
   * length. (If not, entries will be created only up to the length of
   * the shorter of the arrays)
   * @param keys an array of the initial keys for the priority queue
   * @param values an array of the initial values for the priority queue
   */
  /*public LinkedHeapPriorityQueue(K[] keys, V[] values) {
    super();
    for (int j=0; j < Math.min(keys.length, values.length); j++)
      heap.add(new PQEntry<>(keys[j], values[j]));
    heapify();
  }*/

  // protected utilities

 // /** Exchanges the entries at indices i and j of the array list. 
  protected void swap(int i, int j) {
    //tree.tempNode=tree.getNode(tree.root,i);
    //System.out.println("deneme"+tree.getNode(tree.root,i).getIndex()+ "deneme2"+tree.getNode(tree.root,j).getIndex());
    Entry<K,V> temp = tree.getNode(tree.root,i).getElement();
    Entry<K,V> temp2 = tree.getNode(tree.root,j).getElement();
    tree.setNode(tree.getNode(tree.root,i),temp2);
    tree.setNode(tree.getNode(tree.root,j),temp);
  }//*///

  /** Moves the entry at index j higher, if necessary, to restore the heap property. 
  protected void upheap(int j) {
    while (j > 0) {            // continue until reaching root (or break statement)
      int p = parent(j);
      if (compare(heap.get(j), heap.get(p)) >= 0) break; // heap property verified
      swap(j, p);
      j = p;                                // continue from the parent's location
    }
  }*/

  ///** Moves the entry at index j lower, if necessary, to restore the heap property.
  protected void downheap(int j) {

    while (tree.getNode(tree.root,j).getLeft()!=null) {  
      //System.out.println("otto");             // continue to bottom (or break statement)
      int leftIndex = tree.getNode(tree.root,j).getLeft().getIndex();
      int smallChildIndex = leftIndex;     // although right may be smaller
      if (tree.getNode(tree.root,j).getRight()!=null) {
        //System.out.println("otto2"); 
          int rightIndex = tree.getNode(tree.root,j).getRight().getIndex();
          if (compare(tree.getNode(tree.root,leftIndex).getElement(), tree.getNode(tree.root,rightIndex).getElement()) > 0)
            smallChildIndex = rightIndex;  // right child is smaller
      }
      if (compare(tree.getNode(tree.root,smallChildIndex).getElement(), tree.getNode(tree.root,j).getElement()) >= 0)
        break;                             // heap property has been restored
      swap(j, smallChildIndex);
      j = smallChildIndex;                 // continue at position of the child
    }
  }// */

  ///** Performs a bottom-up construction of the heap in linear time. 
  protected void heapify() {
    int startIndex = tree.size()-1;    // start at PARENT of last entry
    for (int j=startIndex; j >= 0; j--)   // loop until processing the root
      downheap(j);
  }
  int sizee;
  protected void insert2(ArrayList asd){
    if(tree2.size()==0)
      tree2.addRoot((Integer)asd.get(0));
    for(int i=1;i<asd.size();i++){
      if(i%2==1){
        tree2.addLeft(tree2.getNode(tree2.root,(i-1)/2),(Integer)asd.get(i));
      }
      if(i%2==0)
        tree2.addRight(tree2.getNode(tree2.root,(i-2)/2),(Integer)asd.get(i));
    }
     sizee=tree2.size();
  }
  
  protected void heapify2() {   // start at PARENT of last entry
    for (int j=tree2.size(); j > 0; j--)   // loop until processing the root
      downheap2(j);
  }
  protected void downheap2(int j) {
    while (tree2.getNode(tree2.root,j).getLeft()!=null) {  
      //System.out.println("otto");             // continue to bottom (or break statement)
      int leftIndex = tree2.getNode(tree2.root,j).getLeft().getIndex();
      int smallChildIndex = leftIndex;     // although right may be smaller
      if (tree2.getNode(tree2.root,j).getRight()!=null) {
        //System.out.println("otto2"); 
          int rightIndex = tree2.getNode(tree2.root,j).getRight().getIndex();
          if ((Integer)tree2.getNode(tree2.root,leftIndex).getElement()>(Integer)tree2.getNode(tree2.root,rightIndex).getElement())
            smallChildIndex = rightIndex;  // right child is smaller
      }
      if ((Integer)tree2.getNode(tree2.root,smallChildIndex).getElement()> (Integer)tree2.getNode(tree2.root,j).getElement())
        break;                             // heap property has been restored
      swap(j, smallChildIndex);
      j = smallChildIndex;                 // continue at position of the child
    }
  }
//*/
  // public methods

  /**
   * Returns the number of items in the priority queue.
   * @return number of items
   */
  @Override
  public int size() {
    return tree.size(); }

  /**
   * Returns (but does not remove) an entry with minimal key.
   * @return entry having a minimal key (or null if empty)
 
  @Override*/
  public Entry<K,V> min() {
   // if (heap.isEmpty()) return null;
    return tree.root.getElement();
  }

  /**
   * Inserts a key-value pair and return the entry created.
   * @param key     the key of the new entry
   * @param value   the associated value of the new entry
   * @return the entry storing the new key-value pair
   * @throws IllegalArgumentException if the key is unacceptable for this queue
   */
  @Override
  public Entry<K,V> insert(K key, V value) throws IllegalArgumentException {
   
    Entry<K,V> newest = new PQEntry<>(key, value);
    //tree.addRoot(newest);
      if((Integer)key<0)
        System.err.println("HATALI");
      else{
          if(size()==0)
            tree.addRoot(newest);
          else{ 
            //System.out.println("asd"); 
              if(tree.last_node.getIndex()%2==1){
               // System.out.println("RightEkledi");
                  tree.addRight(tree.last_node.getParent(),newest);
                  //System.out.println(tree.last_node.getIndex());
              }
              else if(tree.last_node.getIndex()==0){
                //System.out.println("RootaLeftEkledi");
                  tree.addLeft(tree.root,newest);
              }
              else{
                    if(Math.log10(size()+1)/Math.log10(2)-Math.floor(Math.log10(size()+1)/Math.log10(2))==0){
                      tree.tempNode=tree.root;
                      for(int i=1;i<Math.log10(size()+1)/Math.log10(2);i++){
                        tree.tempNode=tree.tempNode.getLeft();
                      }
                      //System.out.println("index:"+tree.tempNode.getIndex()+"RightenSonraBaşaEkledi");
                      tree.addLeft(tree.tempNode,newest);
                      //System.out.println("hasan:"+tree.last_node.getIndex());
                     
                     // System.out.println("index:"+tree.last_node.getIndex());
                    }
                    else{
                      int count=0;
                      //System.out.println(tree.last_node.getIndex());
                      tree.tempNode=tree.last_node;
                      while(tree.tempNode.getParent().getIndex()%2==0){
                        tree.tempNode=tree.tempNode.getParent();
                        count++;
                      }
                      tree.tempNode=tree.tempNode.getParent();
                      tree.tempNode=tree.tempNode.getParent();
                      tree.tempNode=tree.tempNode.getRight();
                      if(tree.tempNode.getLeft()!=null)
                      tree.tempNode=tree.tempNode.getLeft();
                      for(int i=1;i<count;i++){
                        tree.tempNode=tree.tempNode.getRight();
                      }
                      //System.out.println(tree.last_node.getIndex());
                      tree.addLeft(tree.tempNode,newest);

                    }
              }
            }
          
      }
    return newest;
  }
  public int insert22(int newest) throws IllegalArgumentException {
   
    //tree.addRoot(newest);
      if(newest<0)
        System.err.println("HATALI");
      else{
          if(size()==0){
            tree2.addRoot(newest);
            tree2.last_node2=tree2.root;
          }
          else{ 
            //System.out.println("asd"); 
              if(tree2.last_node2.getIndex()%2==1){
               // System.out.println("RightEkledi");
               tree2.addRight(tree2.last_node2.getParent(),newest);
                  //System.out.println(tree.last_node.getIndex());
              }
              else if(tree2.last_node2.getIndex()==0){
                //System.out.println("RootaLeftEkledi");
                tree2.addLeft(tree2.root,newest);
              }
              else{
                    if(Math.log10(size()+1)/Math.log10(2)-Math.floor(Math.log10(size()+1)/Math.log10(2))==0){
                      tree2.tempNode=tree2.root;
                      for(int i=1;i<Math.log10(size()+1)/Math.log10(2);i++){
                        tree2.tempNode=tree2.tempNode.getLeft();
                      }
                      //System.out.println("index:"+tree.tempNode.getIndex()+"RightenSonraBaşaEkledi");
                      tree2.addLeft(tree2.tempNode,newest);
                      //System.out.println("hasan:"+tree.last_node.getIndex());
                     
                     // System.out.println("index:"+tree.last_node.getIndex());
                    }
                    else{
                      int count=0;
                      //System.out.println(tree.last_node.getIndex());
                      tree2.tempNode=tree2.last_node2;
                      while(tree2.tempNode.getParent().getIndex()%2==0){
                        tree2.tempNode=tree2.tempNode.getParent();
                        count++;
                      }
                      tree2.tempNode=tree2.tempNode.getParent();
                      tree2.tempNode=tree2.tempNode.getParent();
                      tree2.tempNode=tree2.tempNode.getRight();
                      if(tree2.tempNode.getLeft()!=null)
                      tree2.tempNode=tree2.tempNode.getLeft();
                      for(int i=1;i<count;i++){
                        tree2.tempNode=tree2.tempNode.getRight();
                      }
                      //System.out.println(tree.last_node.getIndex());
                      tree2.addLeft(tree2.tempNode,newest);
                    }
              }
            }
          
      }
    return newest;
  }
  /**
   * Removes and returns an entry with minimal key.
   * @return the removed entry (or null if empty)
 */
  @Override
  public Entry<K,V> removeMin() {
    Entry<K,V> rootEntry=tree.root.getElement();
    Entry<K,V> lastNodeEntry=tree.last_node.getElement();
    //System.out.println("node"+lastNodeEntry.getKey());
    tree.root.setElement(lastNodeEntry);
    tree.last_node.setElement(rootEntry);
    Entry<K,V> newest;
    if(tree.last_node.getIndex()%2==0){
      //System.out.println("RigthSilindi");
        tree.tempNode=tree.last_node;
        tree.last_node=tree.last_node.getParent().getLeft();
        newest=tree.tempNode.getElement();
         tree.remove(tree.tempNode);
    }
    else if(tree.last_node.getIndex()==0){
      //System.out.println("Root silindi");
      newest=tree.root.getElement();
         tree.remove(tree.root);
    }
    else{
      //System.out.println("buradayız");
      if(Math.log10(size())/Math.log10(2)-Math.floor(Math.log10(size())/Math.log10(2))==0){
        tree.tempNode=tree.root;
        for(int i=1;i<Math.log10(size())/Math.log10(2);i++){
          tree.tempNode=tree.tempNode.getRight();
        }
          tree.tempNode2=tree.last_node;
          tree.last_node=tree.tempNode;
          //System.out.println(tree.last_node.getIndex());
          newest=tree.tempNode2.getElement();
          tree.remove(tree.tempNode2);
      }
      else{
        int count=0;
        tree.tempNode=tree.last_node;
        while(tree.tempNode.getParent().getIndex()%2==1){
          tree.tempNode=tree.tempNode.getParent();
          count++;
        }
        tree.tempNode=tree.tempNode.getParent();
        tree.tempNode=tree.tempNode.getParent();
        tree.tempNode=tree.tempNode.getLeft();
        tree.tempNode=tree.tempNode.getRight();
        for(int i=0;i<count;i++){
          tree.tempNode=tree.tempNode.getRight();
        }
        newest=tree.last_node.getElement();
          tree.remove(tree.last_node);
          tree.last_node=tree.tempNode;
      }
    }
    upheap();
    return newest;
  }
  public int removeMinInt() {
   // System.out.println("index: "+tree2.last_node.getIndex());
    int rootEntry=tree2.root.getElement();
   int lastNodeEntry=tree2.last_node.getElement();
    //System.out.println("node"+lastNodeEntry.getKey());
    tree2.root.setElement(lastNodeEntry);
    tree2.last_node.setElement(rootEntry);
    int newest;
    if(tree2.last_node.getIndex()%2==0){
      //System.out.println("RigthSilindi");
      tree2.tempNode=tree2.last_node;
      tree2.last_node=tree2.last_node.getParent().getLeft();
        newest=tree2.tempNode.getElement();
        tree2.remove(tree2.tempNode);
    }
    else if(tree2.last_node.getIndex()==0){
      //System.out.println("Root silindi");
      newest=tree2.root.getElement();
      tree2.remove(tree2.root);
    }
    else{
      //System.out.println("buradayız");
      if(Math.log10(size())/Math.log10(2)-Math.floor(Math.log10(size())/Math.log10(2))==0){
        tree2.tempNode=tree2.root;
        for(int i=1;i<Math.log10(size())/Math.log10(2);i++){
          tree2.tempNode=tree2.tempNode.getRight();
        }
        tree2.tempNode2=tree2.last_node;
        tree2.last_node=tree2.tempNode;
          //System.out.println(tree.last_node.getIndex());
          newest=tree2.tempNode2.getElement();
          tree2.remove(tree2.tempNode2);
      }
      else{
        int count=0;
        tree2.tempNode=tree2.last_node;
        while(tree2.tempNode.getParent().getIndex()%2==1){
          tree2.tempNode=tree2.tempNode.getParent();
          count++;
        }
        tree2.tempNode=tree2.tempNode.getParent();
        tree2.tempNode=tree2.tempNode.getParent();
        tree2.tempNode=tree2.tempNode.getLeft();
        tree2.tempNode=tree2.tempNode.getRight();
        for(int i=0;i<count;i++){
          tree2.tempNode=tree2.tempNode.getRight();
        }
        newest=tree2.last_node.getElement();
        tree2.remove(tree2.last_node);
        tree2.last_node=tree2.tempNode;
      }
    }
    upheap2();
    return newest;
  }
  public void upheap(){
    tree.tempNode=tree.root;
    Entry<K,V> roott=tree.tempNode.getElement();
    //System.out.println(roott.getKey());
    while(tree.tempNode.getLeft()!=null){
      Entry<K,V> leftt=tree.tempNode.getLeft().getElement();
      Entry<K,V> rightt;
      if(tree.tempNode.getRight()!=null){
        rightt=tree.tempNode.getRight().getElement();
        if((Integer)rightt.getKey()<(Integer)leftt.getKey() && (Integer)rightt.getKey()<(Integer)roott.getKey()){
          tree.tempNode.setElement(rightt);
          tree.tempNode.getRight().setElement(roott);
          tree.tempNode=tree.tempNode.getRight();
        }else if((Integer)rightt.getKey()>(Integer)leftt.getKey() && (Integer)leftt.getKey()<(Integer)roott.getKey()){
          tree.tempNode.setElement(leftt);
          tree.tempNode.getLeft().setElement(roott);
          tree.tempNode=tree.tempNode.getLeft();
        }
        else
          break;
      }
    }
  }
  public void upheap2(){
    tree2.tempNode=tree2.root;
    int roott=tree2.tempNode.getElement();
    //System.out.println(roott.getKey());
    while(tree2.tempNode.getLeft()!=null){
      int leftt=tree2.tempNode.getLeft().getElement();
      int rightt;
      if(tree2.tempNode.getRight()!=null){
        rightt=tree2.tempNode.getRight().getElement();
        if((Integer)rightt<(Integer)leftt && (Integer)rightt<(Integer)roott){
          tree2.tempNode.setElement(rightt);
          tree2.tempNode.getRight().setElement(roott);
          tree2.tempNode=tree2.tempNode.getRight();
        }else if((Integer)rightt>(Integer)leftt&& (Integer)leftt<(Integer)roott){
          tree2.tempNode.setElement(leftt);
          tree2.tempNode.getLeft().setElement(roott);
          tree2.tempNode=tree2.tempNode.getLeft();
        }
        else
          break;
      }
    }
  }

  public void printNode(){
    for(int i=0;i<tree.size();i++){
    Entry<K,V> newest = tree.getNode(tree.root,i).getElement();
    System.out.println("i: "+i+" "+newest.getKey());
    }
  }
  public void printNode2(){
    for(int i=0;i<tree2.size();i++){
    Integer newest = tree2.getNode(tree2.root,i).getElement();
    System.out.println("a: "+i+" "+newest);
    }
  }

  public void heapify3(ArrayList asd,int k,int l,int add){
      if(tree2.getHeight(tree2.root)==l)
       // break;
      for(int i=asd.size()-1;i>0+add;i--){
        int smallIndex=i;
        if(i%2==0){
        if((Integer)asd.get(smallIndex) > (Integer)asd.get(i-1)){
          smallIndex=i-1;
        }
        if((Integer)asd.get(smallIndex)<(Integer)asd.get((i-2)/2)){
            Integer temp=(Integer)asd.get(smallIndex);
            asd.set(smallIndex,(Integer)asd.get((i-2)/2));
            asd.set((i-2)/2,temp);
        }
        System.out.println("küçük: 2==0 "+smallIndex);
      }
        else{
          if((Integer)asd.get(smallIndex) > (Integer)asd.get(i+1)){
            smallIndex=i+1;
          }
          if((Integer)asd.get(smallIndex)<(Integer)asd.get((i-1)/2)){
              Integer temp=(Integer)asd.get(smallIndex);
              asd.set(smallIndex,(Integer)asd.get((i-1)/2));
              asd.set((i-1)/2,temp);
          }
          System.out.println("küçük: 2==1 "+smallIndex);
        }
        i--;
      }
      add=asd.size()/k;
      heapify3(asd,k*2,l++,add);
  }
  public void heapify4(int count){
      if(count!=0){
      tree2.compare2(tree2.last_node);
      prevLastNode();
      heapify4(tree2.last_node.getIndex());
    }else 
        return ;
  }
  public void prevLastNode(){
    if(tree2.last_node.getIndex()%2==0){
      //System.out.println("RigthSilindi");
      tree2.tempNode=tree2.last_node;
      tree2.last_node=tree2.last_node.getParent().getLeft();
    }
    else if(tree2.last_node.getIndex()==0){
        System.out.println("root");
    }
    else{
      System.out.println("buradayız"+sizee);
      if(Math.log10(sizee)/Math.log10(2)-Math.floor(Math.log10(sizee)/Math.log10(2))==0){
        //System.out.println("cabbar");
        tree2.tempNode=tree2.root;
        for(int i=1;i<Math.log10(sizee)/Math.log10(2);i++){
          tree2.tempNode=tree2.tempNode.getRight();
        }
        tree2.tempNode2=tree2.last_node;
        tree2.last_node=tree2.tempNode;
          //System.out.println(tree.last_node.getIndex());
      }
      else{
        int count=0;
        tree2.tempNode=tree2.last_node;
        while(tree2.tempNode.getParent().getIndex()%2==1){
          tree2.tempNode=tree2.tempNode.getParent();
          count++;
        }
        tree2.tempNode=tree2.tempNode.getParent();
        tree2.tempNode=tree2.tempNode.getParent();
        tree2.tempNode=tree2.tempNode.getLeft();
        tree2.tempNode=tree2.tempNode.getRight();
        for(int i=0;i<count;i++){
          tree2.tempNode=tree2.tempNode.getRight();
        }
        tree2.last_node=tree2.tempNode;
      }
    }
    sizee--;
  }

  public ArrayList findKSmallest(ArrayList asd,int k){
    for(int i=0;i<k;i++){
      asd.add(removeMinInt());
    }
    return asd;
  }

}
