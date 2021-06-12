package BUS;

import CONST_CODE.Code;
import DAO.DAO_HocKi;
import DAO.DAO_KyDangKiHocPhan;
import POJO.Hocki;
import POJO.Kydangkihocphan;
import utils.DateUtil;
import utils.GenerateIdUtil;

import java.sql.Date;
import java.util.List;

public class BUS_KyDangKiHocPhan {
    public static Kydangkihocphan kyDangKyHocPhanHienTai = getKyDangKiHocPhanHienTai();
    public static int themKyDangKiHocPhan(String ngayBatDau,String thangBatDau, String namBatDau,
                                          String ngayKetThuc,String thangKetThuc,String namKetThuc)
    {

        Kydangkihocphan kydangkihocphan = new Kydangkihocphan();
        try
        {
            if(BUS_HocKi.hocKiHienTai==null)
            {
                return Code.CHUA_CO_HOC_KI_HIEN_TAI;
            }
            Date batDau = Date.valueOf(namBatDau+"-"+thangBatDau+"-"+ngayBatDau);
            Date ketThuc = Date.valueOf(namKetThuc+"-"+thangKetThuc+"-"+ngayKetThuc);
            if(DateUtil.CompareTwoDate(batDau,ketThuc)==Code.NGAY_TRUOC_LON_HON_NGAY_SAU)
            {
                return Code.NGAY_KHONG_HOP_LE;
            }
            if(DateUtil.CompareToToday(ketThuc)==Code.TRUOC_NGAY_HIEN_TAI)
            {
                return Code.NGAY_KHONG_HOP_LE;
            }
            if(kyDangKyHocPhanHienTai!=null)
            {
                if(DateUtil.CompareTwoDate(batDau,
                        kyDangKyHocPhanHienTai.getNgayKetThuc())==Code.NGAY_TRUOC_LON_HON_NGAY_SAU)
                {
                    return Code.THOI_GIAN_TRUNG_NHAU;
                }
            }

            kydangkihocphan.setIdKyDangKiHocPhan(GenerateIdUtil.RandomId());
            kydangkihocphan.setHocKi(BUS_HocKi.hocKiHienTai);
            kydangkihocphan.setNgayBatDau(batDau);
            kydangkihocphan.setNgayKetThuc(ketThuc);
        }
        catch (IllegalArgumentException e)
        {
            return Code.NGAY_KHONG_HOP_LE;
        }
        if(DAO_KyDangKiHocPhan.createRecord(kydangkihocphan)==Code.THANH_CONG)
        {
            kyDangKyHocPhanHienTai = getKyDangKiHocPhanHienTai();
            return Code.THANH_CONG;
        }
        else
        {
            return Code.THAT_BAI;
        }
    }
    public static Kydangkihocphan getKyDangKiHocPhanHienTai()
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
    public static List<Kydangkihocphan> danhSachKyDangKiHocPhan()
    {
        return DAO_KyDangKiHocPhan.displayrecords();
    }
}
