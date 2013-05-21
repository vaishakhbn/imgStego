package org.developerworks.workflow;

import org.eclipse.swt.SWT;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CBanner;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

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
public class HelpPage extends org.eclipse.swt.widgets.Composite {

	private Menu menu1;
	private MenuItem aboutMenuItem;
	private MenuItem contentsMenuItem;
	private Menu helpMenu;
	private MenuItem helpMenuItem;
	private Label label2;
	private Label label1;
	private Text text3;
	private Text text2;
	private Text text1;
	private MenuItem exitMenuItem;
	private MenuItem closeFileMenuItem;
	private MenuItem saveFileMenuItem;
	private MenuItem newFileMenuItem;
	private MenuItem openFileMenuItem;
	private Menu fileMenu;
	private MenuItem fileMenuItem;

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	public HelpPage(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}
	
	/**
	* Initializes the GUI.
	*/
	private void initGUI() {
		try {
			this.setSize(634, 336);
			this.setBackground(SWTResourceManager.getColor(128, 0, 128));
			FormLayout thisLayout = new FormLayout();
			this.setLayout(thisLayout);
			{
				text3 = new Text(this, SWT.NONE);
				FormData text3LData = new FormData();
				text3LData.left =  new FormAttachment(0, 1000, 43);
				text3LData.top =  new FormAttachment(0, 1000, 273);
				text3LData.width = 332;
				text3LData.height = 15;
				text3.setLayoutData(text3LData);
				text3.setText("                                vaishkh.bargurreddy@gmail.com");
			}
			{
				text2 = new Text(this, SWT.NONE);
				FormData text2LData = new FormData();
				text2LData.left =  new FormAttachment(0, 1000, 43);
				text2LData.top =  new FormAttachment(0, 1000, 243);
				text2LData.width = 332;
				text2LData.height = 19;
				text2.setLayoutData(text2LData);
				text2.setText(" Contact at :\r\n          vinaykumarkolli047@gmail.com\r\n\r\n\r\n");
			}
			{
				label2 = new Label(this, SWT.NONE);
				FormData label2LData = new FormData();
				label2LData.left =  new FormAttachment(0, 1000, 446);
				label2LData.top =  new FormAttachment(0, 1000, 176);
				label2LData.width = 108;
				label2LData.height = 94;
				label2.setLayoutData(label2LData);
				label2.setText("label2");
				Display d= Display.getDefault();
				Image i=new Image(d,"F:/Vinaykumar M Kolli-BE/test/Vaishakh.JPG");
				final Image scaled050 = new Image(d, i.getImageData().scaledTo(96,96));
				label2.setImage(scaled050);
				
			}
			{
				label1 = new Label(this, SWT.NONE);
				FormData label1LData = new FormData();
				label1LData.left =  new FormAttachment(0, 1000, 443);
				label1LData.top =  new FormAttachment(0, 1000, 51);
				label1LData.width = 113;
				label1LData.height = 94;
				label1.setLayoutData(label1LData);
				label1.setText("label1");
				Display d= Display.getDefault();
				Image i=new Image(d,"F:/Vinaykumar M Kolli-BE/test/VinayKolli.JPG");
				final Image scaled050 = new Image(d, i.getImageData().scaledTo(96,96));
				label1.setImage(scaled050);
				
			}
			{
				text1 = new Text(this, SWT.MULTI | SWT.WRAP);
				FormData text1LData = new FormData();
				text1LData.left =  new FormAttachment(0, 1000, 12);
				text1LData.top =  new FormAttachment(0, 1000, 12);
				text1LData.width = 602;
				text1LData.height = 317;
				text1.setLayoutData(text1LData);
				text1.setText("         Designed & Developed By\r\n    \r\n         Vinaykumar M Kolli       1RV09CS119\r\n         Vaishakh B N                   1RV09CS114\r\n\r\n \n\n\n\n\n       ");
				text1.setFont(SWTResourceManager.getFont("Lucida Handwriting", 12, 0, false, false));
				text1.setBackgroundImage(SWTResourceManager.getImage("org/developerworks/workflow/1.png"));
				text1.setEditable(false);
			}
			{
				/*menu1 = new Menu(getShell(), SWT.BAR);
				getShell().setMenuBar(menu1);
				{
					fileMenuItem = new MenuItem(menu1, SWT.CASCADE);
					fileMenuItem.setText("File");
					{
						fileMenu = new Menu(fileMenuItem);
						{
							openFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
							openFileMenuItem.setText("Open");
						}
						{
							newFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
							newFileMenuItem.setText("New");
						}
						{
							saveFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
							saveFileMenuItem.setText("Save");
						}
						{
							closeFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
							closeFileMenuItem.setText("Close");
						}
						{
							exitMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
							exitMenuItem.setText("Exit");
						}
						fileMenuItem.setMenu(fileMenu);
					}
				}
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
				}*/
			}
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void display(){
		
	}
	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		shell.setText("Help Page -About the developers");
		HelpPage inst = new HelpPage(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if(size.x == 0 && size.y == 0) {
			inst.pack();
			shell.pack();
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

}
