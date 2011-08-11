/*
 * Copyright 2009 IT Mill Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package edu.bilgi;

import com.vaadin.Application;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinApplication extends Application {

    private Window window;
    private Label header;

    @Override
    public void init() {
        window = new Window("My Vaadin Application");
        setMainWindow(window);
        header = new Label("Bilgi Google Apps");
        header.setStyleName("h1");

        window.addComponent(header);
        window.addComponent(hr());
        
//        UploadWithProgressMonitoringExample upload = new UploadWithProgressMonitoringExample();
        Uploader upload = new Uploader();
        window.addComponent(upload);
    }

    private Component hr() {
        Label label = new Label("<hr>", Label.CONTENT_XHTML);
        return label;
    }
}
