/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package js.ifaf.ctrl;

import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import js.ifaf.bus.BusinessException;
import js.ifaf.ent.UserPerson;

/**
 *
 * @author joshstreet
 */
@Named(value = "loginController")
@RequestScoped
public class LoginController implements Serializable {
    private String username;
    private String password;
    private UserPerson loggedInUser;

    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;

    }

    public UserPerson getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(UserPerson loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
    
    

    
    private LoginUserController luc;

//   // Un-comment to use realms. <not working>
//    public String doLogin() {
//        System.out.println(this.username);
//        System.out.println(this.password);
//        FacesContext context = FacesContext.getCurrentInstance();
//        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
//        try {
//            request.login(this.username, this.password);
//        } catch (ServletException e) {
//            context.addMessage(null, new FacesMessage("Login failed."));
//            return "error";
//        }
//        return "index";
//    }
    public LoginUserController getContext(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return (LoginUserController)facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "loginUserController");
    }
    
        public String doLogin() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            luc = (LoginUserController)facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "loginUserController");
            luc.login(username);
        } catch (BusinessException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "view/index";
    }

    public String getLoggedinUsername() {
        luc = getContext();
        return luc.getLoggedinUsername();
    }
    
    public UserPerson getLoggedUser() {
        luc = getContext();
        return luc.getloggedUser();
    }
    
  private static final Logger log = Logger.getLogger(LoginController.class.getName());
   
  public String dologout() {
    String result="/index?faces-redirect=true";
     
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
     
    try {
      request.logout();
    } catch (ServletException e) {
      log.log(Level.SEVERE, "Failed to logout user!", e);
      result = "/loginError?faces-redirect=true";
    }
     
    return result;
  }
}
