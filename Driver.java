public class Driver {
	public static void main(String[] args){
		TreeMap<Integer,Integer> t=new TreeMap<>();
		t.put(20, 200);
		t.put(10, 100);
		t.put(30, 300);
		t.put(8, 80);
		t.put(12, 120);
		t.put(24, 240);
		t.put(36, 360);
		t.display();
		t.remove(30);
		t.display();
		System.out.println(t.lastEntry());
		System.out.println(t.firstEntry());
		System.out.println(t.lowerEntry(24));
		System.out.println(t.floorEntry(24));
		System.out.println(t.ceilingEntry(8));
		System.out.println(t.higherEntry(8));
		System.out.println(t.subMap(12, 24));
		
		TreeMap<Integer,Integer> t2=new TreeMap<>();
		t2.put(20, 200);
		t2.display();
		t2.put(10, 100);
		t2.display();
		t2.put(30, 300);
		t2.display();
		t2.put(8, 80);
		t2.display();
		t2.put(12, 120);
		t2.display();
		t2.put(24, 240);
		t2.display();
		t2.put(36, 360);
		t2.display();
		t2.remove(30);
		t2.display();
		t2.remove(36);
		t2.display();
		System.out.println(t2.findKthLargest(2));
	}
}