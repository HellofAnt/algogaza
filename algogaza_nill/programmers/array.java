package programmers;

import java.util.*;

public class array {
    public static void main(String[] args) {
        int[] answer;
        int[] array = {1, 8, 2, 2, 10, 3, 7, 4};
        int[][] commands = {{2, 5, 3},{4, 4, 1},{1, 7, 3},{1, 7, 3}};         
        int[] test = new int[commands.length];
        int index = 0;
        System.out.println(test[2]);
        System.out.println(array.length);
        System.out.println(test);
        
        System.out.println("------------");


        for(int q =0; q < commands.length; q++){
            int[] array2 = new int[commands[q][1] - commands[q][0] + 1];
            for(int j = 0; j <= commands[q][1] - commands[q][0]; j++){
                array2[j] = array[commands[q][0] + j -1];
            } 
            System.out.println("자름");
            System.out.println(Arrays.toString(array2));
            // array = array2;
            int[] r = new int[array2.length];
        
            for(int i = 0; i < array2.length; i++){
                int k = 0;
                for(int j = 0; j < array2.length; j++){
                    if(array2[i] < array2[j]){
                        k = k+1;
                        r[i] = k;

                    }
                }
            }
            System.out.println("몇번째로 큰 수인지 랭크");
            System.out.println(Arrays.toString(r));
            int[] array3 = new int[array2.length];
            for(int i = 0; i < array3.length; i++){
                for(int j = i + 1; j < array3.length; j++){
                    if(r[i] == r[j]){
                        r[i] = r[i]+1;
                        System.out.println("같은 수면 앞에꺼가 작은수로 랭크");
                        System.out.println(Arrays.toString(r));
                    }
                }

                array3[array2.length -r[i] - 1] = array2[i];
                
            }
            System.out.println("랭크에 따라 재배열");
            System.out.println(Arrays.toString(array3));

            answer = array3;
        System.out.println("---------------------");
            
        }        
        
        
        System.out.println("------------");
        System.out.println("------------");


        
        
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
