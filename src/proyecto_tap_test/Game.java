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
    // Posicion x,y del puntero.
    public int xpos, ypos;
    
    // Particula emizora de luz.
    public Particula particula = new Particula();
    
    // Parades donde cada rayo de luz impacta.
    public Pared paredes[] = new Pared[4 + 4];
    
    // Genera posiciones aleatorias para las paredes
    // de los bordes de la ventana.
    private Random r = new Random();
    
    // Dimensión de la ventana
    public Dimension d;

    /**
     * Constructor base del panel Game que tiene la logica de dibujar 
     * y actualizar los objetos del juego
     * @param d recibe la dimensión de la ventana que lo crea
     */
    public Game(Dimension d) {
        // Mueve el panel a la posición 0, 0 del parent (Ventana.java)
        this.setLocation(0, 0);
        
        // Actualiza la dimension local 
        this.d = d;
        
        // Establece la dimensión
        this.setSize(d);
        
        // Cambia el cursor por una imaben vacía
        this.setCursor(getToolkit().createCustomCursor(
                   new BufferedImage( 1, 1, BufferedImage.TYPE_INT_ARGB ),
                   new Point(),
                   null ) );
        
        // Genera las paredes de los bordes de la ventana
        loadWalls();
        
        // inicializa la posicion del ratón desde
        // el inicio para evitar errores de referencia nula
        xpos = 100;
        ypos = 100;
    }
    /**
     * Genera 4 paredes en los bordes de una ventana segun 
     * la dimensión local, además de generar 4 paredes aleatorias
     * dentro de la ventana
     */
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
    
    /**
     * Obtiene la posicion del cursor
     * @return Regresa la posición del cursor con respecto a la ventana
     */
    public Point getMCursor() {
        return new Point(MouseInfo.getPointerInfo().getLocation().x - 4, MouseInfo.getPointerInfo().getLocation().y - 28);
    }

    /**
     * Actualiza el puntero y la particula con la posicion del puntero
     */
    public void actualizar() {
        Point p = MouseInfo.getPointerInfo().getLocation();
        xpos = getMCursor().x;
        ypos = getMCursor().y;

        particula.Actualizar(getMCursor());
    }
    
    // redimensiona el tamaño de la ventana dinamicamente
    public void updateDim(Dimension dim) {
        this.d = dim;
        loadWalls();
    }

    /**
     * Logica de dibujo
     * @param g Lienzo en el que hace las operaciones
     */
    public void paintComponent(Graphics g) {
        limpiar(g);

        particula.Dibujar(g, paredes);
        g.setColor(Color.WHITE);
        for (Pared p : paredes) {
            p.Dibujar(g);
        }
    }

    /**
     * Borra la pantalla con color negro
     * @param g Lienzo en el que hace las operaciones
     */
    public void limpiar(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, (int)d.getWidth(), (int)d.getHeight());
    }
}
