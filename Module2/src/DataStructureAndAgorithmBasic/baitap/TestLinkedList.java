package DataStructureAndAgorithmBasic.baitap;

public class TestLinkedList {
    public static void main(String[] args) {
        class Student{
            private int id;
            private String name;

            public Student() {
            }

            public Student(int id, String name) {
                this.id = id;
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
        MyLinkedList<Student> myLinkedList = new MyLinkedList<>();
        Student student1 = new Student(1,"Trunk");
        Student student2 = new Student(2,"Tom");
        Student student3 = new Student(3,"Harry");
        Student student4 = new Student(4,"Annie");
        Student student5 = new Student(5,"Mane");
        Student student6 = new Student(6,"Kyle");
        Student student7 = new Student(7,"Meow");
        Student student8 = new Student(8,"Tim");
        Student student9 = new Student(9,"Evelyn");

        myLinkedList.addFirst(student1);
        myLinkedList.addFirst(student2);
        myLinkedList.addLast(student3);
        myLinkedList.add(3,student5);
//        myLinkedList.remove(2);
//        MyLinkedList<Student> cloneLinkedList = myLinkedList.clone();
        for (int i = 0; i < myLinkedList.size();i++){
            Student student = (Student) myLinkedList.get(i);
            System.out.println(student.getName());
////        }
//        System.out.println(myLinkedList.indexOf(student1));
    }
}}

