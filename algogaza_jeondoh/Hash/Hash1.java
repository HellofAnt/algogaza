package Hash;

import java.util.*;
// TODO 2020/07/19 by jeondoh
// 완주하지 못한 선수
// 정확성 50 효율성 50
// https://programmers.co.kr/learn/courses/30/lessons/42576
public class Hash1 {
    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        // 생각한 방법 2가지
        // 1. 배열 SORT 해서 FOR문 > 동명이인일때 contain써서 존재시 continue; 불일치시 답 리턴
        // 2. 참여한 선수들을 HashMap에 PUT > FOR문 돌리면서 완주한 선수로 초기화 > 초기화시 완주하지 못한사람 map.getOrDefault을 이용해 값 세팅
        // HashMap을 keySet으로 FOR문 돌리며 return값 추출
        // 밑에건 2번방법 > 채점후 해설보니 다들 이렇게 품..
        Map<String, Integer> resultMap = new HashMap<String, Integer>();
        String answer = "";
        // participant > 참여한 선수이름 배열
        for(String part : participant){
        // 동명이인이 있으면 RETURN 2, 없으면 RETURN 1 (참여한 선수 전체 MAP에 PUT)
            resultMap.put(part, resultMap.getOrDefault(part, 0) + 1);
        }
        // completion > 완주한 선수이름 배열
        for(String compl : completion){
        // 참여한 선수이름들이 담긴 MAP에서 완주한 선수이름을 차례로 가져와서 다시 MAP에 PUT한다.
        // 가져오면서 다시 값을 세팅 ( 동명이인 OR 완주하지 못한사람 RETURN 1, 참여선수 & 완주선수 중복값 RETURN 0 )
            resultMap.put(compl, resultMap.get(compl) - 1);
        }
        // MAP FOR문 돌려서
        for(String result : resultMap.keySet()){
            int resultKey = resultMap.get(result);
            if(resultKey==1){
                answer = result;
                break;
            }
        }
        return answer;
    }
}