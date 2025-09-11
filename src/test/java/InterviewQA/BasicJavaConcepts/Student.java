package InterviewQA.BasicJavaConcepts;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {


    private String name;
    private int age;


    private String studentId;
    private List<String> courses;

    public Student(){
        this.name = "Default Name";
        this.age = 0;
        this.studentId = "Default ID";
        courses = new ArrayList<String>();
    }

    public Student(String name, int age, String studentId) {
        super();
        if (validateName(name) && validateAge(age) && validateStudentId(studentId))






        {
            this.name = name;
            this.age = age;

            this.studentId = studentId;
            courses = new ArrayList<String>(); //Initialization of courses.
        }


    }

    public void entrollCourse(String course) {
        courses.add(course);
        System.out.println(course + " added successfully.");
    }

    public void printStudentInfo(){
        System.out.println("=== Student Information ===");
        System.out.println("name: " + name);
        System.out.println("age: " + age);
        System.out.println("studentID: " + studentId);
        System.out.println("Entrolled for: " + courses);
    }

 //    public String toString(){
 //       return "Student [name= "+ name + ", age= "+ age +", studentID= " + studentId + " courses = " + courses;
 //   }

    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public List<String> getCourses() {
        return courses;
    }

    public boolean validateAge(int age){
        return age > 19 && age <= 35;
    }

    public boolean validateName(String name) {

        String nameRegex = "^[a-zA-Z\\s]+$";

        Pattern namePattern = Pattern.compile(nameRegex);
        Matcher nameMatcher = namePattern.matcher(name);

        if(nameMatcher.matches()){
            return true;
        }
        else {
            System.err.println("Invalid Name!!! Please enter alphabets only.");
            return false;
        }
    }

    public boolean validateStudentId(String studentId) {
        String studentIdRegex = "S-[0-9]+$";
        Pattern StudentIdPattern = Pattern.compile(studentIdRegex);
        Matcher studentIdMatcher = StudentIdPattern.matcher(studentId);

        if(studentIdMatcher.matches()){
            return  true;
        }
        else {
            System.err.println("Invalid StudentId.");
            return false;
        }


    }

}
