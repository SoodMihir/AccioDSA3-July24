package Lec18;

public class SplitDemo {
	public static void main(String[] args) {
		String str = "1 2 3 4 5";
		String[] val = str.split(" ");
		for (String s : val) {
			System.out.println(s + " " + s.length());
		}
		System.out.println(val.length);
	}
}
