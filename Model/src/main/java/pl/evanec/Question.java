package pl.evanec;

import java.util.ArrayList;
import java.util.List;

public class Question {

    String question;
    User user;

    List<Answer> answers = new ArrayList();

    public Question(String question, User user) {
        this.question = question;
        this.user = user;
    }
}
