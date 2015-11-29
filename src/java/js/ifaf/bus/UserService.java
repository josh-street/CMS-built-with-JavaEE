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
public class UserService {

    @EJB
    private UserPersonFacade upf;
//    @EJB
//    private AddressFacade af;

    //public UserPerson addUser(UserPerson up, Address address) throws BusinessException {
    public UserPerson addUser(UserPerson up) throws BusinessException {
        //search for people with same name
        List<UserPerson> list = upf.findUsersByUsername(up.getUsername());
        if (list.isEmpty()) {
//            address = af.edit(address);
//            up.setHome(address);
//            address.getResidents().add(up);
            upf.create(up);
        } else {
            throw new BusinessException("User with name already exists " + up.getFirstname() + " " + up.getLastname());
        }

        return up;
    }
    
    //public UserPerson deleteUser(UserPerson up, Address address) throws BusinessException {
    public UserPerson deleteUser(UserPerson up) throws BusinessException {
        //search for people with same name
        List<UserPerson> list = upf.findUsersByUsername(up.getUsername());
        if (list.isEmpty()) {
            throw new BusinessException("User with name: " + up.getFirstname() + " " + up.getLastname() + " does not exist");
        } else {
           
            }

        return up;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
//    public List<Address> findAllResidences() {
//        return af.findAll();
//    }

//    public Address findAddressById(Long id) {
//        return af.find(id);
//    }

    public List<UserPerson> findAllUsers() {
        return upf.findAll();
    }
    
    public UserPerson findUser(String loggedinUser) {
        List<UserPerson> list = upf.findUserByUsername(loggedinUser);
        if (!list.isEmpty()){
        UserPerson user = list.get(0);
        return user;
        } else {
            return null;
        }
    }

}
