/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_tap_test;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author josea
 */
public class Rayo {

    PointF inicio;
    int r = 30;
    PointF dir;
    double angulo;
    Color mColor;

    /**
     * Constructor de un rayo, con un punto inicial y un angulo de proyección
     * @param start Punto inicial del rayo
     * @param angle Angulo fijo de proyeccion
     */
    public Rayo(PointF start, double angle) {
        this.inicio = start;
        this.dir = calcDir();
        this.angulo = angle;
        mColor = new Color(255, 255, 255);
    }

    /**
     * Actualiza el punto inicial del rayo
     * @param p Punto a donde debe actualizarse
     */
    public void Actualizar(PointF p) {
        this.inicio = new PointF(p.x, p.y);
        dir = calcDir();
    }

    /**
     * Cuando colisiona con algo se pone el fin del rayo
     * @param pt Punto final del rayo
     */
    public void setFin(PointF pt) {
        this.dir.x = pt.x - inicio.x;
        this.dir.y = pt.y - inicio.y;
    }
    
    /**
     * Retorna un punto final provisional
     * @return 
     */
    public PointF calcDir() {
        float x = (float) (Math.cos((angulo * Math.PI) / 180.0) * r);
        float y = (float) (Math.sin((angulo * Math.PI) / 180.0) * r);
        return new PointF((x), (y));
    }

    /**
     * Usa la formula de Line-Line intersection para calcular un punto de interseccion
     * entre el rayo y la pared
     * @param p Pared en la que hará los calculos
     * @return Un punto donde intersecciona el rayo y la pared cualquiera
     */
    public PointF Cast(Pared p) {
        float x1 = p.a.x;
        float y1 = p.a.y;
        float x2 = p.b.x;
        float y2 = p.b.y;

        float x3 = inicio.x;
        float y3 = inicio.y;
        float x4 = inicio.x + dir.x;
        float y4 = inicio.y + dir.y;

        // SI ES 0 entonces son paralelas las lineas;
        float den = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        if (den == 0) {

            return null;
        }

        float t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4));
        t = t / den;
        float u = -((x1 - x2) * (y1 - y3) - (y1 - y2) * (x1 - x3));
        u = u / den;

        if (t > 0 && t < 1 && u > 0) {

            return new PointF((x1 + t * (x2 - x1)), (y1 + t * (y2 - y1)));
        } else {

            return null;
        }
    }

    public void Dibujar(Graphics g, Color col) {
        this.mColor = col;
        //g.drawLine((int) inicio.x, (int) inicio.y, (int) (inicio.x + dir.x), (int) (inicio.y + dir.y));
        dibujarLinea(g, (int) inicio.x, (int) inicio.y, (int) (inicio.x + dir.x), (int) (inicio.y + dir.y));
    }

    /**
     * Utiliza el algoritmo de LinieaDDA para dibujar una linea con degradado a negro
     * @param g Lienzo
     * @param x1 Inicio de la linea en X
     * @param y1 Inicio de la linea en Y
     * @param x2 Fin de la linea en X
     * @param y2 Fin de la linea en Y
     */
    private void dibujarLinea(Graphics g, int x1, int y1, int x2, int y2) {
        double colorR = mColor.getRed();
        double colorG = mColor.getGreen();
        double colorB = mColor.getBlue();
        double dX = x2 - x1;
        double dY = y2 - y1;
        double hyp = Math.hypot(dX, dY);
        double x = x1;
        double y = y1;

        double steps = Math.abs(dX) > Math.abs(dY) ? Math.abs(dX) : Math.abs(dY);
        double incX = dX / steps;
        double incY = dY / steps;

        for (int i = 0; i <= steps; i++) {
            double colorAuxR = Math.max(colorR, 0);
            double colorAuxG = Math.max(colorG, 0);
            double colorAuxB = Math.max(colorB, 0);
            g.setColor(new Color((int) colorAuxR, (int) colorAuxG, (int) colorAuxB));
            g.drawLine((int) x, (int) y, (int) x, (int) y);
            x += incX;
            y += incY;
            colorR -= 0.5 * hyp / steps;
            colorG -= 0.5 * hyp / steps;
            colorB -= 0.5 * hyp / steps;
        }
    }
    
    public void setColor(Color col) {
        this.mColor = new Color(col.getRGB());
    }
}
