import java.io.IOException;
import java.util.Scanner;

public class CountCharacterMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("first string : ");
        String word1 = input.nextLine();
        System.out.print("insert a character : ");
        char ch = 0;
        try {
            ch = (char) System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("character '"+ch+"' appears "+countChar(word1,ch));
    }

    public static int countChar(String str, char c)
    {
        int count = 0;

        for(int i=0; i < str.length(); i++)
        {    if(str.charAt(i) == c)
            count++;
        }

        return count;
    }
}
