/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentregistrationsystem;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileController {
    static final String FILENAME = "Students.data";
    
    static LinkedList<Student> loadStudents() {
        try {
            File f = new File(FILENAME);
            
            if(!f.exists()) {
                saveStudents(new LinkedList<Student>());
                return new LinkedList<Student>();
            }
            
            
            
            FileInputStream fis = new FileInputStream(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            LinkedList<Student> studentList = new LinkedList<Student>();
            
            
            while (true) {
                try {
                    Student current = (Student)ois.readObject();
                    studentList.push(current);
                } catch(EOFException e) {
                    System.out.println("hello");
                    break;
                }
            }
            
            return studentList;
            
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        } catch (IOException ex) {
            System.out.println("io");
        } catch (ClassNotFoundException ex) {
            System.out.println("class not found");
        }
        
        return new LinkedList<Student>();
        
    }
    
    static void saveStudents(LinkedList<Student> studentList) {
        try {
            FileOutputStream fos = new FileOutputStream(FILENAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for(Student current: studentList) {
                oos.writeObject(current);
            }
            
            oos.close();
            fos.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
