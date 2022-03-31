import java.util.*;

class Solution_lv2_주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
		Map<String, Integer> carMap = new HashMap<>();
		Map<String, Integer> timeMap = new TreeMap<>();

		for (int i = 0; i < records.length; i++) {
			String[] input = records[i].split(" ");
			String[] time = input[0].split(":");
			int h = Integer.parseInt(time[0]);
			int m = Integer.parseInt(time[1]);
			int t = 60 * h + m;

			// 입차 -> 차 번호와 주차시간 등록
			if (input[2].equals("IN")) {
				carMap.put(input[1], t);
				
				// 출차 -> 주차한 시간 timeMap에 누적, carMap에서 현재 차 번호 삭제
			} else {
				t -= carMap.get(input[1]);
				carMap.remove(input[1]);
				timeMap.put(input[1], timeMap.getOrDefault(input[1], 0) + t);
			}
		}

		int t = 23 * 60 + 59;
		// 출차 안된 차들의 주차한 시간 계산해서 timeMap에 누적
		for (String key : carMap.keySet()) {
			int time = t - carMap.get(key);
			timeMap.put(key, timeMap.getOrDefault(key, 0) + time);
		}

		int[] answer = new int[timeMap.size()];
		int i = 0;
		// 요금 정산
		for (String key : timeMap.keySet()) {
			t = timeMap.get(key);
			int money = t > fees[0] ? fees[1] + (int) Math.ceil(1.0 * (t - fees[0]) / fees[2]) * fees[3] : fees[1];
			answer[i++] = money;
		}

		return answer;
	}
}