/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Point;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author zeyad
 */
public class DrawShapes extends JComponent implements DrawingEngine {

    Shape S[]=new Shape[100];
    int counter=0,index =0;
   Point p2;
   Shape Undo[]= new Shape[21];
   Map <String, Double> M;
  
   int undocount=-1;


   	 
    @Override
    public void paintComponent(Graphics g){
    	
    	super.paintComponent(g);
    	this.setBackground(Color.white);
    	this.setBounds(0,0 ,660,230);
    	if(counter > 0 ){
    		 DrawShapes(g);
    		
    		 refresh(g);}
    		
    }
    
    public void DrawShapes(Graphics g){
       
	
	    S[ index].setFillColor(MainFrame.getFillColor(index));
	    S[ index].setColor(MainFrame.getBorderColor(index));
	    S[ index].setProperties(MainFrame.getMap(index));
	    S[ index].setPosition(MainFrame.getPoint(index));
    
    }
    
    @Override
    public void addShape(Shape shape) {
        S[ counter]= shape;
        index = counter;
        counter++;
        
    }

    @Override
    public void removeShape(Shape shape) {
    	S[index]=null;
        counter--;
        index--;
        if(index == -1)
        	index = 0;
        }
       
    

    @Override
    public Shape[] getShapes() {
        return S;
    }

    @Override
    public void refresh(Graphics canvas) {
      
    	
    	for (int i=0;i<counter;i++)
  
    		S[i].draw(canvas);

    }

	@Override
	public void undo() {
	
			
			
				undocount++;
				try {
					Undo[undocount] = (Shape) S[index].clone();
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
		
	}

	@Override
	public void redo() {
	

		if(undocount >= 0 && undocount <=19){
			try {
				addShape((Shape) Undo[undocount].clone());
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		undocount--;
		}
	}
	 
	
	public void Copy() {
	
		try {
			addShape((Shape) S[index].clone());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Class<? extends Shape>> getSupportedShapes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void installPluginShape(Class<? extends Shape> shapeClass) {
		// TODO Auto-generated method stub
		
	}

	
		

}