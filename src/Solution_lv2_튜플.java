import java.util.*;
import java.util.Map.Entry;

class Solution_lv2_튜플 {
	// 1. 입력 문자열을 파싱
	// 2. 숫자 빈도별로 맵에 저장 후 내림차순으로 해당 숫자들을 배열에 저장
	public int[] solution(String s) {
		// 숫자 별 빈도수를 저장하는 해쉬맵
		Map<Integer, Integer> hm = new HashMap<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < s.length() - 1; i++) {
			char c = s.charAt(i);

			if (c == '{' || c == '}') {
				continue;
			}

			sb.append(c);
		}

		StringTokenizer st = new StringTokenizer(sb.toString(), ",");
		while (st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			if (hm.containsKey(num)) {
				hm.put(num, hm.get(num) + 1);
			} else {
				hm.put(num, 1);
			}
		}

		int[] answer = new int[hm.size()];
		List<Entry<Integer, Integer>> list = new ArrayList<>(hm.entrySet());

		Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});

		int idx = 0;
		for (Entry<Integer, Integer> entry : list) {
			answer[idx++] = entry.getKey();
		}

		return answer;
	}
}