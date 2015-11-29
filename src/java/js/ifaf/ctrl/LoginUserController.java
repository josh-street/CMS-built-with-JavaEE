/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package js.ifaf.ctrl;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import js.ifaf.bus.BusinessException;
import js.ifaf.bus.UserService;
import js.ifaf.ent.UserPerson;

/**
 *
 * @author joshstreet
 */
@Named(value = "loginUserController")
@SessionScoped
public class LoginUserController implements Serializable {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    private UserService us; 

    private String loggedinUsername;

    public String getLoggedinUsername() {
        return loggedinUsername;
    }
    
    public UserPerson getloggedUser(){
        String user = loggedinUsername;
        return us.findUser(user);   
    }

    public void setLoggedinUsername(String loggedinUsername) {
        this.loggedinUsername = loggedinUsername;
    }

    public String login(String username) throws BusinessException {
        loggedinUsername = username;
        return username;
    }


   // @Remove
    public String logout() throws BusinessException {
        loggedinUsername = "unknown";
        return loggedinUsername;
    }
}
