
package DAO;
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
    public static boolean createRecord(Lophoc lophoc)
    {
        boolean result = true;
        Taikhoan taiKhoan = null;
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
            System.err.println(e);
            result = false;
        }
        finally {
            session.close();
        }
        return result;
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
    public static Lophoc findLopHocByTenLopHoc(String tenLopHoc)
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
    }
    public static List<Sinhvien> getListSinhVienByTenLopHoc(String tenLopHoc)
    {
        List<Sinhvien> dsSinhVien = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            TypedQuery<Lophoc> query = session.createQuery("select lh " +
                             "from Lophoc lh where lh.tenLopHoc =: tenLopHoc",Lophoc.class)
                                .setParameter("tenLopHoc",tenLopHoc);
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
    public static boolean deleteRecord(Lophoc lophoc)
    {
        boolean result = true;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            session.delete(lophoc);
            tx.commit();
        }
        catch(Exception e)
        {
            System.err.print(e);
            result = false;
            tx.rollback();
        }
        finally {
            session.close();
        }
        return result;
    }
    public static void main(String[] args)
    {
        /*if(lophoc!=null)
        {
            System.out.println(lophoc.getTongSoNam());
        }*/
        Lophoc lophoc = new Lophoc();
        lophoc.setIdLopHoc(GenerateIdUtil.RandomId());
        lophoc.setTenLopHoc("19vllt2");
        lophoc.setTongSoNam(70);
        lophoc.setTongSoNu(15);
        lophoc.setTongSoSv(85);
        System.out.println(createRecord(lophoc));
    }
}
