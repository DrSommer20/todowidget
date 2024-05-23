package de.sommer.todowidget;

import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class ToDo extends JPanel{
    private String title;
    private String description;
    private boolean done;
    private int priority;
    private LocalDate dueDate;
    JButton doneButton;
    JTextField textField;

    public ToDo(String title, String description, int priority, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.done = false;

        /* this.setBackground(ToDoWidget.COLORS[priority]); */
        this.setLayout(new BorderLayout());

        textField = new JTextField("some text");
        textField.setBorder(BorderFactory.createEmptyBorder());
        textField.setBackground(this.getBackground());
        this.add(textField, BorderLayout.CENTER);
        textField.addActionListener(e -> setTitle(textField.getText()));

        doneButton = new JButton("Done");
        doneButton.addActionListener(e -> setDone(!done));
        this.add(doneButton, BorderLayout.EAST);

        doneButton.setFocusable(false);

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        if(done){
            textField.setEnabled(false);
            doneButton.setText("Undone");
            doneButton.setBackground(getBackground());
        }
        else{
            textField.setEnabled(true);
            doneButton.setText("Done");
            doneButton.setBackground(UIManager.getColor("Button.startBorderColor")); 
        }
        this.done = done;
        
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;

    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }


    
}
