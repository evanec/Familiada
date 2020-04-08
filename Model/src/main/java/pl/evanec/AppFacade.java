package pl.evanec;

import java.util.List;

public class AppFacade implements QuestionsService{

    private final QuestionsRepository questionRepo;

    public AppFacade(QuestionsRepository questionRepo) {
        this.questionRepo = questionRepo;
    }

    public void AddQuestion(Question question){
        questionRepo.save(question);
    }

    public List<Question> getAllQuestions(){
        return questionRepo.findAll();
    }
}
