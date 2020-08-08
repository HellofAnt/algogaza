package programmers;

import java.util.Arrays;

public class stack {
    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};
        StackSolution solution = new StackSolution();
        System.out.println(Arrays.toString(solution.solution(prices)));
    }
}

class StackSolution{
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        

        label:
        for(int i=0; i < prices.length; i++){
            for(int j = i+1;j< prices.length; j++){
                if(prices[i]<=prices[j]){
                    ++answer[i];
                }else{
                    ++answer[i];
                    continue label;
                }
            }
        }
        return answer;
    }


    int[] stack(int[] test){
        int[]a = {1};

        // if(test)

        return a;
    }
}