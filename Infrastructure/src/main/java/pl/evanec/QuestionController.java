package pl.evanec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionController {

    private final QuestionsService questionService;

    @Autowired
    public QuestionController(QuestionsService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    void addQuestion(@RequestBody QuestionTO request) {
        questionService.AddQuestion(request);
    }

    @GetMapping("/questions")
    List<QuestionTO> getAllQuestions() {
        return questionService.getAllQuestions();
    }

}
