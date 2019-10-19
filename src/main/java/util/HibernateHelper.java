package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateHelper {
    private final static String LOCK_OBJECT = "";
    private static HibernateHelper instance;
    private final SessionFactory factory;

    private HibernateHelper() {
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        config.setProperty("hibernate.connection.username", System.getenv("DB_PROJECT_USER"));
        config.setProperty("hibernate.connection.password", System.getenv("DB_PROJECT_PASSWORD"));
        factory = config.buildSessionFactory();
    }

    public static HibernateHelper getInstance() {
        //Make the singleton to be thread safe
        synchronized (LOCK_OBJECT) {
            if (null == instance) {
                instance = new HibernateHelper();
            }
        }
        return instance;
    }

    public void beginTransactionIfAllowed() {
        Session theSession = factory.openSession();
        if (!theSession.getTransaction().isActive()) {
            theSession.beginTransaction();
        } else {
            theSession.getTransaction().rollback();
            theSession.beginTransaction();
        }
    }

}
