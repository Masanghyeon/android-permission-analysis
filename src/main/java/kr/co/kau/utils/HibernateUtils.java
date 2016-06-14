package kr.co.kau.utils;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import kr.co.kau.model.ApplicationVO;
import kr.co.kau.model.KeywordVO;
import kr.co.kau.model.PermissionVO;

public class HibernateUtils {
    public static SessionFactory createSessionFactory() throws Exception {
        File configurationFile = new File("src/main/resources/hibernate.cfg.xml");
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure(configurationFile).build();
        SessionFactory sessionFactory = new MetadataSources(registry)
/*                .addAnnotatedClass(ApplicationVO.class)
                .addAnnotatedClass(KeywordVO.class)*/
                .addAnnotatedClass(PermissionVO.class)
                .buildMetadata().buildSessionFactory();
        return sessionFactory;
    }
    
}