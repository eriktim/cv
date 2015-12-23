package com.gingerik.cv;

import com.gingerik.cv.data.Education;
import com.gingerik.cv.data.Institute;
import com.gingerik.cv.data.Subject;
import com.gingerik.cv.repository.EducationRepository;
import com.gingerik.cv.repository.InstituteRepository;
import com.gingerik.cv.repository.SubjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Locale;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(SubjectRepository subjectRepository,
                                  InstituteRepository instituteRepository,
                                  EducationRepository educationRepository) {
        return (args) -> {
            log.info("Setting demo data");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
            Subject subject = new Subject("Desmond", "Llewelyn", sdf.parse("1914-09-12"), "Pembrokeshire", "Welsh",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam ultricies magna tempus, blandit velit vitae, aliquet libero. Morbi molestie tempor nulla, in convallis elit luctus eu. Nam non pharetra massa, at venenatis mauris. Sed eu diam et massa cursus pellentesque et at ligula. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vivamus non ultricies quam. Mauris pharetra, metus id egestas iaculis, sem arcu mollis justo, id rhoncus arcu orci quis nisl. Ut hendrerit vulputate est in suscipit. Nam feugiat nunc ut nunc ullamcorper, nec finibus sapien scelerisque. Nullam nec ligula quis risus feugiat pharetra. Aliquam blandit urna at lectus sagittis, nec vulputate purus euismod. Praesent euismod mattis vehicula. Mauris pulvinar sapien in urna vehicula auctor. Nunc mollis sapien a accumsan efficitur. Ut sed libero lobortis, ultricies magna ultrices, tristique mauris. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.");
            Institute institute = new Institute(subject, "Q Branch", "");
            Education education = new Education(institute, sdf.parse("1963-01-01"), sdf.parse("1999-01-01"), "Quartermaster Head", true);

            subjectRepository.save(subject);
            instituteRepository.save(institute);
            educationRepository.save(education);
        };
    }
}