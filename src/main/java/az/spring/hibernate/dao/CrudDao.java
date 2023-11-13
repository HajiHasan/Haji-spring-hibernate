package az.spring.hibernate.dao;

import az.spring.hibernate.model.Employee;

import java.util.List;
import java.util.Optional;

public interface CrudDao <ENTITY, ID>{
    void insert(ENTITY entity);
    void update(ENTITY entity);
    void delete(ID id);
    List<ENTITY> getAll();
    Optional<ENTITY> getById(ID id);
}
