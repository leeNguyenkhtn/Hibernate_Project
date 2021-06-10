package DAO;

import CONST_CODE.Code;
import POJO.Lophoc;
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
    public static int updateRecord(Sinhvien sinhvien)
    {
        int state = Code.THANH_CONG;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            String idSinhVien = sinhvien.getIdSinhVien();

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

}
