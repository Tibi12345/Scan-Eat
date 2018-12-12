import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class MinMaxArrayMain {

    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);

        System.out.print("numbers of elements :");
        int x = key.nextInt();
        int[] num = new int[x];
        int average;
        read(num);
        write(num);
        Arrays.sort(num);
        average= findSum(num)/x;

        System.out.println("\n min is " +num[0]+ " max is " +num[num.length-1]+ " and average is " + average);
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
            System.out.print("  "+ num[i]);


        }
    }
    public static int findSum(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }
}
