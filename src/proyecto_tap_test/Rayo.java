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
public class Rayo {

    Point inicio;
    int r = 30;
    Point dir;
    int angulo;

    public Rayo(Point start, int angle) {
        this.inicio = start;
        this.dir = calcDir();
        this.angulo = angle;
    }

    public void Actualizar(Point p) {
        this.inicio = new Point(p.x, p.y);
        dir = calcDir();
    }

    public void setFin(Point pt) {
        this.dir.x = pt.x - inicio.x;
        this.dir.y = pt.y - inicio.y;
    }

    public Point calcDir() {
        double x = (int) (Math.cos((angulo * Math.PI) / 180.0) * r);
        double y = (int) (Math.sin((angulo * Math.PI) / 180.0) * r);
        return new Point((int) (x), (int) (y));
    }

    public Point Cast(Pared p) {
        int x1 = p.a.x;
        int y1 = p.a.y;
        int x2 = p.b.x;
        int y2 = p.b.y;

        int x3 = inicio.x;
        int y3 = inicio.y;
        int x4 = inicio.x + dir.x;
        int y4 = inicio.y + dir.y;

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

    public void Dibujar(Graphics g) {
        g.setColor(new Color(1, 1, 1, 0.20f));
        g.drawLine(inicio.x, inicio.y, inicio.x + dir.x, inicio.y + dir.y);
    }
}
