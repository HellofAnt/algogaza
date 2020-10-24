package programmers;

import java.util.Arrays;

public class array3{
    public static void main(String[] args) {
        int[] a = {40,404}; //2,2021,202020,20
        // Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        solution(a);
    }

    public static String solution(int[] numbers) {
        String[] toString_numbers = new String[numbers.length];
        String[] solted_numbers = new String[numbers.length];
        int[] arrayRank = new int[toString_numbers.length];
        for(int i=0; i < numbers.length; i++){
            toString_numbers[i] = Integer.toString(numbers[i]);
        }

        ranking(toString_numbers,arrayRank);

        for(int i = 0; i < toString_numbers.length; i++){
            solted_numbers[toString_numbers.length - arrayRank[i] - 1] = toString_numbers[i]; 
        }

        if(solted_numbers[0].equals("0")){
            return "0";
        }

        StringBuffer answer = new StringBuffer();
        
        for(int i = 0; i < solted_numbers.length; i++){
            answer.append(solted_numbers[i]);
            
        }
        System.out.println(answer);
        return answer.toString();
    }

    public static int[] ranking(String[] toString_numbers,int[] arrayRank) {
        for(int i=0; i < toString_numbers.length; i++){
            for(int j = i+1; j < toString_numbers.length; j++){
                if(toString_numbers[i].equals(toString_numbers[j])){
                    ++arrayRank[j];
                    continue;
                }
                compare(i, j, toString_numbers, arrayRank, 0, 0);
                
            }
        }
        System.out.println(Arrays.toString(arrayRank));
        
        return arrayRank;
    }
    
    // 재귀함수 쓰기 위해서 100 1
    public static int[] compare(int i, int j,String[] toString_numbers, int[] arrayRank, int charAt_i_index, int charAt_j_index){
        if(toString_numbers[i].charAt(charAt_i_index) > toString_numbers[j].charAt(charAt_j_index)){
            ++arrayRank[i];

        }
        if(toString_numbers[i].charAt(charAt_i_index) < toString_numbers[j].charAt(charAt_j_index)){
            ++arrayRank[j];
        }
        if(toString_numbers[i].charAt(charAt_i_index) == toString_numbers[j].charAt(charAt_j_index)){
            if(toString_numbers[i].length() == charAt_i_index + 1){
                if(toString_numbers[j].length() == charAt_j_index + 1){
                    ++arrayRank[j];
                }
                else if(toString_numbers[j].charAt(charAt_j_index + 1) > toString_numbers[i].charAt(0)){
                    ++arrayRank[j];
                }
                else if(toString_numbers[j].charAt(charAt_j_index + 1) < toString_numbers[i].charAt(0)){
                    ++arrayRank[i];
                }
                else if(toString_numbers[j].charAt(charAt_j_index + 1) == toString_numbers[i].charAt(0)){
                    compare(i, j, toString_numbers, arrayRank, charAt_i_index = 0, ++charAt_j_index);
                }
            } else if(toString_numbers[j].length() == charAt_j_index + 1){
                if(toString_numbers[i].length() == charAt_i_index + 1){
                    ++arrayRank[j];
                }
                else if(toString_numbers[i].charAt(charAt_i_index + 1) > toString_numbers[j].charAt(0)){
                    ++arrayRank[i];
                }
                else if(toString_numbers[i].charAt(charAt_i_index + 1) < toString_numbers[j].charAt(0)){
                    ++arrayRank[j];
                }
                else if(toString_numbers[i].charAt(charAt_i_index + 1) == toString_numbers[j].charAt(0)){
                    compare(i, j, toString_numbers, arrayRank, ++charAt_i_index, charAt_j_index = 0);
                }
            } else{
                compare(i, j, toString_numbers, arrayRank, ++charAt_i_index, ++charAt_j_index);
            }
        }

        return arrayRank;
    }

    
}
class solution2 {
    String solution(String[] toString_numbers){
        
        Arrays.sort(toString_numbers, (o1,o2)->(o2+o1).compareTo(o1+o2));
        
        if(toString_numbers[0].equals("0")){
            return "0";
        }

        StringBuffer answer = new StringBuffer();
        
        for(int i = 0; i < toString_numbers.length; i++){
            answer.append(toString_numbers[i]);
            
        }
        return answer.toString();
    }
}



