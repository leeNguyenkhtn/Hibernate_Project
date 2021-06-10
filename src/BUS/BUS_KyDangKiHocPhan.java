package BUS;

import CONST_CODE.Code;
import DAO.DAO_HocKi;
import POJO.Hocki;
import POJO.Kydangkihocphan;
import utils.DateUtil;

public class BUS_KyDangKiHocPhan {
    public static Kydangkihocphan kyHienTai = getKyHienTai();
    public static Kydangkihocphan getKyHienTai()
    {
        Hocki hocKiHienTai = DAO_HocKi.getCurrentHocKi();
        if(hocKiHienTai!=null)
        {
            if(hocKiHienTai.getDsKyDangKiHocPhan()!=null)
            {
                for(Kydangkihocphan kydangkihocphan:hocKiHienTai.getDsKyDangKiHocPhan())
                {
                    if(DateUtil.CompareToToday(kydangkihocphan.getNgayBatDau())== Code.TRUOC_NGAY_HIEN_TAI&&
                            DateUtil.CompareToToday(kydangkihocphan.getNgayKetThuc())==Code.SAU_NGAY_HIEN_TAI)
                    {
                        return kydangkihocphan;
                    }
                }
            }
        }
        return null;
    }

}
