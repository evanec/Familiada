package pl.evanec.questions;

import org.modelmapper.ModelMapper;
import pl.evanec.AnswerTO;

import javax.persistence.*;

@Entity
public class AnswerEntity {
    String answerRaw;
    String answerStandardized;
    String ipOfResponder;
    boolean questionSucks = false;
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    private QuestionEntity question;

    public AnswerEntity() {
    }

    public AnswerEntity(String answer, String ipOfResponder, QuestionEntity question) {
        this.answerRaw = answer;
        this.answerStandardized = answer;
        this.ipOfResponder = ipOfResponder;
        this.question = question;
    }

    public AnswerEntity(boolean questionSucks, String ipOfResponder, QuestionEntity question) {
        this.questionSucks = questionSucks;
        this.ipOfResponder = ipOfResponder;
        this.question = question;
    }

    public static AnswerTO convertToTO(AnswerEntity entity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, AnswerTO.class);
    }

    public static AnswerEntity convertToEntity(AnswerTO to) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(to, AnswerEntity.class);
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
