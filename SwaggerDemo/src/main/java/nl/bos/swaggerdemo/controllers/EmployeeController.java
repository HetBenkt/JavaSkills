package nl.bos.swaggerdemo.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import nl.bos.swaggerdemo.data.Employee;
import nl.bos.swaggerdemo.data.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@Api(produces = MediaType.APPLICATION_JSON_VALUE, value = "Operations for employee management")
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDao;

    @GetMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get all employees", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all employees")
    }
    )
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeDao.getEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping(path = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get employee by ID", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved employee"),
            @ApiResponse(code = 404, message = "The employee you were trying to reach is not found")
    }
    )
    public ResponseEntity<Employee> getEmployee(@PathVariable long id) {
        Employee employee = employeeDao.getEmployee(id);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create a new employee", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created employee"),
            @ApiResponse(code = 500, message = "Something really bad went wrong on the server!")
    }
    )
    public ResponseEntity<Employee> addEmployees(@RequestBody Employee employee) {
        long nextId = employeeDao.getEmployees().size() + 1;
        employee.setId(nextId);
        if (employeeDao.addEmployee(employee)) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping(path = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Delete employee by ID", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Successfully deleted employee"),
            @ApiResponse(code = 404, message = "The employee you were trying to reach is not found"),
    }
    )
    public ResponseEntity<Employee> deleteEmployee(@PathVariable long id) {
        if (employeeDao.deleteEmployee(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(path = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update employee by ID", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully updated employee"),
            @ApiResponse(code = 404, message = "The employee you were trying to reach is not found"),
    }
    )
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
        if (employeeDao.updateEmployee(id, employee)) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
