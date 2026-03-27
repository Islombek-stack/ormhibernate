package org.example.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory session = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        try {
            return new Configuration()
                    .configure()
                    .buildSessionFactory();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
    public static SessionFactory getSessionFactory() {
        return session;
    }
    public static void shutdown() {
        getSessionFactory().close();
    }
}
