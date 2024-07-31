package Lec14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class AsteroidCollision {
	public static List<Integer> asteroidCollision(int[] asteroids) {
		// write your code here
		Stack<Integer> st = new Stack<>();
		for (int a : asteroids) {
			if (a > 0) {
				// moving in right
				// if stack contains 0-ve values they cant collide
				// since current Asteroid is moving twd right -> No collision
				st.push(a);
			} else {
				// -ive asteroid
				// a is moving in left direction
				while (!st.isEmpty() && st.peek() > 0 && st.peek() < (-1 * a)) {
					// -ve asteroid will be destroying the +ve ones
					st.pop();
				}

				// peek is equal to current asteroid -> destroyed both
				if (!st.isEmpty() && st.peek() > 0 && st.peek() == (-1 * a)) {
					st.pop();
				} else if (!st.isEmpty() && st.peek() > 0 && st.peek() > (-1 * a)) {
					// peek value will destroy the current element
					// do not add the current number
					continue;
				} else {
					// st is empty or peek elements are moving in left dirn and curr num is also -ve
					st.add(a);
				}
			}
		}

		List<Integer> res = new ArrayList<>();
		if (st.isEmpty()) {
			res.add(-1);
		} else {
//			stack is having some elements
			while (!st.isEmpty()) {
				res.add(st.pop());
			}
			 // reverse the asteroids to get the asteroids in correct order
			Collections.reverse(res); // O(n)
		}
		return res;
	}
}
