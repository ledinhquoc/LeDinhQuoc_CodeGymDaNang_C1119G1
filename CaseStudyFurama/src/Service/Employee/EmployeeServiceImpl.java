package Service.Employee;

import Models.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService {
    private static Map<String, Employee> employeeMap;

    static {
        employeeMap = new HashMap<>();
        employeeMap.put("001", new Employee("001", "Iker Casillas", 20, "Spain"));
        employeeMap.put("002", new Employee("002", "Michel Salgado", 24, "Spain"));
        employeeMap.put("003", new Employee("003", "Roberto Carlos", 22, "Brazil"));
        employeeMap.put("004", new Employee("004", "Zinedine Zidane", 25, "France"));
        employeeMap.put("005", new Employee("005", "Ronaldo", 26, "Brazil"));
    }

    @Override
    public List<Employee> getAllEmployee() {
        return new ArrayList<>(employeeMap.values());
    }
}
