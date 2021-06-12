
package DAO;
import CONST_CODE.Code;
import POJO.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.GenerateIdUtil;
import utils.HibernateUtil;

import javax.persistence.EntityGraph;
import javax.persistence.TypedQuery;
import java.util.List;


public class DAO_LopHoc {
    public static int createRecord(Lophoc lophoc)
    {
        int state = Code.THANH_CONG;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            session.save(lophoc);
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
    public static List<Lophoc> displayRecord()
    {
        List<Lophoc> dsLopHoc = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            dsLopHoc = session.createQuery("select lh from Lophoc lh",Lophoc.class).list();
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
        return dsLopHoc;
    }
    /*public static Lophoc findLopHocByTenLopHoc(String tenLopHoc)
    {
        Lophoc result = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            result = (Lophoc) session.createQuery("select lh from Lophoc lh where lh.tenLopHoc = :tenLopHoc")
                    .setParameter("tenLopHoc",tenLopHoc).getSingleResult();
            tx.commit();
        }
        catch(Exception e)
        {
            tx.rollback();
        }
        finally {
            session.close();
        }
        return result;
    }*/
    public static Lophoc getLopHocById(String idLopHoc)
    {
        Lophoc lophoc = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            lophoc = session.get(Lophoc.class,idLopHoc);
            tx.commit();
        }
        catch(Exception e)
        {
            tx.rollback();
        }
        finally {
            session.close();
        }
        return lophoc;
    }
    public static List<Sinhvien> getListSinhVien(String idLopHoc)
    {
        List<Sinhvien> dsSinhVien = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            TypedQuery<Lophoc> query = session.createQuery("select lh " +
                             "from Lophoc lh where lh.idLopHoc =: idLopHoc",Lophoc.class)
                                .setParameter("idLopHoc",idLopHoc);
            EntityGraph<Lophoc> entityGraph = session.createEntityGraph(Lophoc.class);
            entityGraph.addSubgraph("dsSinhVien").addAttributeNodes("taiKhoan");
            query.setHint("javax.persistence.fetchgraph",entityGraph);
            dsSinhVien = query.getSingleResult().getDsSinhVien();
            tx.commit();
        }
        catch (Exception e)
        {
            System.err.println(e);
            tx.rollback();
        }
        return dsSinhVien;
    }
    public static int deleteRecord(String idLopHoc)
    {
        int state = Code.THANH_CONG;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            Lophoc lh = session.load(Lophoc.class, idLopHoc);
            session.delete(lh);
            tx.commit();
        }
        catch(Exception e)
        {
            state = Code.THAT_BAI;
            tx.rollback();
        }
        finally {
            session.close();
        }
        return state;
    }
    public static void main(String[] args)
    {
        List<Sinhvien> ds = getListSinhVien("lh");
        for(Sinhvien sv:ds)
        {
            System.out.println(sv.getHoVaTen());
        }
    }
}
