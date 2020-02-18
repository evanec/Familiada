package pl.evanec;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue
    private Long id;
    String question;
    User user;
    @OneToMany(mappedBy="Question", cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Answer.class)
    List<Answer> answers = new ArrayList();

    public Question() {
    }

    public Question(String question, User user) {
        this.question = question;
        this.user = user;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
