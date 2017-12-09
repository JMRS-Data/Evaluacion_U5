package utng.controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.data.IpDAO;
import utng.data.OfficeDAO;
import utng.model.Ip;
import utng.model.Office;


@ManagedBean(name="officeBean") 
@SessionScoped
public class OfficeBean implements Serializable{
    private List<Office>offices;
    private Office office;
    private List<Ip> ips;
    
    public OfficeBean(){
        office = new Office();
        office.setIp(new Ip());
    }

    public List<Office> getOffices() {
        return offices;
    }

    public void setOffices(List<Office> offices) {
        this.offices = offices;
    }

    public Office getOffice() {
        return office;
    }

    public void setOficina(Office office) {
        this.office = office;
    }
    
    public List<Ip> getIps() {
        return ips;
    }
    public void setIp(List<Ip> ips) {
        this.ips = ips;
    }
    
    
    public String list(){
       OfficeDAO dao = new OfficeDAO();
        try {
            offices = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Offices";
    }
    
    public String delete(){
         OfficeDAO dao = new OfficeDAO();
        try {
            dao.delete(office);
            offices = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }
    
    public String start(){
        office = new Office();
        office.setIp(new Ip());
        try {
            ips = new IpDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Start";
    }
    
    public String save(){
        OfficeDAO dao = new OfficeDAO();
        try {
            if(office.getIdOffice()!= 0){
                dao.update(office);
            }else {
                dao.insert(office);
            }
            offices=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancel(){
    return "Cancel";
    }
    
    public String edit(Office office){
        this.office = office;
        try {
            ips = new IpDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Edit";
    }
    
}
