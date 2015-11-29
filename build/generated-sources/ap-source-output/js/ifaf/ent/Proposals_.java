package js.ifaf.ent;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import js.ifaf.ent.UserPerson;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-29T19:19:10")
@StaticMetamodel(Proposals.class)
public class Proposals_ { 

    public static volatile SingularAttribute<Proposals, UserPerson> owner;
    public static volatile SingularAttribute<Proposals, Integer> votesAb;
    public static volatile SingularAttribute<Proposals, Integer> votesDown;
    public static volatile SingularAttribute<Proposals, String> description;
    public static volatile SingularAttribute<Proposals, String> rule;
    public static volatile SingularAttribute<Proposals, Long> id;
    public static volatile SingularAttribute<Proposals, String> justification;
    public static volatile SingularAttribute<Proposals, String> title;
    public static volatile SingularAttribute<Proposals, Integer> votesUp;
    public static volatile SingularAttribute<Proposals, Date> timestamp;

}