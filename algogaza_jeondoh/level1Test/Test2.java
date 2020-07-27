package level1Test;

// TODO 2020/07/26 by jeondoh
// 코딩테스트 연습 > 연습문제 > 두 정수의 합
// 두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요.
// 예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.
// a와 b의 대소관계는 정해져있지 않음.
// https://programmers.co.kr/learn/courses/30/lessons/12912
public class Test2 {
    public static void main(String[] args) {
        int a1 = -1; int b1 = 1;
        int a2 = 33; int b2 = -13;
        int a3 = 3; int b3 = 3;

        System.out.println(solution1(a1,b1));
        System.out.println(solution1(a2,b2));
        System.out.println(solution1(a3,b3));
        System.out.println(solution2(a1,b1));
        System.out.println(solution2(a2,b2));
        System.out.println(solution2(a3,b3));
    }
    // FOR문을 이용한 방법
    public static long solution1(int a, int b) {
        long answer = 0;
        if(a==b){
            return a;
        }
        long min = Math.min(a,b);
        long max = Math.max(a,b);

        for(long i=min; i<=max; i++){
            answer+=i;
        }
        return answer;
    }
    // 식을 이용한 방법
    public static long solution2(int a, int b) {
        long min = Math.min(a,b);
        long max = Math.max(a,b);
        return (max-min+1) * (min+max) / 2;
    }
}
