package inputfile;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Inputfile {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String folder, fileName;
        folder = "C:\\Users\\pandy\\Documents\\UGM\\Akademik\\Semester 2\\MII1212 Praktikum Pemrograman II\\UTS\\Materi\\1";
        fileName = "1.txt";
        FileReader FR = new FileReader(folder+fileName);
        int temp = FR.read();
        while(temp != -1){
            System.out.print((char)temp);
            temp = FR.read();
        }
    }
    
}