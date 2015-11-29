package js.ifaf.ent;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import js.ifaf.ent.Proposals;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-29T19:19:10")
@StaticMetamodel(UserPerson.class)
public class UserPerson_ { 

    public static volatile SingularAttribute<UserPerson, String> country;
    public static volatile SingularAttribute<UserPerson, String> firstname;
    public static volatile SingularAttribute<UserPerson, String> password;
    public static volatile SingularAttribute<UserPerson, String> occupation;
    public static volatile SingularAttribute<UserPerson, String> dtype;
    public static volatile ListAttribute<UserPerson, Proposals> proposals;
    public static volatile SingularAttribute<UserPerson, Long> id;
    public static volatile SingularAttribute<UserPerson, String> email;
    public static volatile SingularAttribute<UserPerson, String> lastname;
    public static volatile SingularAttribute<UserPerson, String> username;

}