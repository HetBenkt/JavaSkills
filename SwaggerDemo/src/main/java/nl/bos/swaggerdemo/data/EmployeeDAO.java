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

    public boolean deleteEmployee(long id) {
        Employee result = employees.stream().filter(employee -> employee.getId() == id).findFirst().orElse(null);
        if (result != null) {
            employees.remove(result);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateEmployee(long id, Employee employee) {
        Employee result = employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        if (result != null) {
            result.setName(employee.getName());
            result.setAge(employee.getAge());
            return true;
        } else {
            return false;
        }
    }
}
