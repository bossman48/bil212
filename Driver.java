public class Driver {
	public static void main(String[] args){
		LinkedBST<Integer> bt=new LinkedBST<>();
		bt.insert(8);
		bt.insert(16);
		bt.insert(4);
		bt.insert(2);
		bt.insert(6);
		bt.insert(20);
		bt.insert(12);
		bt.insert(2);
		System.out.println(bt.size());
		System.out.println(bt.contains(13));
		System.out.println(bt.contains(8));
		bt.toStringInOrder();
		System.out.println();
		bt.toStringPreOrder();
	}
}