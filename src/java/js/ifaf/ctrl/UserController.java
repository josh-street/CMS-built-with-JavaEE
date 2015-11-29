/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package js.ifaf.ctrl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import js.ifaf.bus.BusinessException;
import js.ifaf.bus.InitService;
import js.ifaf.bus.UserService;
//import js.ifaf.ent.Address;
import js.ifaf.ent.UserPerson;

/**
 *
 * @author joshstreet
 */
@Named(value = "userController")
@RequestScoped
public class UserController {
    @EJB
    private UserService us;
    /**
     * Creates a new instance of UserController
     */
    public UserController() {
    }

    private UserPerson up = new UserPerson();
    //private Address address = new Address();

    public UserPerson getUp() {
        return up;
    }

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

    public void setUp(UserPerson up) {
        this.up = up;
    }

    public String doAddUser() {
        try {
            //us.addUser(up, address);
            up.setDtype("UnapprovedUser");
            us.addUser(up);
        } catch (BusinessException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            FacesMessage fm = new FacesMessage(ex.getMessage());
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
        return "";
    }
    
    public String doDeleteUser() {
        try {
            //us.deleteUser(up, address);
            us.deleteUser(up);
        } catch (BusinessException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            FacesMessage fm = new FacesMessage(ex.getMessage());
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
        return "";
    }

    public UserService getUs() {
        return us;
    }

//    public List<Address> getResidences() {
//        return us.findAllResidences();
//    }

    public List<UserPerson> getAllUsers() {
        return us.findAllUsers();
    }

    @EJB
    private InitService is;

    public String doInit() {
        try {
            is.initialise();
        } catch (BusinessException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            FacesMessage fm = new FacesMessage(ex.getMessage());
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
        return "";
    }
}
