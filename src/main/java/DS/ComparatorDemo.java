package DS;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@Getter
class ComparatorPerson {
    String name;
    int age;

}
public class ComparatorDemo {
    public static void main(String[] args) {
        ComparatorPerson kowshik = new ComparatorPerson("Kowshik", 24);
        ComparatorPerson elon = new ComparatorPerson("Elon", 60);
        ComparatorPerson mom = new ComparatorPerson("Mom", 48);
        List<ComparatorPerson> listOfPersons = new ArrayList<>();
        listOfPersons.add(kowshik);
        listOfPersons.add(elon);
        listOfPersons.add(mom);
        printerListOfPersons(listOfPersons);
        System.out.println("=====");
        listOfPersons.sort(new Comparator<ComparatorPerson>() {
            @Override
            public int compare(ComparatorPerson o1, ComparatorPerson o2) {
                return o1.getAge() - o2.getAge();
                //return Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        printerListOfPersons(listOfPersons);

    }

    public static void printerListOfPersons(List<ComparatorPerson> listOfPersons) {
        for(ComparatorPerson curr : listOfPersons) {
            System.out.println(curr.getAge() + " " + curr.getName());
        }
    }
}
