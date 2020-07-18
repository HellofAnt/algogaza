package programmers;

import java.util.Arrays;

public class array2{
    public static void main(String[] args) {
        int[] a = {10 ,30, 22, 50, 10, 10, 30, 33, 33};
        // Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        solution(a);
    }

    public static String solution(int[] numbers) {
        String[] toString_numbers = new String[numbers.length];
        for(int i=0; i < numbers.length; i++){
            toString_numbers[i] = Integer.toString(numbers[i]);
        }
        
        
        System.out.println(Arrays.toString(test(toString_numbers, 0)));

        // System.out.println(toString_numbers[7].length());

        String answer = "";
        return answer;
    }

    public static int[] test(String[] toString_numbers, int charAt_index) {
        int[] arrayRank = new int[toString_numbers.length];
        for(int i=0; i < toString_numbers.length; i++){
            for(int j = 0; j < toString_numbers.length; j++){
                
                if(toString_numbers[i].charAt(charAt_index) > toString_numbers[j].charAt(charAt_index)){
                    arrayRank[i] = arrayRank[i]+1;
                }
            }
        }
        
        for(int i = 0; i < arrayRank.length; i++){
            for(int j = i + 1; j < arrayRank.length; j++){
                if(arrayRank[i] == arrayRank[j]){
                    if(toString_numbers[i].length() == charAt_index + 1 
                                    &&  toString_numbers[j].length() == charAt_index + 1){
                        arrayRank[j] = arrayRank[j] + 1;
                    }else if(toString_numbers[i].length() == charAt_index + 1){
                        if(toString_numbers[i].charAt(0) > toString_numbers[j].charAt(charAt_index + 1)){

                            arrayRank[i] = arrayRank[i] + 1;
                        }else{

                            arrayRank[j] = arrayRank[j] + 1 ;
                        }
                    }else{
                        test(toString_numbers, charAt_index + 1);
                    }
                }
                
            }
        }

        return arrayRank;
    }
}




/////////////////////////////////////////////////////////////////////
/* Error list
1.재귀함수에서 charAt_index값이 올라갔는데 비교는 다 하고 있음 
2.test()에서 arrayRank는 결국 초기화 */