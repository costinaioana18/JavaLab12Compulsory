package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * The ControlPanel will allow the user to specify any class name of a Swing component (such as JButton, JLabel, JSpinner, JComboBox ), a name for that component  and a button for creating and adding an instance of the specified component to the DesignPanel.
 */
public class ControlPanel extends JPanel {
    final MainFrame frame;
    JLabel componentLabel;
    JTextField componentField;
    JLabel nameLabel;
    JTextField nameField;
    JButton button;

    /**
     * Creating the panels and the button and adding them to the panel
     */
    public ControlPanel(MainFrame frame)
    {
        this.frame=frame;

        componentLabel=new JLabel("The Class name of the Swing component: ");
        componentField=new JTextField(10);

        nameLabel=new JLabel("The default text for the component: ");
        nameField=new JTextField(10);

        button=new JButton("Create & add");

        add(componentLabel);
        add(componentField);
        add(nameLabel);
        add(nameField);
        add(button);

        button.addActionListener(this::add);
    }

    /**
     * The method calls a specific method of the design panel, considering what the user wrote in the fields
     */
    private void add(ActionEvent e) {

        String component = componentField.getText();
        String name=nameField.getText();
        if(component.equals("JComboBox"))
            frame.designPanel.addCombo(name);
        if(component.equals("JTextField"))
            frame.designPanel.addField(name);
        if(component.equals("JButton"))
            frame.designPanel.addButton(name);
        if(component.equals("JSpinner"))
            frame.designPanel.addSpinner(name);

    }
}