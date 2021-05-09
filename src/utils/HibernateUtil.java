package utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil{
    private static SessionFactory sessionFactory;

    static
    {
        try
        {

        }catch (HibernateException e)
        {
            e.printStackTrace();
        }
        Configuration configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
    }
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
