
package animaciones;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;


public class Lienzo extends javax.swing.JPanel implements Runnable{


    public Lienzo(int ancho, int alto, int velocidad) {
        initComponents();
        hilo=new Thread(this);
        this.x=0;
        this.y=((double)alto/2)-15;
        this.ancho=ancho;
        this.alto=alto;
        this.velocidad=velocidad;
        indice=0;
        velX=Math.random()*(19-1)+1;
        velY=Math.random()*(19-1)+1;
        indiceFig=1;
        this.figura="6.jpg";
        CreaPelota creador= new CreaPelota();
        this.pelota=creador.getImagen();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

 
    @Override
    public void paint(Graphics g){
      super.paint(g);
      
      Image ima= getToolkit().getImage(figura);
      
       Graphics2D g2d =(Graphics2D) g; //se hace una especie de casteo desde g a una g2D
       g2d.drawImage(ima, 0, 0,this.getWidth(),this.getHeight(), this); 
       indice++;
       AffineTransform tranf= new AffineTransform();
       tranf.translate(x, y);
       tranf.rotate(Math.toRadians(velocidad*indice),45,45);
       g2d.drawImage(pelota,tranf,null); 
     }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void inicio(){
        hilo.start();
    }
    public void parar(){
        hilo.suspend();
    }
    public void continuar(){
        hilo.resume();
    }


    @Override
    public void run() {
        boolean estadoX=true;
        boolean estadoY=false;
        
       try{
           while(true){
               
               if(estadoX==true && estadoY==false){
                while((x<(ancho-90)) && (y>0)){
                    x+=velX;
                    y-=velY;
                    Thread.sleep(30);
                    repaint();
                        if((x>=(ancho-90))){
                            estadoX=!estadoX;
                            figura=Integer.toString(indiceFig++)+".jpg";
                            if (indiceFig>6) indiceFig=1;
                        }
                        if(y<=0){
                                estadoY=!estadoY;
                        }
                }
               }
 
               if(estadoX==true && estadoY==true){
                while((x<(ancho-90)) && (y<(alto-90))){
                    x+=velX;
                    y+=velY;
                    Thread.sleep(30);
                    repaint();
                        if((x>=(ancho-90))){
                            estadoX=!estadoX;
                            figura=Integer.toString(indiceFig++)+".jpg";
                            if (indiceFig>6) indiceFig=1;
                        }
                        if(y>=(alto-90)){
                                estadoY=!estadoY;
                        }
                }
               }
               
                if(estadoX==false && estadoY==true){
                    while((x>0) && (y<(alto-90))){
                    x-=velX;
                    y+=velY;
                    Thread.sleep(30);
                    repaint();
                             if((x<=0)){
                                 estadoX=!estadoX;
                                 figura=Integer.toString(indiceFig++)+".jpg";
                                if (indiceFig>6) indiceFig=1;
                             }
                             if(y>=(alto-90)){
                                     estadoY=!estadoY;
                             }
                     }
               }
                
                if(estadoX==false && estadoY==false){
                    while((x>0) && (y>0)){
                    x-=velX;
                    y-=velY;
                    Thread.sleep(30);
                    repaint();
                             if((x<=0)){
                                 estadoX=!estadoX;
                                 figura=Integer.toString(indiceFig++)+".jpg";
                                if (indiceFig>6) indiceFig=1;
                             }
                             if(y<=0){
                                     estadoY=!estadoY;
                             }
                     }
               }
    
             
           }
       }
       catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error en la animacion", "Error", JOptionPane.WARNING_MESSAGE);
       }
    }
    
        private double x;
        private double y;
        private int ancho;
        private int alto;
        Thread hilo;
        private String figura;
        private BufferedImage pelota;
        private int velocidad;
       private  int indice;
       private  double velX;
       private  double velY;
        private int indiceFig;
}
