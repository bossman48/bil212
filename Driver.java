public class Driver {
	public static void main(String[] args){
		TreeMap<Integer,Integer> t=new TreeMap<>();
		t.put(40, 40);
		t.put(20, 20);
		t.put(60, 60);
		t.put(50, 50);
		t.put(70, 70);
		t.put(65, 65);
		System.out.println();
		t.display();
		t.rotateL(t.root());
		System.out.println();
		t.display();
		
		AVLTreeMap<Integer,Integer> avl=new AVLTreeMap<>();
		avl.put(10,10);
		avl.put(11,11);
		avl.put(12,12);
		avl.put(13,14);
		System.out.println(avl.get(13));
		avl.remove(13);

		 

	}
}