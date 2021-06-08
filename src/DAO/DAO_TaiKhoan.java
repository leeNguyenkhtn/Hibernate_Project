package DAO;

import POJO.Sinhvien;
import POJO.Taikhoan;
import POJO.Thongtingiaovu;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import utils.GenerateIdUtil;
import CONST_CODE.Code;
import javax.persistence.NoResultException;
import java.util.List;

public class DAO_TaiKhoan {
    public static String createRecord(String tenDangNhap,String matKhau,String dinhDanh)
    {
        String id = null;
        Taikhoan taiKhoan;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            taiKhoan = new Taikhoan();
            id = GenerateIdUtil.RandomId();
            taiKhoan.setIdTaiKhoan(id);
            taiKhoan.setTenDangNhap(tenDangNhap);
            taiKhoan.setMatKhau(matKhau);
            taiKhoan.setDinhDanh(dinhDanh);
            session.save(taiKhoan);
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
        return id;
    }
    public static boolean createRecord(Taikhoan taikhoan)
    {
        boolean result = true;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            session.save(taikhoan);
            tx.commit();
        }
        catch (Exception e)
        {
            System.err.println(e);
            tx.rollback();
            result = false;
        }
        finally {
            session.close();
        }
        return result;
    }
    public static List<Taikhoan> displayRecord()
    {
        List<Taikhoan> dsTaiKhoan = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            dsTaiKhoan = session.createQuery("select tk from Taikhoan tk",Taikhoan.class).list();
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
        return dsTaiKhoan;
    }
    public static int updatePassword(String tenDangNhap, String matKhauCu,String matKhauMoi)
    {
        Taikhoan taikhoan =null;
        String  id = findTaiKhoanByUserName(tenDangNhap).getIdTaiKhoan();
        int result = 0;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {

            if(id!=null)
            {
                taikhoan = session.get(Taikhoan.class,id);
                if(taikhoan.getMatKhau().equals(matKhauCu))
                {
                    taikhoan.setMatKhau(matKhauMoi);
                    session.update(taikhoan);
                }
                else
                {
                    result = Code.MAT_KHAU_KHONG_DUNG;
                }
            }
            else
            {
                result = Code.TEN_DANG_NHAP_KHONG_TON_TAI;
            }
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
        return result;
    }
    public static Taikhoan findTaiKhoanByUserName(String tenDangNhap)
    {
        Taikhoan tk = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            String hql = "select tk from Taikhoan tk where tk.tenDangNhap = :tenDangNhap";
            tk = session.createQuery(hql,Taikhoan.class)
                    .setParameter("tenDangNhap",tenDangNhap).getSingleResult();
            tx.commit();
        }
        catch (NoResultException e)
        {
            tk = null;
            System.err.println(e);
            tx.rollback();
        }
        finally {
            session.close();
        }
        return tk;
    }
    public static boolean deleteRecord(String id)
    {
        boolean resutl = true;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            Taikhoan taikhoan = session.load(Taikhoan.class,id);
            session.delete(taikhoan);
            tx.commit();
        }
        catch (Exception e)
        {
            System.err.println(e);
            resutl = false;
            tx.rollback();
        }
        finally {
            session.close();
        }
        return resutl;
    }
}
