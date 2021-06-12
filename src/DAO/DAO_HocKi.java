package DAO;

import CONST_CODE.Code;
import POJO.Hocki;
import POJO.Kydangkihocphan;
import POJO.Lophoc;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.persistence.EntityGraph;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAO_HocKi {
    public static int createRecord(Hocki hocki)
    {
        int state = Code.THANH_CONG;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            session.save(hocki);
            tx.commit();
        }
        catch(Exception e)
        {
            tx.rollback();
            System.out.println(e);
            state = Code.THAT_BAI;
        }
        finally {
            session.close();
        }
        return state;
    }
    public static List<Hocki> displayRecords()
    {
        List<Hocki> dsHocKi = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            dsHocKi = session.createQuery("select hk from Hocki hk",Hocki.class).list();
            tx.commit();
        }
        catch (Exception e)
        {
            tx.rollback();
            System.err.println(e);
        }
        finally {
            session.close();
        }
        return dsHocKi;
    }
    public static int setStateRecord(String idHocKi)
    {
        int state = Code.THANH_CONG;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            session.createQuery("update Hocki hk set hk.trangThai = 0 where hk.trangThai = 1").executeUpdate();
            session.createQuery("update Hocki hk set hk.trangThai = 1 where hk.idHocKi = :idHocKi")
                    .setParameter("idHocKi",idHocKi).executeUpdate();
            tx.commit();
        }
        catch (Exception e)
        {
            state = Code.THAT_BAI;
            System.out.println(e);
            tx.rollback();
        }
        finally {
            session.close();
        }
        return state;
    }
    public static Hocki getCurrentHocKi()
    {
        Hocki hocki = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            TypedQuery<Hocki> query = session.createQuery("select hk from Hocki hk where hk.trangThai=1",Hocki.class);
            EntityGraph<Hocki> entityGraph = session.createEntityGraph(Hocki.class);
            entityGraph.addSubgraph("dsKyDangKiHocPhan");
            query.setHint("javax.persistence.fetchgraph",entityGraph);
            hocki = query.getSingleResult();
            tx.commit();
        }
        catch(Exception e)
        {
            tx.rollback();
        }
        finally {
            session.close();
        }
        return hocki;
    }
    public static int deleteRecord(String idHocKi)
    {
        int state = Code.THANH_CONG;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            Hocki hk = session.load(Hocki.class, idHocKi);
            session.delete(hk);
            tx.commit();
        }
        catch(Exception e)
        {
            tx.rollback();
            state = Code.THAT_BAI;
        }
        finally {
            session.close();
        }
        return state;
    }

}
