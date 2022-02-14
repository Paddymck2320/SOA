/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.ait;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
/**
 *
 * @author a00266219
 */

@XmlRootElement(name="student")
@XmlType(propOrder = {"id", "name", "address", "course"})
public class Student {
    private static int nextId = 0;
    
    private int id;
    private String name;
    private String address;
    private String course;
    
    public Student (int id, String name, String address, String course) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.course = course;
    }
    
    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = Student.nextId;
        Student.nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    
    
}