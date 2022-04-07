class Solution_lv2_삼각달팽이 {
	public int[] solution(int n) {
		int S = n * (n + 1) / 2;
		// 동, 북서, 남
		int[] dx = { 0, -1, 1 };
		int[] dy = { 1, -1, 0 };
		int[] answer = new int[S];
		int[][] arr = new int[n][n];
		
		// i행 0열은 i + 1로 고정 
		for (int i = 0; i < n; i++) {
			arr[i] = new int[i + 1];
			arr[i][0] = i + 1;
		}

		int x = n - 1, y = 0, d = 0;
		int num = n, len = n - 1;

		// num이 n까지의 합이 될때까지 수행
		while (num != S) {
			for (int i = 0; i < len; i++) {
				x += dx[d];
				y += dy[d];
				arr[x][y] = ++num;
			}

			// 길이 하나씩 줄임
			--len;
			if (++d == 3) {
				d = 0;
			}
		}

		int idx = 0;
		// 순서대로 저장
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				answer[idx++] = arr[i][j];
			}
		}

		return answer;
	}
}