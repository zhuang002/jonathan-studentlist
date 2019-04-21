/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentlist;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author zhuan
 */
class Student implements Comparable<Student> {
    int id=0;
    String name=null;
    Date birthday=new Date();
    Address address=new Address();
    Phone phone=new Phone();
    ArrayList<Course> currentCourses=new ArrayList();
    ArrayList<Course> takenCourses=new ArrayList();
    
    void deserialize(String s) {
        String[] fields=s.split("\\|");
        this.id=Integer.parseInt(fields[0]);
        this.name=fields[1];
        SimpleDateFormat format=new SimpleDateFormat("dd/mm/yyyy");
        try {
            this.birthday=format.parse(fields[2]);
        } catch (Exception e) {
            this.birthday=new Date();
        }
        this.address.deserialize(fields[3]);
        this.phone.deserialize(fields[4]);
    }

    String serialize() {
        SimpleDateFormat format=new SimpleDateFormat("dd/mm/yyyy");
        return id+"|"+name+"|"+format.format(birthday)+"|"+address.toString()+"|"+phone.toString();
    }

    @Override
    public int compareTo(Student o) {
        
        return this.id-o.id;
    }
    
    @Override
    public String toString() {
        String s="ID:" + this.id+"\n";
        s+="Name:"+this.name+"\n";
        SimpleDateFormat format=new SimpleDateFormat("dd/mm/yyyy");
        s+="Birthday:"+format.format(this.birthday)+"\n";
        s+="Address: "+this.address+"\n";
        s+="Phone: "+this.phone+"\n";
        return s;
    }
    
}
