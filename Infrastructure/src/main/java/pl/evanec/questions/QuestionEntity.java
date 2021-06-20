package pl.evanec.questions;

import org.modelmapper.ModelMapper;
import pl.evanec.QuestionTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class QuestionEntity {

    String question;
    boolean removed = false;
    String ipOfResponder;
    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<AnswerEntity> answers = new ArrayList<>();
    @Id
    @GeneratedValue
    private Long id;

    public QuestionEntity() {
    }

    public QuestionEntity(String question, String ipOfResponder) {
        this.question = question;
        this.ipOfResponder = ipOfResponder;
    }

    public QuestionEntity(String question, String ipOfResponder, List<AnswerEntity> answers) {
        this.question = question;
        this.ipOfResponder = ipOfResponder;
        this.answers = answers;
    }

    public static QuestionTO convertToTO(QuestionEntity entity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, QuestionTO.class);
    }

    public static QuestionEntity convertToEntity(QuestionTO to) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(to, QuestionEntity.class);
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

    public List<AnswerEntity> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerEntity> answers) {
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
