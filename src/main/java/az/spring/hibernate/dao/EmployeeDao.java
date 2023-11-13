package az.spring.hibernate.dao;

import az.spring.hibernate.model.Employee;

import java.util.List;

public interface EmployeeDao {
    void insert(Employee employee);
    void update(Employee employee);
    void delete(int id);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);


}
