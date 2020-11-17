package pl.evanec;

import java.util.Collection;
import java.util.List;

public interface QuestionsService {

    void AddQuestion(Question question);

    void deleteQuestions(Collection<Question> questions);

    List<Question> getAllQuestions();

}
