import java.util.*;

class Solution_lv2_메뉴리뉴얼 {
	// key: 메뉴 구성, value: 해당 메뉴 구성을 주문한 횟수
	Map<String, Integer> map;
	StringBuilder sb = new StringBuilder();

	public List<String> solution(String[] orders, int[] course) {
		List<String> answer = new ArrayList<>();

		// 조합을 구하기 위해 메뉴들을 정렬 시킨다
		for (int i = 0; i < orders.length; i++) {
			char[] c = orders[i].toCharArray();
			Arrays.sort(c);
			orders[i] = String.valueOf(c);
		}

		// 코스메뉴 구성을 모든 경우의 수를 고려해서 구한다
		for (int i = 0; i < course.length; i++) {
			map = new HashMap<>();
			int max = 0;

			for (int j = 0; j < orders.length; j++) {
				if (course[i] <= orders[j].length()) {
					comb(orders[j], course[i], 0, 0);
				}
			}

			for (String key : map.keySet()) {
				max = Math.max(max, map.get(key));
			}

			// 최소 2개 이상으로 구성된 코스요리 중, 가장 많이 주문한 메뉴만 리스트에 넣는다
			for (String key : map.keySet()) {
				int cnt = map.get(key);
				if (cnt >= 2 && cnt == max) {
					answer.add(key);
				}
			}
		}

		// 오름차순 정렬 후 리턴
		Collections.sort(answer);
		return answer;
	}

	/* 조합을 통해 메뉴 구성을 구한 후 map에 뽑은 메뉴와 횟수를 저장 */
	public void comb(String str, int len, int start, int cnt) {
		if (cnt == len) {
			map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
			return;
		}

		// sb에 메뉴를 추가하고 해당 재귀 탐색이 끝나면 추가한 메뉴를 제거
		// -> 백트래킹
		for (int i = start; i < str.length(); i++) {
			sb.append(str.charAt(i));
			comb(str, len, i + 1, cnt + 1);
			sb.delete(cnt, cnt + 1);
		}
	}
}