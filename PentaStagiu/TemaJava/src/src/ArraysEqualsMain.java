import java.util.Arrays;
import java.util.Scanner;

public class ArraysEqualsMain {

    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);

        System.out.print("numbers of elements for first array :");
        int x = key.nextInt();
        int [] num1 = new int [x];

        System.out.print("numbers of elements for second array :");
        int y = key.nextInt();
        int [] num2 = new int [y];


        if(x == y){
            read(num1);
            write(num1);
            read(num2);
            write(num2);
            if(Arrays.equals(num1,num2))
            {
                System.out.println("True");
            }
            else
            {
                System.out.println("False");
            }
        }
        else{
            System.out.println("arrays don`t have the same number of elements");
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
                System.out.println("  "+ num[i]);

            }
    }
}

