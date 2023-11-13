package az.spring.hibernate.dao;

import az.spring.hibernate.model.Employee;

import java.util.List;

public interface EmployeeDao extends CrudDao<Employee,Integer>{
    List<Employee> findByName(String name);
}
