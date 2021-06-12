package POJO;

import javax.persistence.*;
import java.sql.Date;

@Entity

public class Sinhviendangkihocphan {
    @EmbeddedId
    private SinhviendangkihocphanPK sinhviendangkihocphanPK;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idSinhVien")
    @JoinColumn(name = "sinhvien_idSinhVien")
    private Sinhvien sinhVien;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idHocPhan")
    @JoinColumn(name = "LopDangKiHocPhan_idLopDangKiHocPhan")
    private Lopdangkihocphan hocPhan;

    public Lopdangkihocphan getHocPhan()
    {
        return hocPhan;
    }
    public void setHocPhan(Lopdangkihocphan hocPhan) {
        this.hocPhan = hocPhan;
    }


    private Date thoiGianDangKi;

    @Basic
    @Column(name = "thoigiandangki" ,nullable = false)
    public Date getThoiGianDangKi() {
        return thoiGianDangKi;
    }
    public void setThoiGianDangKi(Date thoiGianDangKi) {
        this.thoiGianDangKi = thoiGianDangKi;
    }

    public SinhviendangkihocphanPK getSinhviendangkihocphanPK()
    {
        return   sinhviendangkihocphanPK;
    }

    public void setSinhviendangkihocphanPK(SinhviendangkihocphanPK sinhviendangkihocphanPK) {
        this.sinhviendangkihocphanPK = sinhviendangkihocphanPK;
    }

    public Sinhvien getSinhVien() {
        return sinhVien;
    }
    public void setSinhVien(Sinhvien sinhVien) {
        this.sinhVien = sinhVien;
    }


}
