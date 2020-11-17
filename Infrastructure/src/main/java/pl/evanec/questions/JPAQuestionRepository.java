package pl.evanec.questions;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.evanec.Question;
import pl.evanec.QuestionsRepository;

public interface JPAQuestionRepository extends JpaRepository<Question, Long>, QuestionsRepository {

}
