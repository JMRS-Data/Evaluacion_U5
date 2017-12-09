package utng.data;

import org.hibernate.HibernateException;
import utng.model.Office;



public class OfficeDAO extends DAO<Office> {
     public OfficeDAO() {
        super(new Office());
    }

    public Office getOneById(Office office) throws HibernateException {
        return super.getOneById(office.getIdOffice()); //To change body of generated methods, choose Tools | Templates.
    }
}