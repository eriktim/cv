package com.gingerik.cv.repository;

import com.gingerik.cv.Application;
import com.gingerik.cv.DatabaseConfig;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import static org.assertj.core.api.Assertions.assertThat;

@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
                         DirtiesContextTestExecutionListener.class,
                         TransactionalTestExecutionListener.class,
                         DbUnitTestExecutionListener.class})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, DatabaseConfig.class})
@DbUnitConfiguration(databaseConnection="dbUnitDatabaseConnection")
@DatabaseSetup(SubjectRepositoryTest.DATASET)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = {SubjectRepositoryTest.DATASET})
@DirtiesContext
public class SubjectRepositoryTest {

    protected static final String DATASET = "classpath:datasets/subjects.xml";

    @Autowired
    private SubjectRepository repository;

    @Test
    public void findAllTest() {
        assertThat(repository.findAll())
            .hasSize(2)
            .extracting("firstName")
            .containsOnly("Marvin", "Harry");
    }

    @Test
    public void findByLastNameTest() {
        assertThat(repository.findByLastName("MERCHANTS"))
            .hasSize(1)
            .extracting("firstName")
            .containsOnly("Marvin");
        assertThat(repository.findByLastName("Merchants"))
            .hasSize(0);
        assertThat(repository.findByLastName("Marvin"))
            .hasSize(0);
    }

    @Test
    public void findByLastNameIgnoreCaseTest() {
        assertThat(repository.findByLastNameIgnoreCase("MERCHANTS"))
            .hasSize(1)
            .extracting("firstName")
            .containsOnly("Marvin");
        assertThat(repository.findByLastNameIgnoreCase("Merchants"))
            .hasSize(1)
            .extracting("firstName")
            .containsOnly("Marvin");
        assertThat(repository.findByLastName("Marvin"))
            .hasSize(0);
    }

}