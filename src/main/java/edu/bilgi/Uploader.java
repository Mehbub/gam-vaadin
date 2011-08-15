/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bilgi;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Table;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.FinishedEvent;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.StartedEvent;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.VerticalLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author hd
 */
public class Uploader extends VerticalLayout {

    private String fileName;
    private Receiver uploadReceiver;
    private Upload upload;

    public String getFileName() {
        return fileName;
    }

    public Uploader() {
        uploadReceiver = new UploadReceiver();

        upload = new Upload("", uploadReceiver);
        upload.setImmediate(true);
        upload.setButtonCaption("Upload File");
        addComponent(upload);

        final Button cancelProcessing = new Button("Cancel processing");
        cancelProcessing.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                upload.interruptUpload();
            }
        });
        cancelProcessing.setEnabled(false);
        cancelProcessing.setStyleName("small");
        addComponent(cancelProcessing);

        upload.addListener(new Upload.StartedListener() {

            public void uploadStarted(StartedEvent event) {
                fileName = event.getFilename();
                cancelProcessing.setEnabled(true);
            }
        });

        upload.addListener(new Upload.SucceededListener() {

            public void uploadSucceeded(SucceededEvent event) {
                // TODO
                // notification
                addComponent(studentTable());
            }
        });

        upload.addListener(new Upload.FinishedListener() {

            public void uploadFinished(FinishedEvent event) {
                cancelProcessing.setEnabled(false);
            }
        });

    }

    public Component studentTable() {
        Table table = new Table();
        String[] header = new String[]{"First Name", "Last Name", "Email", "User Name"};
        for(String h : header) {
            table.addContainerProperty(h, String.class, null);
        }
        return table;
    }

    public List<String> getStudentListHeader() {
        try {
            List<String> header = new LinkedList<String>();
            InputStream inputStream = null;
            
            inputStream = new FileInputStream("/home/hd/foo/" + fileName);

            POIFSFileSystem fileSystem = null;

            fileSystem = new POIFSFileSystem(inputStream);

            HSSFWorkbook workBook = new HSSFWorkbook(fileSystem);
            HSSFSheet sheet = workBook.getSheetAt(0);

            Iterator<Cell> cells = sheet.getRow(0).cellIterator();

            while (cells.hasNext()) {
                HSSFCell cell = (HSSFCell) cells.next();
                header.add(cell.getStringCellValue());
            }
            return header;
        } catch (IOException ex) {
            Logger.getLogger(Uploader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        StudentListReader reader = new StudentListExcelReader(fileName);
        List<String> header = reader.getHeader();
        return header;
    }
}