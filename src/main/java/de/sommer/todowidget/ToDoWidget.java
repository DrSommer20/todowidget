package de.sommer.todowidget;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.formdev.flatlaf.IntelliJTheme;

public class ToDoWidget {

    public static FrameDragListener frameDragListener;

    public static void main(String[] args) {
        
        IntelliJTheme.setup(ToDoWidget.class.getResourceAsStream("/Cobalt_2.theme.json"));
		UIManager.put( "Button.arc", 12 );
		UIManager.put( "Component.arc", 12 );
		UIManager.put( "ProgressBar.arc", 12);
		UIManager.put( "TextComponent.arc", 12 ); 
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setUndecorated(true);
            frame.setSize(250, 350);
            frame.setResizable(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ListPane listPane = new ListPane();
            frame.setContentPane(listPane);

            frameDragListener = new FrameDragListener(frame);
            frame.addMouseListener(frameDragListener);
            frame.addMouseMotionListener(frameDragListener);
            listPane.addMouseListener(frameDragListener);
            listPane.addMouseMotionListener(frameDragListener);

      
            frame.setVisible(true);
        });
    }

    public static class FrameDragListener extends MouseAdapter {

        private final JFrame frame;
    	private Point mouseDownCompCoords = null;

        public FrameDragListener(JFrame frame) {
            this.frame = frame;
        }


        public void mouseReleased(MouseEvent e) {
            mouseDownCompCoords = null;
        }

        public void mousePressed(MouseEvent e) {
            mouseDownCompCoords = e.getPoint();
        }

        public void mouseDragged(MouseEvent e) {
            Point currCoords = e.getLocationOnScreen();
            frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
        }
    }
}