import java.util.HashMap;
import java.util.Map;

/**
 * 위장 옷 입기 경우의수
 */
public class lesson1{
    public static void main(String[] args) {
        String[][] question1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] question2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        System.out.println("문제 1 가짓수 : " + solution(question1));
        System.out.println("문제 2 가짓수 : " + solution(question2));
    }

    /**
     *  문제 설명
        스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
        예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
        스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.

        문제풀이
        경우의수 공식을 대입하여 풀이하면 된다.
        ((경우의가지수 + 1) * ... ) - 1 = 정답  
     * @param clothes 옷가지
     * @return
     */
    public static int solution(String[][] clothes){
        Map<String, Integer> index = new HashMap<>();
        for(String[] cloth : clothes){
            int count = index.getOrDefault(cloth[1], 0); 
            index.put(cloth[1], ++count);
        }

        int answer = 1;
        Object[] keyArray = index.keySet().toArray();
        for(Object subject: keyArray){
            int cnt = index.get(subject);
            answer = answer * (cnt+1);
        }
        return answer - 1;
    }
}