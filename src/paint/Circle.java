
package paint;
import java.awt.Point;
import java.util.Map;
import java.util.HashMap;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Circle extends DrawShapes  implements Shape {
    private Point P;
    private Map<String, Double> M;
    private Color CBorder;
    private Color CFill;
    public Circle() {
    	
		M = new HashMap<String, Double>() {};
		M.put("Raduis", 0.0);
		
	}
    
    @Override
    public void setPosition(java.awt.Point position){ P=position;}
    @Override
    public java.awt.Point getPosition(){return P;}

    @Override
   public void setProperties(Map<String, Double> properties){M= properties;}
    @Override
    public java.util.Map<String, Double> getProperties(){return M;};

    @Override
   public void setColor(java.awt.Color color){CBorder=color;}
    @Override
    public java.awt.Color getColor(){return CBorder;}
    @Override
    public void setFillColor(java.awt.Color color){CFill=color; }
    @Override
    public java.awt.Color getFillColor(){return CFill;}
    @Override
    public Object clone()  throws CloneNotSupportedException {
    	Circle c = new Circle();
		return  c;
    	}
    @Override
    public void draw(Graphics canvas){
    	
    	canvas.setColor(CFill);
        canvas.fillOval((int)P.getX(), (int)P.getY(), (int)(M.get("Raduis").doubleValue()), (int)(M.get("Raduis").doubleValue()));
        canvas.setColor(CBorder);
        canvas.drawOval((int)P.getX(), (int)P.getY(), (int)(M.get("Raduis").doubleValue()), (int)(M.get("Raduis").doubleValue()));
     
   
    }
    
}
