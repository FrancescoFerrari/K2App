package com.k2.entity;

import javax.imageio.spi.ServiceRegistry;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

   private static final SessionFactory sessionFactory;
   private static ServiceRegistry serviceRegistry;

   static
    {
      try {
         // Create the SessionFactory from hibernate.cfg.xml
        //HIBERNATE 4
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = (ServiceRegistry) new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory((org.hibernate.service.ServiceRegistry) serviceRegistry);
        //HIBERNATE 3
        //sessionFactory = new Configuration().configure().buildSessionFactory();////sessionFactory =  new AnnotationConfiguration().configure().buildSessionFactory();
      }catch (Throwable ex){
         // Make sure you log the exception, as it might be swalledd
         System.err.println("Initial SessionFactory creation failed." + ex);
         throw new ExceptionInInitializerError(ex);
      }
   }

    public static SessionFactory getSessionFactory(){
      return sessionFactory;
   }
    
    /*
    private static SessionFactory sessionFactory;
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        HibernateUtil.sessionFactory = sessionFactory;
    }
    */
    
}