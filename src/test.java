import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws FileNotFoundException {
        String str = "input\\qws_10k_10.txt";
        Scanner scanner = new Scanner(new File(str));
        for (int i = 0; i < 2; i++) {
            String strs = scanner.nextLine();
            String[] strss = strs.split(",");
            for (int j = 0; j < strss.length; j++) {
                System.out.println(j + ": " + Double.valueOf(strss[j]));
            }
        }
        scanner.close();
    }
}