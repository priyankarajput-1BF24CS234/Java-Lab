import java.util.Scanner;
class WrongAge extends Exception {
    public WrongAge(String message) {
        super(message);
    }
}
class Father {
    int fatherAge;

    Father(int age) throws WrongAge {
        if (age < 0) {
            throw new WrongAge("Father's age cannot be negative");
        }
        fatherAge = age;
    }
}
class Son extends Father {
    int sonAge;

    Son(int fAge, int sAge) throws WrongAge {
        super(fAge);   // Call Father constructor

        if (sAge < 0) {
            throw new WrongAge("Son's age cannot be negative");
        }
        if (sAge >= fAge) {
            throw new WrongAge("Son's age must be less than Father's age");
        }

        sonAge = sAge;
    }
}

public class InheritanceExceptionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter father's age: ");
            int fAge = sc.nextInt();

            System.out.print("Enter son's age: ");
            int sAge = sc.nextInt();

            Son s = new Son(fAge, sAge);

            System.out.println("Father's Age: " + fAge);
            System.out.println("Son's Age: " + sAge);
            System.out.println("Object created successfully");

        } catch (WrongAge e) {
            System.out.println("Exception caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter integers only.");
        }

        sc.close();
    }
}



