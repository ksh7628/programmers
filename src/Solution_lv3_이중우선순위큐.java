import java.util.*;

class Solution_lv3_이중우선순위큐 {
	public int[] solution(String[] operations) {
        int[] answer = new int[2];
        // key: 숫자, value: 숫자의 개수
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (int i = 0; i < operations.length; i++) {
            String[] in = operations[i].split(" ");
            int key = 0;
            
            switch (in[0]) {
            case "I":
                key = Integer.parseInt(in[1]);
                map.put(key, map.getOrDefault(key, 0) + 1);
                break;
            default:
                if (map.isEmpty()) {
                    continue;
                }

                if (Integer.parseInt(in[1]) == 1) {
                    key = map.lastKey();
                } else {
                    key = map.firstKey();
                }
                
                int cnt = map.get(key) - 1;
                // 해당 숫자를 모두 뽑았다면 맵에서 제거
                if (cnt == 0) {
                    map.remove(key);
                } else {
                    map.put(key, cnt);
                }
            }
        }
        
        if (map.isEmpty()) {
            return answer;
        }
        
        answer[0] = map.lastKey();
        answer[1] = map.firstKey();
        return answer;
    }
}