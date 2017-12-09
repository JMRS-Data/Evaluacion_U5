package utng.controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.data.IpDAO;
import utng.model.Ip;

@ManagedBean
@SessionScoped
public class IpBean implements Serializable{
    private List<Ip> ips;
    private Ip ip;
    public IpBean(){}

    public List<Ip> getIps() {
        return ips;
    }

    public void setIps(List<Ip> ips) {
        this.ips = ips;
    }

    public Ip getIp() {
        return ip;
    }

    public void setIp(Ip ip) {
        this.ip = ip;
    }
    
    
    public String list(){
        IpDAO dao = new IpDAO();
        try {
            ips=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Ips";
    }
    
    public String delete(){
         IpDAO dao = new IpDAO();
        try {
            dao.delete(ip);
            ips=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";
    }
    
    public String start(){
        ip = new Ip();
        return "Start";
    }
    
    public String save(){
        IpDAO dao = new IpDAO();
        try {
            if(ip.getIdIp()!= 0){
                dao.update(ip);
            }else {
                dao.insert(ip);
            }
            ips=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancel(){
    return "Cancel";
    }
    
    public String edit(Ip ip){
        this.ip=ip;
        return "Edit";
    }
    
}
