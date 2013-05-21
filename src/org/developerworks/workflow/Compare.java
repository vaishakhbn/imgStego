package org.developerworks.workflow;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.cloudgarden.resource.SWTResourceManager;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class Compare extends org.eclipse.swt.widgets.Composite {

	private Menu menu1;
	public static String SRC;
	public static String DEST;
	private MenuItem aboutMenuItem;
	private MenuItem contentsMenuItem;
	private Menu helpMenu;
	private MenuItem helpMenuItem;
	private Label After;
	private Label label2;
	private Label label1;

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	public Compare(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}
	
	/**
	* Initializes the GUI.
	*/
	private void initGUI() {
		try {
			this.setSize(816, 434);
			this.setBackground(SWTResourceManager.getColor(192, 192, 192));
			FormLayout thisLayout = new FormLayout();
			this.setLayout(thisLayout);
			{
				After = new Label(this, SWT.NONE);
				FormData AfterLData = new FormData();
				AfterLData.left =  new FormAttachment(0, 1000, 409);
				AfterLData.top =  new FormAttachment(0, 1000, 203);
				AfterLData.width = 43;
				AfterLData.height = 15;
				After.setLayoutData(AfterLData);
				After.setText("after");
			}
			{
				label2 = new Label(this, SWT.NONE);
				FormData label2LData = new FormData();
				label2LData.left =  new FormAttachment(0, 1000, 428);
				label2LData.top =  new FormAttachment(0, 1000, 7);
				label2LData.width = 388;
				label2LData.height = 415;
				label2.setLayoutData(label2LData);
				label2.setText("label2");
				Display display = Display.getDefault();
				Shell shell = new Shell(display);
				 Image before=new Image(display,DEST);
				 final Image scaled050 = new Image(display, before.getImageData().scaledTo(512,512));
			        label1.setImage(scaled050);
			}
			{
				label1 = new Label(this, SWT.NONE);
				FormData label1LData = new FormData();
				label1LData.left =  new FormAttachment(0, 1000, 6);
				label1LData.top =  new FormAttachment(0, 1000, 7);
				label1LData.width = 410;
				label1LData.height = 415;
				label1.setLayoutData(label1LData);
				label1.setText("label1");
				Display display = Display.getDefault();
				Shell shell = new Shell(display);
				 Image before=new Image(display,SRC);
				 final Image scaled050 = new Image(display, before.getImageData().scaledTo(512,512));
			        label1.setImage(scaled050);
			}
			{
				menu1 = new Menu(getShell(), SWT.BAR);
				getShell().setMenuBar(menu1);
				{
					helpMenuItem = new MenuItem(menu1, SWT.CASCADE);
					helpMenuItem.setText("Help");
					{
						helpMenu = new Menu(helpMenuItem);
						{
							contentsMenuItem = new MenuItem(helpMenu, SWT.CASCADE);
							contentsMenuItem.setText("Contents");
						}
						{
							aboutMenuItem = new MenuItem(helpMenu, SWT.CASCADE);
							aboutMenuItem.setText("About");
						}
						helpMenuItem.setMenu(helpMenu);
					}
				}
			}
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void show() {
		Display display = Display.getCurrent();
		Shell shell = new Shell(display);
		 Image before = new Image(display,SRC);
		    Image after = new Image(display,DEST);
		    final Image scaled050 = new Image(display, before.getImageData().scaledTo(512,512));
		    final Image scaled200 = new Image(display,after.getImageData().scaledTo(512,512));
		//Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		/*if(size.x == 0 && size.y == 0) {
			shell.pack();
			shell.setSize(130, 100);
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			shell.setSize(shellBounds.width, shellBounds.height);
		}*/
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

	public static void giveNames(String text, String text2) {
		// TODO Auto-generated method stub
		SRC=text;
		DEST=text2;
		System.out.println("The src is "+SRC);
		System.out.println("The dst is "+DEST);
	}

}
