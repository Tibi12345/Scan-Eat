import java.util.Scanner;

public class SumAndAverageMain {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int a ;
        int b;
        float average;
        int sum = 0;


        System.out.println("write 2 numbers:");
        a = scan.nextInt();
        b =scan.nextInt();

        System.out.println("First number: " +a );
        System.out.println("Second number: " +b);

            for(int i = a;i <= b; i++)
            {
                sum += i;

            }

            average = (a+b)/2;
        System.out.println("the total sum is "+ sum+ " and the average is " + average);




    }
}
