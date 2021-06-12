package DAO;

import POJO.Thongtingiaovu;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.persistence.EntityGraph;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAO_Thongtingiaovu {
    public static boolean creatRecord(Thongtingiaovu giaoVu)
    {
        boolean result = true;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            session.save(giaoVu);
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
    public static List<Thongtingiaovu> displayRecord()
    {
        List<Thongtingiaovu> dsGiaoVu = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            TypedQuery<Thongtingiaovu> query = session.createQuery("select gv from Thongtingiaovu gv",Thongtingiaovu.class);
            EntityGraph<Thongtingiaovu> entityGraph = session.createEntityGraph(Thongtingiaovu.class);
            entityGraph.addAttributeNodes("taiKhoan");
            query.setHint("javax.persistence.fetchgraph",entityGraph);
            dsGiaoVu = query.getResultList();
            tx.commit();
        }
        catch (Exception e)
        {
            tx.rollback();
        }
        finally {
            session.close();
        }
        return dsGiaoVu;
    }
    public static boolean updateRecord(String id,Thongtingiaovu thongTinMoi)
    {
        boolean state = true;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            Thongtingiaovu thongTin = session.get(Thongtingiaovu.class,id);
            thongTin.setHoVaTen(thongTinMoi.getHoVaTen());
            thongTin.setGioiTinh(thongTinMoi.getGioiTinh());
            thongTin.setNgaySinh(thongTinMoi.getNgaySinh());
            thongTin.setSoDienThoai(thongTinMoi.getSoDienThoai());
            thongTin.setEmail(thongTinMoi.getEmail());
            session.update(thongTin);
            tx.commit();
        }
        catch(Exception e)
        {
            state =false;
            tx.rollback();
        }
        finally {
            session.close();
        }
        return state;
    }
    public static void deleteRecord(String id)
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            Thongtingiaovu giaoVu =  session.load(Thongtingiaovu.class,id);
            session.delete(giaoVu);
            tx.commit();
        }
        catch(Exception e)
        {
            tx.rollback();
        }
        finally {
            session.close();
        }
    }
    public static Thongtingiaovu findThongTinGiaoVuById(String id)
    {
        Thongtingiaovu giaoVu = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            giaoVu =  session.get(Thongtingiaovu.class,id);
            tx.commit();
        }
        catch(Exception e)
        {
            tx.rollback();
        }
        finally {
            session.close();
        }
        return giaoVu;
    }
}
