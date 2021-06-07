package DAO;

import POJO.Sinhvien;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

public class DAO_SinhVien {
    public static boolean createRecord(Sinhvien sinhvien)
    {
        boolean result = true;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            session.save(sinhvien);
            tx.commit();
        }
        catch (Exception e)
        {
            result = false;
            tx.rollback();
        }
        finally {
            session.close();
        }
        return result;
    }
    public static Sinhvien getSinhVienById(String id)
    {
        Sinhvien sinhvien =null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            sinhvien =  session.get(Sinhvien.class,id);
            tx.commit();
        }
        catch (Exception e)
        {
            tx.rollback();
        }
        finally {
            session.close();
        }
        return sinhvien;
    }
    public static void main(String[] args)
    {

    }
}
