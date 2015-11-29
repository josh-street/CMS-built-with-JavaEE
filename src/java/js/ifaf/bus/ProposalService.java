/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package js.ifaf.bus;

import javax.ejb.Stateless;
import java.util.List;
import javax.ejb.EJB;
import js.ifaf.ent.Proposals;
import js.ifaf.ent.UserPerson;
import js.ifaf.pers.ProposalFacade;

/**
 *
 * @author joshstreet
 */
@Stateless
public class ProposalService {

    @EJB
    private ProposalFacade pf;

    public List<Proposals> findProposalsByTitle(String title) {
        return pf.findProposalsByTitle(title);
    }

    public void create(Proposals entity) {
        pf.create(entity);
    }

    public Proposals edit(Proposals entity) {
        return pf.edit(entity);
    }

    public void remove(Proposals entity) {
        pf.remove(entity);
    }

    public Proposals find(Object id) {
        return pf.find(id);
    }

    public List<Proposals> findAll() {
        return pf.findAll();
    }

    public List<Proposals> findRange(int[] range) {
        return pf.findRange(range);
    }

    public int count() {
        return pf.count();
    }

    public Proposals addProposal(Proposals pro) throws BusinessException {
        //search for people with same name
        List<Proposals> list = pf.findProposalsByTitle(pro.getTitle());
        if (list.isEmpty()) {
            pro.setAbsVotes(0);
            pro.setUpVotes(0);
            pro.setDownVotes(0);
//            pro.setJustification(null);

            pf.edit(pro);
        } else {
            throw new BusinessException("Proposal with title already exists " + pro.getTitle());
        }
        return pro;
    }
    
    public Proposals deleteProposal(Proposals pro, UserPerson up) throws BusinessException {
        //search for people with same name
        List<Proposals> list = pf.findProposalsByOwner(up);
        if (list.contains(pro)) {
            pf.remove(pro);
        } else {
            throw new BusinessException("You cannot withdraw proposal: " + pro.getTitle() + ". As you did not create it.");
        }
        return pro;
    }
    
    public Proposals castVote (String vote, UserPerson up, Proposals pro) throws BusinessException {
        if(vote.equals("up")){
               pro.setUpVotes(+1);
               pf.edit(pro);
        } else if (vote.equals("down")){
                pro.setDownVotes(+1);
                pf.edit(pro);
        } else {
            pro.setAbsVotes(+1);
            pf.edit(pro);
        }
        return pro;
    }

}
