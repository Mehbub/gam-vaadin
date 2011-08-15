/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bilgi;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author hd
 */
public class ComboBoxDepartmentPrompt extends VerticalLayout implements
        Property.ValueChangeListener {

    private static final String[] cities = new String[]{"Bioengineering", "Computer Engineering",
        "Electrical and Electronics Engineering", "Energy Systems Engineering", "Industrial Engineering"};

    public ComboBoxDepartmentPrompt() {
        setMargin(true, false, false, false);
        ComboBox l = new ComboBox();
        l.setInputPrompt("Please select a department");

        l.setImmediate(true);
        l.addListener(this);
        for (int i = 0; i < cities.length; i++) {
            l.addItem(cities[i]);
        }

        addComponent(l);
    }

    public void valueChange(ValueChangeEvent event) {
    }
}
