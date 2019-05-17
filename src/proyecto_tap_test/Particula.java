/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_tap_test;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author josea
 */
public class Particula {

    int[] Posicion;
    private Frame frame;
    int w, h;
    final int CANTRAYOS = 360 * 3;
    Rayo[] rayos = new Rayo[CANTRAYOS];
    
    public Particula() {
        Posicion = new int[2];
        w = 10;
        h = 10;

        for (int i = 0; i < CANTRAYOS; i++) {
            rayos[i] = new Rayo(new PointF(0, 0), i * (360.0 / CANTRAYOS));
        }

    }

    public void Actualizar(Point p) {
        this.Posicion[0] = p.x;
        this.Posicion[1] = p.y;

        for (int i = 0; i < CANTRAYOS; i++) {
            rayos[i].Actualizar(new PointF(p.x, p.y));
        }
    }

    public void Dibujar(Graphics g, Pared... paredes) {
        g.fillArc(this.Posicion[0] - w / 2, this.Posicion[1] - h / 2, w, h, 0, 360);

        for (Rayo r : rayos) {
            PointF closest = null;
            double record = Double.MAX_VALUE;
            for (Pared p : paredes) {
                PointF pt = r.Cast(p);
                if (pt != null) {
                    double d = Math.sqrt(Math.pow(Posicion[0] - pt.x ,2) + Math.pow(Posicion[1] - pt.y, 2));
                    if (d < record) {
                        record = d;
                        closest = pt;
                    }
                }
            }
            
            if (closest != null) {
                g.setColor(Color.WHITE);
                r.setFin(closest);
                r.Dibujar(g);
            }
        }
    }
}
