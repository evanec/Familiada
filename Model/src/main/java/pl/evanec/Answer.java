package pl.evanec;

import javax.persistence.*;

@Entity
public class Answer {

    @Id
    @GeneratedValue
    private Long id;
    String answerRaw;
    String answerStandardized;
    String ipOfResponder;
    boolean questionSucks = false;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    private Question question;

    public Answer() {
    }

    public Answer(String answer, String ipOfResponder, Question question) {
        this.answerRaw = answer;
        this.answerStandardized = answer;
        this.ipOfResponder = ipOfResponder;
        this.question = question;
    }

    public Answer(boolean questionSucks, String ipOfResponder, Question question) {
        this.questionSucks = questionSucks;
        this.ipOfResponder = ipOfResponder;
        this.question = question;
    }

    public boolean isQuestionSucks() {
        return questionSucks;
    }

    public void setQuestionSucks(boolean questionSucks) {
        this.questionSucks = questionSucks;
    }

    public String getAnswerRaw() {
        return answerRaw;
    }

    public void setAnswerRaw(String answerRaw) {
        this.answerRaw = answerRaw;
    }

    public String getAnswerStandardized() {
        return answerStandardized;
    }

    public void setAnswerStandardized(String answerStandardized) {
        this.answerStandardized = answerStandardized;
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
        return answerStandardized;
    }
}
