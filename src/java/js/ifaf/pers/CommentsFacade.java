/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package js.ifaf.pers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import js.ifaf.ent.Comments;
import js.ifaf.ent.Proposals;


/**
 *
 * @author joshstreet
 */
@Stateless
public class CommentsFacade extends AbstractFacade<Comments> {
    @PersistenceContext(unitName = "entwa2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommentsFacade() {
        super(Comments.class);
    }
    
    public List<Comments> findCommentsByText(String text) {
        Query q = em.createQuery("SELECT u FROM Comments u WHERE u.text = :text");
        q.setParameter("text", text);
        return q.getResultList();
    }
    
    public List<Comments> findCommentsByProposal(Proposals pro) {
        Query q = em.createQuery("SELECT u FROM Comments u WHERE u.proposal = :proposal");
        q.setParameter("proposal", pro);
        return q.getResultList();
    }
    
    static final String[] initNames = {"comment 1", "comment 2", "comment 3"};

    public List<Comments> createInitialData() {
        List<Comments> l = new ArrayList<>();
        for (String s : initNames) {
            Comments co = new Comments();
            Date d = new Date();
            co.setText(s);
            co.setTimestamp(d);
            this.create(co);
            l.add(co);
        }
        return l;
    }

    public List<Comments> findCommentsByText(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
