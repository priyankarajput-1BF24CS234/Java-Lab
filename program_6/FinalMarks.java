import cie.*;
import see.*;
import java.util.Scanner;

public class FinalMarks{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of student " + (i + 1));

            System.out.print("USN: ");
            String usn = sc.next();

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Semester: ");
            int sem = sc.nextInt();

            int[] cieMarks = new int[5];
            int[] seeMarks = new int[5];

            System.out.println("Enter CIE marks (out of 50):");
            for (int j = 0; j < 5; j++) {
                cieMarks[j] = sc.nextInt();
            }

            System.out.println("Enter SEE marks (out of 50):");
            for (int j = 0; j < 5; j++) {
                seeMarks[j] = sc.nextInt();
            }

            Personal p = new Personal(usn, name, sem);
            Internals in = new Internals(cieMarks);
            External ex = new External(usn, name, sem, seeMarks);

            System.out.println("\nFinal Marks (CIE + SEE):");
            for (int j = 0; j < 5; j++) {
                System.out.println("Course " + (j + 1) + ": " +
                        (in.internalMarks[j] + ex.externalMarks[j]));
            }
        }
        sc.close();
    }
}
