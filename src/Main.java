import structures.TT_Tree.TT_Tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        Person person = new Person("Aozo", "Kukucka", LocalDate.now(), "98124520");
        Person person2 = new Person("Ahozo", "Kukucka", LocalDate.now(), "98124520");
        System.out.println(person.compareTo(person2));

        TT_Tree<Person> tree = new TT_Tree<>();
        tree.insert(person);
        tree.insert(person2);
        if (tree.find(person2)) {
            System.out.println("t");
        } else {
            System.out.println("F");
        }

        String a = "a";
        String b = "b";
        TT_Tree<String> t = new TT_Tree<>();
        t.insert(a);
        if (t.find(a)) {
            System.out.println("t");
        } else {
            System.out.println("F");
        }
    }
}
