package az.spring.hibernate.daoImpl;

import az.spring.hibernate.dao.CrudDao;
import az.spring.hibernate.dao.EmployeeDao;
import az.spring.hibernate.model.Employee;
import com.mysql.cj.x.protobuf.MysqlxCursor;
import jakarta.persistence.Id;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDaoImpl extends AbstractSessionFactory implements EmployeeDao {

    @Override
    @Transactional
    public void insert(Employee employee) {
         getSession().persist(employee);
    }
    @Override
    @Transactional
    public void update(Employee employee) {
        getSession().merge(employee);
    }


    @Override
    @Transactional
    public void delete(Integer id) {
       Employee employee =  getById(id)
                .orElseThrow(() -> new RuntimeException("Id not found"));
        getSession().remove(employee);

    }
    @Transactional
    @Override
    public List<Employee> getAll() {
       return getSession()
               .createQuery("select e from Employee e").list();
    }

    @Transactional
    @Override
    public Optional<Employee> getById(Integer id) {
        Employee employee = getSession().get(Employee.class, id);

        return Optional.ofNullable(employee);
    }
}
