package com.lhq.test;

import com.lhq.domain.Customer;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {
    @Test
    public void testSave() {
//      1.加载配置文件创建实体管理器工厂
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myJpa");
//      2.根据实体管理器工厂，创建实体管理器
        EntityManager entityManager = entityManagerFactory.createEntityManager();
//      3.创建事务对象，开启事务
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
//      4.增删改查操作
        Customer customer = new Customer();
        customer.setCustName("好名字");
        customer.setCustIndustry("互联网");
        entityManager.persist(customer);
//      5.提交事务
        tx.commit();
//      6.释放资源
        entityManager.close();
        entityManagerFactory.close();

    }
}
