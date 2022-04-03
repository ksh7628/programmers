import java.util.*;

public class Solution_lv2_가장큰수 {
	public String solution(int[] numbers) {
		String[] str = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			str[i] = Integer.toString(numbers[i]);
		}

		// 내림차순으로 정렬
		// -> 두 문자열을 붙이는 순서를 다르게 해서 비교
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return (s2 + s1).compareTo(s1 + s2);
			}
		});

		// 0으로 시작할 경우 뒤에도 전부 0
		// -> 0이 2개 이상 붙으면 안됨
		if (str[0].equals("0")) {
			return "0";
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length; i++) {
			sb.append(str[i]);
		}
		return sb.toString();
	}
}
