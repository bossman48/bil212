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
public class LinkedHeapPriorityQueue2<K,V> extends AbstractPriorityQueue<K,V> {
  /** primary collection of priority queue entries */
  protected ArrayList<Entry<K,V>> heap = new ArrayList<>();
  protected LinkedBinaryTree2<Entry<K,V>> tree = new LinkedBinaryTree2<>();

  /** Creates an empty priority queue based on the natural ordering of its keys. */
  public LinkedHeapPriorityQueue2() { super(); }

  /**
   * Creates an empty priority queue using the given comparator to order keys.
   * @param comp comparator defining the order of keys in the priority queue
   */
  public LinkedHeapPriorityQueue2(Comparator<K> comp) { super(comp); }



  /**
   * Creates a priority queue initialized with the respective
   * key-value pairs.  The two arrays given will be paired
   * element-by-element. They are presumed to have the same
   * length. (If not, entries will be created only up to the length of
   * the shorter of the arrays)
   * @param keys an array of the initial keys for the priority queue
   * @param values an array of the initial values for the priority queue
   */
  /*public LinkedHeapPriorityQueue2(K[] keys, V[] values) {
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
    return tree.root.getElement();//heap.get(0);
  }/*
  public int max(){
    if (heap.isEmpty()) return 0;
    return maxAux(0);
  }
  int max=0;
  public int maxAux(int k){
    //System.out.println(k+" : "+heap.get(k).getKey());
    if((Integer)heap.get(k).getKey()>max)
      max=(Integer)heap.get(k).getKey();
    if(hasLeft(k)){
      int left=left(k);
      if((Integer)heap.get(left).getKey()>max){
        max=(Integer)heap.get(left).getKey();
      }
       maxAux(left(k));
    }
    if(hasRight(k)){
      int right=right(k);
      if((Integer)heap.get(right).getKey()>max){
        max=(Integer)heap.get(right).getKey();
      }
        maxAux(right(k));
    }
    return max;
  }

  */

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
              if(tree.getNodeByPath(tree.last_path).getIndex()%2==1){
               // System.out.println("RightEkledi");
                  tree.addRight(tree.getNodeByPath(tree.last_path).getParent(),newest);
                  //System.out.println(tree.last_node.getIndex());
              }
              else if(tree.getNodeByPath(tree.last_path).getIndex()==0){
                //System.out.println("RootaLeftEkledi");
                  tree.addLeft(tree.root,newest);
              }
              else{
                    if(Math.log10(size()+1)/Math.log10(2)-Math.floor(Math.log10(size()+1)/Math.log10(2))==0){
                      tree.tempPath=tree.root.getPath();
                      for(int i=1;i<Math.log10(size()+1)/Math.log10(2);i++){
                        tree.tempPath=tree.getNodeByPath(tree.tempPath).getLeft().getPath();
                      }
                      //System.out.println("index:"+tree.tempNode.getIndex()+"RightenSonraBaşaEkledi");
                      tree.addLeft(tree.getNodeByPath(tree.tempPath),newest);
                      //System.out.println("hasan:"+tree.last_node.getIndex());
                     
                     // System.out.println("index:"+tree.last_node.getIndex());
                    }
                    else{
                      int count=0;
                      //System.out.println(tree.last_node.getIndex());
                      tree.tempPath=tree.last_path;
                      while(tree.getNodeByPath(tree.tempPath).getParent().getIndex()%2==0){
                        tree.tempPath=tree.getNodeByPath(tree.tempPath).getParent().getPath();
                        count++;
                      }
                      tree.tempPath=tree.getNodeByPath(tree.tempPath).getParent().getPath();
                      tree.tempPath=tree.getNodeByPath(tree.tempPath).getParent().getPath();
                      tree.tempPath=tree.getNodeByPath(tree.tempPath).getRight().getPath();
                      if(tree.getNodeByPath(tree.tempPath).getLeft()!=null)
                      tree.tempPath=tree.getNodeByPath(tree.tempPath).getLeft().getPath();
                      for(int i=1;i<count;i++){
                        tree.tempPath=tree.getNodeByPath(tree.tempPath).getRight().getPath();
                      }
                      //System.out.println(tree.last_node.getIndex());
                      tree.addLeft(tree.getNodeByPath(tree.tempPath),newest);

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
    Entry<K,V> lastNodeEntry=tree.getNodeByPath(tree.last_path).getElement();
    //System.out.println("node"+lastNodeEntry.getKey());
    tree.root.setElement(lastNodeEntry);
    tree.getNodeByPath(tree.last_path).setElement(rootEntry);
    Entry<K,V> newest;
    if(tree.getNodeByPath(tree.last_path).getIndex()%2==0){
      //System.out.println("RigthSilindi");
        tree.tempPath=tree.getNodeByPath(tree.last_path).getPath();
        tree.last_path=tree.getNodeByPath(tree.last_path).getParent().getLeft().getPath();
        newest=tree.getNodeByPath(tree.tempPath).getElement();
         tree.remove(tree.getNodeByPath(tree.tempPath));
    }
    else if(tree.getNodeByPath(tree.last_path).getIndex()==0){
      //System.out.println("Root silindi");
      newest=tree.root.getElement();
         tree.remove(tree.root);
    }
    else{
      //System.out.println("buradayız");
      if(Math.log10(size())/Math.log10(2)-Math.floor(Math.log10(size())/Math.log10(2))==0){
        tree.tempPath=tree.root.getPath();
        for(int i=1;i<Math.log10(size())/Math.log10(2);i++){
          tree.tempPath=tree.getNodeByPath(tree.tempPath).getRight().getPath();
        }
          tree.tempPath2=tree.getNodeByPath(tree.last_path).getPath();
          tree.last_path=tree.getNodeByPath(tree.tempPath).getPath();
          //System.out.println(tree.last_node.getIndex());
          newest=tree.getNodeByPath(tree.tempPath2).getElement();
          tree.remove(tree.getNodeByPath(tree.tempPath2));
      }
      else{
        int count=0;
        tree.tempPath=tree.getNodeByPath(tree.last_path).getPath();
        while(tree.getNodeByPath(tree.tempPath).getParent().getIndex()%2==1){
          tree.tempPath=tree.getNodeByPath(tree.tempPath).getParent().getPath();
          count++;
        }
        tree.tempPath=tree.getNodeByPath(tree.tempPath).getParent().getPath();
        tree.tempPath=tree.getNodeByPath(tree.tempPath).getParent().getPath();
        tree.tempPath=tree.getNodeByPath(tree.tempPath).getLeft().getPath();
        tree.tempPath=tree.getNodeByPath(tree.tempPath).getRight().getPath();
        for(int i=0;i<count;i++){
          tree.tempPath=tree.getNodeByPath(tree.tempPath).getRight().getPath();
        }
        newest=tree.getNodeByPath(tree.last_path).getElement();
          tree.remove(tree.getNodeByPath(tree.last_path));
          tree.last_path=tree.getNodeByPath(tree.tempPath).getPath();
      }
    }
    upheap();
    return newest;
  }
  public void upheap(){
    tree.tempPath=tree.root.getPath();
    Entry<K,V> roott=tree.getNodeByPath(tree.tempPath).getElement();
    while(tree.getNodeByPath(tree.tempPath).getLeft()!=null){
      Entry<K,V> leftt=tree.getNodeByPath(tree.tempPath).getLeft().getElement();
      Entry<K,V> rightt;
      if(tree.getNodeByPath(tree.tempPath).getRight()!=null){
        rightt=tree.getNodeByPath(tree.tempPath).getRight().getElement();
        if((Integer)rightt.getKey()<(Integer)leftt.getKey() && (Integer)rightt.getKey()<(Integer)roott.getKey()){
          tree.getNodeByPath(tree.tempPath).setElement(rightt);
          tree.getNodeByPath(tree.tempPath).getRight().setElement(roott);
          tree.tempPath=tree.getNodeByPath(tree.tempPath).getRight().getPath();
          System.out.println(tree.getNodeByPath(tree.tempPath).getIndex());
        }else if((Integer)rightt.getKey()>(Integer)leftt.getKey() && (Integer)leftt.getKey()<(Integer)roott.getKey()){
          tree.getNodeByPath(tree.tempPath).setElement(leftt);
          tree.getNodeByPath(tree.tempPath).getLeft().setElement(roott);
          tree.tempPath=tree.getNodeByPath(tree.tempPath).getLeft().getPath();
        }else{
          break;
        }
      }
      else{
        tree.tempPath=tree.getNodeByPath(tree.tempPath).getLeft().getPath();
      }
    }
  }

  public void printNode(){
    for(int i=0;i<tree.size();i++){
    Entry<K,V> newest = tree.getNode(tree.root,i).getElement();
    System.out.println("i: "+i+" "+newest.getKey());
    }
  }

  /*
  public int findNode(int root,int k){
    if(k<0)System.err.println("hata");
    if((Integer)heap.get(root).getKey()==k)
        return root;
    else{
      if(heap.get(left(root))!=null && findNode(left(root), k)!=0)
        return findNode(left(root), k);
      if(heap.get(right(root))!=null && findNode(right(root), k)!=0)
        return findNode(right(root), k);
        else 
          return 0;
    }
  }
  */
  /** Used for debugging purposes only 
  private void sanityCheck() {
    for (int j=0; j < heap.size(); j++) {
      int left = left(j);
      int right = right(j);
      if (left < heap.size() && compare(heap.get(left), heap.get(j)) < 0)
        System.out.println("Invalid left child relationship");
      if (right < heap.size() && compare(heap.get(right), heap.get(j)) < 0)
        System.out.println("Invalid right child relationship");
    }
  }*/


  public double getHeight(){
      return  Math.ceil(Math.log10(size())/Math.log10(2));
  }
}
