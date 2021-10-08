import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Valami {
    
    public ArrayList<Employee> loadFile(){
        ArrayList<Employee> employeeList = null;
        try {
            employeeList = tryLoadFile();
        } catch (FileNotFoundException e) {
            System.err.println("Hiba! A fájl nem található!");
        }
        return employeeList;
    }
    public ArrayList<Employee> tryLoadFile() throws FileNotFoundException {
        ArrayList<Employee> employeeList = null;
        FileReader fileReader = new FileReader("adat.txt");
        Scanner scanner = new Scanner(fileReader);
        employeeList = getEmployeesFromScanner(scanner);
        scanner.close();
        return employeeList;
    }
    private ArrayList<Employee> getEmployeesFromScanner(Scanner scanner) {
        ArrayList<Employee> employeeList = new ArrayList<>();
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Employee employee = getEmployeFromLine(line);
            employeeList.add(employee);
        }
        return employeeList;
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
