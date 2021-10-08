import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Valami {
    public ArrayList<Dolgozo> loadFile() throws FileNotFoundException {
        ArrayList<Dolgozo> employeeList = null;
        FileReader fileReader = new FileReader("adat.txt");
        Scanner scanner = new Scanner(fileReader);
        while(scanner.hasNextLine()) {
            Object foo = new Object();
        }
        scanner.close();
        return employeeList;
    }
}
