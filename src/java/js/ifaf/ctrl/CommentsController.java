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
import js.ifaf.bus.CommentsService;
import js.ifaf.ent.Comments;
import js.ifaf.ent.Proposals;
import js.ifaf.ent.UserPerson;

/**
 *
 * @author joshstreet
 */
@Named(value = "commentsController")
@RequestScoped
public class CommentsController {
    @EJB
    private CommentsService cs;
    
    private LoginUserController luc;
    /**
     * Creates a new instance of CommentsController
     */
    public CommentsController() {
        this.com = new Comments();
    }
    
    private UserPerson up;
    private Proposals pro;
    private Comments com;
    //private Long newId;

    public Comments getCom() {
        return com;
    }

    public void setCom(Comments com) {
        this.com = com;
    }

    public CommentsService getCs() {
        return cs;
    }

    public void setCs(CommentsService cs) {
        this.cs = cs;
    }
    
    public UserPerson getUp() {
        return up;
    }

    public void setUp(UserPerson up) {
        this.up = up;
    }

    public Proposals getPro() {
        return pro;
    }

    public void setPro(Proposals pro) {
        this.pro = pro;
    }
    
    public List<Comments> getAllComments() {
        return cs.findAll();    
    }
    
//    public List<Comments> getComments() {
//        // When realms work
//        //return cs.findCommentsByProposal(newId);
//        return cs.findCommentsByProposal(pro);
//    }

//    public String doAddComment() {
//        try {
//            FacesContext facesContext = FacesContext.getCurrentInstance();
//            luc = (LoginUserController)facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "loginUserController");
//            up = luc.getloggedUser();
//            cs.addComment(com, up, pro);
//        } catch (BusinessException ex) {
//            Logger.getLogger(ProposalController.class.getName()).log(Level.SEVERE, null, ex);
//            FacesMessage fm = new FacesMessage(ex.getMessage());
//            FacesContext fc = FacesContext.getCurrentInstance();
//            fc.addMessage(null, fm);
//        }
//        return "index";
//    }
    
        public String doAddComment() {
        return "index";
    }
    
}
