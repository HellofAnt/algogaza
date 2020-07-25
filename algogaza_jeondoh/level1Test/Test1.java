package level1Test;

// TODO 2020/07/26 by jeondoh
// 코딩테스트 연습 > 연습문제 > 이상한 문자 만들기
// 짝수번째 알파벳 2,4,6... > 대문자
// 홀수번째 알파벳 1,3,5... > 소문자
// https://programmers.co.kr/learn/courses/30/lessons/12930
public class Test1 {
    public static void main(String[] args) {
        String question = "try hello world";
        System.out.println(solution(question));
    }
    // 함정이 섞여있음
    // 공백 뒤에는 다시 0부터 시작
    public static String solution(String s) {
        String answer = "";
        int size = s.length();
        int count = 0;
        for(int i=0; i<size; i++){
            if(s.charAt(i) == ' '){
                answer+= " ";
                count = 0;
                continue;
            }
            if(count%2==0){
                answer += s.toUpperCase().charAt(i);
            }else{
                answer += s.toLowerCase().charAt(i);
            }
            count++;
        }
        return answer;
    }
}
