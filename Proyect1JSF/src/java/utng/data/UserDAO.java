package utng.data;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import utng.model.User;

public class UserDAO extends DAO<User>{

    public UserDAO() {
        super(new User());
    }
    public User getOneById(User user) throws HibernateException {
        return super.getOneById(user.getIdUser()); 
    }
    public User login (User user){
        List<String> parameters= new ArrayList<String>();
        List<Object> values = new ArrayList<Object>();
        parameters.add("userName");
        parameters.add("pass");
        values.add(user.getUserName());
        values.add(user.getPass());
        user = query("SELECT u FROM "+model.getClass().getName()+" u WHERE u.userName =:userName AND u.pass=:pass", 
                parameters, values);
        return user;
    }
}