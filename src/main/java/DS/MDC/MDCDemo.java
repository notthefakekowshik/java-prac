package DS.MDC;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.MDC;

public class MDCDemo {

    public static void main(String[] args) {
        Student kowshik = new Student(23,"kowshik",'M');
        Student MlonEusk = new Student(70,"Mlon Esuk" , 'M');
        Student LrockBesnar = new Student(65,"Lrock Besnar" , 'M');
        List<Student> listOfStudents = Arrays.asList(kowshik, MlonEusk, LrockBesnar);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for(Student s : listOfStudents) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try{
                        Map<String,String> mapuu = Optional.ofNullable(MDC.getCopyOfContextMap()).orElse(new HashMap<>());
                        MDC.put("StudentName" , s.getName());
                        MDC.put("StudentAge", String.valueOf(s.getAge()));
                        s.incrementAge(s);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    finally {
                         MDC.clear();
                    }
                }
            });
        }
        executorService.shutdown();
    }
}
