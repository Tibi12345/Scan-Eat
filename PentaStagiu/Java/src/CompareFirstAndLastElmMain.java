import java.util.Scanner;

public class CompareFirstAndLastElmMain {


    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        System.out.print("numbers of elements :");
        int x=key.nextInt();
        int [] num= new int [x];

        read(num);
        write(num);

        if (num[0] == num[num.length-1]) {
            System.out.println("\n true");
        }
        else {
            System.out.println("\n false");
        }

    }

    static void read(int num[])
    {
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i<num.length; i++)
            {
                System.out.print("the element "+ (i+1) +" is ");
                num[i] = scan.nextInt();
            }
    }

    static void write(int num[])
    {

        for(int i = 0; i<num.length; i++)
            {
                System.out.print(" "+ num[i]);
            }
    }

}