package InterviewQA.BasicJavaConcepts;



public class StudentManagement {
    public static void main(String[] args) {
        Student std1 = new Student("Tom Tucker", 23, "1000");
        Student std2 =new  Student ("Mel Gibson", 24, "1001");
        Student std3 =new  Student ("Homer Simpson", 26, "1003");

        std1.entrollCourse("Math");
        std2.entrollCourse("Math");
        std2.entrollCourse("English");
        std3.entrollCourse("French");





        std1.printStudentInfo();
       // std2.printStudentInfo();
      //  std3.printStudentInfo();
       


    }
}
