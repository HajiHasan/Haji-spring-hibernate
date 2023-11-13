package az.spring.hibernate.base;

import az.spring.hibernate.config.HibernateConfig;
import az.spring.hibernate.dao.LeadersDao;
import az.spring.hibernate.model.Leaders;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HibernateApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        //EmployeeDao employeeDao = context.getBean(EmployeeDao.class);

        LeadersDao leadersDao = context.getBean(LeadersDao.class);
        Leaders leaders = new Leaders();

        leaders.setName("Rovshan");
        leaders.setSurname("Najaf");

        leadersDao.insert(leaders);





    }
}
