package proyecto_tap_test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author josea
 */
public class Pared {
    
    // Puntos para determinar el inicio y el fin de la pared
    public Point a, b;
    
    /**
     * Constructor principal de Pared
     * @param x1 inicio de la pared en X
     * @param y1 inicio de la pared en Y
     * @param x2 fin de la pared en X
     * @param y2 fin de la pared en Y
     */
    public Pared (int x1, int y1, int x2, int y2) {
        this.a = new Point(x1, y1);
        this.b = new Point(x2, y2);
    }
    
    /**
     * Dibuja la pared con un color blanco
     * @param g Lienzo donde hace las operaciones
     */
    public void Dibujar(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawLine(a.x, a.y, b.x, b.y);
    }
}
