import java.util.Scanner;

public class StringEndMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("first string : ");
        String word1 = input.nextLine();
        System.out.print("second string: ");
        String word2 = input.nextLine();

        if(word1.endsWith(word2))
        {
            System.out.println("True");
        }
        else
        {
            System.out.println("False");
        }

    }

}
