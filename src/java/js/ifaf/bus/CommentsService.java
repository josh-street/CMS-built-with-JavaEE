/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package js.ifaf.bus;

import javax.ejb.Stateless;
import java.util.List;
import javax.ejb.EJB;
import js.ifaf.ent.Comments;
import js.ifaf.ent.Proposals;
import js.ifaf.ent.UserPerson;
import js.ifaf.pers.CommentsFacade;

/**
 *
 * @author joshstreet
 */
@Stateless
public class CommentsService {
    
    @EJB
    private CommentsFacade cf;
    
    public List<Comments> findCommentsByText(String text) {
        return cf.findCommentsByText(text);
    }
    
    public List<Comments> findCommentsByProposal(Proposals pro) {
        return cf.findCommentsByProposal(pro);
    }

    public void create(Comments entity) {
        cf.create(entity);
    }

    public Comments edit(Comments entity) {
        return cf.edit(entity);
    }

    public void remove(Comments entity) {
        cf.remove(entity);
    }

    public Comments find(Object id) {
        return cf.find(id);
    }

    public List<Comments> findAll() {
        return cf.findAll();
    }

    public List<Comments> findRange(int[] range) {
        return cf.findRange(range);
    }

    public int count() {
        return cf.count();
    }
    
        public Comments addComment (Comments com, UserPerson up, Proposals pro) throws BusinessException {
        //search for people with same name
        List<Comments> list = cf.findCommentsByText(com.getText());
        if (list.isEmpty()) {
            com.setOwner(up);  
            com.setProposal(pro);
            cf.create(com);
        } else {
            throw new BusinessException("Proposal with title already exists " + com.getText());
        }
        return com;
        }
        

    public void addProposal(ProposalService ps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
