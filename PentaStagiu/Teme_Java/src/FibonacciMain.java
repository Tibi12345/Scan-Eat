import java.util.Scanner;

public class FibonacciMain {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("x = ");

        double x = scan.nextDouble();
        int n1=1,n2=1,n3;
        double average,sum = 0;

        System.out.print(n1+" "+n2);

        for(int i=2; i<x; ++i)
        {
            n3=n1+n2;
            System.out.print(" "+n3);
            n1=n2;
            n2=n3;
            sum=sum+n3;
        }
        average=sum/x;
        System.out.println("\n Average is "+ average );

    }
}
