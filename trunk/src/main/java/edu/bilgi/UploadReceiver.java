/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bilgi;

import com.vaadin.ui.Upload.Receiver;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author hd
 */
public class UploadReceiver implements Receiver {

    OutputStream outputFile;

    public OutputStream receiveUpload(String filename, String mimeType) {
        File file = null;
        try {
            file = new File("/home/hd/foo/" + filename);
            if (!file.exists()) {
                file.createNewFile();
            }
            outputFile = new FileOutputStream(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputFile;
    }
}
