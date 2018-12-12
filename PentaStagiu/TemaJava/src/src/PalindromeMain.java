import java.util.Scanner;

public class PalindromeMain {
    public static void main(String args[])
    {
        String word, rev = "";
        Scanner input = new Scanner(System.in);
        System.out.print("first string : ");
         word = input.nextLine();

        int length = word.length();

        for ( int i = length - 1; i >= 0; i-- )
            rev = rev + word.charAt(i);

        if (word.equals(rev))
            System.out.println(word+" is a palindrome");
        else
            System.out.println(word+" is not a palindrome");

    }
}

