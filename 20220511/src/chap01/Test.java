package chap01;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 3, 4 };
		int[] arr2 = { 0, 1, 2, 3, 4 };

		System.out.println(arr.equals(arr2));
		System.out.println(Arrays.equals(arr, arr2));

		String[][] str = { { "aaa", "bbb" }, { "AAA", "BBB" } };
		String[][] str2 = { { "aaa", "bbb" }, { "AAA", "BBB" } };
		System.out.println(str.equals(str2));
		System.out.println(Arrays.equals(str, str2));
		System.out.println(Arrays.deepEquals(str, str2)); // 2차원배열
	}
}
