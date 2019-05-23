/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_tap_test;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.image.BufferedImage;
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
    Dimension d;

    public Game(Dimension d) {
        this.setLocation(0, 0);
        this.d = d;
        this.setSize(d);
        this.setCursor(getToolkit().createCustomCursor(
                   new BufferedImage( 1, 1, BufferedImage.TYPE_INT_ARGB ),
                   new Point(),
                   null ) );
        
        loadWalls();

        xpos = 100;
        ypos = 100;
    }
    
    private void loadWalls() {
        paredes[0] = new Pared(0, 0, (int)d.getWidth(), 0);
        paredes[1] = new Pared((int)d.getWidth(), 0, (int)d.getWidth(), (int)d.getHeight());
        paredes[2] = new Pared(0, (int)d.getHeight(), (int)d.getWidth(), (int)d.getHeight());
        paredes[3] = new Pared(0, 0, 0, (int)d.getHeight());

        paredes[4] = new Pared(200 + r.nextInt((int)d.getWidth() - 200), 50 + r.nextInt((int)d.getHeight() - 100), 200 + r.nextInt((int)d.getWidth() - 200), 50 + r.nextInt((int)d.getHeight() - 100));
        paredes[5] = new Pared(200 + r.nextInt((int)d.getWidth() - 200), 50 + r.nextInt((int)d.getHeight() - 100), 200 + r.nextInt((int)d.getWidth() - 200), 50 + r.nextInt((int)d.getHeight() - 100));
        paredes[6] = new Pared(200 + r.nextInt((int)d.getWidth() - 200), 50 + r.nextInt((int)d.getHeight() - 100), 200 + r.nextInt((int)d.getWidth() - 200), 50 + r.nextInt((int)d.getHeight() - 100));
        paredes[7] = new Pared(200 + r.nextInt((int)d.getWidth() - 200), 50 + r.nextInt((int)d.getHeight() - 100), 200 + r.nextInt((int)d.getWidth() - 200), 50 + r.nextInt((int)d.getHeight() - 100));
    }
    
    public Point getMCursor() {
        Point screen = getLocation();

        return new Point(MouseInfo.getPointerInfo().getLocation().x - 4, MouseInfo.getPointerInfo().getLocation().y - 28);
    }

    public void actualizar() {
        Point p = MouseInfo.getPointerInfo().getLocation();
        xpos = getMCursor().x;
        ypos = getMCursor().y;

        particula.Actualizar(getMCursor());
    }
    
    public void updateDim(Dimension dim) {
        this.d = dim;
        loadWalls();
    }

    public void paintComponent(Graphics g) {
        limpiar(g);

        particula.Dibujar(g, paredes);
        g.setColor(Color.WHITE);
        for (Pared p : paredes) {
            p.Dibujar(g);
        }
    }

    public void limpiar(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, (int)d.getWidth(), (int)d.getHeight());
    }
}
