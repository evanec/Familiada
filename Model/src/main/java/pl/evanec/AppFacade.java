package pl.evanec;

import java.util.Collection;
import java.util.List;

public class AppFacade implements QuestionsService {

    private final QuestionsRepository questionRepo;

    public AppFacade(QuestionsRepository questionRepo) {
        this.questionRepo = questionRepo;
    }

    @Override
    public void AddQuestion(QuestionTO question) {
        questionRepo.save(question);
    }

    @Override
    public void deleteQuestions(Collection<QuestionTO> questions) {
        for (QuestionTO question : questions) {
            question.setRemoved(true);
            questionRepo.save(question);
        }
    }

    @Override
    public List<QuestionTO> getAllQuestions() {
        return questionRepo.findAllQuestions();
    }
}
