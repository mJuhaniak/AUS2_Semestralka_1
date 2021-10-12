import structures.TT_Tree.TT_Tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        Person person = new Person("Aozo", "Kukucka", LocalDate.now(), "98124520");
        Person person2 = new Person("Ahozo", "Kukucka", LocalDate.now(), "98124520");
        Person person3 = new Person("Bozo", "Kukucka", LocalDate.now(), "98124520");
        Person person4 = new Person("Bozo", "Kukuck", LocalDate.now(), "98124520");

        PCR_Test test1 = new PCR_Test(1);
        PCR_Test test2 = new PCR_Test(2);
        PCR_Test test3 = new PCR_Test(3);
        PCR_Test test4 = new PCR_Test(4);
        PCR_Test test5 = new PCR_Test(5);
        PCR_Test test6 = new PCR_Test(6);
        PCR_Test test7 = new PCR_Test(7);
        PCR_Test test8 = new PCR_Test(8);
        PCR_Test test9 = new PCR_Test(9);
        PCR_Test test10 = new PCR_Test(10);

        /*TT_Tree<Person> tree = new TT_Tree<>();
        tree.insert(person);
        tree.insert(person2);
        tree.insert(person3);
        if (tree.find(person4)) {
            System.out.println("t");
        } else {
            System.out.println("F");
        }*/

        TT_Tree<PCR_Test> t = new TT_Tree<>();
        t.insert(test1);
        t.insert(test2);
        t.insert(test3);
        t.insert(test4);
        t.insert(test5);
        t.insert(test6);
        t.insert(test7);
        t.insert(test8);
        t.insert(test9);
        t.insert(test10);
        if (t.find(test5)) {
            System.out.println("t");
        } else {
            System.out.println("F");
        }
    }
}
