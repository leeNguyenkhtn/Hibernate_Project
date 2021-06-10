package BUS;

import DAO.DAO_HocKi;
import DAO.DAO_KyDangKiHocPhan;
import POJO.Hocki;
import POJO.Kydangkihocphan;
import POJO.Lopdangkihocphan;

import java.util.List;

public class BUS_LopDangKiHocPhan {
    public static List<Lopdangkihocphan> danhSachHocPhan = capNhatDanhSachHocPhan();
    public static List<Lopdangkihocphan> capNhatDanhSachHocPhan()
    {
        if(BUS_KyDangKiHocPhan.kyHienTai!=null)
        {
            DAO_KyDangKiHocPhan.getListHocPhan(BUS_KyDangKiHocPhan.kyHienTai.getIdKyDangKiHocPhan());
        }
        return null;
    }

}
