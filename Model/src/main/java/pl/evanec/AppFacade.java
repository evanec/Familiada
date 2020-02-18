package pl.evanec;

public class AppFacade {

    private final QuestionRepo questionRepo;

    public AppFacade(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }
}
