package pl.evanec;

import pl.evanec.Question;

import java.util.List;

public interface QuestionsService {

    void AddQuestion(Question question);

    List<Question> getAllQuestions();

}
