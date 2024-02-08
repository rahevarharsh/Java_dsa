public class Oop {
    public static void main(String[] args) {
    Student s1 = new Student();
    s1.name = "harsh";
    s1.marke[0]= 10;
        s1.marke[1]= 20;
        s1.marke[2]= 30;

        System.out.println(s1.name);
        for (int i = 0; i <s1.marke.length ; i++) {
            System.out.println(s1.marke[i]);
        }
    }
}
class Student{
    String name ;
    int[] marke = new int[3];

}
