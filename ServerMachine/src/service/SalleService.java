package service;

import dao.IDao;
import entities.Salle;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class SalleService extends UnicastRemoteObject implements IDao<Salle> {

    public SalleService() throws RemoteException {
        super();
    }

    @Override
    public boolean create(Salle salle) throws RemoteException {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(salle);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return false;
    }

    @Override
    public boolean update(Salle salle) throws RemoteException {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(salle);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Salle salle) throws RemoteException {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(salle);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return false;
    }

    @Override
    public List<Salle> findAll() throws RemoteException {
        Session session = null;
        Transaction tx = null;
        List<Salle> salles = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            salles = session.getNamedQuery("findAll").list();
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return salles;
    }

    @Override
    public Salle findById(int id) throws RemoteException {
        Session session = null;
        Transaction tx = null;
        Salle salle = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            salle = (Salle) session.get(Salle.class, id);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return salle;
    }
}
