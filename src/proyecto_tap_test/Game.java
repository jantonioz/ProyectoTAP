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
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author josea
 */
public class Game extends JPanel {

    int xpos, ypos;
    Particula particula = new Particula();
    Pared paredes[] = new Pared[4 + 4];
    Random r = new Random();

    public Game() {
        this.setLocation(0, 0);
        this.setSize(800, 450);
        paredes[0] = new Pared(0    , 0     , 800   , 0);
        paredes[1] = new Pared(800  , 0     , 800   , 450);
        paredes[2] = new Pared(0    , 450   , 800   , 450);
        paredes[3] = new Pared(0    , 0     , 0     , 450);
        
        paredes[4] = new Pared(200 + r.nextInt(600), 50 + r.nextInt(300), 200 + r.nextInt(600), 50 + r.nextInt(300));
        paredes[5] = new Pared(200 + r.nextInt(600), 50 + r.nextInt(300), 200 + r.nextInt(600), 50 + r.nextInt(300));
        paredes[6] = new Pared(200 + r.nextInt(600), 50 + r.nextInt(300), 200 + r.nextInt(600), 50 + r.nextInt(300));
        paredes[7] = new Pared(200 + r.nextInt(600), 50 + r.nextInt(300), 200 + r.nextInt(600), 50 + r.nextInt(300));
        
        xpos = 100;
        ypos = 100;
    }

    public Point getMCursor() {
        Point screen = getLocation();

        return new Point(MouseInfo.getPointerInfo().getLocation().x - 4, MouseInfo.getPointerInfo().getLocation().y - 28);
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
        for(Pared p : paredes) 
            p.Draw(g);
        particula.Draw(g, paredes);
    }

    public void clear(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 450);
    }
}
