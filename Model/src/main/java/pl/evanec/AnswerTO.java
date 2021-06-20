package pl.evanec;

public class AnswerTO {

    String answerRaw;
    String answerStandardized;
    String ipOfResponder;
    boolean questionSucks = false;
    private Long id;
    private QuestionTO question;

    public AnswerTO() {
    }

    public AnswerTO(String answer, String ipOfResponder, QuestionTO question) {
        this.answerRaw = answer;
        this.answerStandardized = answer;
        this.ipOfResponder = ipOfResponder;
        this.question = question;
    }

    public AnswerTO(boolean questionSucks, String ipOfResponder, QuestionTO question) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        if (questionSucks) {
            return "question sucks";
        }
        return answerStandardized;
    }
}
