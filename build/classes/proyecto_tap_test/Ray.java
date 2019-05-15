/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_tap_test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author josea
 */
public class Ray {

    Point start;
    int r = 500;
    Point end;
    int angle;

    public Ray(Point start, int angle) {
        this.start = start;
        this.end = calcEnd();
        this.angle = angle;
    }

    public void Update(Point p) {
        this.start = new Point(p.x, p.y);
        end = calcEnd();
    }

    public void setEnd() {

    }
    
    public Point calcEnd() {
        double x = (int) (Math.cos((angle * Math.PI) / 180.0) * r);
        double y = (int) (Math.sin((angle * Math.PI) / 180.0) * r);
        return new Point((int)(start.x + x), (int)(start.y + y));
    }

    public void Cast(Pared p) {
        
    }

    public void Draw(Graphics g) {
        g.setColor(new Color(1,1,1, 0.35f));
        g.drawLine(start.x, start.y, end.x, end.y);
    }
}
