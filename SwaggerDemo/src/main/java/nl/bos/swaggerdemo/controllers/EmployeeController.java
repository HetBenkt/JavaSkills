package nl.bos.swaggerdemo.controllers;

import nl.bos.swaggerdemo.data.Employee;
import nl.bos.swaggerdemo.data.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDao;

    @GetMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }

    @GetMapping(path = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployee(@PathVariable long id) {
        Employee employee = employeeDao.getEmployee(id);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> addEmployees(@RequestBody Employee employee) {
        long nextId = employeeDao.getEmployees().size() + 1;
        employee.setId(nextId);
        if (employeeDao.addEmployee(employee)) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping(path = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> deleteEmployee(@PathVariable long id) {
        boolean result = employeeDao.deleteEmployee(id);
        if (result) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
