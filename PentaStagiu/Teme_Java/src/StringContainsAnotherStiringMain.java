import java.util.Scanner;

public class StringContainsAnotherStiringMain {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("first string : ");
        String word1 = input.nextLine();
        System.out.print("second string: ");
        String word2 = input.nextLine();

        Boolean bool = word1.contains(word2);
        System.out.print(bool);
    }
}
