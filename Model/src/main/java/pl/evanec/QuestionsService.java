package pl.evanec;

import java.util.Collection;
import java.util.List;

public interface QuestionsService {

    void AddQuestion(QuestionTO question);

    void deleteQuestions(Collection<QuestionTO> questions);

    List<QuestionTO> getAllQuestions();
}
