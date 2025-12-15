import java.util.Scanner;

class Book{
    private String name;
    private String author;
    private double price;
    private int num_pages;
    public Book(String name,String author,double price,int num_pages){
        this.name=name;
        this.author=author;
        this.price=price;
        this.num_pages=num_pages;
    }
    public void SetName(String name){
        this.name=name;
    }
    public void setauthor(String author){
        this.author=author;
    }
    public void setprice(double price){
        this.price=price;
    }
    public void setnumpages(int num_pages){
        this.num_pages=num_pages;
    }
    public String getname(){
        return name;
    }
    public String getauthor(){
        return author;
    }
    public int getnumpages(){
        return num_pages;
    }
    public String toString(){
        return "book name: "+name+
                "\nauthor: "+author+
                "\nprice: "+price+
                "\nnumber of pages: "+num_pages+ "\n";
        }

}

public class BookDemo{
    public static void main(String[] args){
        Scanner sc=new Scanner (System.in);

        System.out.println("enter number of books:");
        int n=sc.nextInt();
        sc.nextLine();

        Book[] books=new Book[n];

        for (int i=0;i<n;i++){
            System.out.println("\nenter details of book"+(i+1)+":");
            System.out.println("name: ");
            String name=sc.nextLine();
            System.out.println("author: ");
            String author=sc.nextLine();

            System.out.println("price: ");
            double price=sc.nextDouble();

            System.out.println("number of pages:");
            int pages=sc.nextInt();
            sc.nextLine();

            books[i]= new Book(name,author,price,pages);
        }
        System.out.println("---book details---");
        for (Book b:books){
            System.out.println(b.toString());
        }
        sc.close();

    }
}
