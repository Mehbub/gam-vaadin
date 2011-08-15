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
public class StudentListExcelReader extends StudentListReader{

    public StudentListExcelReader(String fileName) {
        super(fileName);
    }

    @Override
    public List<String> getHeader() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Student> getStudentInfo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
            
}
