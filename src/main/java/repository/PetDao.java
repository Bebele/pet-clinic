package repository;

import model.Pet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

public class PetDao {
    public Pet findByIdPet(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Pet pet = session.find(Pet.class, id);
            return pet;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public void createPet(Pet pet) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(pet);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void updatePet(Pet pet) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(pet);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void deletePet(Pet pet) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(pet);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
}
