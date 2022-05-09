package chap04;

import java.util.Arrays;

public class Test2 {

	public static void main(String[] args) {
		String animals ="dog,cat,bear,lion,tiger";
		String[] arr = animals.split(",");
		System.out.println(Arrays.toString(arr));
		
		System.out.println(String.join(",", arr));
	}

}
