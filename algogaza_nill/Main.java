import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String... args) throws IOException {
        int year = Integer.parseInt(br.readLine());
        System.out.println(leapYear(year));
    }

    public static int leapYear(final int year) {
        if (year % 400 == 0) {
            return 1;
        } else {
            if (year % 4 == 0) {
                if (year % 100 != 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        }
    }
}