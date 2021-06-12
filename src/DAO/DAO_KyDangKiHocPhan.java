package DAO;

import CONST_CODE.Code;
import POJO.Kydangkihocphan;
import POJO.Lopdangkihocphan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.persistence.EntityGraph;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAO_KyDangKiHocPhan {
    public static int createRecord(Kydangkihocphan kydangkihocphan)
    {
        int state = Code.THANH_CONG;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            session.save(kydangkihocphan);
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
    public static List<Kydangkihocphan> displayrecords()
    {
        List<Kydangkihocphan> kydangkihocphanList = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            TypedQuery<Kydangkihocphan> query = session.createQuery("select kdkhp from Kydangkihocphan kdkhp");
            EntityGraph<Kydangkihocphan> entityGraph = session.createEntityGraph(Kydangkihocphan.class);
            entityGraph.addAttributeNodes("hocKi");
            query.setHint("javax.persistence.fetchgraph",entityGraph);
            kydangkihocphanList = query.getResultList();
            tx.commit();
        }
        catch(Exception e)
        {
            tx.rollback();
        }
        finally {
            session.close();
        }
        return kydangkihocphanList;
    }
    public static List<Lopdangkihocphan> getListHocPhan(String idKyDangKiHocPhan)
    {
        List<Lopdangkihocphan> danhSachHocPhan = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            TypedQuery<Kydangkihocphan> query = session.createQuery("select kdkhp " +
                    "from Kydangkihocphan kdkhp where kdkhp.idKyDangKiHocPhan = :id",Kydangkihocphan.class)
                    .setParameter("id",idKyDangKiHocPhan);
            EntityGraph<Kydangkihocphan> entityGraph = session.createEntityGraph(Kydangkihocphan.class);
            entityGraph.addSubgraph("danhSachHocPhan").addAttributeNodes("monHoc","lopHoc");

            query.setHint("javax.persistence.fetchgraph",entityGraph);
            danhSachHocPhan = query.getSingleResult().getDanhSachHocPhan();
            tx.commit();
        }
        catch (Exception e)
        {
            System.err.println(e);
            tx.rollback();
        }
        finally {
            session.close();
        }
        return danhSachHocPhan;
    }
    public static void main(String[] args)
    {
        List<Lopdangkihocphan> dsHP =  getListHocPhan("kdkhp");
        for(Lopdangkihocphan hp: dsHP)
        {
            System.out.println(hp.getLopHoc().getTenLopHoc());
        }

    }
}
