package pl.evanec;

import java.util.List;

public interface QuestionsRepository {

    List<QuestionTO> findAllQuestions();

    QuestionTO save(QuestionTO question);

    void delete(QuestionTO question);
}
