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
    int r = 30;
    Point dir;
    int angle;

    public Ray(Point start, int angle) {
        this.start = start;
        this.dir = calcDir();
        this.angle = angle;
    }

    public void Update(Point p) {
        this.start = new Point(p.x, p.y);
        dir = calcDir();
    }

    public void setEnd(Point pt) {
        this.dir.x = pt.x - start.x;
        this.dir.y = pt.y - start.y;
    }

    public Point calcDir() {
        double x = (int) (Math.cos((angle * Math.PI) / 180.0) * r);
        double y = (int) (Math.sin((angle * Math.PI) / 180.0) * r);
        return new Point((int) (x), (int) (y));
    }

    public Point Cast(Pared p) {
        int x1 = p.a.x;
        int y1 = p.a.y;
        int x2 = p.b.x;
        int y2 = p.b.y;

        int x3 = start.x;
        int y3 = start.y;
        int x4 = start.x + dir.x;
        int y4 = start.y + dir.y;

        // SI ES 0 entonces son paralelas las lineas;
        int den = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        if (den == 0) {

            return null;
        }

        double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4));
        t = t / den;
        double u = -((x1 - x2) * (y1 - y3) - (y1 - y2) * (x1 - x3));
        u = u / den;

        if (t > 0 && t < 1 && u > 0) {

            return new Point((int) (x1 + t * (x2 - x1)), (int) (y1 + t * (y2 - y1)));
        } else {

            return null;
        }
    }

    public void Draw(Graphics g) {
        g.setColor(new Color(1, 1, 1, 0.20f));
        g.drawLine(start.x, start.y, start.x + dir.x, start.y + dir.y);
    }
}
