package BUS;

import CONST_CODE.Code;
import DAO.DAO_MonHoc;
import POJO.Monhoc;

import java.util.List;

public class BUS_MonHoc {
    public static List<Monhoc> dsMonHoc = DAO_MonHoc.DisplayRecord();

    private static void updateList()
    {
        dsMonHoc = DAO_MonHoc.DisplayRecord();
    }
    public static int themMonHoc(String maMonHoc,String tenMonHoc,int soTinChi)
    {
        if(soTinChi<1)
        {
            return Code.SO_TIN_CHI_PHAI_LON_HON_1;
        }
        else if(maMonHoc.equals("")||tenMonHoc.equals(""))
        {
            return Code.KHONG_DUOC_BO_TRONG;
        }
        else {
            Monhoc monhoc = new Monhoc();
            monhoc.setIdMonHoc(utils.GenerateIdUtil.RandomId());
            monhoc.setMaMonHoc(maMonHoc);
            monhoc.setTenMonHoc(tenMonHoc);
            monhoc.setSoTinChi(soTinChi);
            if (DAO_MonHoc.CreateRecord(monhoc) == Code.THANH_CONG) {
                updateList();
                return Code.THANH_CONG;
            } else {
                return Code.THAT_BAI;
            }

        }
    }
    public static int xoaMonHoc(int index)
    {
        if(index<0)
        {
            return Code.CHON_HANG;
        }
        String id = dsMonHoc.get(index).getIdMonHoc();
        int state = DAO_MonHoc.deleteRecord(id);
        if(state==Code.THANH_CONG)
        {
            updateList();
        }
        return state;
    }
    public static int suaMonHoc(int index,String maMonHoc,String tenMonHoc,int soTinChi)
    {
        if(index<0)
        {
            return Code.CHON_HANG;
        }
        if(maMonHoc.equals("")||tenMonHoc.equals("")||soTinChi<1)
        {
            return Code.THAT_BAI;
        }
        else
        {
            Monhoc monHocMoi = new Monhoc();
            monHocMoi.setTenMonHoc(tenMonHoc);
            monHocMoi.setMaMonHoc(maMonHoc);
            monHocMoi.setSoTinChi(soTinChi);
            String id = dsMonHoc.get(index).getIdMonHoc();
            if(DAO_MonHoc.UpdateRecord(id, monHocMoi)==Code.THANH_CONG)
            {
                updateList();
                return Code.THANH_CONG;
            }
            else
            {
                return Code.THAT_BAI;
            }

        }
    }
}
