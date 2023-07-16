package org.example;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "students")
public class Students {

    private List<Students> studentsList;
    Students(){

    }
    public Students(List<Students> studentsList){
        this.studentsList = studentsList;
    }
    @XmlElement(name = "student")
    public List<Students> getStudents(){
        return this.studentsList;
    }
    public void setStudentsList(List<Students> studentsList) {
        this.studentsList = studentsList;
    }


}
