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
    
    // Posicion de la ventana
    int[] Posicion;
    
    // Alto y ancho del centro de la partícula
    int w, h;
    
    // Cantidad de rayos que dibuja la particula
    // Por defecto 200
    int CANTRAYOS = 200;
    
    // Arreglo de rayos que contiene la particula
    // Por defecto la cantidad de rayos antes definida
    Rayo[] rayos = new Rayo[CANTRAYOS];
    
    // Color del centro de la particula
    Color mColor = new Color(255, 255, 255);
    
    /**
     * Constructor por defecto de la particula
     */
    public Particula() {
        Posicion = new int[2];
        w = 10;
        h = 10;

        // Agrega nuevas instancias de rayo al arreglo rayos
        for (int i = 0; i < rayos.length; i++) {
            rayos[i] = new Rayo(new PointF(0, 0), i * (360.0 / CANTRAYOS));
        }
    }

    /**
     * Actualiza la posicion de los rayos con respecto 
     * a la perticula.
     * @param p Actualiza en el punto indicado.
     */
    public void Actualizar(Point p) {
        this.Posicion[0] = p.x;
        this.Posicion[1] = p.y;

        for (int i = 0; i < rayos.length; i++) {
            rayos[i].Actualizar(new PointF(p.x, p.y));
        }
    }

    /**
     * Logica de dibujo de la particula
     * @param g Lienzo de dibujo
     * @param paredes paredes para calcular los puntos de interseccion
     */
    public void Dibujar(Graphics g, Pared... paredes) {
        g.fillArc(this.Posicion[0] - w / 2, this.Posicion[1] - h / 2, w, h, 0, 360);
        
        // itera sobre todos los rayos
        for (Rayo r : rayos) {
            
            // Variables para determinar el punto de interseccion más cercano
            PointF closest = null;
            double record = Double.MAX_VALUE;
            
            // itera sobre todas las peredes
            for (Pared p : paredes) {
                // obtiene el punto de interseccion entre el rayo actual y 
                // la pared actual.
                PointF pt = r.Cast(p);
                
                // Si el punto existe calcula la distancia 
                // y actualiza al punto más cercano
                if (pt != null) {
                    double d = Math.sqrt(Math.pow(Posicion[0] - pt.x ,2) + Math.pow(Posicion[1] - pt.y, 2));
                    if (d < record) {
                        record = d;
                        closest = pt;
                    }
                }
            }
            
            // si existe el punto más cercano lo dibuja.
            if (closest != null) {
                // actualiza el fin del punto con el punto de interseccion más cercano
                r.setFin(closest);
                r.Dibujar(g, mColor);
            }
        }
    }
    
    /**
     * actualiza la cantidad de rayos de manera dinamica
     * @param cant Actualiza a la cantidad definida
     */
    public void setRayos(int cant) {
        // Si la cantidad de rayos por parametro es la misma
        // entonces se sale 
        if (cant == CANTRAYOS)
            return;
        
        CANTRAYOS = cant;
        rayos = new Rayo[cant];
        for (int i = 0; i < CANTRAYOS; i++) {
            rayos[i] = new Rayo(new PointF(0, 0), i * (360.0 / CANTRAYOS));
        }
    }

    /**
     * Actualiza el color de la particula
     * @param color 
     */
    void setColorRayos(Color color) {
        this.mColor = color;
    }
}
