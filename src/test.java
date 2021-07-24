import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws FileNotFoundException {
        //String str = "input\\qws_10k_10.txt";
        //Scanner scanner = new Scanner(new File(str));
        //for (int i = 0; i < 2; i++) {
        //    String strs = scanner.nextLine();
        //    String[] strss = strs.split(",");
        //    for (int j = 0; j < strss.length; j++) {
        //        System.out.println(j + ": " + Double.valueOf(strss[j]));
        //    }
        //}
        //scanner.close();

        //Integer[] arr = new Integer[] { 3, 2, 1, 5, 4 };
        List<Integer> list = List.of(3, 2, 1, 5, 4);
        PriorityQueue<Integer> pq = new PriorityQueue<>(list);
        System.out.println(pq.peek());

    }
}