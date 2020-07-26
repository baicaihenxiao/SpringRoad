package club.cser.springroad.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ComputerDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public boolean addComputer(String brand, String city) {
        String hql = "INSERT INTO Computer (brand, city) VALUES (?1, ?2)";

        return getSession().createSQLQuery(hql)
                .setParameter(1, brand)
                .setParameter(2, city)
                .executeUpdate() == 1;
    }
}
