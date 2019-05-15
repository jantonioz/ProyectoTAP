/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_tap_test;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author josea
 */
public class Particula {
    int[] Position;
    private Frame frame;
    int w, h;
    final int RAYCOUNT = 180;
    Ray[] rays = new Ray[RAYCOUNT];
    
    
    
    public Particula(){
        Position = new int[2];
        w = 20;
        h = 20;
        
        for (int i = 0; i < RAYCOUNT; i++) {
            rays[i] = new Ray(new Point(0,0), i*(int)( 360.0/RAYCOUNT ) );
        }
        
    }
    
    public void Update(Point p) {
        this.Position[0] = p.x;
        this.Position[1] = p.y;
        
        for (int i = 0; i < RAYCOUNT; i++) {
            rays[i].Update(p);
        }
    }
    
    public void Draw(Graphics g) {
        g.fillArc(this.Position[0] - w / 2, this.Position[1] - h / 2, w, h , 0, 360);
        
        for (Ray r : rays) {
            r.Draw(g);
        }
    }
}
