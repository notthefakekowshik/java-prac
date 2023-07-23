package org.DSA;

import jakarta.xml.bind.annotation.*;
import lombok.Data;
import lombok.Setter;

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
