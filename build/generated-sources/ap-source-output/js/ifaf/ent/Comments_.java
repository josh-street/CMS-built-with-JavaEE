package js.ifaf.ent;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import js.ifaf.ent.Proposals;
import js.ifaf.ent.UserPerson;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-29T19:19:10")
@StaticMetamodel(Comments.class)
public class Comments_ { 

    public static volatile SingularAttribute<Comments, Proposals> proposal;
    public static volatile SingularAttribute<Comments, UserPerson> owner;
    public static volatile SingularAttribute<Comments, Long> id;
    public static volatile SingularAttribute<Comments, String> text;
    public static volatile SingularAttribute<Comments, Date> timestamp;

}