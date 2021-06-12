package BUS;

import CONST_CODE.Code;
import DAO.DAO_HocKi;
import POJO.Hocki;
import utils.DateUtil;

import java.sql.Date;
import java.util.List;

public class BUS_HocKi {
    public static List<Hocki> danhSachHocKi = DAO_HocKi.displayRecords();
    public static Hocki hocKiHienTai = DAO_HocKi.getCurrentHocKi();
    public static void capNhatDanhSachHocKi()
    {
        danhSachHocKi = DAO_HocKi.displayRecords();
    }
    public static int themHocKi(String tenHocKi,String namHoc,String ngayBatDau,String thangBatDau, String namBatDau,
                                String ngayKetThuc,String thangKetThuc,String namKetThuc)
    {
        Hocki hocki = new Hocki();
        try
        {
            hocki.setIdHocKi(utils.GenerateIdUtil.RandomId());
            hocki.setTenHocKi(tenHocKi);
            hocki.setNamHoc(namHoc);
            hocki.setNgayBatDau(Date.valueOf(namBatDau+"-"+thangBatDau+"-"+ngayBatDau));
            hocki.setNgayKetThuc(Date.valueOf(namKetThuc+"-"+thangKetThuc+"-"+ngayKetThuc));
            hocki.setTrangThai(0);
        }catch (IllegalArgumentException e)
        {
            return Code.THAT_BAI;
        }
        if(DAO_HocKi.createRecord(hocki)== Code.THANH_CONG)
        {
            capNhatDanhSachHocKi();
            capNhatHocKiHienTai();
            return Code.THANH_CONG;
        }
        else
        {
            return Code.THAT_BAI;
        }
    }
    public static int xoaHocKi (int index)
    {
        if(index>=0&&index<danhSachHocKi.size())
        {
            String idHocKi = danhSachHocKi.get(index).getIdHocKi();
            if(DAO_HocKi.deleteRecord(idHocKi)==Code.THANH_CONG)
            {
                capNhatDanhSachHocKi();
                capNhatHocKiHienTai();
                return Code.THANH_CONG;
            }
        }
        return Code.THAT_BAI;
    }
    public static int setHocKiHienTai(int index)
    {
        if(index>=0&&index<danhSachHocKi.size())
        {
            if(danhSachHocKi.get(index).getTrangThai()==1)
            {
                return Code.DA_LA_HOC_KI_HIEN_TAI;
            }
            String idHocKi = danhSachHocKi.get(index).getIdHocKi();
            if(DateUtil.CompareToToday(danhSachHocKi.get(index).getNgayKetThuc())==Code.TRUOC_NGAY_HIEN_TAI)
            {
                return Code.TRUOC_NGAY_HIEN_TAI;
            }
            if(DateUtil.CompareToToday(danhSachHocKi.get(index).getNgayBatDau())==Code.SAU_NGAY_HIEN_TAI)
            {
                return Code.SAU_NGAY_HIEN_TAI;
            }
            if(DAO_HocKi.setStateRecord(idHocKi)==Code.THANH_CONG)
            {
                capNhatDanhSachHocKi();
                capNhatHocKiHienTai();
                return Code.THANH_CONG;
            }
        }
        return Code.THAT_BAI;
    }
    public static void capNhatHocKiHienTai()
    {
        hocKiHienTai = DAO_HocKi.getCurrentHocKi();
    }
}
