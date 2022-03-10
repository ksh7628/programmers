import java.util.*;

class Solution_lv3_단어변환 {
	public static int solution(String begin, String target, String[] words) {
		Set<String> set = new HashSet<>();
		for (String s : words) {
			set.add(s);
		}

		// 타겟이 존재안하면 0
		if (!set.contains(target)) {
			return 0;
		}

		int answer = 0;
		Set<String> usedSet = new HashSet<>();
		ArrayDeque<String> q = new ArrayDeque<>();
		usedSet.add(begin);
		q.offer(begin);

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				String cur = q.poll();
				if (cur.equals(target)) {
					return answer;
				}

				for (String s : words) {
					if (usedSet.contains(s)) {
						continue;
					}

					int cnt = 0;
					for (int j = 0; j < cur.length(); j++) {
						if (cur.charAt(j) == s.charAt(j)) {
							cnt++;
						}
					}

					// 서로 다른 알파벳이 하나만 존재할 경우에만 바꿔서 탐색
					if (cnt == cur.length() - 1) {
						usedSet.add(s);
						q.offer(s);
					}
				}
			}

			answer++;
		}

		return answer;
	}

	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		System.out.println(solution(begin, target, words));
	}
}