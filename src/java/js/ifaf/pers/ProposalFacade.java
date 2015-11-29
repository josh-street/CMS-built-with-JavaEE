/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package js.ifaf.pers;

//import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import js.ifaf.ent.Proposals;
import js.ifaf.ent.UserPerson;

/**
 *
 * @author joshstreet
 */
@Stateless
public class ProposalFacade extends AbstractFacade<Proposals> {
    @PersistenceContext(unitName = "entwa2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProposalFacade() {
        super(Proposals.class);
    }
    
    public List<Proposals> findProposalsByTitle(String title) {
        Query q = em.createQuery("SELECT u FROM Proposals u WHERE u.title = :title");
        q.setParameter("title", title);
        return q.getResultList();
    }
    
    public List<Proposals> findProposalsByOwner(UserPerson owner) {
        Query q = em.createQuery("SELECT u FROM Proposals u WHERE u.owner = :owner");
        q.setParameter("owner", owner);
        return q.getResultList();
    }

//    static final String[] initNames = {"Jim", "John", "Jack"};
      
      
//    public List<UserPerson> createInitialData() {
//        List<UserPerson> l = new ArrayList<>();
//        for (String s : initNames) {
//            UserPerson up = new UserPerson();
//            up.setForename(s);
//            up.setSurname("Testuser");
//            this.create(up);
//            l.add(up);
//        }
//        return l;
//    }
}
