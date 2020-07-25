package programmers;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
            // String[] seoul = {"Kim", "dsfds"};
            // String answer = "";
            // for(int i = 0; i < seoul.length; i++){
            //     if(seoul[i].equals("Kim")){
                    
            //         answer = "김서방은 " + i + "에 있다";
            //         break;
            //     }
            // }
            // System.out.println(answer);
            int[] a = new int[4];
            int[] b = {1, 2, 3, 4};
            
            System.out.println(Arrays.toString(a));
            Integer k = new Integer(10);
            Integer e = 10;
            int f = k + e;
            Integer g = k + e;
            int c = k.intValue();
            int d = g.intValue();
            System.out.println(k);
            System.out.println(e);
            System.out.println(c);
            System.out.println(d);
            System.out.println(f);
            System.out.println(g);
            
    }
}






// class Solution {
//     public String solution(String[] seoul) {
//         String answer = "";
//         String Kim = "Kim";
//         for(int i = 0; i < seoul.length; i++){
//             if(seoul[i] == Kim){
                
//                 answer = "김서방은 " + i + "에 있다";
//                 break;
//             }
//         }
//     return answer;        
//     }
// }