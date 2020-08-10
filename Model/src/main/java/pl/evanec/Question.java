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
    String ipOfResponder;
    @OneToMany(mappedBy="question", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Answer> answers = new ArrayList();

    public Question() {
    }
    public Question(String question, String ipOfResponder) {
        this.question = question;
        this.ipOfResponder = ipOfResponder;
    }

    public Question(String question, String ipOfResponder, List<Answer> answers) {
        this.question = question;
        this.ipOfResponder = ipOfResponder;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public String getIpOfResponder() {
        return ipOfResponder;
    }

    public void setIpOfResponder(String ipOfResponder) {
        this.ipOfResponder = ipOfResponder;
    }

    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return question;
    }
}
