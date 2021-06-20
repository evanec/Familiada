package pl.evanec.questions;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.evanec.QuestionTO;
import pl.evanec.QuestionsRepository;

import java.util.List;
import java.util.stream.Collectors;

public interface JPAQuestionRepository extends JpaRepository<QuestionEntity, Long>, QuestionsRepository {

    @Override
    default QuestionTO save(QuestionTO questionTO) {
        QuestionEntity entity = save(QuestionEntity.convertToEntity(questionTO));
        return QuestionEntity.convertToTO(entity);
    }

    @Override
    default void delete(QuestionTO questionTO) {
        delete(QuestionEntity.convertToEntity(questionTO));
    }

    @Override
    default List<QuestionTO> findAllQuestions() {
        return findAll().stream().map(QuestionEntity::convertToTO).collect(Collectors.toList());
    }
}
