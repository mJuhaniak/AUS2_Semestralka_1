import structures.TT_Tree.TT_Tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        TT_Tree<String> tree = new TT_Tree<String>();
        Person person = new Person("Aozo", "Kukucka", LocalDate.now(), "98124520");
        Person person2 = new Person("Aozo", "Kukucka", LocalDate.now(), "98124520");
        System.out.println(person.compare(person2));
    }
}
