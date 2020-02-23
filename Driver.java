public class Driver {
	public static void main(String[] args){
		HeapPriorityQueue<Integer,Integer> heap=new HeapPriorityQueue<>();
		for(int i=0;i<15;i++)
			heap.insert(i+5,i);
		heap.printPreOrder();
		heap.lessThanOrEqual(9);

		System.out.println();
		System.out.println(heap.setKey(7,45)+"\n");
		heap.printPreOrder();
		System.out.println();
		heap.removeEntry(7);
		heap.printPreOrder();

		stringComparator comp=new stringComparator();
		HeapPriorityQueue<String,String> heapString=new HeapPriorityQueue<>(comp);

		for(int i=0;i<10;i++){
			heapString.insert(String.valueOf(i), String.valueOf(i));
		}
		System.out.println();
		heapString.printPreOrder();
		System.out.println();
		heapString.removeMin();
		heapString.removeMin();
		heapString.removeMin();
		heapString.printPreOrder();
		

	}
}