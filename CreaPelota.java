
package animaciones;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;


public class CreaPelota {
    
     public CreaPelota() {
        this.imagen=new BufferedImage(90, 90, BufferedImage.BITMASK);
        Graphics g= imagen.getGraphics();
        Graphics2D g2d =(Graphics2D) g; //se hace una especie de casteo desde g a una g2D
         Color color_primero = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
         Color color_segundo = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
         g2d.setPaint(new GradientPaint(0, 0, color_primero, 90, 0, color_segundo, true)); 
        g2d.fill(new Ellipse2D.Double( 0, 0, 90, 90 ));
        g2d.setStroke(new BasicStroke( 2 ) );
       g2d.setPaint(Color.BLACK);
        g2d.draw(new Ellipse2D.Double(1,1,88,88));
        
        colorFractal = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
        profundidad = (int)(Math.random()*(5-1)+1);
       
        double ancho=(double)(this.imagen.getWidth()-1)/2;
        double extension=20;
       
        
      hacerFractal(colorFractal,imagen,ancho,ancho,extension,profundidad);
     
     
    }
    private void hacerFractal(Color colorF,BufferedImage imagen,double xCentro,double yCentro,double ancho, int prof){
        
        
            double x1=xCentro+ancho;
            double x2=xCentro-ancho;
            double y1=yCentro+ancho;
            double y2=yCentro-ancho;

            
            Graphics g = imagen.getGraphics();
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke( 2 ) );
            g2.setPaint(colorF);
            g2.draw(new Line2D.Double( xCentro, yCentro, x1, yCentro) );
            g2.draw(new Line2D.Double( xCentro, yCentro, x2, yCentro) );
            g2.draw(new Line2D.Double( xCentro, yCentro, xCentro, y1) );
            g2.draw(new Line2D.Double( xCentro, yCentro, xCentro,y2) );

            if(prof>1){
            hacerFractal(colorFractal,imagen,x1,yCentro,ancho/2,prof-1);
             hacerFractal(colorFractal,imagen,x2,yCentro,ancho/2,prof-1);
              hacerFractal(colorFractal,imagen,xCentro,y1,ancho/2,prof-1);
               hacerFractal(colorFractal,imagen,xCentro,y2,ancho/2,prof-1);}
    }

    
      public BufferedImage getImagen(){  
        return this.imagen;
    }
    

    private BufferedImage imagen;
    private Color colorFractal;
    private int profundidad;
    
}
