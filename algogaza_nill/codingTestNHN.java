
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class codingTestNHN {

    // 수정 전 (out of range방지를 위해 재귀함수의 사용)
    // private static int noOutOfBoundsArray(int nextSuleIdx, int nonSulesLength) {
    //     if (nextSuleIdx < 0) {
    //         nextSuleIdx += nonSulesLength;
    //         return noOutOfBoundsArray(nextSuleIdx, nonSulesLength);
    //     }
    //     if (nextSuleIdx > nonSulesLength - 1) {
    //         nextSuleIdx -= nonSulesLength;
    //         return noOutOfBoundsArray(nextSuleIdx, nonSulesLength);
    //     }
    //     return nextSuleIdx;
    // }

    private static boolean quickCheck(char sule, char[] namesOfQuickPlayers) {
        for (int i = 0; i < namesOfQuickPlayers.length; i++) {
            if (sule == namesOfQuickPlayers[i]) {
                return true;
            }
        }
        return false;
    }

    private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames,
            int[] numOfMovesPerGame) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        char[] players = new char[numOfAllPlayers];
        char fistPlayer = 65;
        for (int i = 0; i < numOfAllPlayers; i++) {
            players[i] = fistPlayer++;
            map.put(String.valueOf(players[i]), 0);
        }

        char sule = 65;
        map.put(String.valueOf(sule), 1);
        char temp = 65;
        char[] nonSules = new char[numOfAllPlayers - 1];
        char secoundPlayer = 66;
        // int nextSuleIdx = 0;
        int nextSuleIdx2 = 0;
        for (int i = 0; i < numOfAllPlayers - 1; i++) {
            nonSules[i] = secoundPlayer++;
        }
        for (int i = 0; i < numOfGames; i++) {
            // 수정 전 (out of range방지를 위해 재귀함수의 사용)
            // nextSuleIdx = numOfMovesPerGame[i] + nextSuleIdx;
            // nextSuleIdx = noOutOfBoundsArray(nextSuleIdx, nonSules.length);
            // temp = sule; 
            // sule = nonSules[nextSuleIdx2];
            // if(quickCheck(sule, namesOfQuickPlayers)){
            //     sule = temp;
            // }else{
            //     nonSules[nextSuleIdx2] = temp;
            // }

            //수정 후 (out of range방지를 위해 나머지, 절대값 사용)
            if(numOfMovesPerGame[i] + nextSuleIdx2 < 0){
                if(nonSules.length % Math.abs(numOfMovesPerGame[i] + nextSuleIdx2) == 0){
                }else{
                    nextSuleIdx2 = nonSules.length - (Math.abs(numOfMovesPerGame[i] + nextSuleIdx2) % nonSules.length);
                }
            }else{
                nextSuleIdx2 = (numOfMovesPerGame[i] + nextSuleIdx2) % nonSules.length;
            }            
            temp = sule; 
            sule = nonSules[nextSuleIdx2];
            if(quickCheck(sule, namesOfQuickPlayers)){
                sule = temp;
            }else{
                nonSules[nextSuleIdx2] = temp;
            }
            map.put(String.valueOf(sule) ,map.get(String.valueOf(sule)) + 1);
        }


        for(int i =0; i < nonSules.length; i++){
            System.out.println(nonSules[i]+" "+map.get(String.valueOf(nonSules[i])));
        }
        System.out.println(sule+" "+map.get(String.valueOf(sule)));
    }





    private static class InputData {
        int numOfAllPlayers;
        int numOfQuickPlayers;
        char[] namesOfQuickPlayers;
        int numOfGames;
        int[] numOfMovesPerGame;
      }
    
      private static InputData processStdin() {
        InputData inputData = new InputData();
    
        try (Scanner scanner = new Scanner(System.in)) {
          inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
    
          inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
          inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
          System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0, inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);
    
          inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
          inputData.numOfMovesPerGame = new int[inputData.numOfGames];
          String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
          for(int i = 0; i < inputData.numOfGames ; i++){
            inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
          }
        } catch (Exception e) {
          throw e;
        }
    
        return inputData;
      }
    
      public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();
    
        solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers, inputData.numOfGames, inputData.numOfMovesPerGame);
      }
    }