package DataStructureAndAgorithmBasic.baitap;

public class MyListTest {
    public static class Student{
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

    public static void main(String[] args) {
        Student student1 = new Student(1,"Rooney");
        Student student2 = new Student(12,"Tom");
        Student student3 = new Student(123,"Han");
        Student student4 = new Student(1234,"Lily");
        Student student5 = new Student(12345,"James");
        Student student6 = new Student(123456,"Ron");
        Student student7 = new Student(1234567,"Kyle");
        MyArrayList<Student> studentMyArrayList = new MyArrayList<>();
        MyArrayList<Student> studentMyArrayList1 = new MyArrayList<>();

        studentMyArrayList.add(student1);
        studentMyArrayList.add(student2);
        studentMyArrayList.add(student3);
        studentMyArrayList.add(student4);
        studentMyArrayList.add(student5);
        studentMyArrayList.add(student6);
        studentMyArrayList.add(student7,2);
        System.out.println();

//        for (int i = 0; i < studentMyArrayList.size(); i++){
//            Student student = (Student) studentMyArrayList.elements[i];
//            System.out.println(student.getId());
//            System.out.println(student.getName());
//
//            System.out.println(studentMyArrayList.get(2).getName());
//        }
//        System.out.println(studentMyArrayList.indexOf(student3));
//        System.out.println(studentMyArrayList.contains(student6));

//        studentMyArrayList1 = studentMyArrayList.clone();
//        studentMyArrayList1.remove(0);
//        for (int i = 0; i < studentMyArrayList1.size(); i++){
//            System.out.println(studentMyArrayList1.get(i).getName());
        }
        }


