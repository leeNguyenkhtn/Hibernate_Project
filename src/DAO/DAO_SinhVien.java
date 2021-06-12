package DAO;

import CONST_CODE.Code;
import POJO.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.persistence.EntityGraph;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;


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
    public static int updateRecord(Sinhvien sinhvien)
    {
        int state = Code.THANH_CONG;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            String idSinhVien = sinhvien.getIdSinhVien();
            //
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
    public static List<Sinhviendangkihocphan> getListHocPhanDangKi(String idSinhVien)
    {
        List<Sinhviendangkihocphan> danhSachLopDangKhiHocPhan = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            TypedQuery<Sinhvien> query = session.createQuery("select sv from Sinhvien sv " +
                    "where sv.idSinhVien =:id",Sinhvien.class).setParameter("id",idSinhVien);
            EntityGraph<Sinhvien> entityGraph = session.createEntityGraph(Sinhvien.class);
            entityGraph.addSubgraph("danhSachDangKiHocPhan").addAttributeNodes("hocPhan");
            query.setHint("javax.persistence.fetchgraph",entityGraph);
            danhSachLopDangKhiHocPhan = query.getSingleResult().getDanhSachDangKiHocPhan();
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
        return danhSachLopDangKhiHocPhan;
    }
    public static int setLopHoc(String idSinhVien,String idLopHoc)
    {
        int state = Code.THANH_CONG;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            Sinhvien sinhvien = session.load(Sinhvien.class,idSinhVien);
            Lophoc lophoc = session.load(Lophoc.class,idLopHoc);
            sinhvien.setLopHoc(lophoc);
            if(sinhvien.getGioiTinh().equals("Nam"))
            {
                lophoc.setTongSoNam(lophoc.getTongSoNam()+1);
            }
            else
            {
                lophoc.setTongSoNu(lophoc.getTongSoNu()+1);
            }
            lophoc.setTongSoSv(lophoc.getTongSoSv()+1);
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
    public static String getIdSinhVienByMSSV(String mssv)
    {
        String idSinhVien = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
             idSinhVien = (String) session.createQuery("select sv.idSinhVien " +
                     "from Sinhvien sv where sv.mssv =:maSoSV ").setParameter("maSoSV",mssv).getSingleResult();
             tx.commit();
        }
        catch (Exception e)
        {
            tx.rollback();
        }
        finally {
            session.close();
        }
        return idSinhVien;
    }
    public static Sinhvien getSinhVienById(String id)
    {
        Sinhvien sinhvien =null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            sinhvien = session.get(Sinhvien.class,id);
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
    public static int createNewRegister(String idSinhvien, String idHocPhan, Date toDay)
    {
        int state = Code.THANH_CONG;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            Sinhvien sinhvien = session.load(Sinhvien.class,idSinhvien);
            Lopdangkihocphan hocPhan = session.load(Lopdangkihocphan.class,idHocPhan);
            Sinhviendangkihocphan sinhviendangkihocphan = new Sinhviendangkihocphan();
            sinhviendangkihocphan.setSinhVien(sinhvien);
            sinhviendangkihocphan.setHocPhan(hocPhan);
            sinhviendangkihocphan.setThoiGianDangKi(toDay);
            String serial = (String)session.save(sinhviendangkihocphan);
            System.out.println(serial);
        }
        catch (Exception e)
        {
            System.err.println(e);
            state = Code.THAT_BAI;
            tx.rollback();
        }
        finally {
            session.close();
        }
        return state;
    }
}
