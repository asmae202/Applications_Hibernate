package ma.projet.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    // Crée une seule SessionFactory au démarrage (pattern Singleton)
    private static final SessionFactory sessionFactory = buildSessionFactory();

    // Méthode pour initialiser la SessionFactory
    private static SessionFactory buildSessionFactory() {
        try {
            // Configuration par défaut : lit hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Fournit la SessionFactory pour ouvrir des sessions
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Ferme la SessionFactory avant de quitter l'application
    public static void shutdown() {
        getSessionFactory().close();
    }
}
