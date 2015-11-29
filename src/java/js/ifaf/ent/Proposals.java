/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package js.ifaf.ent;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;

/**
 *
 * @author joshstreet
 */
@Entity
public class Proposals implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    private String title;
    private String description;
    private String rule;
    private int votesUp;
    private int votesDown;
    private int votesAb;
    private String justification;
    @Temporal(DATE)
    private Date timestamp;
    @ManyToOne
    private UserPerson owner;

    public UserPerson getOwner() {
        return owner;
    }

    public void setOwner(UserPerson owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getUpVotes() {
        return votesUp;
    }

    public int getDownVotes() {
        return votesDown;
    }

    public int getAbsVotes() {
        return votesAb;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUpVotes(int upVotes) {
        this.votesUp = upVotes;
    }

    public void setDownVotes(int downVotes) {
        this.votesDown = downVotes;
    }

    public void setAbsVotes(int absVotes) {
        this.votesAb = absVotes;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
    

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proposals)) {
            return false;
        }
        Proposals other = (Proposals) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "js.ifaf.ent.Proposal[ id=" + id + " ]";
    }
    
}
