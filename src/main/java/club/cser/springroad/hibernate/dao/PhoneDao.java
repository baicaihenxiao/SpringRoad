package club.cser.springroad.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;

@Repository
public class PhoneDao {
    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public String getManufactureById(Integer id) {
        // Phone标红是idea没有识别，在sessionFactory配置了mappingLocations。如果在hibernate.cfg.xml里配置mapping的话就不标红了。
        String hql = "SELECT p.manufacture from Phone p where p.id = ?1";
        Query query = getSession().createQuery(hql).setParameter(1, id);
        return (String)query.uniqueResult();
    }

    // hql 里的Phone和saleDate不是数据库里表和列的名字，而是程序里定义的类和字段的名字。0
    public Date getSaleDateById(Integer id) {
        String hql = "SELECT p.saleDate from Phone p where p.id = ?1";
        Query query = getSession().createQuery(hql).setParameter(1, id);
        return (Date)query.uniqueResult();
    }
}
