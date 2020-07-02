package pl.evanec;

import javax.persistence.*;

@Entity
public class Answer {

    @Id
    @GeneratedValue
    private Long id;
    String answer;
    String ipOfResponder;
    boolean questionSucks = false;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    private Question question;

    public Answer() {
    }

    public Answer(String answer, String ipOfResponder, Question question) {
        this.answer = answer;
        this.ipOfResponder = ipOfResponder;
        this.question = question;
    }

    public Answer(boolean questionSucks, String ipOfResponder, Question question) {
        this.questionSucks = questionSucks;
        this.ipOfResponder = ipOfResponder;
        this.question = question;
    }

    public Question getBook() {
        return question;
    }

    public void setBook(Question book) {
        this.question = book;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getIpOfResponder() {
        return ipOfResponder;
    }

    public void setIpOfResponder(String ipOfResponder) {
        this.ipOfResponder = ipOfResponder;
    }

    @Override
    public String toString() {
        if (questionSucks) {
            return "question sucks";
        }
        return answer;
    }
}
