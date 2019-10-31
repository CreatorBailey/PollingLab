package apress.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

//JPA Annotation
@Entity
public class Poll {

    //This Class Stores the poll question
    @Id
    @GeneratedValue
    @Column(name = "POLL_ID")
    private Long id;


    @Column(name = "Question")
    @NotEmpty
    private String question;

//@OneToMany indicates the Poll instance can contain zero or more Option instances
    @OneToMany(cascade = CascadeType.ALL)
    //CascadeType.All indicates that any database operations performed on a Poll instance needs to be done to related Option instances

    @JoinColumn(name = "POLL_ID")
    @OrderBy
    @Size(min = 2,max = 6)
    private Set<Option> options;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }
}
