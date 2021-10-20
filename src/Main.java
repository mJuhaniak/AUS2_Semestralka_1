import structures.TT_Tree.TT_Tree;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        Person person = new Person("Aozo", "Kukucka", LocalDate.now(), "98124520");
        Person person2 = new Person("Ahozo", "Kukucka", LocalDate.now(), "98124520");
        Person person3 = new Person("Bozo", "Kukucka", LocalDate.now(), "98124520");
        Person person4 = new Person("Bozo", "Kukuck", LocalDate.now(), "98124520");

        /*
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
        PCR_Test test11 = new PCR_Test(11);
*/
        /*TT_Tree<Person> tree = new TT_Tree<>();
        tree.insert(person);
        tree.insert(person2);
        tree.insert(person3);
        if (tree.find(person4)) {
            System.out.println("t");
        } else {
            System.out.println("F");
        }*/

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
        PCR_Test test11 = new PCR_Test(11);
        PCR_Test test12 = new PCR_Test(12);
        PCR_Test test13 = new PCR_Test(13);
        PCR_Test test14 = new PCR_Test(14);
        PCR_Test test15 = new PCR_Test(15);
        PCR_Test test16 = new PCR_Test(16);
        PCR_Test test17 = new PCR_Test(17);
        PCR_Test test18 = new PCR_Test(18);
        PCR_Test test19 = new PCR_Test(19);
        PCR_Test test20 = new PCR_Test(20);
        PCR_Test test21 = new PCR_Test(21);
        PCR_Test test22 = new PCR_Test(22);
        PCR_Test test23 = new PCR_Test(23);
        PCR_Test test24 = new PCR_Test(24);
        PCR_Test test25 = new PCR_Test(25);
        PCR_Test test26 = new PCR_Test(26);
        PCR_Test test27 = new PCR_Test(27);
        PCR_Test test28 = new PCR_Test(28);
        PCR_Test test29 = new PCR_Test(29);
        PCR_Test test30 = new PCR_Test(30);
        PCR_Test test31 = new PCR_Test(31);
        PCR_Test test32 = new PCR_Test(32);
        PCR_Test test33 = new PCR_Test(33);
        PCR_Test test34 = new PCR_Test(34);
        PCR_Test test35 = new PCR_Test(35);
        PCR_Test test36 = new PCR_Test(36);
        PCR_Test test37 = new PCR_Test(37);
        PCR_Test test38 = new PCR_Test(38);
        PCR_Test test39 = new PCR_Test(39);

        TT_Tree<PCR_Test> t = new TT_Tree<>();
        t.insert(test22);
        t.insert(test7);
        t.insert(test24);
        t.insert(test1);
        t.insert(test20);
        t.insert(test25);
        t.insert(test9);
        t.insert(test8);
        t.insert(test6);
        t.insert(test26);
        t.insert(test3);
        t.insert(test30);
        t.insert(test18);
        t.insert(test12);
        t.insert(test14);
        t.insert(test39);
        t.insert(test33);
        t.insert(test35);
        t.insert(test21);
        t.insert(test36);
        t.insert(test10);

        t.delete(test7);
        t.delete(test12);
        t.delete(test22);

        if (t.find(test36) != null) {
            System.out.println("t");
        } else {
            System.out.println("F");
        }
    }
}
