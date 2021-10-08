import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Valami {
    ArrayList<Employee> employeeList;
    FileReader fileReader;
    Scanner scanner;

    public Valami() {
        initFile();
        loadFile();
    }

    private void initFile(){
        try {
            tryInitFile();
        } catch (FileNotFoundException e) {
            System.err.println("Hiba! A fájl nem található!");
        }
    }

    private void tryInitFile()  throws FileNotFoundException {
        this.fileReader = new FileReader("adat.txt");
        this.scanner = new Scanner(fileReader);
    }

    private void loadFile() {
        genEmployeesFromScanner();
        this.scanner.close();
    }
    
    private void genEmployeesFromScanner() {
        while(this.scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Employee employee = getEmployeFromLine(line);
            this.employeeList.add(employee);
        }
    }

    private Employee getEmployeFromLine(String line) {
        Employee employee = new Employee();
        String[] lineArray = line.split(":");
        employee.nev = lineArray[0];
        employee.telepules = lineArray[1];
        employee.fizetes = Double.parseDouble(lineArray[2]);
        return employee;
    }
}
