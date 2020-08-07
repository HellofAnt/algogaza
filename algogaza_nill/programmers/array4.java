package programmers;

import java.util.Arrays;

public class array4 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ci = {3,0,6,1,5};
        System.out.println(solution.solution(ci));
    }
}

        // 문제 잘못 알고 구상한 로직
        //citation 길이 구하고
        //citation 내림차순 정렬
        //citation 인자가 길이보가 크면 아웃
        //citation 인자의 수가 그 수 이상의 인자를 가진 인자들의 개수보다 작은것을 찾을때 retrun


class Solution{
    public int solution(int[] citations) {
        int answer = 0;
        int maxPossibleH_index = citations.length;
        Arrays.sort(citations);
        int[] reverseOrderCitations = new int[maxPossibleH_index];
        
        for(int i = 0; i<maxPossibleH_index; i++){
            reverseOrderCitations[i] = citations[maxPossibleH_index-i-1];
        }
        
        for(int i = 0; i<maxPossibleH_index; i++){
            // if(reverseOrderCitations[i] <= maxPossibleH_index){
            //     if(reverseOrderCitations[i] <= i+1){
            //         answer = reverseOrderCitations[i];
            //         System.out.println(answer);
            //         break;
            //     }
            // }

            // n번째 있는 수가 n 이상이면 내림차순으로 되어있는 citatinos는 앞에있는 수는 n보다 크거나 같음
            if(reverseOrderCitations[i]> i)
                answer = i+1;
            // else break;

        }

        return answer;
    }
}