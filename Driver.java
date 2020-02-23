public class Driver {
	public static void main(String[] args){
		LinkedBinaryTree<Integer> bt=new LinkedBinaryTree<Integer>();
		bt.addRoot(10);
		Position<Integer> l=bt.addLeft(bt.root(), 11);
		Position<Integer> r=bt.addRight(bt.root(), 12);
		Position<Integer> num=bt.addLeft(l, 13);
		bt.addRight(l, 14);
		bt.addLeft(r, 15);
		bt.addRight(r, 16);
		bt.addLeft(num, 17);
		System.out.println(bt.preorder());
		System.out.println(bt.postorder());
		System.out.println(bt.inorder());
		System.out.println(bt.countInternalDescendants(bt.root()));
		System.out.println(bt.search(15));
		System.out.println(bt.sum(bt));
	}
}