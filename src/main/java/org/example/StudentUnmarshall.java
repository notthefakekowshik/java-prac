package org.example;

import java.io.File;
import java.util.List;

import jakarta.xml.bind.*;

public class StudentUnmarshall {

    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);

        // Create an Unmarshaller
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        // Unmarshal the XML from a file or input source
        File file = new File("src/main/java/org/example/student.xml");
        Student stu = (Student) unmarshaller.unmarshal(file);
        System.out.println(stu.getAge());
        System.out.println(stu.getName());


    }
}
