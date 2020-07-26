package club.cser.springroad.hibernate.dao;

import club.cser.springroad.hibernate.entity.Phone;
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

    public boolean updateManufactureById(String manufacture, Integer id) {
        String hql = "UPDATE Phone p SET p.manufacture = ?1 where p.id = ?2";

        return getSession().createQuery(hql)
                .setParameter(1, manufacture)
                .setParameter(2, id)
                .executeUpdate() == 1;
    }

    public boolean addPhone(String manufacture, String city) {
        String hql = "INSERT INTO Phone (manufacture, city) VALUES (?1, ?2)";

        return getSession().createSQLQuery(hql)
                .setParameter(1, manufacture)
                .setParameter(2, city)
                .executeUpdate() == 1;
    }

    public void addPhone1(String manufacture, String city) {
        Phone phone = new Phone();
        phone.setCity(city);
        phone.setManufacture(manufacture);
        phone.setSaleDate(new Date()); // 用 new Date在数据库里是CENTRAL DAYLIGHT TIMECDT (UTC-5)时间
        System.out.println(new Date()); // 输出时间是对的

        getSession().save(phone);
    }

}
