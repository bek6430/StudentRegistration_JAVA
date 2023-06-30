/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentregistrationsystem;

import java.io.Serializable;


public class Student implements Serializable {

    public Student(String id, String firstname, String lastname, String password, String department, String bdate, String sex, int BlockNo, int DormNo) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.department = department;
        this.bdate = bdate;
        this.sex = sex;
        this.BlockNo = BlockNo;
        this.DormNo = DormNo;
    }

    
    String id;
    String firstname;
    String lastname;
    String password;
    String department;
    String bdate;
    String sex;
    int BlockNo;
    int DormNo;
   
    public Student() {}
    
   
}
