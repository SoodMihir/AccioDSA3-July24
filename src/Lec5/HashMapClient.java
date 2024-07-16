package Lec5;

public class HashMapClient {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put(1, 5);
		map.put(2, 10);
		map.put(3, 15);

		System.out.println(map.get(3));
		System.out.println(map.get(4));
		System.out.println(map.containsKey(1));
		System.out.println(map.containsKey(100));
		System.out.println(map.get(1));
		map.put(1, 100);
		System.out.println(map.get(1));

		map.put(5, 5);
		map.put(9, 125);
		map.put(21, 655);
		map.put(17, 7655);
		map.put(25, 1115);
		map.put(121, 655);
		map.put(117, 7655);
		map.put(125, 1115);
		
		
	}

}
