import java.util.*;
import java.util.Scanner;
public class JavaCalc
{
    public static void main(String[] args)
    {
        System.out.println("Enter first and second number:");
        Scanner inp= new Scanner(System.in);
        int num1, num2;
        num1 = inp.nextInt();
        num2 = inp.nextInt();
        System.out.println("Enter your selection: 1 for Addition, 2 for subtraction 3 for Multiplication and 4 for division:");
        int choose;
        choose = inp.nextInt();
        switch (choose){
            case 1:
                System.out.println(num1);
            case 2:
                System.out.println(sub( num1,num2));

                System.out.println(mult( num1,num2));

            case 4:
                System.out.println();

                System.out.println("Illegal Operation");


        }



    }
    private static int add(int x, int y)
    {
        int result = x + y;
        return result;
    }
    private static int sub(int x, int y)
    {
        int result = x-y;
        return result;
    }
    private static int mult(int x, int y)
    {
        int result = x*y;
        return result;
    }
    private static int div(int x, int y)
    {
        int result = x/y;
        return result;
    }

}