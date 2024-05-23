package de.sommer.todowidget;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ListPane extends JPanel{
    private JPanel mainList;

    
    public ListPane() {
        setLayout(new BorderLayout());
        mainList = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.weighty = 1;
        mainList.add(new JPanel(), gbc);
        setBorder(BorderFactory.createEmptyBorder(5,5, 5, 5));
        mainList.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(mainList);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane, BorderLayout.CENTER);
        JButton add = new JButton("Add");
        JButton close = new JButton("X");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ToDo todo = new ToDo("Title", "Description", 0, null);
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                gbc.weightx = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                mainList.add(todo, gbc, 0);

                validate();
                repaint();
            }
        });
        
        add.setFocusable(false);
        close.setFocusable(false);
        JPanel buttons = new JPanel(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.weightx = 0;
        buttons.add(close, g);
        g.weightx = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        buttons.add(add, g);
        
        add(buttons, BorderLayout.SOUTH);

    }
}
