import java.util.Scanner;

public class Quadratic {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter coefficient of a:");
        double a = input.nextDouble();

        System.out.println("Enter coefficient of b:");
        double b = input.nextDouble();

        System.out.println("Enter coefficient of c:");
        double c = input.nextDouble();

        double d = b*b - 4*a*c;  // discriminant

        if (d > 0) {
            double r1 = (-b + Math.sqrt(d)) / (2*a);
            double r2 = (-b - Math.sqrt(d)) / (2*a);
            System.out.println("The roots are real and distinct:");
            System.out.println("Root1 = " + r1);
            System.out.println("Root2 = " + r2);
        }
        else if (d == 0) {
            double r = -b / (2*a);
            System.out.println("The roots are real and equal:");
            System.out.println("Root1 = " + r);
            System.out.println("Root2 = " + r);
        }
        else {
            double realPart = -b / (2*a);
            double imgPart = Math.sqrt(-d) / (2*a);
            System.out.println("The roots are complex:");
            System.out.println("Root1 = " + realPart + " + " + imgPart + "i");
            System.out.println("Root2 = " + realPart + " - " + imgPart + "i");
        }

        input.close();
    }
}
