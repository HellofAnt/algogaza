package programmers;

import java.util.*;

public class array {
    public static void main(String[] args) {
        //test case
        int[] array = {1, 8, 2, 2, 10, 3, 244, 56, 2, 4, 2, 4, 2, 5};
        int[][] commands = {{2, 12, 11},{4, 14, 10},{1, 7, 3},{1, 14, 2}};   
        
        System.out.println(Arrays.toString(Solution.solution(array, commands)));
        
    }
    static class Solution {
        public static int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            // get answer factor
            for(int q =0; q < commands.length; q++){
                int[] cuted_array = new int[commands[q][1] - commands[q][0] + 1];
                for(int j = 0; j <= commands[q][1] - commands[q][0]; j++){
                    cuted_array[j] = array[commands[q][0] + j -1];
                } 
                int[]  arrayRank = new int[cuted_array.length];
            
                for(int i = 0; i < cuted_array.length; i++){
                    int rank = 0;
                    for(int j = 0; j < cuted_array.length; j++){
                        if(cuted_array[i] < cuted_array[j]){
                            rank = rank+1;
                             arrayRank[i] = rank;
    
                        }
                    }
                }
                int[] sorted_array = new int[cuted_array.length];
                for(int i = 0; i < sorted_array.length; i++){
                    // check and change the same rank
                    for(int j = i + 1; j < sorted_array.length; j++){
                        if( arrayRank[i] ==  arrayRank[j]){
                             arrayRank[j] =  arrayRank[j]+1;
                        }
                    }
                    sorted_array[cuted_array.length - arrayRank[i] - 1] = cuted_array[i];
                }
                answer[q] = sorted_array[commands[q][2]-1];
            }
            return answer;
        }
    }
}

/* class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0 ;
 
        for(int i = 0 ; i < commands.length ; i++)
        {
            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];
 
            int[] tmp = new int[end - start + 1];
 
            int a = 0;
            for(int j = start - 1 ; j < end ; j++)
                tmp[a++] = array[j];
 
            Arrays.sort(tmp);
            answer[index++] = tmp[k-1];
        }
        return answer;
    }
} */
