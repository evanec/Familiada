package pl.evanec.questions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import pl.evanec.Question;
import pl.evanec.QuestionsRepository;

import java.util.List;

public interface JPAQuestionRepository extends JpaRepository<Question, Long>, QuestionsRepository {
}
