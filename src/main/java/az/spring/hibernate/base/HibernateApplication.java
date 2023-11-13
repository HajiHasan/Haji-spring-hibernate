package az.spring.hibernate.base;

import az.spring.hibernate.config.HibernateConfig;
import az.spring.hibernate.dao.EmployeeDao;
import az.spring.hibernate.daoImpl.EmployeeDaoImpl;
import az.spring.hibernate.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HibernateApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        EmployeeDao employeeDao = context.getBean(EmployeeDao.class);
        Employee employee = new Employee();

        employee.setName("Haji2");
        employee.setSurname("Hasanov2");
        employee.setAge(27);
        employee.setSalary(2000);

        employeeDao.insert(employee);
    }
}
