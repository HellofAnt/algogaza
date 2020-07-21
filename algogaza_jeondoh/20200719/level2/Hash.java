package level2;

import java.util.Arrays;
// 해시 > 전화번호목록
// 정확성 84.6 효율성 15.4 ...
// Comment > 오히려 Arrays.sort 보다 2중 FOR문이 속도에서 더 빨랐음. 예상과 달랐음
// https://programmers.co.kr/learn/courses/30/lessons/42577
public class Hash {
    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        String[] phone_book2 = {"123","456","789"};
        String[] phone_book3 = {"12","123","1235","567","88"};

        System.out.println(solution(phone_book));
        System.out.println(solution(phone_book2));
        System.out.println(solution(phone_book3));

        System.out.println(solution2(phone_book));
        System.out.println(solution2(phone_book2));
        System.out.println(solution2(phone_book3));
    }
    // 정렬 후 i번째 phone번호와 i+1번째 폰번호 비교
    public static boolean solution(String[] phone_book) {
        int size = phone_book.length;
        Arrays.sort(phone_book); // 정렬
        for(int i=0; i<size-1; i++){
           if(phone_book[i+1].startsWith(phone_book[i])) return false;
        }
        return true;
    }
    // 2중 FOR문으로, i번째와 i+1번째 폰번호 비교
    public static boolean solution2(String[] phone_book) {
        int size = phone_book.length;
        for(int i=0; i<size-1; i++) {
            for(int j=i+1; j<size; j++) {
                if(phone_book[i].startsWith(phone_book[j])) return false;
                if(phone_book[j].startsWith(phone_book[i])) return false;
            }
        }
        return true;
    }

}
