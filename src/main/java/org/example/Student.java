package org.example;

import jakarta.xml.bind.annotation.*;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Data
@XmlRootElement
public class Student {
    @Setter
    private int age;
    @Setter
    private String name;

    @XmlElement
    public int getAge(){
        return this.age;
    }

    @XmlElement
    public String getName(){
        return this.name;
    }
}
