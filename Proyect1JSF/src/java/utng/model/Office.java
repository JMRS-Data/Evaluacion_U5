package utng.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_office")
public class Office implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_Office")
    private Long idOffice;
    @Column(name="nombre_encargado", length=30)
    private String nameAttendant;
    @Column(length=40)
    private String ocupation;
     @Column(length=40)
    private String area;
    
    @ManyToOne()
    @JoinColumn(name="id_ip")
    private Ip ip;

    public Office() {
        this.idOffice=0L;
    }

    public Office(Long idOffice, String nameAttendant, String ocupation, String area, Ip ip) {
        super();
        this.idOffice = idOffice;
        this.nameAttendant = nameAttendant;
        this.ocupation = ocupation;
        this.area = area;
        this.ip = ip;
    }

    public Long getIdOffice() {
        return idOffice;
    }

    public void setIdOffice(Long idOffice) {
        this.idOffice = idOffice;
    }

    public String getNameAttendant() {
        return nameAttendant;
    }

    public void setNameAttendant(String nameAttendant) {
        this.nameAttendant = nameAttendant;
    }

    public String getOcupation() {
        return ocupation;
    }

    public void setOcupation(String ocupation) {
        this.ocupation = ocupation;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Ip getIp() {
        return ip;
    }

    public void setIp(Ip ip) {
        this.ip = ip;
    }
    
    

}
    