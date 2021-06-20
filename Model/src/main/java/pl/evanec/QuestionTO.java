package pl.evanec;

import java.util.ArrayList;
import java.util.List;

public class QuestionTO {

    String question;
    boolean removed = false;
    String ipOfResponder;
    List<AnswerTO> answers = new ArrayList<>();
    private Long id;

    public QuestionTO() {
    }

    public QuestionTO(String question, String ipOfResponder) {
        this.question = question;
        this.ipOfResponder = ipOfResponder;
    }

    public QuestionTO(String question, String ipOfResponder, List<AnswerTO> answers) {
        this.question = question;
        this.ipOfResponder = ipOfResponder;
        this.answers = answers;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<AnswerTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerTO> answers) {
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

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return question;
    }
}
