package pl.evanec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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
