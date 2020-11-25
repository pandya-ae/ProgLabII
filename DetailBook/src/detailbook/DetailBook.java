package detailbook;

public class DetailBook {
    public static void main(String[] args) {
        Book mybook=new Book();
        mybook.bookData("green", 1970);
        Sysem.out.println("The Detail of mybook: \n" + mybook.color + "\n" + mybook.year);
    }
    
}
