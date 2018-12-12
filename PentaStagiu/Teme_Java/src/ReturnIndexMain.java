import java.util.Arrays;
import java.util.Scanner;

public class ReturnIndexMain {

    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);

        System.out.print("numbers of elements :");
        int x = key.nextInt();

        int[] num = new int[x];
        int index;
        read(num);
        write(num);
        System.out.println("\n");
        Arrays.sort(num);
        write(num);
        System.out.print("\n index of:");
        int value = key.nextInt();

        index= Arrays.binarySearch(num,value);
        System.out.println("\n index is " + index);
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


}
