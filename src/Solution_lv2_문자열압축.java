class Solution_lv2_문자열압축 {
	public int solution(String s) {
		int size = s.length();
		int answer = size;

		// 문자열을 크기 1 ~ size / 2 + 1까지 압축하면서 최소 길이를 구한다.
		// -> size가 홀수인 경우 나누어 떨어지지 않으므로 size / 2 + 1
		for (int i = 1; i < size / 2 + 1; i++) {
			// 이전 문자열
			String pre = s.substring(0, i);
			// 최종 압축한 문자열 길이, 압축된 문자열의 개수, 마지막 문자열 길이
			int len = 0, cnt = 1, last = 0;

			for (int j = i; j < size; j += i) {
				// 남은 문자열의 길이가 i보다 짧다면 남은 길이를 저장
				if (j + i > size) {
					last = s.substring(j).length();
					break;
				}

				// 같은 문자열
				// -> 압축 가능, 개수를 증가
				if (pre.equals(s.substring(j, j + i))) {
					cnt++;
					
					// 다른 문자열이라면 길이를 더하고 압축한 개수의 자릿수만큼 더해준다
					// -> Math.log10() 이용
				} else {
					len += i;
					if (cnt > 1) {
						len += (int) Math.log10(cnt) + 1;
						cnt = 1;
					}
					pre = s.substring(j, j + i);
				}
			}

			len += i + last;
			// 마지막으로 압축된 개수가 1을 넘는다면 개수의 자릿수만큼 더해준다
			if (cnt > 1) {
				len += (int) Math.log10(cnt) + 1;
			}
			answer = Math.min(answer, len);
		}

		return answer;
	}
}