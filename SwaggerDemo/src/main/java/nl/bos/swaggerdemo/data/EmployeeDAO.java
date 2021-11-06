package nl.bos.swaggerdemo.data;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDAO {

    private static final List<Employee> employees = new ArrayList<>();

    static {
        employees.add(new Employee(1, "John Doe", 21));
        employees.add(new Employee(2, "Marry Jane", 33));
        employees.add(new Employee(3, "Harry Low", 15));
        employees.add(new Employee(4, "Keeth Jones", 56));
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public boolean addEmployee(Employee employee) {
        return employees.add(employee);
    }

    public Employee getEmployee(long id) {
        return employees.stream().filter(employee -> employee.getId() == id).findFirst().orElse(null);
    }
}
