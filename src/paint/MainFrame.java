
package paint;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
//import java.awt.List;
import java.awt.Point;

import javax.print.attribute.standard.SheetCollate;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.Timer;

import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.awt.Point;
import java.io.File;



class MainFrame implements ActionListener,KeyListener {
	   Timer t = new Timer(5, this);
	   DrawShapes she;
	   JButton bCircle,bTriangle,bRectangle,bSquare,bLine,bElipse,bMove,bEdit,bRedo,bUndo,
       bColor,bDelete,bCopy,bPlugin,bBorder,bFill,okBut,CancelBut;
       JLabel SelShape;
       JPanel Space;
       JDialog p,pColor;       
       JFileChooser Choose;
       JComboBox box;
       JLabel xLabel,yLabel,wLabel,hLabel,rLabel,TriLabel1,TriLabel2,TriLabel3;
       JTextField xText,yText,wText,hText,rText,TriText1,TriText2,TriText3;
       
       private String xPoint,yPoint,wPoint,hPoint,name,number;
	   private static Color SetColor[]= new Color[100];
	   private static Color FillColor[]= new Color[100];
       private String value,valueY;   //for moving shapes'
       private String numberY,nameY;
       private String TriDegree;
       private JRadioButton HZ,VT;	  
       private ButtonGroup btn;
       private Boolean checkLineMoving=false;
       private DefaultComboBoxModel<String> Model;
       private JFrame mainframe;
       private int LineX=0,LineY=0,TriX1=0,TriY1=0,TriX2=0,TriY2=0,x,y,ComboBoxSelectItem,velx=0,vely=0,FlagLine=0,TextAssert=0;
       private static Point P1[] = new Point[100];
       private static HashMap<String,Double>[] myMap = new HashMap[100];
       boolean checkOkBut=false,checkCancelBut=false,checkText=false;
       private Boolean checkMove=false,checkTriangleMoving=false,checkEdit=false;
     
      
	
	MainFrame(){
		GUI();
		}
	
        public static void main(String [] arg0){
        	new MainFrame();	
        	
        	}
        
        private void GUI(){
        	  
            mainframe = new JFrame("Vector Drawing Application");
            t.start();
    		mainframe.addKeyListener(this);
    		mainframe.setFocusable(true);
    		mainframe.setFocusTraversalKeysEnabled(false);
    		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		
    		xLabel    =	new JLabel("Enter x value :");
    		yLabel    =	new JLabel("Enter y value :");
    		wLabel    =	new JLabel("Enter width value :");
    		hLabel    =	new JLabel("Enter height value :");
    		rLabel 	  =	new JLabel("Enter Radius value :");
    		TriLabel1 =	new JLabel("Enter Length1 :");
    		TriLabel2 =	new JLabel("Enter Length2 :");
    		TriLabel3 =	new JLabel("Enter Degree  :");
    		xText 	  =	new JTextField();
    		yText 	  =	new JTextField();
    		wText 	  =	new JTextField();
    		hText 	  =	new JTextField();
    		rText 	  =	new JTextField();
    		TriText1  =	new JTextField();
    		TriText2  =	new JTextField();
    		TriText3  =	new JTextField();
    		
    		p =         new JDialog(mainframe,"Child",true);
    	
    		bCircle = 	new JButton("Circle");
    	    bTriangle = new JButton("Triangle");
         	bRectangle =new JButton("Rectangle");
    		bSquare = 	new JButton("Square");
    		bLine = 	new JButton("LineSegment");
    		bElipse = 	new JButton("Ellipse");
    		bRedo = 	new JButton("Redo");
    		bUndo = 	new JButton("Undo");
    		bMove = 	new JButton("Move");
    		bEdit = 	new JButton("Edit");
    		bColor= 	new JButton("Color");
    		bDelete = 	new JButton("Delete");
    		bCopy = 	new JButton("Copy");
    		bBorder = 	new JButton("BorderColor");
    		bFill = 	new JButton("FillColor");
    		HZ =	    new JRadioButton("Horizontal");
    		VT = 		new JRadioButton("Vertical");
    		
    		Model = new DefaultComboBoxModel();
    		box = new JComboBox();
    		
    		SelShape = new JLabel("Select Shape");
    		box.setRenderer(new MyComboBoxRenderer("Selected Shape"));
    		
    		box.setSelectedIndex(-1);
    		box.addActionListener(this);
    		
    	   for(int i =0 ; i<100;i++){
    		   myMap[i] = (HashMap<String, Double>) new HashMap();
    			 P1[i] = new Point();   
    	   
    	    SetColor[i]=Color.BLACK;
    	    FillColor[i]=Color.white;
    	   } 
    		x=300;
    		y=130;
    		Space=new JPanel();
          
            okBut = new JButton("Ok");
            CancelBut = new JButton("Cancel");
            
    		bCircle.setBounds((815-550), 25, 110	, 30);
    		bLine.setBounds((815-440), 25, 110, 30);
    		bSquare.setBounds((815-330), 25, 110	, 30);
    		bElipse.setBounds((815-220), 25, 110	, 30);
    		bTriangle.setBounds((815-110), 25, 110	, 30);
    		bRectangle.setBounds(815, 25, 110	, 30);
    		bUndo.setBounds(15,80,100,30);
    		bRedo.setBounds(115,80,100,30);	
    		bColor.setBounds(115, 230,100,30);
    		bCopy.setBounds(15, 230,100,30);
    		bDelete.setBounds(115, 270,100,30);
    		bMove.setBounds(115, 190,100,30);
    		bEdit.setBounds(15, 190,100,30);
    		SelShape.setBounds(15,125 ,200,20);
    		Space.setBounds((815-550),80 ,660,230); 
    		box.setBounds(15	, 150, 200, 30);

    		wLabel.setBounds(20,50,150,20);
    		hLabel.setBounds(20,70,150,20);
    		rLabel.setBounds(20,50,150,20);
    		TriLabel1.setBounds(20,50,110,20);
    		TriLabel2.setBounds(20,70,110,20);
    		TriLabel3.setBounds(20,90,110,20);
    		rText.setBounds(160, 50, 70, 20);
    		
    		wText.setBounds(160,50,70,20);
    		hText.setBounds(160,70,70,20);
    		TriText1.setBounds(160, 50,70,20);
    		TriText2.setBounds(160,70,70,20);
    		TriText3.setBounds(160,90,70,20);
    		xText.setBounds(160,10,70,20);
    		yText.setBounds(160,30,70,20);
    		xLabel.setBounds(20,10,90,20);
    		yLabel.setBounds(20,30,90,20);
    		
    		
    		
    		okBut.setBounds(130,110,90,30);
    		CancelBut.setBounds(30,110,90,30);
    		
    		HZ.setBounds(50,80,90,20);
    		VT.setBounds(140,80,90,20);
    		
    		btn = new ButtonGroup();
    		btn.add(HZ);
    		btn.add(VT);
    		 Space.setVisible(true);
           
             
    		 Space.setBackground(Color.white);
    		 p.setBounds(440,140,250,150);
    		 p.setUndecorated(true);
    		 p.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
    		pColor = 	new JDialog(mainframe,"Childss",true);
    		 
    		 pColor.setBounds(440,150,300,50);
    		
    		bBorder.setBounds(5, 10, 140, 30);
    		bFill.setBounds(155, 10, 140, 30);
    		 pColor.setUndecorated(true);
    		 pColor.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
    		 pColor.add(bFill);
             pColor.add(bBorder);
             p.add(okBut);
             p.add(CancelBut);
             p.add(xLabel);
             p.add(yLabel);
             p.add(wLabel);
             p.add(hLabel);
             p.add(xText);
             p.add(yText);
             p.add(wText);
             p.add(hText);
             p.add(rLabel);
             p.add(rText);
             p.add(TriLabel1);
             p.add(TriLabel2);
             p.add(TriLabel3);
             p.add(TriText1);
             p.add(TriText2);
             p.add(TriText3);
             p.add(HZ);
             p.add(VT);
      
             DialgFalse();
          
             
    		Focus();
    		
    		xText.setVisible(true);
    		yText.setVisible(true);
    		xLabel.setVisible(true);
    		yLabel.setVisible(true);
         
            she = new DrawShapes();
    		Space.add(she);
    		
    		p.setLayout(new BorderLayout());

               p.setVisible(false);
               
            pColor.setLayout(new BorderLayout());

               pColor.setVisible(false);
               
              
               mainframe.add(Space);
           	bCircle.addActionListener(this);
    		bSquare.addActionListener(this);
    		bTriangle.addActionListener(this);
    		bRectangle.addActionListener(this);
    		bElipse.addActionListener(this);
    		bLine.addActionListener(this);
    		bEdit.addActionListener(this);
    		bMove.addActionListener(this);
    		bCopy.addActionListener(this);
    		bUndo.addActionListener(this);
    		bRedo.addActionListener(this);
    		bColor.addActionListener(this);
    		bDelete.addActionListener(this);
    		bBorder.addActionListener(this);
    		bFill.addActionListener(this);
    		CancelBut.addActionListener(this);
    		okBut.addActionListener(this);
    		bRedo.setEnabled(false);
    		mainframe.add(box);
       		mainframe.add(SelShape);
       		mainframe.add(bMove);
       		mainframe.add(bEdit);
       		mainframe.add(bCopy);
       		mainframe.add(bColor);
       		mainframe.add(bDelete);
       		mainframe.add(bRedo);
       		mainframe.add(bUndo);
       		mainframe.add(bCircle);
       		mainframe.add(bLine);
       		mainframe.add(bSquare);
       		mainframe.add(bElipse);
       		mainframe.add(bTriangle);
       		mainframe.add(bRectangle);
       		bPlugin = new JButton("Add New Plugin");
       		bPlugin.setBounds(20, 25, 200, 30);
       		mainframe.add(bPlugin);
       		bPlugin.addActionListener(this);
    		mainframe.setLayout(new BorderLayout());
       	
                    mainframe.setResizable(false);            
                    mainframe.setLocationRelativeTo(null);
                    mainframe.setLocation(0, 0);
    		mainframe.setSize(970, 380);
    		mainframe.setVisible(true);
    		
    		DialgFalse();
                    
        }

@Override
public void actionPerformed(ActionEvent e) {
	
	
	if(e.getSource() == box){
	if(box.getSelectedIndex() != -1){
	ComboBoxSelectItem = box.getSelectedIndex();
		she.index = ComboBoxSelectItem;
		x=P1[she.index].x;
		y=P1[she.index].y;
		
	}
	
	}
	
	if(e.getSource() == bPlugin){
		Choose = new JFileChooser();
		Choose.showOpenDialog(null);
		File f = Choose.getSelectedFile();
                           System.out.println(f);
//		String s = f.getName();
//		System.out.println(s);
				
	}
	
	if(e.getSource() == bEdit){
		checkEdit=true;
		CheckPropertiesShape();
		checkEdit=false;
	}
	if(e.getSource() == bCopy){
		checkMove=false;
		
			if(she.index >= 0){

			
			
			
			myMap[she.counter].putAll(myMap[ComboBoxSelectItem]);
			//cannot use myMap [i]=myMap[i-1] because its like pointer, if i edited new shape ,old shape will be also edited 
			P1[she.counter] = P1[ComboBoxSelectItem];
			SetColor[she.counter]=SetColor[ComboBoxSelectItem];
			FillColor[she.counter]=FillColor[ComboBoxSelectItem];
			x= P1[ComboBoxSelectItem].x;
			y=P1[ComboBoxSelectItem].y;
			
			she.Copy();
			Add(String.valueOf("SELECT-SHAPE " + (she.index+1)));
			mainframe.repaint();
			
			}
		
	}
	
	if(e.getSource() == bRedo){
		
		checkMove=false;
		checkTriangleMoving=false;
		DialgFalse();
		she.redo();
		if(she.undocount == 0)
			bRedo.setEnabled(false);
		mainframe.repaint();
		Add(String.valueOf("SELECT-SHAPE " + (she.index+1)));
		
	}
		
		
	
	if(e.getSource() == bUndo){
		if(she.undocount > 19){
			bUndo.setEnabled(false);
			}
		
		if(she.counter > 0 && she.undocount <=19){
			she.undo();
			bRedo.setEnabled(true);
			this.RemoveShape();
			}
			

	}
	if(e.getSource() == bDelete){
		this.RemoveShape();
	
	}
	
	
	if(e.getSource() == bMove){
		
		checkMove =true;
		
		

	}
	if(e.getSource() == bColor){
		
		if(she.counter >0){
			pColor.setVisible(true);
        }
		
		else
		{
			
			JOptionPane.showMessageDialog(bColor,"Please Draw Your Shape First");
		}
		
		
	}  
	if(e.getSource() == bBorder){
		pColor.setVisible(false);
		
			
			bColor.setFocusable(false);
			Color initialColor = Color.BLACK;
			SetColor[she.index]= JColorChooser.showDialog(bColor, "Choose A Colour", initialColor) ;
			mainframe.repaint();
      
	}
	if(e.getSource() == bFill){
	
		pColor.setVisible(false);
			
			
			bColor.setFocusable(false);
			Color initialColor = Color.BLACK;
			FillColor[she.index]= JColorChooser.showDialog(bColor, "Choose A Colour", initialColor) ;
			mainframe.repaint();
     
	}
	
	
	
	if(e.getSource() == bRectangle){
		 she.addShape(new Rectangle());
		 CheckPropertiesShape();}
	
	
   if(e.getSource() == bSquare){
		 she.addShape(new Square());
		 CheckPropertiesShape();}
   
   
   if(e.getSource() == bLine){
	
	 	 	
  		she.addShape(new Line());
  		CheckPropertiesShape();
	
   }
   if(e.getSource() == bElipse){

		
		she.addShape(new Ellipse());
		CheckPropertiesShape();
   }
   if(e.getSource() == bTriangle){
	
		 she.addShape(new Triangle());
		 CheckPropertiesShape();
   }

	 if(e.getSource() == bCircle){	
		  
		she.addShape(new Circle());
		
		CheckPropertiesShape();
		
		 
    }
	
	
	 if(e.getSource() == okBut){
		 
		checkOkBut = true;
		
		if(checkEdit==false){
			 myMap[she.index] = (HashMap<String, Double>) new HashMap();
			 P1[she.index] = new Point();
			 
			
		}
		
		
		TextAssert=0;
		
		CheckPropertiesShape();
		
		
		
	       
	}
	else if(e.getSource() == CancelBut){
		
		p.setVisible(false);
		DialgFalse();
		
		
		if(checkEdit == false){

			checkMove=false;
			checkLineMoving=false;
		if(she.index != -1){
			she.removeShape(she.S[she.index]);
			mainframe.repaint();
			she.index--;
		}
		if(she.index == -1)
			she.index=0;
	
		}}
	
}

public void Add(String name)
{
	Model.addElement(name);
	box.setModel(Model);
	box.setSelectedIndex(she.index);
}

public void RemoveShape()
{
	if(she.counter > 0 ){
		if(she.counter !=2)
	box.setSelectedIndex(she.counter-2);
	box.removeItemAt(she.counter-1);
	}
	checkMove=false;
	checkLineMoving=false;
	she.index = she.counter-1;
	
	if(she.counter > 0){

		she.removeShape(she.S[she.index]);

		mainframe.repaint();
		
		
			x= P1[she.index].x;
			y=P1[she.index].y;
		
		
		
	}
	

	
}

public static Color getBorderColor(int x){
	
	return SetColor[x];
	
}
public static Color getFillColor(int x){
	
	return FillColor[x];
	
}

public static Point getPoint(int index){
	return P1[index];
}

public static Map getMap(int index){
	return myMap[index];
}


public void CircleProperties(){
	if(checkOkBut){
		
	if(rText.getText() == null || rText.getText().isEmpty() || xText.getText() == null || xText.getText().isEmpty()
			|| yText.getText() == null || yText.getText().isEmpty()){
			JOptionPane.showMessageDialog(okBut, "Please Fill the Field");
			
			TextAssert=1;
			
		}
	if(TextAssert == 0){
		if(checkEdit==false){
			 Add(String.valueOf("SELECT-SHAPE " + (she.index+1)));
			 bUndo.setEnabled(true);
				she.undocount=0;}
		x = (int)  (Integer.parseInt(xText.getText()));
		y = (int)  (Integer.parseInt(yText.getText()));
	checkTriangleMoving=false;
	number = String.valueOf(Double.parseDouble(rText.getText())*2);
	valueY=number;
	name="Raduis";
	myMap[she.index].put(name,(Double.parseDouble(number)));
	P1[she.index].setLocation(x,y);	
	value=number;
	mainframe.repaint();		
	p.setVisible(false);
	}}
	else{
		DialgFalse();
		checkLineMoving=false;
		checkMove=false;
		rLabel.setVisible(true);
		rText.setVisible(true);
		rLabel.setText("Enter Circle Radius(m):");
	 	p.setVisible(true); 
	 	rText.setText(null);
	    xText.setText(null);
	    yText.setText(null);
	}
}
public void RectangleProperties(){
	if(checkOkBut){
		if(wText.getText() == null || wText.getText().isEmpty() ||hText.getText() == null || hText.getText().isEmpty() 
				|| xText.getText() == null || xText.getText().isEmpty() || yText.getText() == null || yText.getText().isEmpty()){
			JOptionPane.showMessageDialog(okBut, "Please Fill the Field");
			
			TextAssert=1;
			
		}
	if(TextAssert == 0){
		if(checkEdit==false){
			 Add(String.valueOf("SELECT-SHAPE " + (she.index+1)));
			 bUndo.setEnabled(true);
				she.undocount=0;}
		x = (int)  (Integer.parseInt(xText.getText()));
		y = (int)  (Integer.parseInt(yText.getText()));
	checkTriangleMoving=false;
	number = wText.getText();
	numberY= hText.getText();
	valueY=numberY;
	name="RectX";
		nameY = "RectY";
	myMap[she.index].put(nameY,(Double.parseDouble(numberY)));
	myMap[she.index].put(name,(Double.parseDouble(number)));
	P1[she.index].setLocation(x,y);	
	value=number;
	mainframe.repaint();		
	p.setVisible(false);}}
	else{
		DialgFalse();
		hLabel.setVisible(true);
		wLabel.setVisible(true);
		hText.setVisible(true);
		wText.setVisible(true);
		wLabel.setText("Enter Width:");
		hLabel.setText("Enter Height:");
		p.setVisible(true); 
		wText.setText(null);
	    hText.setText(null);
	    xText.setText(null);
	    yText.setText(null);
	}
}
public void SquareProperties(){
	if(checkOkBut){
		if(rText.getText() == null || rText.getText().isEmpty() || xText.getText() == null || xText.getText().isEmpty()
				|| yText.getText() == null || yText.getText().isEmpty()){
			JOptionPane.showMessageDialog(okBut, "Please Fill the Field");
			
			TextAssert=1;
			
		}
	if(TextAssert == 0){
		if(checkEdit==false){
			 Add(String.valueOf("SELECT-SHAPE " + (she.index+1)));
			 bUndo.setEnabled(true);
				she.undocount=0;}
		x = (int)  (Integer.parseInt(xText.getText()));
		y = (int)  (Integer.parseInt(yText.getText()));
	number = rText.getText();
	valueY=number;
	name="side";
	myMap[she.index].put(name,(Double.parseDouble(number)));
	P1[she.index].setLocation(x,y);	
	value=number;
	mainframe.repaint();		
	p.setVisible(false);}}
	else{
		DialgFalse();
		 rLabel.setVisible(true);
		 rText.setVisible(true);
		 rLabel.setText("Enter Square Length(m):");
		 p.setVisible(true); 
		 rText.setText(null);
		    xText.setText(null);
		    yText.setText(null);
		
	}
}
public void TriangleProperties(){
	if(checkOkBut){
		
		if(xText.getText() == null || xText.getText().isEmpty() || yText.getText() == null || yText.getText().isEmpty() 
				|| TriText1.getText() == null || TriText1.getText().isEmpty() || TriText2.getText() == null || TriText2.getText().isEmpty() 
				|| TriText2.getText() == null || TriText2.getText().isEmpty() || TriText3.getText() == null || TriText3.getText().isEmpty() ){
			JOptionPane.showMessageDialog(okBut, "Please Fill the Field");
			
			TextAssert=1;
			
		}
	if(TextAssert == 0){
		if(checkEdit==false){
			 Add(String.valueOf("SELECT-SHAPE " + (she.index+1)));
			 bUndo.setEnabled(true);
				she.undocount=0;}
		x = (int)  (Integer.parseInt(xText.getText()));
		y = (int)  (Integer.parseInt(yText.getText()));
	checkTriangleMoving=false;
	TriDegree = TriText3.getText();
	myMap[she.index].put("LineY1",(double) y);
	myMap[she.index].put("LineX1", x+(Double.parseDouble(TriText1.getText())));
	myMap[she.index].put("LineX2",x+(Double.parseDouble(TriDegree)/2)+(Double.parseDouble(TriText2.getText())) );
	myMap[she.index].put("LineY2",y+(Double.parseDouble(TriDegree)/10)-(Double.parseDouble(TriText2.getText())) );
	TriX1 = (int) (x+(Double.parseDouble(TriText1.getText())));
	TriY1 = (int) y;
	TriX2 = (int)  (x+(Double.parseDouble(TriDegree)/2)+(Double.parseDouble(TriText2.getText())));
	TriY2 = (int)  (y+(Double.parseDouble(TriDegree)/10)-(Double.parseDouble(TriText2.getText())));
	
	checkTriangleMoving=true;

	P1[she.index].setLocation(x,y);	
	value=number;
	mainframe.repaint();		
	p.setVisible(false);}}
	else{
		DialgFalse();
		 TriLabel1.setVisible(true);
		 TriLabel2.setVisible(true);
		 TriLabel3.setVisible(true);
		 TriText1.setVisible(true);
		 TriText2.setVisible(true);
		 TriText3.setVisible(true);
		 p.setVisible(true); 
		 xText.setText(null);
		 yText.setText(null);
		 TriText1.setText(null);
		 TriText2.setText(null);
		 TriText3.setText(null);
		 
	}
	
}
public void LineProperties(){
	if(checkOkBut){
		
		if(rText.getText() == null || rText.getText().isEmpty() || xText.getText() == null || xText.getText().isEmpty()
				|| yText.getText() == null || yText.getText().isEmpty() || (!VT.isSelected() && !HZ.isSelected())){
			JOptionPane.showMessageDialog(okBut, "Please Fill the Field");
			
			TextAssert=1;
			
		}
	if(TextAssert == 0){
		if(checkEdit==false){
			 Add(String.valueOf("SELECT-SHAPE " + (she.index+1)));
			 bUndo.setEnabled(true);
				she.undocount=0;}
		x = (int)  (Integer.parseInt(xText.getText()));
		y = (int)  (Integer.parseInt(yText.getText()));
	checkTriangleMoving=false;
	number = rText.getText();
	
	valueY=number;
	name="LineLength";
	nameY = "LineDegree";

	
	if(VT.isSelected()){
		myMap[she.index].put(name, (double) x);
		myMap[she.index].put(nameY,(y+(Double.parseDouble(number))));
		LineX=x;
		LineY=(int) (y+(Double.parseDouble(number)));
		FlagLine=0;
	}
	if(HZ.isSelected()){
		myMap[she.index].put(name,(x+(Double.parseDouble(number))));
		myMap[she.index].put(nameY,(double) y);
		LineY= y;
		LineX=(int) (x+(Double.parseDouble(number)));
		FlagLine=1;
		
	}
	
	checkLineMoving=true;
	P1[she.index].setLocation(x,y);	
	value=number;
	
	mainframe.repaint();		
	p.setVisible(false);}}
	else{
		DialgFalse();
		rLabel.setVisible(true);
  		rText.setVisible(true);
  		rLabel.setText("Enter Line Length(m):");
  		HZ.setVisible(true);
  		VT.setVisible(true);
  		p.setVisible(true); 
  		rText.setText(null);
  	    xText.setText(null);
  	    yText.setText(null);
	}
	
}
public void EllipseProperties(){
	if(checkOkBut){
		
		if(wText.getText() == null || wText.getText().isEmpty() ||hText.getText() == null || hText.getText().isEmpty() 
				|| xText.getText() == null || xText.getText().isEmpty() || yText.getText() == null || yText.getText().isEmpty()){
			JOptionPane.showMessageDialog(okBut, "Please Fill the Field");
			
			TextAssert=1;
			
		}
	if(TextAssert == 0){
		if(checkEdit==false){
		 Add(String.valueOf("SELECT-SHAPE " + (she.index+1)));
		 bUndo.setEnabled(true);
			she.undocount=0;}
		x = (int)  (Integer.parseInt(xText.getText()));
		y = (int)  (Integer.parseInt(yText.getText()));
	checkTriangleMoving=false;
	number = wText.getText();
	numberY= hText.getText();
	valueY=numberY;
	name="EllipseX";
		nameY = "EllipseY";
	myMap[she.index].put(nameY,(Double.parseDouble(numberY)));
	myMap[she.index].put(name,(Double.parseDouble(number)));
	P1[she.index].setLocation(x,y);	
	value=number;
	mainframe.repaint();		
	p.setVisible(false);}}
	else{
		DialgFalse();
		hLabel.setVisible(true);
		wLabel.setVisible(true);
		hText.setVisible(true);
		wText.setVisible(true);
		wLabel.setText("Enter Width:");
		hLabel.setText("Enter Height:");
		p.setVisible(true); 
		wText.setText(null);
	    hText.setText(null);
	    xText.setText(null);
	    yText.setText(null);
	}
	
}


public void CheckPropertiesShape(){
	if(she.index>=0){
		
		
	if(she.S[she.index] instanceof Circle){
	
			CircleProperties();
			
	}
	else if(she.S[she.index] instanceof Rectangle){
	
		RectangleProperties();
	
	}
	else if(she.S[she.index] instanceof Triangle){
	
		TriangleProperties();
		
	}
	else if(she.S[she.index] instanceof Line){
	
		LineProperties();
		
	}
	else if(she.S[she.index] instanceof Ellipse){
		
		EllipseProperties();
	
	}
	else if(she.S[she.index] instanceof Square){
	
		SquareProperties();
	
	}
	
	checkOkBut = false;
	number = null;
   
    

	
	}
	
	
}

public void Focus(){
	bCircle.setFocusable(false);
	bLine.setFocusable(false);
	bElipse.setFocusable(false);
	bTriangle.setFocusable(false);
	bRectangle.setFocusable(false);
	bSquare.setFocusable(false);
	bEdit.setFocusable(false);
	bMove.setFocusable(false);
	bCopy.setFocusable(false);
	bColor.setFocusable(false);
	bUndo.setFocusable(false);
	bRedo.setFocusable(false);
	bDelete.setFocusable(false);
	box.setFocusable(false);
	bBorder.setFocusable(false);
	bFill.setFocusable(false);
}


public void DialgFalse(){
    wLabel.setVisible(false);
    hLabel.setVisible(false);
    rLabel.setVisible(false);
    wLabel.setVisible(false);
    wText.setVisible(false);
    hText.setVisible(false);
    rText.setVisible(false);
    TriLabel1.setVisible(false);
    TriLabel2.setVisible(false);
    TriLabel3.setVisible(false);
    TriText1.setVisible(false);
    TriText2.setVisible(false);
    TriText3.setVisible(false);
    HZ.setVisible(false);
    VT.setVisible(false);
  
}

@Override
public void keyPressed(KeyEvent e) {
int code = e.getKeyCode();
	if(checkMove){
	if (code == KeyEvent.VK_DOWN){
		vely = 1;
		velx = 0;
	if(checkTriangleMoving==false){
		if(checkLineMoving == true){
			if(FlagLine == 0){
				if(y+(Double.parseDouble(valueY))== 229)
					vely=0;}
			else{
				if(y == 229)
					vely=0;
			}
		}	
		else{
		if((y+(Double.parseDouble(valueY))) == 229.0)
			vely=0;}
		
		
		
	}}
	if (code == KeyEvent.VK_UP){
		vely = -1;
		velx = 0;
		if(y==0)
			vely=0;
	}
	if (code == KeyEvent.VK_LEFT){
		vely = 0;
		velx = -1;
		if(x==0)
			velx=0;
	}
	if (code == KeyEvent.VK_RIGHT){
		vely = 0;
		velx = 1;
		if(checkTriangleMoving == false){
		if(checkLineMoving == true){
			if(FlagLine == 1){
				if(x+(Double.parseDouble(value))== 659)
					velx=0;}
			else{
				if(x == 659)
					velx=0;
			}
		}
		else{
		if((x+(Double.parseDouble(value))) == 659.0)
			velx=0;}
		
		
	}}
	 x += velx;
     y += vely;
     
     P1[she.index] = new Point();
     P1[she.index].setLocation(x,y);
     if(checkLineMoving==true)
     {	 LineX +=velx;
     		LineY +=vely;
    	 myMap[she.index].put(nameY,(double) LineY);
 		myMap[she.index].put(name,(double) LineX);
     }
     if(checkTriangleMoving == true){
    	 TriX1 += velx;
    	 TriX2 += velx;
    	 TriY1 += vely;
    	 TriY2 += vely;
    		myMap[she.index].put("LineY1",(double) TriY1);
			myMap[she.index].put("LineX1",(double) TriX1);
			myMap[she.index].put("LineX2",(double) TriX2);
			myMap[she.index].put("LineY2",(double) TriY2);
     }
     mainframe.repaint();
  
	}
	
}
@Override
public void keyReleased(KeyEvent e) {
	velx=0;
	vely=0;
	
}

@Override
public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
}


class MyComboBoxRenderer extends JLabel implements ListCellRenderer
{
	
private String _title;

public MyComboBoxRenderer(String title)
{
    _title = title;
   
}

@Override
public Component getListCellRendererComponent(JList list, Object value,
        int index, boolean isSelected, boolean hasFocus)
    {
	
    if (index == -1 && value == null) setText(_title);
    else setText(value.toString());
    return this;
}
}	
      
    
