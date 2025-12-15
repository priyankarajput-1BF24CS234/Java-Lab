import java.util.Scanner;

abstract class Shape{
    int a,b;
    abstract void printArea();
}
class Rectangle extends Shape{
    Rectangle(int length, int breadth){
        a=length;
        b=breadth;
    }
    void printArea(){
        System.out.println("area of rectangle: "+(a*b));
    }
}
class Triangle extends Shape{
    Triangle (int x,int y){
        a=x;
        b=y;
    }
    void printArea(){
        System.out.println("area of triangle :"+(0.5*a*b));
    }
}
class Circle extends Shape{
    Circle (int r){
        a=r;
    }
    void printArea(){
        System.out.println("Area of circle:"+(3.14*a*a));
    }
}
public class ShapeMain{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("enter length and breadth of rectangle:");
        int l=sc.nextInt();
        int b=sc.nextInt();
        Rectangle rect=new Rectangle(l,b);

        System.out.println("enter base and height of triangle:");
        int base=sc.nextInt();
        int height=sc.nextInt();
        Triangle tri=new Triangle(base,height);

        System.out.println("enter radius of circle:");
        int r=sc.nextInt();
        Circle cir=new Circle(r);

        rect.printArea();
        tri.printArea();
        cir.printArea();
    }
}
