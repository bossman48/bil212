import java.util.function.DoubleUnaryOperator;

public class DLLDriver {
	public static void main(String[] args) {
		DoublyLinkedList<String> dll = new DoublyLinkedList<>();
		dll.addFirst("A");
		dll.addFirst("B");
		dll.addLast("C");
		dll.addFirst("D");
		System.out.println(dll);
		dll.removeFirst();
		System.out.println("After removal of first:\n"+dll);
		dll.removeLast();
		System.out.println("After removal of last:\n"+dll);
		dll.addBefore("K",dll.getNode2(2));	
		System.out.println("After add before 2:\n"+dll);
		dll.removeBefore(dll.getNode2(2));
		System.out.println("After remove before 2:\n"+dll);
		dll.add2(2,"O");
		System.out.println("After add 2 O : \n"+dll);
		dll.remove(2);
		System.out.println("After remove 2 :\n"+dll);
		dll.add2(2,"Z");
		System.out.println("After add 2 Z : \n"+dll);
		dll.add2(2,"Y");
		System.out.println("After add 2 Y : \n"+dll);
		dll.removeEveryOther();
		System.out.println("After remove every other : \n"+dll);
	}
}
