package pl.evanec;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepoTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private QuestionRepo employeeRepository;

    @Test
    public void addQuestion(){
        Question question  = new Question("question","1.1.1.1");

        employeeRepository.save(question);
        Assert.assertFalse(employeeRepository.findAll().isEmpty());

    }


}
