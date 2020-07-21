package level1;

import java.util.Arrays;
// 정렬 > K번째 수
// 정확성 100
// https://programmers.co.kr/learn/courses/30/lessons/42748
public class Sort {

	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		System.out.println(Arrays.toString(solution(array, commands)));
	}

	public static int[] solution(int[] array, int[][] commands) {
		int roop = 0;
		int[] answer = new int[commands.length];

		for(int[] data : commands){
			int i=data[0];
			int j=data[1];
			int k=data[2];
			int[] solv = new int[j-i+1];

			int solvRoop = 0;
			for(int l=i;l<=j;l++){
				solv[solvRoop] = array[l-1];
				solvRoop++;
			}
			Arrays.sort(solv);
			answer[roop++] = solv[k-1];
		}
		return answer;
	}

}
