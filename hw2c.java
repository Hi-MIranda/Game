package Lab;
import java.util.Scanner;
public class hw2c{
    public static void bubbleSort (String[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (!smaller(arr[j], arr[j+1])) {
                    String temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static boolean smaller (String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        int i = 0;
        while(s1.charAt(i) - 'a' == s2.charAt(i) - 'a') {
            if (i == Math.min(s1.length()-1, s2.length()-1)){
                return s1.length() < s2.length();
            }
            i++;
        }
        if (s1.charAt(i) - 'a' > s2.charAt(i) - 'a') return false;
        else return true;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 10 Strings: ");
        String str = sc.nextLine();
        sc.close();
        String[] arr = str.split(", ");
        bubbleSort(arr);
        String res = "Sorted Strings:";
        for (int i = 0; i < 10; i++) {
            res += " " + arr[i] + ",";
        }
        System.out.print(res);
    }
}
