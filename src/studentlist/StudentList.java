/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentlist;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author zhuan
 */
public class StudentList {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Student> students=new ArrayList();

    public static void main(String[] args) {
        // TODO code application logic here
        //readInStudents(students);
        commandLoop();
        
    }

    private static void readInStudents(ArrayList<Student> students) {
        students.clear();
        try  {
            Scanner sc=new Scanner(new File("students.txt"));
            int n=sc.nextInt();
            sc.nextLine();
            for (int i=0;i<n;i++) {
                String s=sc.nextLine();
                Student student=new Student();
                student.deserialize(s);
                students.add(student);
            }
            Collections.sort(students);
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void commandLoop() {
        Scanner sc=new Scanner(System.in);
        String command="";
        String[] params = new String[5];
        while (!command.equalsIgnoreCase("quit")) {
            if (command.equalsIgnoreCase("list")) {
                listStudents();
            } else if (command.equalsIgnoreCase("delete")) {
                int id=Integer.parseInt(params[1]);
                deleteStudent(id);
            } else if (command.equalsIgnoreCase("save")) {
                saveStudents();
            } else if (command.equalsIgnoreCase("add")) {
                Student student=inputStudentInfo(sc, ">>Student Info>");
                students.add(student);
            } else if (command.equalsIgnoreCase("load")) {
                readInStudents(students);
            }
            
            System.out.print(">> ");
            String line=sc.nextLine();
            params=line.split(" ");
            command=params[0];
            
        }
    }

    private static void listStudents() {
        for (Student student:students) {
            System.out.println(student);
        }
       /* for (int i=0;i<students.size();i++) {
            System.out.println(students.get(i));
        }*/
    }

    private static void deleteStudent(int id) {
        Student student=new Student();
        student.id=id;
        int idx=Collections.binarySearch(students,student);
        if (idx>=0) students.remove(idx);
    }

    private static void saveStudents() {
        try {
            PrintWriter writer=new PrintWriter(new FileWriter("students.txt"));
            writer.println(students.size());
            for (Student student:students) {
                writer.println(student.serialize());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Save file error.");
        }
    }

    private static Student inputStudentInfo(Scanner sc, String prompt) {
        Student student=new Student();
        System.out.print(prompt+"id:");
        student.id=sc.nextInt();
        sc.nextLine();
        System.out.print(prompt+"name:");
        student.name=sc.nextLine();
        System.out.print(prompt+"birthday (dd/mm/yyyy):");
        SimpleDateFormat format=new SimpleDateFormat("dd/mm/yyyy");
        try {
            student.birthday=format.parse(sc.nextLine());
        } catch (Exception e) {
            student.birthday=new Date();
        }
        System.out.print(prompt+"address (rmNo,stNum street,city,province postCode):");
        student.address=new Address();
        student.address.deserialize(sc.nextLine());
        
        System.out.print(prompt+"phone [countryCode-areaCode(code1)code2]:");
        student.phone=new Phone();
        student.phone.deserialize(sc.nextLine());
        
        inputCurrentCoursesInfo(sc,prompt,"current course",student.currentCourses);
        return student;
    }

    private static void inputCurrentCoursesInfo(Scanner sc,String prompt, String prompt2, ArrayList<Course> currentCourses) {
        while (true) {
            System.out.print(prompt+"input current course (y/n)? ");
            String line=sc.nextLine();
            if (line.equalsIgnoreCase("n")) {
                break;
            }
            Course course=inputCourseInfo(sc,prompt+prompt2);
            currentCourses.add(course);
        }
    }

    private static Course inputCourseInfo(Scanner sc, String prompt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
