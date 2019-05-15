/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_tap_test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import javax.swing.JPanel;

/**
 *
 * @author josea
 */
public class Game extends JPanel {

    int xpos, ypos;
    Particula particula = new Particula();

    public Game() {
        this.setLocation(0, 0);
        this.setSize(800, 450);
        xpos = 100;
        ypos = 100;
    }
    
    public Point getMCursor() {
        return new Point(MouseInfo.getPointerInfo().getLocation().x-4, MouseInfo.getPointerInfo().getLocation().y-28);
    }

    public void update() {
        Point p = MouseInfo.getPointerInfo().getLocation();
        xpos = getMCursor().x;
        ypos = getMCursor().y;
        
        particula.Update(getMCursor());
    }

    public void paintComponent(Graphics g) {
        clear(g);
        
        g.setColor(Color.WHITE);
        particula.Draw(g);
    }
    
    public void clear(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 450);
    }
}
