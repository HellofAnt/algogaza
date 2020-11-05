package programmers;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class hash {
    public static void main(String[] args) {
       String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa", "filipa","filipa","filipa","filipa"};
       String[] completion = {"marina", "josipa", "nikola", "filipa", "vinko","filipa","filipa","filipa"};
       HashSolution solution = new HashSolution();
       System.out.println(solution.solution(participant, completion));
    }
}


class HashSolution {
    public String solution(String[] participant, String[] completion) {
        /* 효율성 테스트 실패 
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < participant.length; i++){
            sb.append("/");
            sb.append(participant[i]);

        }
        String appendedParticipant = sb.toString();
        for(int i = 0; i < completion.length; i++){
            appendedParticipant = appendedParticipant.replaceFirst("/" + completion[i] + "/","/");

        }
        answer = appendedParticipant.replace("/", "");
        return answer; */

        String answer = "";
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < participant.length; i++) {
            map.put(participant[i],map.getOrDefault(participant[i], 0) + 1);
        }
        for (int j = 0; j < completion.length; j++) {
            map.put(completion[j], map.get(completion[j]) - 1);
        }
        for (String key : map.keySet()) {
            if(map.get(key) == 1){
                answer = key;
            }
        }
        return answer;
    }
}