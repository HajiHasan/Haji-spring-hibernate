package az.spring.hibernate.daoImpl;

import az.spring.hibernate.dao.EmployeeDao;
import az.spring.hibernate.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class EmployeeDaoImpl extends AbstractSessionFactory implements EmployeeDao {

    @Override
    @Transactional
    public void insert(Employee employee) {
         getSession().persist(employee);
    }
    @Override
    public void update(Employee employee) {

    }

    @Transactional
    @Override
    public void delete(int id) {
        getSession().remove(getEmployeeById(id));

    }
    @Transactional
    @Override
    public List<Employee> getAllEmployees() {
       return getSession().createQuery("select e from Employee e").list();
    }

    @Transactional
    @Override
    public Employee getEmployeeById(int id) {
        return getSession().get(Employee.class, id);
    }
}
