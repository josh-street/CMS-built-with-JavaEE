/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package js.ifaf.pers;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import js.ifaf.ent.UserPerson;

/**
 *
 * @author joshstreet
 */
@Stateless
public class UserPersonFacade extends AbstractFacade<UserPerson> {
    @PersistenceContext(unitName = "entwa2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserPersonFacade() {
        super(UserPerson.class);
    }

    public List<UserPerson> findUsersByUsername(String username) {
        Query q = em.createQuery("SELECT u FROM UserPerson u WHERE u.username = :username");
        q.setParameter("username", username);
        return q.getResultList();
    }
    
    public List<UserPerson> findUserByUsername(String username) {
        Query q = em.createQuery("SELECT u FROM UserPerson u WHERE u.username = :username");
        q.setParameter("username", username);
        return q.getResultList();
    }

//    public List<UserPerson> findUsersByCity(String city) {
//        Query q = em.createQuery("SELECT u FROM UserPerson u WHERE u.home.city = :city");
//        q.setParameter("city", city);
//        return q.getResultList();
//    }

    static final String[] initNames = {"Jim", "John", "Jack"};

    public List<UserPerson> createInitialData() {
        List<UserPerson> l = new ArrayList<>();
        for (String s : initNames) {
            UserPerson up = new UserPerson();
            up.setFirstname(s);
            up.setLastname("Testuser");
            this.create(up);
            l.add(up);
        }
        return l;
    }
}
