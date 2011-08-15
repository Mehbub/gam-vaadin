/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bilgi;

import java.util.List;

/**
 *
 * @author hd
 */
public abstract class StudentListReader {

    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public StudentListReader(String fileName) {
        this.fileName = fileName;
    }
    
    public abstract List<String> getHeader();
    public abstract List<Student> getStudentInfo();
}
