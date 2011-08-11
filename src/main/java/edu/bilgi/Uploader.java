/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bilgi;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.FinishedEvent;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.StartedEvent;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.VerticalLayout;

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
            }
        });

        upload.addListener(new Upload.FinishedListener() {
            public void uploadFinished(FinishedEvent event) {
                cancelProcessing.setEnabled(false);
            }
        });

    }
}
