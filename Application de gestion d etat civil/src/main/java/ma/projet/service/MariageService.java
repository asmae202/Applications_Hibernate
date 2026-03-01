package ma.projet.service;

import ma.projet.beans.Homme;
import ma.projet.beans.Femme;
import ma.projet.beans.Mariage;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class MariageService implements IDao<Mariage> {

    @Override
    public void add(Mariage m) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(m);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Mariage m) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(m);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Mariage m) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(m);
        tx.commit();
        session.close();
    }

    @Override
    public Mariage findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Mariage m = session.get(Mariage.class, id);
        session.close();
        return m;
    }

    @Override
    public List<Mariage> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Mariage> list = session.createQuery("from Mariage", Mariage.class).list();
        session.close();
        return list;
    }

    // Afficher les mariages d’un homme
    public void afficherMariagesHomme(int hommeId) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Mariage> mariages = session.createQuery(
                        "from Mariage m where m.homme.id = :hid order by m.id.dateDebut", Mariage.class)
                .setParameter("hid", hommeId)
                .list();

        System.out.println("Nom : " + (mariages.isEmpty() ? "" : mariages.get(0).getHomme().getNom() + " " + mariages.get(0).getHomme().getPrenom()));

        System.out.println("Mariages En Cours :");
        for (Mariage m : mariages) {
            if (m.getDateFin() == null) {
                System.out.print("Femme : " + m.getFemme().getPrenom() + " " + m.getFemme().getNom());
                System.out.print("   Date Début : " + m.getId().getDateDebut());
                System.out.println("   Nbr Enfants : " + m.getNbrEnfant());
            }
        }

        System.out.println("\nMariages échoués :");
        for (Mariage m : mariages) {
            if (m.getDateFin() != null) {
                System.out.print("Femme : " + m.getFemme().getPrenom() + " " + m.getFemme().getNom());
                System.out.print("   Date Début : " + m.getId().getDateDebut());
                System.out.print("   Date Fin : " + m.getDateFin());
                System.out.println("   Nbr Enfants : " + m.getNbrEnfant());
            }
        }
        session.close();
    }

    // Hommes mariés à 4 femmes entre deux dates
    public List<Homme> hommesMariesQuatreFemmes(Date debut, Date fin) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        String hql = "select m.homme from Mariage m " +
                "where m.id.dateDebut between :debut and :fin " +
                "group by m.homme.id having count(m.femme) = 4";

        Query<Homme> query = session.createQuery(hql, Homme.class);
        query.setParameter("debut", debut);
        query.setParameter("fin", fin);

        List<Homme> result = query.list();
        session.close();
        return result;
    }

    // Femmes mariées deux fois ou plus
    public List<Femme> femmesMarieesDeuxFoisOuPlus() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        String hql = "select m.femme from Mariage m " +
                "group by m.femme.id having count(m.homme) >= 2";

        Query<Femme> query = session.createQuery(hql, Femme.class);
        List<Femme> result = query.list();
        session.close();
        return result;
    }
}