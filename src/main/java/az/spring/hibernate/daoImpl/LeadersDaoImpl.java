package az.spring.hibernate.daoImpl;

import az.spring.hibernate.dao.LeadersDao;
import az.spring.hibernate.model.Leaders;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class LeadersDaoImpl extends AbstractSessionFactory implements LeadersDao {


    @Override
    @Transactional
    public void insert(Leaders leaders) {
        getSession().persist(leaders);

    }

    @Override
    @Transactional
    public void update(Leaders leaders) {
         getSession().merge(leaders);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Leaders leaders = getById(id)
                .orElseThrow(()->new RuntimeException("Id not found"));
        getSession().remove(leaders);
    }

    @Override
    @Transactional
    public List<Leaders> getAll() {
        return getSession()
                .createQuery("select l from Leaders l").list();
    }

    @Override
    @Transactional
    public Optional<Leaders> getById(Integer id) {
        Leaders leaders = getSession().get(Leaders.class, id);
        return Optional.ofNullable(leaders);
    }
}
