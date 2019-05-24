/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_tap_test;

/**
 *
 * @author josea
 */
public class PointF {
    public float x;
    public float y;
    
    /**
     * Constructor de punto flotante para mantener la presicion de los rayos
     * @param x
     * @param y 
     */
    public PointF(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public PointF add(PointF b) {
        return new PointF(this.x + b.x, this.y + b.y);
    }
    
    public PointF sub(PointF b) {
        return new PointF(this.x - b.x, this.y - b.y);
    }
    
    public PointF mult(float s){
        return new PointF(this.x * s, this.y * s);
    }
}
