package DAO;

import CONST_CODE.Code;
import POJO.Monhoc;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class DAO_MonHoc {
    public static int CreateRecord(Monhoc monhoc)
    {
        int state = Code.THANH_CONG;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            session.save(monhoc);
            tx.commit();
        }
        catch (Exception e)
        {
            state = Code.THAT_BAI;
            tx.rollback();
        }
        finally {
            session.close();
        }
        return state;
    }
    public static List<Monhoc> DisplayRecord()
    {
        List<Monhoc> dsMonHoc = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            dsMonHoc = session.createQuery("select mh from Monhoc mh",Monhoc.class).list();
            tx.commit();
        }
        catch (Exception e)
        {
            tx.rollback();
        }
        finally {
            session.close();
        }
        return dsMonHoc;
    }
    public static Monhoc getMonHocById(String id)
    {
        Monhoc monhoc = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            monhoc = session.get(Monhoc.class,id);
            tx.commit();
        }
        catch (Exception e)
        {
            tx.rollback();
        }
        finally {
            session.close();
        }
        return monhoc;
    }
    public static int UpdateRecord(String id, Monhoc monHocMoi)
    {
        int state = Code.THANH_CONG;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            Monhoc monHoc = (Monhoc) session.load(Monhoc.class,id);
            monHoc.setMaMonHoc(monHocMoi.getMaMonHoc());
            monHoc.setTenMonHoc(monHocMoi.getTenMonHoc());
            monHoc.setSoTinChi(monHocMoi.getSoTinChi());
            session.update(monHoc);
            tx.commit();
        }
        catch (Exception e)
        {
            state =Code.THAT_BAI;
            tx.rollback();
        }
        finally {
            session.close();
        }
        return state;
    }
    public static int deleteRecord(String id)
    {
        int state = Code.THANH_CONG;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            Monhoc monhoc = session.get(Monhoc.class,id);
            session.delete(monhoc);
            tx.commit();
        }
        catch (Exception e)
        {
            state = Code.THAT_BAI;
            System.err.println(e);
            tx.rollback();
        }
        finally {
            session.close();
        }
        return state;
    }
    public static void main(String[] args)
    {
        System.out.println(getMonHocById("mh").getTenMonHoc());
    }
}
