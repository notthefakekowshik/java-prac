package DS;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Getter
class ComparablePerson implements Comparable<ComparablePerson>{
    String name;
    int age;


    @Override
    public int compareTo(ComparablePerson o) {
        //return this.getAge() - o.getAge();
        return Integer.compare(this.getAge(), o.getAge());
    }
}

public class ComparableDemo {
    public static void main(String[] args) {
        ComparablePerson kowshik = new ComparablePerson("kowshik",23);
        ComparablePerson elon = new ComparablePerson("Elon" , 69);
        ComparablePerson mom = new ComparablePerson("mom",48);
        List<ComparablePerson> listOfPersons = new ArrayList<>();
        listOfPersons.add(kowshik);
        listOfPersons.add(elon);
        listOfPersons.add(mom);
        printerListOfPersons(listOfPersons);
        Collections.sort(listOfPersons);
        printerListOfPersons(listOfPersons);

    }

    public static void printerListOfPersons(List<ComparablePerson> listOfPersons) {
        for(ComparablePerson curr : listOfPersons) {
            System.out.println(curr.getAge() + " " + curr.getName());
        }
        System.out.println("=========");
    }
}
