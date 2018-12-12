import java.util.Scanner;

public class AlphabetEncodingMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print(" string : ");
        String word1 = input.nextLine();

        char[] ch = word1.toCharArray();
        for (char c : ch) {
            int temp = (int) c;
            int temp_integer = 96; //for lower case
            if (temp <= 122 & temp >= 97)
                System.out.print(" " +( temp - temp_integer));
        }
    }
}
