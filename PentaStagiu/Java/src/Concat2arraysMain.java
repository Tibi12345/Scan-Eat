import java.util.Arrays;
import java.util.Scanner;

public class Concat2arraysMain {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);

        System.out.print("numbers of elements for first array :");
        int x = key.nextInt();
        int[] num1 = new int[x];

        System.out.print("numbers of elements for second array :");
        int y = key.nextInt();
        int[] num2 = new int[y];
        read(num1);
        write(num1);
        read(num2);
        write(num2);

        int aLen = num1.length;
        int bLen = num2.length;
        int[] result = new int[aLen + bLen];
        System.arraycopy(num1, 0, result, 0, aLen);
        System.arraycopy(num2, 0, result, aLen, bLen);

        System.out.println(Arrays.toString(result));
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
