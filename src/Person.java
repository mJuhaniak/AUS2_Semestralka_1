import structures.TT_Tree.TT_Data;

import java.time.LocalDate;

public class Person extends TT_Data {
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private String personId;

    public Person(String name, String lastName, LocalDate birthDate, String personId) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.personId = personId;
    }

    public int compare(Person person) {
        if (this.name.compareTo(person.name) > 0) {
            return 1;
        } else if (this.name.compareTo(person.name) < 0) {
            return -1;
        } else {
            if (this.lastName.compareTo(person.lastName) > 0) {
                return 1;
            } else if (this.lastName.compareTo(person.lastName) < 0) {
                return -1;
            } else {
                if (this.personId.compareTo(person.personId) > 0) {
                    return 1;
                } else if (this.personId.compareTo(person.personId) < 0) {
                    return -1;
                } else{
                    return 0;
                }
            }
        }
    }
}
