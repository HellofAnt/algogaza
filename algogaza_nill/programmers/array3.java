package programmers;

import java.util.Arrays;

public class array3{
    public static void main(String[] args) {
        int[] a = {0,0,70,0,7000,70070,430,70770,70324,100000,10000,1000,1000,1000,1000,1000,1010,100,1010,101,101,10,99,99,99,99,99,9,99,9,9,9,9,999,9,999,999,9999,999999,909};
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

        // 다른 주소를 가지게 할려면 배열에 일일이 담는 수 밖에 없나?
        // String[] testt = new String[numbers.length];
        // testt = toString_numbers;
        // Arrays.sort(testt, (o1,o2)->(o2+o1).compareTo(o1+o2));

        // System.out.println("hi"+Arrays.toString(toString_numbers));
        // System.out.println("hi"+Arrays.toString(testt));

        ranking(toString_numbers,arrayRank, 0);

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

    public static int[] ranking(String[] toString_numbers,int[] arrayRank, int charAt_index) {
        for(int i=0; i < toString_numbers.length; i++){
            for(int j = i+1; j < toString_numbers.length; j++){
                if(toString_numbers[i].equals(toString_numbers[j])){
                    ++arrayRank[j];
                    continue;
                }
                compare(i, j, toString_numbers, arrayRank, charAt_index);
                
            }
        }
        System.out.println(Arrays.toString(arrayRank));
        
        return arrayRank;
    }
    
    // 재귀함수 쓰기 위해서
    public static int[] compare(int i, int j,String[] toString_numbers, int[] arrayRank, int charAt_index){
        if(toString_numbers[i].charAt(charAt_index) > toString_numbers[j].charAt(charAt_index)){
            ++arrayRank[i];
        }
        if(toString_numbers[i].charAt(charAt_index) < toString_numbers[j].charAt(charAt_index)){
            ++arrayRank[j];
        }
        if(toString_numbers[i].charAt(charAt_index) == toString_numbers[j].charAt(charAt_index)){
            if(toString_numbers[i].length() == charAt_index + 1){
                if(toString_numbers[j].charAt(charAt_index + 1) >= toString_numbers[j].charAt(0)){
                    ++arrayRank[j];
                }
                if(toString_numbers[j].charAt(charAt_index + 1) < toString_numbers[j].charAt(0)){
                    ++arrayRank[i];
                }
            } else if(toString_numbers[j].length() == charAt_index + 1){
                if(toString_numbers[i].charAt(charAt_index + 1) > toString_numbers[i].charAt(0)){
                    ++arrayRank[i];
                }
                if(toString_numbers[i].charAt(charAt_index + 1) <= toString_numbers[i].charAt(0)){
                    ++arrayRank[j];
                }
            } else{
                compare(i, j, toString_numbers, arrayRank, ++charAt_index);
            }
        }

        return arrayRank;
    }

    
}
class solution2 {
    String solution2(String[] toString_numbers){
        
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



