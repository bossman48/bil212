import java.util.ArrayList;

public class Driver {

public static void main(String[] args) {
   /* HeapPriorityQueue new2=new HeapPriorityQueue();
    new2.insert(2,"A");
    new2.insert(3,"B");
    new2.insert(4,"C");
    new2.insert(10,"K");
    System.out.println(new2.hasLeft(0));
    System.out.println(new2.max());
    LinkedBinaryTree<Integer> asd=new LinkedBinaryTree<>();
    asd.addRoot(12);
    System.out.println(Math.log10(8)/Math.log10(2));*/
    LinkedHeapPriorityQueue linkedHeap=new LinkedHeapPriorityQueue();
    linkedHeap.insert(20, "I");
    linkedHeap.insert(19, "U");
    linkedHeap.insert(18, "Y");
    linkedHeap.insert(17, "T");
    linkedHeap.insert(16, "R");
    linkedHeap.insert(15, "E");
    linkedHeap.insert(14, "W");
    linkedHeap.insert(13, "Q");

   
  
    //linkedHeap.heapify();
    linkedHeap.printNode();
    linkedHeap.removeMin();
    linkedHeap.removeMin();
    linkedHeap.removeMin();
    System.out.println();
    linkedHeap.printNode();

    LinkedHeapPriorityQueue2 linkedHeap2=new LinkedHeapPriorityQueue2();
    linkedHeap2.insert(20, "I");
    linkedHeap2.insert(19, "U");
    linkedHeap2.insert(18, "Y");
    linkedHeap2.insert(17, "T");
    linkedHeap2.insert(16, "R");
    linkedHeap2.insert(15, "E");
    linkedHeap2.insert(14, "W");
    linkedHeap2.insert(13, "Q");
    linkedHeap2.insert(12, "K");
    linkedHeap2.insert(2, "O");
    linkedHeap2.insert(1, "p");
    linkedHeap2.insert(3, "l");
    linkedHeap2.heapify();
    System.out.println("osman onur"+linkedHeap2.tree.root.getLeft().getIndex());
    linkedHeap2.printNode();
    linkedHeap2.removeMin();
    linkedHeap2.removeMin();
    linkedHeap2.removeMin();
    System.out.println();
    linkedHeap2.printNode();
    //System.out.println(linkedHeap2.tree.path);

    ArrayList<Integer> asd=new ArrayList<>();
    for(int i=0;i<63;i++){
        asd.add(62-i);
    }
    //System.out.println(asd.get(1));
    for(int i=0;i<asd.size()-1;i++){
        System.out.println(("i :"+i+" "+asd.get(i)));
    }
    //linkedHeap.heapify3(asd);
    System.out.println("osman");
    //linkedHeap.insert2(asd);
    linkedHeap.tree2.insertLevelOrder(asd, linkedHeap.tree2.root, 0);
    System.out.println("otto"+linkedHeap.tree2.root.getLeft());
    linkedHeap.sizee=linkedHeap.tree2.size();
    System.out.println(linkedHeap.sizee+"   " +linkedHeap.tree2.size());
    linkedHeap.heapify4(linkedHeap.tree2.size());
    System.out.println("lastnode:"+linkedHeap.tree2.last_node.getIndex());
    linkedHeap.printNode2();
    linkedHeap.tree2.arrange_last_node(linkedHeap.tree2.size()-1);
    ArrayList<Integer> das=new ArrayList<>();
    linkedHeap.findKSmallest(das, 3);
    for(int i=0;i<das.size();i++){
        System.out.println(("i :"+i+" "+das.get(i)));
    }
    /*System.out.println(linkedHeap.tree2.getHeight(linkedHeap.tree2.root));
    System.out.println(linkedHeap.tree2.getNodeHeight(linkedHeap.tree2.root));*/
    //linkedHeap.heapify2();*/
    
    
//BAK Bİ

}
}