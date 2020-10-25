package programmers;
import java.util.Arrays;

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
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < participant.length; i++){
            sb.append("/");
            sb.append(participant[i]);

        }
        String appendedParticipant = sb.toString();
        for(int i = 0; i < completion.length; i++){
            appendedParticipant = appendedParticipant.replaceFirst("/" + completion[i],"");

        }
        answer = appendedParticipant.replace("/", "");
        return answer;
    }
}