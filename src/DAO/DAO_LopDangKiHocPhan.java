package DAO;

import CONST_CODE.Code;
import POJO.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import javax.persistence.EntityGraph;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;
import java.util.Set;

public class DAO_LopDangKiHocPhan {
    public static int createRecord(Lopdangkihocphan lopdangkihocphan)
    {
        int state = Code.THANH_CONG;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            session.save(lopdangkihocphan);
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
    public static int deleteRecord(String id)
    {
        int state = Code.THANH_CONG;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            Lopdangkihocphan lopdangkihocphan = session.load(Lopdangkihocphan.class,id);
            session.delete(lopdangkihocphan);
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
    public static List<Lopdangkihocphan> displayRecords()
    {
        List<Lopdangkihocphan> danhSachHocPhan = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            TypedQuery<Lopdangkihocphan> query = session.createQuery("select hp from " +
                    "Lopdangkihocphan hp",Lopdangkihocphan.class);
            EntityGraph<Lopdangkihocphan> entityGraph = entityGraph = session.createEntityGraph(Lopdangkihocphan.class);
            entityGraph.addAttributeNodes("lopHoc");
            entityGraph.addAttributeNodes("monHoc");
            entityGraph.addAttributeNodes("kyDangKiHocPhan");
            query.setHint("javax.persistence.fetchgraph",entityGraph);
            danhSachHocPhan = query.getResultList();
            tx.commit();
        }catch (Exception e)
        {
            tx.rollback();
        }
        finally {
            session.close();
        }
        return danhSachHocPhan;
    }
    public static List<Sinhviendangkihocphan> listSinhVienInHocPhan(String idLopDangKiHocPhan)
    {
        List<Sinhviendangkihocphan> danhSachSV = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            TypedQuery<Lopdangkihocphan> query = session.createQuery("select hp " +
                    "from Lopdangkihocphan hp " +
                    "where hp.idLopDangKiHocPhan =: idLopDangKiHocPhan",Lopdangkihocphan.class)
                    .setParameter("idLopDangKiHocPhan",idLopDangKiHocPhan);
            EntityGraph<Lopdangkihocphan> entityGraph = session.createEntityGraph(Lopdangkihocphan.class);
            //entityGraph.addAttributeNodes("monHoc");
            entityGraph.addSubgraph("danhSachSinhVienDangKi").addAttributeNodes("sinhVien");
            query.setHint("javax.persistence.fetchgraph",entityGraph);
            danhSachSV = query.getSingleResult().getDanhSachSinhVienDangKi();
            tx.commit();
        }
        catch (Exception e)
        {
            System.out.println(e);
            tx.rollback();
        }
        finally {
            session.close();
        }
        return danhSachSV;
    }
    public static void main(String[] args)
    {
        List<Sinhviendangkihocphan> ds = listSinhVienInHocPhan("txQtym21JG5i");
        for(Sinhviendangkihocphan sv:ds)
        {
            System.out.println(sv.getSinhVien().getMssv());
        }
    }
}
