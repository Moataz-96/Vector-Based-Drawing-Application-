
package paint;
import java.awt.Point;
import java.util.Map;
import java.util.HashMap;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Rectangle extends DrawShapes  implements Shape {
    private Point P;
    private Map<String, Double> M;
    private Color CBorder;
    private Color CFill;
    public Rectangle() {
    	
		M = new HashMap<String, Double>() {};
		M.put("RectX", 0.0);
		M.put("RectY", 0.0);
		
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
    	Rectangle r = new Rectangle();
		return  r;
    	}
    @Override
    public void draw(Graphics canvas){
    	
    	canvas.setColor(CFill);
      	canvas.fill3DRect((int)P.getX(), (int)P.getY(), (int)(M.get("RectX").doubleValue()), (int)(M.get("RectY").doubleValue()),true);
     	
    	canvas.setColor(CBorder);
      	canvas.drawRect((int)P.getX(), (int)P.getY(), (int)(M.get("RectX").doubleValue()), (int)(M.get("RectY").doubleValue()));
   
    }
    
}
