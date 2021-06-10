package DAO;

import CONST_CODE.Code;
import POJO.Hocki;
import POJO.Kydangkihocphan;
import POJO.Lopdangkihocphan;
import POJO.Lophoc;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.persistence.Entity;
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
    public static List<Lopdangkihocphan> getListHocPhan(String idKyDangKiHocPhan)
    {
        List<Lopdangkihocphan> danhSachHocPhan = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            TypedQuery<Kydangkihocphan> query = session.createQuery("select kdkhp " +
                    "from Kydangkihocphan kdkhp where kdkhp.idKyDangKiHocPhan =: id",Kydangkihocphan.class)
                    .setParameter("id",idKyDangKiHocPhan);
            EntityGraph<Lopdangkihocphan> entityGraph = session.createEntityGraph(Lopdangkihocphan.class);
            entityGraph.addSubgraph("dsLopDangKiHocPhan")
                    .addAttributeNodes("monHoc","lopHoc");

            query.setHint("javax.persistence.fetchgraph",entityGraph);
            danhSachHocPhan = query.getSingleResult().getDsLopDangKiHocPhan();
        }
        catch (Exception e)
        {
            tx.rollback();
        }
        finally {
            session.close();
        }
        return danhSachHocPhan;
    }
}
