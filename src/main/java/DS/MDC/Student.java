package DS.MDC;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

@AllArgsConstructor
@Getter
public class Student{
    protected int age;
    protected String name;
    protected char gender;
    private static final Logger logger = LoggerFactory.getLogger(Student.class);
    public void incrementAge(Student s) {
        System.out.println(Thread.currentThread().getName());
        logger.info("Before -> Current student's name " + MDC.get("StudentName")+ " Current student's age " + MDC.get("StudentAge") + " Changed value -> " + s.getAge());
        s.age += 1;
        logger.info("After -> Current student's name " + MDC.get("StudentName")+ " Current student's age " + MDC.get("StudentAge") + " Changed value -> " + s.getAge());
    }
}
