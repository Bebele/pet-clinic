package repository;

import model.Veterinarian;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utility.HibernateUtil;

import java.util.List;

public class VeterinarianDao {
    public Veterinarian findByIdVeterinarian(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Veterinarian veterinarian = session.find(Veterinarian.class, id);
            return veterinarian;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public void createVeterinarian(Veterinarian veterinarian) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(veterinarian);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void updateVeterinarian(Veterinarian veterinarian) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(veterinarian);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void deleteVeterinarian(Veterinarian veterinarian) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(veterinarian);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public List<Veterinarian> findByNameVeterinarian(String firstName) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Veterinarian where firstName:= firstName", Veterinarian.class);
            query.setParameter("firstName", firstName);

            List<Veterinarian> employeeList = query.list();

            return employeeList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
