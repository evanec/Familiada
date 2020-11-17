package pl.evanec;

import java.util.Collection;
import java.util.List;

public interface QuestionsRepository {

    List<Question> findAll();

    Question save(Question question);

    void delete(Question question);
}
