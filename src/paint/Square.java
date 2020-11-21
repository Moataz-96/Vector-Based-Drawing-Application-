package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Square extends DrawShapes implements Shape  {

	private Point p;
	private Map<String, Double> M;
	private Color CBorder;
	private Color CFill;
	
	public Square() {
		M = new HashMap<String, Double>();
		M.put("side", 0.0);
	}
	
        @Override
	public void setPosition(Point position) { p = position; }
        @Override
	public Point getPosition() { return p; }

    /**
     *
     * @param properties
     */
    @Override
	public void setProperties(Map<String, Double> properties) {	M = properties; }
        @Override
	public Map<String, Double> getProperties() { return M; }

        @Override
	public void setColor(Color color) {	CBorder = color;	}
	
        @Override
	public Color getColor() { return CBorder;	}

        @Override
	public void setFillColor(Color color) { CFill = color; }
        @Override
	public Color getFillColor() { return CFill; }
        @Override
        public Object clone()  throws CloneNotSupportedException {
        	Square s = new Square();
    		return  s;
        	}
	@Override
	public void draw(Graphics canvas) {
		   canvas.setColor(CFill);      
			canvas.fill3DRect((int)p.getX(), (int)p.getY(), (int)(M.get("side").doubleValue()), (int)(M.get("side").doubleValue()),true);		
		
          canvas.setColor(CBorder);      
		canvas.drawRect((int)p.getX(), (int)p.getY(), (int)(M.get("side").doubleValue()), (int)(M.get("side").doubleValue()));		
	
	}
	
}