/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package js.ifaf.ctrl;

import java.util.Arrays;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import js.ifaf.bus.BusinessException;
import js.ifaf.bus.CommentsService;
import js.ifaf.bus.ProposalService;
import js.ifaf.ent.Comments;
import js.ifaf.ent.Proposals;
import js.ifaf.ent.UserPerson;


/**
 *
 * @author joshstreet
 */
@Named(value = "proposalController")
@RequestScoped
public class ProposalController {
    @EJB
    private ProposalService ps;
    private Long selectedProposal;
    private String searchValue;
    private LoginUserController luc;
    @EJB
    private CommentsService cs;
    /**
     * Creates a new instance of ProposalController
     */
    public ProposalController() {
        this.up = new UserPerson();
    }
    
    private Proposals pro = new Proposals();
    private UserPerson up;
    private List<Comments> comList;
    private Comments com; 
    
    String[] voteRoles = { "SysAdmin", "Voter"}; 
    
    

    public UserPerson getLoggedUser(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        luc = (LoginUserController)facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "loginUserController");
        up = luc.getloggedUser();
        return up;
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

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public Comments getCom() {
        return com;
    }

    public void setCom(Comments com) {
        this.com = com;
    }
    
    public ProposalService getPs() {
        return ps;
    }

    public List<Proposals> getAllProposals() {
            return ps.findAll();  
    }
    
    public Proposals getFullProposal(){
        return ps.find(selectedProposal);
    }
    
    public List<Comments> getComments() {
        pro = ps.find(selectedProposal);
        comList = cs.findCommentsByProposal(pro);
        return comList;
    }
    
    public String doAddProposal() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            luc = (LoginUserController)facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "loginUserController");
            up = luc.getloggedUser();
            if(up != null){
                pro.setOwner(up);
                ps.addProposal(pro);
            } else {
                return "Error adding proposal, user not in database.";
            }
        } catch (BusinessException ex) {
            Logger.getLogger(ProposalController.class.getName()).log(Level.SEVERE, null, ex);
            FacesMessage fm = new FacesMessage(ex.getMessage());
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
        return "index";
    }
    
    public String doDeleteProposal(Proposals pro) {
        try {
            getLoggedUser();
            ps.deleteProposal(pro, up);
        } catch (BusinessException ex) {
            Logger.getLogger(ProposalController.class.getName()).log(Level.SEVERE, null, ex);
            FacesMessage fm = new FacesMessage(ex.getMessage());
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
        return "index";
    }
    
    public String doViewProposal(Proposals pro) {
        selectedProposal = pro.id;
        return "proposal";
    }
    
    public String doAddComment() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            luc = (LoginUserController)facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "loginUserController");
            up = luc.getloggedUser();
            cs.addComment(com, up, pro);
        } catch (BusinessException ex) {
            Logger.getLogger(ProposalController.class.getName()).log(Level.SEVERE, null, ex);
            FacesMessage fm = new FacesMessage(ex.getMessage());
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
        return "index";
    }
    
    public String doUpVote() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            luc = (LoginUserController)facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "loginUserController");
            up = luc.getloggedUser();
            String role = up.getDtype();
            if (Arrays.asList(voteRoles).contains(role)){
                ps.castVote("up", up, pro);
            }
        } catch (BusinessException ex) {
            Logger.getLogger(ProposalController.class.getName()).log(Level.SEVERE, null, ex);
            FacesMessage fm = new FacesMessage(ex.getMessage());
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
        return "index";
    }
}
