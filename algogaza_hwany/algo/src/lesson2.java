import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class lesson2 {

    /**
     * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
     * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
     * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
     */
    public static void main(String[] args) {
        int[] param = {6, 10, 2};

        Solution solution = new Solution();
        int[] maxNums = solution.findBigNumber(param);
        System.out.println("가장 큰 수 "+maxNums);
    }
}

class Solution {

    /// #. 만들어진 경우의수
    public List<int[]> numbers = new ArrayList<>();

    /// 가장 큰 배열순을 찾아라
    public int[] findBigNumber(int[] params) {

        /// 1. 경우의수로 주어진 정수들을 조합한다
        ///1.1 배열의 길이를 구한다(순열 메서드 활용)
        perm(params, 0);

        /// 2. 경우의수의 조합들중 가장 큰 수를 찾아 반환한다
        return compareBigNumber(numbers);
    }

    /// 가장 큰 배열을 반환해준다
    private int[] compareBigNumber(List<int[]> numbers) {
        int mostBigSize = 0, mostBigSizeIndex = 0, currentIndex = 0;

        List<int[]> splitNumbers = numbers.stream().map(nums -> {
            List<Integer> transList = new ArrayList<>();
            for (int num : nums) {
                if (num >= 10) {
                    String[] split = String.valueOf(num).split("");
                    for (String splitNum : split) {
                        transList.add(Integer.parseInt(splitNum));
                    }
                } else {
                    transList.add(num);
                }
            }
            return transList.stream().mapToInt(i -> i).toArray();
        }).collect(Collectors.toList());

        for (int[] numberArr : splitNumbers) {
            int size = 0;
            int unit = numberArr.length;
            for (int number : numberArr) {
                int pow = (int) Math.pow(10, unit--);
                size += number * pow;
            }

            if (size > mostBigSize) {
                mostBigSize = size;
                mostBigSizeIndex = currentIndex;
            }
            currentIndex++;
        }

        return splitNumbers.get(mostBigSizeIndex);
    }

    /// 배열의 순서를 바꿔준다
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 배열의 순열 구하기
     *
     * @param arr          기준 배열
     * @param currentDepth 현재 위치한 뎁스
     */
    public void perm(int[] arr, int currentDepth) {
        if (currentDepth == arr.length) {
            numbers.add(Arrays.copyOf(arr, arr.length));
            return;
        }
        for (int i = currentDepth; i < arr.length; i++) {
            swap(arr, i, currentDepth);
            perm(arr, currentDepth + 1);
            swap(arr, i, currentDepth);
        }
    }

}