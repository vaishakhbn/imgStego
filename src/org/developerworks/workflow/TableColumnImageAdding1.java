package org.developerworks.workflow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class TableColumnImageAdding1 {

	public static String src;
	public static String dest;
	
	

  public void getFile(String src1, String dest1) {
		// TODO Auto-generated constructor stub
	  src=src1; dest=dest1; System.out.println("Hi "+src +"hi 2"+dest);
	
  }
  public static void main()
  {

    final Display display = new Display();

    
    Image before = new Image(display,"C:/Users/user/Pictures/1.png");
    Image after = new Image(display,"C:/Users/user/Pictures/NewFile.bmp");
    final Image scaled050 = new Image(display, before.getImageData().scaledTo(512,512));
    final Image scaled200 = new Image(display,after.getImageData().scaledTo(512,512));
    Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());
    shell.setMinimumSize(1100, 600);
    shell.setText("Comaprision of Morphed and Original Images");
    
    
    final Table table = new Table(shell, SWT.BORDER);
    TableColumn column1 = new TableColumn(table, SWT.NONE);
    TableColumn column2 = new TableColumn(table, SWT.NONE);
    TableColumn column3 = new TableColumn(table, SWT.NONE);
    
    TableItem item1 = new TableItem(table, SWT.NONE);
    item1.setText(new String[] { "Before", "After",""});
    item1.setImage(0, scaled050);
    item1.setImage(1, scaled200);

    column1.pack();
    column2.pack();
    column3.pack();

    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch())
        display.sleep();
    }
    before.dispose();
    after.dispose();
    display.dispose();
  }



public TableColumnImageAdding1(Composite parent,int style) {
			super();
}

public void pack() {
	// TODO Auto-generated method stub
	
}
public Point getSize() {
	// TODO Auto-generated method stub
	return null;
}

}