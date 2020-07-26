package club.cser.springroad.hibernate.entity;


import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

// 定义columnDefinition https://stackoverflow.com/questions/3110266/how-to-set-a-default-entity-property-value-with-hibernate

@Entity
@Table(name = "computer")
@DynamicInsert
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "brand", columnDefinition="varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT (_utf8mb4'')")
    private String brand;

    @Column(name = "city", columnDefinition="varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT (_utf8mb4'')")
    private String city;

    @Column(name = "buy_date", columnDefinition="datetime default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date buyDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }
}
