package Hash;

import java.util.*;

// TODO 2020/07/25 by jeondoh
// 해시 > 위장
// https://programmers.co.kr/learn/courses/30/lessons/42578
public class Hash3 {
    public static void main(String[] args) {
        String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(solution(clothes1));
        System.out.println(solution(clothes2));
    }

    public static int solution(String[][] clothes) {
        int result = 1;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String[] cloth : clothes){
            String type = cloth[1]; // 의상의 종류
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        for(int value : map.values()){
            result *= (value+1); // 옷종류가 여러가지라도 한종류만 입을 수 있는 경우
        }
        return result-1; // 모두 다 안입는 경우
    }

}
