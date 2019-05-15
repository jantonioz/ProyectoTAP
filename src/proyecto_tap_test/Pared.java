package proyecto_tap_test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author josea
 */
public class Pared {
    public Point a, b;
    public Pared (int x1, int y1, int x2, int y2) {
        this.a = new Point(x1, y1);
        this.b = new Point(x2, y2);
    }
    
    public void Dibujar(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawLine(a.x, a.y, b.x, b.y);
    }
}
