package programmers;

public class test {
    public static void main(String[] args) {
            String[] seoul = {"Kim", "dsfds"};
            String answer = "";
            String Kim = "Kim";
            for(int i = 0; i < seoul.length; i++){
                if(seoul[i] == Kim){
                    
                    answer = "김서방은 " + i + "에 있다";
                    break;
                }
            }
            System.out.println(answer);
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