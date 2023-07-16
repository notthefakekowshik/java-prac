package org.example;

import jakarta.xml.bind.*;

public class StudentMarshall {
    public static void main(String[] args) throws JAXBException {
        // Create a JAXBContext for the Person class
        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);

        // Create a Person object
        Student stu = new Student();
        stu.setAge(30);
        stu.setName("elon musk");

        // Create a Marshaller
        Marshaller marshaller = jaxbContext.createMarshaller();

        // Set properties for formatting the output
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Marshal to XML and print to console
        marshaller.marshal(stu, System.out);
    }
}
