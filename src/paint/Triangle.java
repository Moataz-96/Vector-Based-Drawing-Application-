
package paint;
import java.awt.Point;
import java.util.Map;
import java.util.HashMap;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Triangle extends DrawShapes  implements Shape {
    private Point P;
    private Map<String, Double> M;
    private Color CBorder;
    private Color CFill;
    public Triangle() {
    	
		M = new HashMap<String, Double>() {};
		M.put("LineX1", 0.0);
		M.put("LineX2", 0.0);
		M.put("LineX3", 0.0);
		M.put("LineY1", 0.0);
		M.put("LineY2", 0.0);
		M.put("LineY3", 0.0);
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
    	Triangle t = new Triangle();
		return  t;
    	}
    @Override
    public void draw(Graphics canvas){
    	
    	canvas.setColor(CBorder);
    	
   	canvas.drawLine((int)P.getX(), (int)P.getY(), (int)(M.get("LineX1").doubleValue()), (int)(M.get("LineY1").doubleValue()));
   	canvas.drawLine( (int)(M.get("LineX1").doubleValue()), (int)(M.get("LineY1").doubleValue()), (int)(M.get("LineX2").doubleValue()), (int)(M.get("LineY2").doubleValue()));
   	canvas.drawLine( (int)(M.get("LineX2").doubleValue()), (int)(M.get("LineY2").doubleValue()), (int)P.getX(), (int)P.getY());
   	
    }
    
}
