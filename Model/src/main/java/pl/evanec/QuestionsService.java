package pl.evanec;

import java.util.List;

public interface QuestionsService {

    void AddQuestion(Question question);

    List<Question> getAllQuestions();

}
