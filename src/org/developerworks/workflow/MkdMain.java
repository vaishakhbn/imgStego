package org.developerworks.workflow;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Window;
import java.awt.peer.FramePeer;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;



import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
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
public class MkdMain extends org.eclipse.swt.widgets.Composite {

	private Menu menu1;
	public static String xa;
	public static String q;
	private Label label1;
	private Label PUBKey;
	private Text PKey;
	private Label PKLabel;
	private Text AlphaValue;
	private Text QValue;
	private Label Alpha;
	private Label Enter;
	private Button GenPubPara;
	private Text PubKey;
	private Label Q;
	private Group group1;
	private Button button1;
	private Label Label2;
	private MenuItem aboutMenuItem;
	private MenuItem contentsMenuItem;
	private Menu helpMenu;
	private MenuItem helpMenuItem;
	private Label Label1;
	private Combo Option;
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

	public MkdMain(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}
	
	/**
	* Initializes the GUI.
	*/
	private void initGUI() {
		try {
			this.setSize(731, 385);
			this.setBackground(SWTResourceManager.getColor(219, 219, 219));
			FormLayout thisLayout = new FormLayout();
			this.setLayout(thisLayout);
			this.setOrientation(SWT.HORIZONTAL);
			this.setToolTipText("MKD- Image SteganoGraphy");
			{
				Enter = new Label(this, SWT.NONE);
				FormData EnterLData = new FormData();
				EnterLData.left =  new FormAttachment(0, 1000, 266);
				EnterLData.top =  new FormAttachment(0, 1000, 140);
				EnterLData.width = 43;
				EnterLData.height = 15;
				Enter.setLayoutData(EnterLData);
				Enter.setText("Enter");
				Enter.setVisible(false);
			}
			{
				GenPubPara = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData GenPubParaLData = new FormData();
				GenPubParaLData.left =  new FormAttachment(0, 1000, 174);
				GenPubParaLData.top =  new FormAttachment(0, 1000, 142);
				GenPubParaLData.width = 132;
				GenPubParaLData.height = 25;
				GenPubPara.setLayoutData(GenPubParaLData);
				GenPubPara.setText("Generate Public Values");
				GenPubPara.setVisible(false);
				GenPubPara.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e){
						Random prng = new SecureRandom();
						BigInteger q=BigInteger.probablePrime(32,prng);
						 System.out.println(""+q);
						 QValue.setText(q.toString());
						 //code for generating alpha
						 BigInteger alpha;
						 primitiveRoot pr = new primitiveRoot();
						
						 for ( alpha = BigInteger.valueOf(2);
						            alpha.compareTo(q) > 0;
								 alpha = alpha.add(BigInteger.ONE)) {
						 if( pr.isPrimitive(q, alpha))
							 break;
						 }
						System.out.println(""+alpha);
						AlphaValue.setText(alpha.toString());
					}});
			}
			{
				FormData PubKeyLData = new FormData();
				PubKeyLData.left =  new FormAttachment(0, 1000, 326);
				PubKeyLData.top =  new FormAttachment(0, 1000, 188);
				PubKeyLData.width = 121;
				PubKeyLData.height = 15;
				PubKey = new Text(this, SWT.NONE);
				PubKey.setLayoutData(PubKeyLData);
				PubKey.setVisible(false);
			}
			{
				PUBKey = new Label(this, SWT.NONE);
				FormData PUBKeyLData = new FormData();
				PUBKeyLData.left =  new FormAttachment(0, 1000, 217);
				PUBKeyLData.top =  new FormAttachment(0, 1000, 187);
				PUBKeyLData.width = 97;
				PUBKeyLData.height = 15;
				PUBKey.setLayoutData(PUBKeyLData);
				PUBKey.setText("Public Key is");
				PUBKey.setVisible(false);
			}
			{
				FormData PKeyLData = new FormData();
				PKeyLData.left =  new FormAttachment(0, 1000, 326);
				PKeyLData.top =  new FormAttachment(0, 1000, 166);
				PKeyLData.width = 121;
				PKeyLData.height = 15;
				PKey = new Text(this, SWT.NONE);
				PKey.setLayoutData(PKeyLData);
				PKey.setVisible(false);
				
				PKey.addModifyListener(new ModifyListener() {
					
					@Override
					public void modifyText(ModifyEvent arg0) {
						// TODO Auto-generated method stub
						BigInteger alpha=new BigInteger(AlphaValue.getText());
						BigInteger xa=new BigInteger(PKey.getText());
						BigInteger q=new BigInteger(QValue.getText());
						BigInteger ya = alpha.modPow(xa, q);
						System.out.println("Y a is "+ya);
						PubKey.setText(ya.toString());
						PubKey.setEditable(false);	
					}
				});
			
				/*Adapter() {
				public void widgetSelected(SelectionEvent e){
					BigInteger alpha=new BigInteger(AlphaValue.getText());
					BigInteger xa=new BigInteger(PKey.getText());
					BigInteger q=new BigInteger(QValue.getText());
					BigInteger ya = alpha.modPow(xa, q);
					System.out.println("Y a is "+ya);
					PubKey.setText(ya.toString());
					PubKey.setEditable(false);
				}});*/
			}
			{
				PKLabel = new Label(this, SWT.NONE);
				FormData PKLabelLData = new FormData();
				PKLabelLData.left =  new FormAttachment(0, 1000, 217);
				PKLabelLData.top =  new FormAttachment(0, 1000, 166);
				PKLabelLData.width = 97;
				PKLabelLData.height = 15;
				PKLabel.setLayoutData(PKLabelLData);
				PKLabel.setText("Enter Private Key");
				PKLabel.setVisible(false);
			}
			{
				FormData AlphaValueLData = new FormData();
				AlphaValueLData.left =  new FormAttachment(0, 1000, 504);
				AlphaValueLData.top =  new FormAttachment(0, 1000, 138);
				AlphaValueLData.width = 64;
				AlphaValueLData.height = 15;
				AlphaValue = new Text(this, SWT.NONE);
				AlphaValue.setLayoutData(AlphaValueLData);
				AlphaValue.setVisible(false);
			}
			{
				FormData QValueLData = new FormData();
				QValueLData.left =  new FormAttachment(0, 1000, 340);
				QValueLData.top =  new FormAttachment(0, 1000, 137);
				QValueLData.width = 107;
				QValueLData.height = 15;
				QValue = new Text(this, SWT.NONE);
				QValue.setLayoutData(QValueLData);
				QValue.setVisible(false);
			}
			{
				Alpha = new Label(this, SWT.NONE);
				FormData AlphaLData = new FormData();
				AlphaLData.left =  new FormAttachment(0, 1000, 465);
				AlphaLData.top =  new FormAttachment(0, 1000, 138);
				AlphaLData.width = 40;
				AlphaLData.height = 15;
				Alpha.setLayoutData(AlphaLData);
				Alpha.setText("Alpha");
				Alpha.setVisible(false);
			}
			{
				Q = new Label(this, SWT.NONE);
				FormData QLData = new FormData();
				QLData.left =  new FormAttachment(0, 1000, 328);
				QLData.top =  new FormAttachment(0, 1000, 138);
				QLData.width = 12;
				QLData.height = 15;
				Q.setLayoutData(QLData);
				Q.setText("Q");
				Q.setVisible(false);
			}

			{
				group1 = new Group(this, SWT.NONE);
				GridLayout group1Layout = new GridLayout();
				group1Layout.makeColumnsEqualWidth = true;
				group1.setLayout(group1Layout);
				FormData group1LData = new FormData();
				group1LData.left =  new FormAttachment(0, 1000, 149);
				group1LData.top =  new FormAttachment(0, 1000, 127);
				group1LData.width = 429;
				group1LData.height = 64;
				group1.setLayoutData(group1LData);
				group1.setText("Diffie-Hellman Key Exchange");
				group1.setVisible(false);
				
			}
			{
				button1 = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData button1LData = new FormData();
				button1LData.width = 100;
				button1LData.height = 32;
				button1LData.right =  new FormAttachment(568, 1000, 0);
				button1LData.bottom =  new FormAttachment(650, 1000, 0);
				button1LData.top =  new FormAttachment(567, 1000, 0);
				button1LData.left =  new FormAttachment(431, 1000, 0);
				button1.setLayoutData(button1LData);
				button1.setText("Proceed");
				//button1.setBackground(SWTResourceManager.getColor(128, 0, 255));
				button1.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e){
						String s=new String(Option.getText());
						String s1=new String("Encrypt the Data into an Image");
						String s2=new String("Decrypt the Message from an Image");
						if(s.equals(s1))
						{
							xa=PKey.getText();
							q=QValue.getText();
						Display display = Display.getDefault();
						Shell shell = new Shell(display);
						EncryptWindow inst = new EncryptWindow(shell, SWT.NULL);
						Point size = inst.getSize();
						//shell.setLayout(new FillLayout());
						shell.layout();
						new Label(shell, SWT.NONE).setText("Operation:");
					    final Label returnVal = new Label(shell, SWT.NONE);
					    //returnVal.setLayoutData(new FillLayout(SWT.NULL));
						returnVal.setText("");

				        returnVal.setText(Option.getText());
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
						else if(s.equals(s2))
						{
							xa=PKey.getText();
							q=QValue.getText();
							Display display = Display.getDefault();
							Shell shell = new Shell(display);
							DecryptWindow inst = new DecryptWindow(shell, SWT.NULL);
							Point size = inst.getSize();
							//shell.setLayout(new FillLayout());
							shell.layout();
							new Label(shell, SWT.NONE).setText("Operation:");
						    final Label returnVal = new Label(shell, SWT.NONE);
						    //returnVal.setLayoutData(new FillLayout(SWT.NULL));
							returnVal.setText("");

					        returnVal.setText(Option.getText());
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
				});
			}
			
			{
				Label2 = new Label(this, SWT.NONE);
				FormData Label2LData = new FormData();
				Label2LData.width = 443;
				Label2LData.height = 49;
				Label2LData.bottom =  new FormAttachment(144, 1000, 0);
				Label2LData.right =  new FormAttachment(811, 1000, 0);
				Label2LData.top =  new FormAttachment(16, 1000, 0);
				Label2LData.left =  new FormAttachment(205, 1000, 0);
				Label2.setLayoutData(Label2LData);
				Label2.setText("V's Image Steganography ");
				Label2.setFont(SWTResourceManager.getFont("Lucida Handwriting", 22, 1, false, false));
				Label2.setAlignment(SWT.CENTER);
				Label2.setBackground(SWTResourceManager.getColor(219, 219, 219));
			}
			{
				Label1 = new Label(this, SWT.NONE);
				FormData Label1LData = new FormData();
				Label1LData.width = 234;
				Label1LData.height = 22;
				Label1LData.left =  new FormAttachment(204, 1000, 0);
				Label1LData.right =  new FormAttachment(524, 1000, 0);
				Label1LData.bottom =  new FormAttachment(232, 1000, 0);
				Label1LData.top =  new FormAttachment(175, 1000, 0);
				Label1.setLayoutData(Label1LData);
				Label1.setText("What you want to do...?");
				Label1.setBackground(SWTResourceManager.getColor(219, 219, 219));
			}
			{
				Option = new Combo(this, SWT.NONE);
				FormLayout OptionLayout = new FormLayout();
				Option.setLayout(OptionLayout);
				FormData OptionLData = new FormData();
				OptionLData.left =  new FormAttachment(204, 1000, 0);
				OptionLData.top =  new FormAttachment(232, 1000, 0);
				OptionLData.width = 408;
				OptionLData.height = 19;
				OptionLData.right =  new FormAttachment(799, 1000, 0);
				OptionLData.bottom =  new FormAttachment(287, 1000, 0);
				Option.setLayoutData(OptionLData);
				Option.setText("Select Option");
				Option.setBackground(SWTResourceManager.getColor(192, 192, 192));
				Option.setToolTipText("\r\n");
				Option.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e){
						if(Option.getText().equals("Encrypt the Data into an Image")){
							xa=PKey.getText();
							q=QValue.getText();
						group1.setVisible(true);
						PubKey.setVisible(true);
						PUBKey.setVisible(true);
						PKey.setVisible(true);
						PKLabel.setVisible(true);
						AlphaValue.setVisible(true);
						QValue.setVisible(true);
						Alpha.setVisible(true);
						Q.setVisible(true);
						GenPubPara.setVisible(true);
						Enter.setVisible(false);
						}
						if(Option.getText().equals("Decrypt the Message from an Image")){
							/*PubKey.setText("");
							PKey.setText("null");
							QValue.setText("null");
							AlphaValue.setText("0");*/
							group1.setVisible(true);
							PubKey.setVisible(true);
							PUBKey.setVisible(true);
							PKey.setVisible(true);
							PKLabel.setVisible(true);
							AlphaValue.setVisible(true);
							QValue.setVisible(true);
							Alpha.setVisible(true);
							Q.setVisible(true);
							Enter.setVisible(true);
							GenPubPara.setVisible(false);
							}
							
					}//Encrypt e=new Encrypt();
				});
				Option.add("Encrypt the Data into an Image");
				Option.add("Decrypt the Message from an Image");
			}
			{
				label1 = new Label(this, SWT.NONE);
				FormData label1LData = new FormData();
				label1LData.left =  new FormAttachment(0, 1000, 149);
				label1LData.top =  new FormAttachment(0, 1000, 285);
				label1LData.width = 429;
				label1LData.height = 35;
				label1.setLayoutData(label1LData);
				label1.setText("                             Copyright 2012., All Rights Reserved.,\r\n                              Vinaykumar M Kolli & Vaishakh B N  ");
				label1.setBackground(SWTResourceManager.getColor(192, 192, 192));
			}
			{
				menu1 = new Menu(getShell(), SWT.BAR);
				getShell().setMenuBar(menu1);
				/*{
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
				}*/
				{
					helpMenuItem = new MenuItem(menu1, SWT.CASCADE);
					helpMenuItem.setText("Help");
					{
						helpMenu = new Menu(helpMenuItem);
						{
							contentsMenuItem = new MenuItem(helpMenu, SWT.CASCADE);
							contentsMenuItem.setText("Help Contents");
							contentsMenuItem.addSelectionListener(new SelectionAdapter() { 
							});
						}
						{
							aboutMenuItem = new MenuItem(helpMenu, SWT.CASCADE);
							aboutMenuItem.setText("About");
							aboutMenuItem.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent e){
									Display display = Display.getDefault();
									Shell shell = new Shell(display);
									HelpPage help=new HelpPage(shell,SWT.NULL);
									Point size = help.getSize();
									//shell.setLayout(new FillLayout());
									shell.layout();
									//new Label(shell, SWT.NONE).setText("Operation:");
								    //final Label returnVal = new Label(shell, SWT.NONE);
								    //returnVal.setLayoutData(new FillLayout(SWT.NULL));
									//returnVal.setText("");

							        //returnVal.setText(Option.getText());
									if(size.x == 0 && size.y == 0) {
										help.pack();
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
							});
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
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		shell.setText("V's Image SteganoGraphy Application");
		MkdMain inst = new MkdMain(shell, SWT.NULL);
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
	
	public Label getLabel2() {
		return Label2;
	}

}
