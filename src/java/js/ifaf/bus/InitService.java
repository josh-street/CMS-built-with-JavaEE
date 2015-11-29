/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package js.ifaf.bus;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
//import js.ifaf.ent.Address;
import js.ifaf.ent.UserPerson;
//import js.ifaf.pers.AddressFacade;
import js.ifaf.pers.UserPersonFacade;

/**
 *
 * @author joshstreet
 */
@Stateless
public class InitService {

    @EJB
    private UserPersonFacade upf;
//    @EJB
//    private AddressFacade af;

    public List<UserPerson> initialise() throws BusinessException {
        if (upf.count() <= -1) {
            List<UserPerson> ul = upf.createInitialData();
            //List<Address> al = af.createInitialData();

            //Address addr = al.get(0);
            //for (UserPerson up : ul) {
                //up.setHome(addr);
                //addr.getResidents().add(up);
            //}
            return ul;
        } else {
            return null;
        }
    }
}
