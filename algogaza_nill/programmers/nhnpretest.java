package programmers;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class nhnpretest {

  //size를 영역 수 만큼 저장하기 위해 맵 이용
  //solution과 arroundCheck(재귀함수)에서 이용하기 위해 전역변수로 사용
  private static Integer size = 0;
  private static Map<Integer, Integer> map = new HashMap<>();

  //발견된 1에서 4방향으로 붙어있 1 찾아 연속적으로(재귀함수) 바꾸기(카운트 된 인자는 50으로 바꿈)
  //이때 사이즈도 카운트
  private static int[][] arroundCheck(int sizeOfMatrix, int matrix[][], int i, int j){
    if(i != 0 && matrix[i-1][j] == 1){
      matrix[i-1][j] = 50;
      size = size + 1;
      arroundCheck(sizeOfMatrix, matrix, i-1, j);
    }
    if(j != 0 && matrix[i][j-1] == 1){
      matrix[i][j-1] = 50;
      size = size + 1;
      arroundCheck(sizeOfMatrix, matrix, i, j-1);
    }
    if(i < sizeOfMatrix-1 && matrix[i+1][j] == 1){
      matrix[i+1][j] = 50;
      size = size + 1;
      arroundCheck(sizeOfMatrix, matrix, i+1, j);
    }
    if(j < sizeOfMatrix-1 && matrix[i][j+1] == 1){
      matrix[i][j+1] = 50;
      size = size + 1;
      arroundCheck(sizeOfMatrix, matrix, i, j+1);
    }
    return matrix;
  }

  private static void solution(int sizeOfMatrix, int[][] matrix) {
    // 
    Integer areaNum = 0;


    /* 오른쪽과 아래만 붙어있는거 체크에서 오류 다수 발견

     * for(int i=0; i < sizeOfMatrix; i++){ label: for(int j=0; j < sizeOfMatrix;
     * j++){ if(matrix[i][j] == 1){ areaNum = areaNum + 1; if(i != 0 && j != 0 &&
     * (matrix[i-1][j] == 1 || matrix[i][j-1] == 1)){ areaNum = areaNum - 1;
     * continue; } if(i == 0 && j != 0 && matrix[i][j-1] == 1){ areaNum = areaNum -
     * 1; continue; } if(i != 0 && j == 0 && matrix[i-1][j] == 1){ areaNum = areaNum
     * - 1; continue; }
     * 
     * for(int k = 1; j+k < sizeOfMatrix; k++){ if(i !=0 && matrix[i][j+k] == 1){
     * if(matrix[i-1][j+k] == 1){ areaNum = areaNum - 1; continue label; } } }
     * 
     * } } }
     */


    for (int i = 0; i < sizeOfMatrix; i++) {
      for (int j = 0; j < sizeOfMatrix; j++) {
        if (matrix[i][j] == 1) {
          matrix[i][j] = 50;
          size = size + 1;
          arroundCheck(sizeOfMatrix, matrix, i, j);
          areaNum = areaNum + 1;
          map.put(areaNum, size);
          size = 0;
        }
      }
    }
    
    int[] sizes = new int[areaNum];

    for(int i=0; i<areaNum; i++){
      sizes[i] = map.get(i+1);
    }
    Arrays.sort(sizes);

    
    System.out.println(areaNum);
    for(int i=0; i<sizes.length; i++){
      System.out.print(sizes[i]);
			if(i != sizes.length-1){
				System.out.print(" ");
			}else{
				System.out.println();
			}
    }
  }

  private static class InputData {
    int sizeOfMatrix;
    int[][] matrix;
  }

  private static InputData processStdin() {
    InputData inputData = new InputData();

    try (Scanner scanner = new Scanner(System.in)) {
      inputData.sizeOfMatrix = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

      inputData.matrix = new int[inputData.sizeOfMatrix][inputData.sizeOfMatrix];
      for (int i = 0; i < inputData.sizeOfMatrix; i++) {
        String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
        for (int j = 0; j < inputData.sizeOfMatrix; j++) {
          inputData.matrix[i][j] = Integer.parseInt(buf[j]);
        }
      }
    } catch (Exception e) {
      throw e;
    }

    return inputData;
  }

  public static void main(String[] args) throws Exception {
    InputData inputData = processStdin();

    solution(inputData.sizeOfMatrix, inputData.matrix);

  }
}
