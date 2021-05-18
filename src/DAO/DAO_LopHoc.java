
package DAO;
import POJO.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;


public class DAO_LopHoc {
    public static void layThongTinLopHoc(String idLopHoc)
    {
        List<Lophoc> dsLopHoc = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();

        Transaction tx = session.beginTransaction();
        try
        {

            String hql = "select lh from Lophoc lh";
            Query query = session.createQuery(hql);
            dsLopHoc = query.list();
            for(Lophoc lh: dsLopHoc)
            {
                List<Sinhvien> dsSV =  lh.getDsSinhVien();
                for(Sinhvien sv:dsSV)
                {
                    System.out.println(sv.getHoVaTen());
                }
            }
            //lophoc = (Lophoc) session.get(Lophoc.class,idLopHoc);
            /*if(dsLopHoc == null)
            {
                System.out.println("Fail");
            }*/
            tx.commit();

        }
        catch(HibernateException e)
        {
            System.out.println();
            e.printStackTrace();
            tx.rollback();
        }
        finally {
            session.close();
        }
    }
    public static void main(String[] args)
    {
        layThongTinLopHoc("18ctt4");
        /*if(lophoc!=null)
        {
            System.out.println(lophoc.getTongSoNam());
        }*/

    }
}
