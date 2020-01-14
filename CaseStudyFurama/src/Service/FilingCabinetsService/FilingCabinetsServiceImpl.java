package Service.FilingCabinetsService;

import Models.Employee;
import java.util.Stack;

public class FilingCabinetsServiceImpl implements FilingCabinetsService {
private static Stack<Employee> employees;

static {
    employees = new Stack<>();
    employees.push(new Employee("001", "Lê Đình Quốc 1", 27, "Da Nang"));
    employees.push(new Employee("002", "Lê Đình Quốc 2", 27, "Da Nang"));
    employees.push(new Employee("003", "Lê Đình Quốc 3", 27, "Da Nang"));
    employees.push(new Employee("004", "Lê Đình Quốc 4", 27, "Da Nang"));
    employees.push(new Employee("005", "Lê Đình Quốc 5", 27, "Da Nang"));
}
@Override
    public Employee findEmployeeById(String id){
    Stack<Employee> employees1 = employees;
    while (true){
        Employee employee = employees1.pop();
        if (employee == null){
            break;
        }
        if (id.equals(employee.getIdEmployee())){
            return employee;
        }
    }
    return null;
}
}
