package org.developerworks.workflow;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.math.BigInteger;
import java.nio.ByteBuffer;

import javax.swing.JOptionPane;

import org.developerworks.workflow.AES.Util;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ProgressBar;
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
public class DecryptWindow extends org.eclipse.swt.widgets.Composite {

	private Menu menu1;
	public byte[] DeText;
	private String realText;
	private Button DataFile;
	private Button HideKey;
	private Text Readable;
	private Text PubKey;
	private Button Read;
	private Button GenSesKey;
	private Label label1;
	private ProgressBar progressBar1;
	private Label KeyLabel;
	private Text KeyText;
	private Button StegAlgo;
	private Group group2;
	private Button EncryptButton;
	private Text DataFileArea;
	private Group ManualEntry;
	private Text DataFileName;
	private Label Dummy;
	private Group Encryption;
	private Label imageLabel;
	private Label LabelForFIle;
	private MenuItem aboutMenuItem;
	private MenuItem contentsMenuItem;
	private Menu helpMenu;
	private MenuItem helpMenuItem;
	private Button button1;
	private Text FileName;
	private MenuItem exitMenuItem;
	private MenuItem closeFileMenuItem;
	private MenuItem saveFileMenuItem;
	private MenuItem newFileMenuItem;
	private MenuItem openFileMenuItem;
	private Menu fileMenu;
	private MenuItem fileMenuItem;
	private String real;

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	public DecryptWindow(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}
	
	/**
	* Initializes the GUI.
	*/
	private  void initGUI() {
		try {
			{
				this.setOrientation(SWT.HORIZONTAL);
			}
			this.setSize(1225, 619);
			this.setBackground(SWTResourceManager.getColor(128, 0, 255));
			FormLayout thisLayout = new FormLayout();
			this.setLayout(thisLayout);
			{
				HideKey = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData HideKeyLData = new FormData();
				HideKeyLData.left =  new FormAttachment(0, 1000, 1112);
				HideKeyLData.top =  new FormAttachment(0, 1000, 107);
				HideKeyLData.width = 59;
				HideKeyLData.height = 22;
				HideKey.setLayoutData(HideKeyLData);
				HideKey.setText("Hide Key");
				HideKey.setVisible(false);
				HideKey.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e) {
						HideKey.setVisible(false);
						Read.setVisible(true);
						KeyText.setVisible(true);
						Readable.setVisible(false);
						KeyText.setText(Readable.getText());
						//Readable.setVisible(false);
						
					}
				});
			}
			{
				FormData ReadableLData = new FormData();
				ReadableLData.left =  new FormAttachment(0, 1000, 1086);
				ReadableLData.top =  new FormAttachment(0, 1000, 91);
				ReadableLData.width = 105;
				ReadableLData.height = 16;
				Readable = new Text(this, SWT.NONE);
				Readable.setLayoutData(ReadableLData);
				Readable.setVisible(false);
			}
			{
				FormData PubKeyLData = new FormData();
				PubKeyLData.left =  new FormAttachment(0, 1000, 863);
				PubKeyLData.top =  new FormAttachment(0, 1000, 80);
				PubKeyLData.width = 202;
				PubKeyLData.height = 15;
				PubKey = new Text(this, SWT.NONE);
				PubKey.setLayoutData(PubKeyLData);
			}
			{
				group2 = new Group(this, SWT.NONE);
				GridLayout group2Layout = new GridLayout();
				group2Layout.makeColumnsEqualWidth = true;
				group2.setLayout(group2Layout);
				FormData group2LData = new FormData();
				group2LData.left =  new FormAttachment(0, 1000, 863);
				group2LData.top =  new FormAttachment(0, 1000, 127);
				group2LData.width = 322;
				group2LData.height = 108;
				group2.setLayoutData(group2LData);
				group2.setText("1st Level Security -DeSteganoGraphy");
				{
					DataFile = new Button(group2, SWT.PUSH | SWT.CENTER);
					GridData DataFileLData = new GridData();
					DataFile.setLayoutData(DataFileLData);
					DataFile.setText("Save Data to File");
					DataFile.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e){
							Display display = Display.getDefault();
							Shell shell = new Shell(display);
							shell.layout();
							FileDialog dialog = new FileDialog(shell, SWT.SAVE);
							String path = dialog.open();
							DataFileName.setText(path);
							if (path != null) {
								
								File file = new File(path);
								if (file.isFile())
									displayFiles(new String[] { file.toString()});
								else
									displayFiles(file.list());
								//DataFileName.setText(FileFile);
							}
							//code to be written here to get the filename entered and retriving the file contents from there
							//Image image=new Image(display,FileName.getText());
							//imageLabel.setImage(image);
							//shell.open();
							while (!shell.isDisposed()) {
								if (!display.readAndDispatch())
									display.sleep();
							}
						}
						
						private void displayFiles(String[] files) {
							// TODO Auto-generated method stub
							for (int i = 0; files != null && i < files.length; i++) {
								DataFileName.setText(files[i]);
								DataFileName.setEditable(true);
							}

						}
					});
				}
				{
					DataFileName = new Text(group2, SWT.NONE);
					GridData DataFileNameLData = new GridData();
					DataFileNameLData.widthHint = 302;
					DataFileNameLData.heightHint = 15;
					DataFileName.setLayoutData(DataFileNameLData);
					DataFileName.setBackground(SWTResourceManager.getColor(204,179,203));
				}
				{
					GridData progressBar1LData = new GridData();
					progressBar1LData.widthHint = 309;
					progressBar1LData.heightHint = 17;
					progressBar1 = new ProgressBar(group2, SWT.NONE);
					progressBar1.setLayoutData(progressBar1LData);
					progressBar1.setVisible(false);
				}
				{
					StegAlgo = new Button(group2, SWT.PUSH);
					GridData StegAlgoLData = new GridData();
					StegAlgoLData.widthHint = 146;
					StegAlgoLData.heightHint = 25;
					StegAlgoLData.horizontalAlignment = GridData.CENTER;
					StegAlgo.setLayoutData(StegAlgoLData);
					StegAlgo.setText("Apply De-SteganoGraphy");
					StegAlgo.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e){
							String key=KeyText.getText();
							progressBar1.setVisible(true); 
							//try{
								//int i=0;
								progressBar1.setSelection(15);
								//code for progress bar
								// while(i<15){ i++; progressBar1.setSelection(i); Thread.sleep(100);}		
								System.out.println(key.getBytes());
								System.out.println(key);
								int keyvalue = Integer.parseInt(key);
								SteganoAlgorithm steg=new SteganoAlgorithm(keyvalue);
								progressBar1.setSelection(50);
								//System.out.println(key.getByt
										System.out.println("This is the byte key value"+keyvalue);
								
								keyvalue=(byte) (keyvalue & 1);
								System.out.println("The int after binary operation is "+keyvalue);
								// while(i<95){ i++; progressBar1.setSelection(i); Thread.sleep(100);}
								realText=steg.decode(FileName.getText(),DataFileName.getText());
								progressBar1.setSelection(80);
								
								//real=realText;
								progressBar1.setSelection(100);
								DeText=realText.getBytes();
								// while(i<progressBar1.getMaximum()){ i++; progressBar1.setSelection(i); Thread.sleep(100);}
								DataFileArea.setText(realText);
								// if(!realText.isEmpty()){ JOptionPane.showMessageDialog(null,"The data is successfully Decrypted from the image", "Success",JOptionPane.INFORMATION_MESSAGE);}
								progressBar1.setVisible(false);
								//} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									//e1.printStackTrace();
									//}
							//File d=new File(DataFileName.getText());
							//try{ OutputStream o=new FileOutputStream(d);
							//byte buf[]=DeText;//realText.getBytes();
							
							//o.write(buf); 
							//} catch(IOException ae){ }						    
							//progressBar1.setVisible(false);
						}
					});
								
				}
			}
			{
				Encryption = new Group(this, SWT.NONE);
				GridLayout EncryptionLayout = new GridLayout();
				EncryptionLayout.makeColumnsEqualWidth = true;
				Encryption.setLayout(EncryptionLayout);
				FormData EncryptionLData = new FormData();
				EncryptionLData.left =  new FormAttachment(0, 1000, 861);
				EncryptionLData.top =  new FormAttachment(0, 1000, 256);
				EncryptionLData.width = 323;
				EncryptionLData.height = 333;
				Encryption.setLayoutData(EncryptionLData);
				Encryption.setText("2nd Level Security-Decryption");
				{
					Dummy = new Label(Encryption, SWT.NONE);
					GridData DummyLData = new GridData();
					DummyLData.widthHint = 38;
					DummyLData.heightHint = 15;
					Dummy.setLayoutData(DummyLData);
					Dummy.setText("OR");
				}
				{
					ManualEntry = new Group(Encryption, SWT.NONE);
					GridLayout ManualEntryLayout = new GridLayout();
					ManualEntryLayout.makeColumnsEqualWidth = true;
					ManualEntry.setLayout(ManualEntryLayout);
					GridData ManualEntryLData = new GridData();
					ManualEntryLData.widthHint = 303;
					ManualEntryLData.heightHint = 250;
					ManualEntry.setLayoutData(ManualEntryLData);
					ManualEntry.setText("You can read the Data Here");
					ManualEntry.setBackground(SWTResourceManager.getColor(128, 128, 0));
					{
						DataFileArea = new Text(ManualEntry, SWT.MULTI | SWT.WRAP);
						GridData DataFileAreaLData = new GridData();
						DataFileAreaLData.widthHint = 289;
						DataFileAreaLData.heightHint = 241;
						DataFileArea.setLayoutData(DataFileAreaLData);
						
					}
				}
				{
					EncryptButton = new Button(Encryption, SWT.PUSH);
					GridData EncryptButtonLData = new GridData();
					EncryptButtonLData.widthHint = 99;
					EncryptButtonLData.heightHint = 28;
					EncryptButtonLData.horizontalAlignment = GridData.CENTER;
					EncryptButton.setLayoutData(EncryptButtonLData);
					EncryptButton.setText("Decrypt Data");
					EncryptButton.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e){
							progressBar1.setVisible(true);
							progressBar1.setSelection(15);
							AES4all aesalgorithm=new AES4all();
							FileReader fr;
							String FileContents=new String();
							try {
								fr = new FileReader(DataFileName.getText());
							
							BufferedReader br=new BufferedReader(fr);
							char ch[];
							String s=null;
							while((s=br.readLine())!=null){ /*ch=s.toCharArray(); for(int i=0;i<ch.length;i++) ch[i]-=Integer.parseInt(KeyText.getText()); s=ch.toString();*/FileContents=FileContents+s; System.out.println(s); }
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} 
							//System.out.println("Contents are "+FileContents);
							System.out.println("The Contents are "+realText); char ch[];
							//ch=realText.toCharArray(); for(int i=0;i<ch.length;i++) ch[i]-=Integer.parseInt(KeyText.getText()); realText=ch.toString();
							String sDemoMesage =DataFileArea.getText();//realText;
							System.out.println("The Obtained file contents are "+sDemoMesage);
							byte[] demoMesageBytes =Util.hex2byte(sDemoMesage);//sDemoMesage.getBytes();//DataFileArea.getText().getBytes();
							//shared secret
							String NewMessage=sDemoMesage.trim();
							System.out.println("The new Mesage is"+NewMessage);
							for(int i=0;i<demoMesageBytes.length;i++)
							System.out.println("Obtained Hex converted Bytes are"+demoMesageBytes[i] );
							byte[] demoKeyBytes = new byte[] {  0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07,
									0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f};
							// Initialization Vector - usually a random data, stored along with the shared secret,
							// or transmitted along with a message.
							// Not all the ciphers require IV - we use IV in this particular sample
							byte[] demoIVBytes = new byte[] { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07,
									0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f};
							String sPadding = "ISO10126Padding"; //"ISO10126Padding", "PKCS5Padding"
							progressBar1.setSelection(50);
							System.out.println("Demo Key (base64): "+ new String(SimpleBase64Encoder.encode(demoKeyBytes)));
							System.out.println("Demo IV  (base64): "+ new String(SimpleBase64Encoder.encode(demoIVBytes)));
							try{
							//byte[] demo1EncryptedBytes = aesalgorithm.demo1encrypt(demoKeyBytes, demoIVBytes, sPadding, demoMesageBytes);
							//System.out.println("Demo1 encrypted (base64): "+ new String(SimpleBase64Encoder.encode(demo1EncryptedBytes)));
							
							byte[] demo1DecryptedBytes = aesalgorithm.demo1decrypt(demoKeyBytes, demoIVBytes, sPadding, /*EncryptWindow.enBytes*/demoMesageBytes);
						    progressBar1.setSelection(100);
						    EncryptButton.setEnabled(false);
								 /*byte[] demo2DecryptedBytes = AES4all.demo2decrypt(demoKeyBytes, sPadding, demoMesageBytes);*/
							        System.out.println("Demo2 decrypted message : "+new String(demo1DecryptedBytes));
							        String DecryptedString=new String(demo1DecryptedBytes);
							 System.out.println("The retrieved bytes are "+demo1DecryptedBytes);
							System.out.println("Demo1 decrypted message : "+DecryptedString);
							DataFileArea.setText(DecryptedString);
							//part for pdf
							OutputStream out = new FileOutputStream(DataFileName.getText());
							out.write(demo1DecryptedBytes);
							out.close();
							progressBar1.setVisible(false);
							//end of part for pdf
							/*File d=new File(DataFileName.getText());
							try{ OutputStream o=new FileOutputStream(d);
							byte buf[]=demo1DecryptedBytes;//realText.getBytes();
							
							o.write(buf); 
							} catch(IOException ae){ }*/
							
							} catch(Exception eeee){}
						}
						
					});
				}
			}
			{
				imageLabel = new Label(this, SWT.NONE);
				FormData imageLabelLData = new FormData();
				imageLabelLData.left =  new FormAttachment(0, 1000, 28);
				imageLabelLData.top =  new FormAttachment(0, 1000, 10);
				imageLabelLData.width = 817;
				imageLabelLData.height = 550;
				imageLabel.setLayoutData(imageLabelLData);
			}
			{
				LabelForFIle = new Label(this, SWT.NONE);
				FormData LabelForFIleLData = new FormData();
				LabelForFIleLData.left =  new FormAttachment(0, 1000, 863);
				LabelForFIleLData.top =  new FormAttachment(0, 1000, 10);
				LabelForFIleLData.width = 274;
				LabelForFIleLData.height = 15;
				LabelForFIle.setLayoutData(LabelForFIleLData);
				LabelForFIle.setText("Select the SteganoGraphed Source image");
			}
			{
				button1 = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData button1LData = new FormData();
				button1LData.left =  new FormAttachment(0, 1000, 1083);
				button1LData.top =  new FormAttachment(0, 1000, 33);
				button1LData.width = 54;
				button1LData.height = 25;
				button1.setLayoutData(button1LData);
				button1.setText("Browse");
				button1.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e) {
						Display display = Display.getDefault();
						Shell shell = new Shell(display);
						shell.layout();
						FileDialog dialog = new FileDialog(shell, SWT.NULL);
				        String path = dialog.open();
				        if (path != null) {

				          File file = new File(path);
				          if (file.isFile())
				            displayFiles(new String[] { file.toString()});
				          else
				            displayFiles(file.list());

				        }
				        Image image=new Image(display,FileName.getText());
				        imageLabel.setImage(image);
				        //shell.open();
				        while (!shell.isDisposed()) {
							if (!display.readAndDispatch())
								display.sleep();
						}
							      
					}

					private void displayFiles(String[] files) {
						// TODO Auto-generated method stub
						 for (int i = 0; files != null && i < files.length; i++) {
						      FileName.setText(files[i]);
							  FileName.setEditable(true);
							}
					}
				});
			}
			{
				FormData FileNameLData = new FormData();
				FileNameLData.left =  new FormAttachment(0, 1000, 863);
				FileNameLData.top =  new FormAttachment(0, 1000, 33);
				FileNameLData.width = 202;
				FileNameLData.height = 21;
				FileName = new Text(this, SWT.NONE);
				FileName.setLayoutData(FileNameLData);
			}
			{
				FormData KeyTextLData = new FormData();
				KeyTextLData.left =  new FormAttachment(0, 1000, 1083);
				KeyTextLData.top =  new FormAttachment(0, 1000, 91);
				KeyTextLData.width = 110;
				KeyTextLData.height = 16;
				KeyText = new Text(this, SWT.NONE|SWT.PASSWORD);
				KeyText.setLayoutData(KeyTextLData);
			}
			{
				KeyLabel = new Label(this, SWT.NONE);
				FormData KeyLabelLData = new FormData();
				KeyLabelLData.left =  new FormAttachment(0, 1000, 863);
				KeyLabelLData.top =  new FormAttachment(0, 1000, 66);
				KeyLabelLData.width = 208;
				KeyLabelLData.height = 14;
				KeyLabel.setLayoutData(KeyLabelLData);
				KeyLabel.setText("Enter the Sender's Public Key ");
			}
			{
				label1 = new Label(this, SWT.NONE);
				FormData label1LData = new FormData();
				label1LData.left =  new FormAttachment(0, 1000, 253);
				label1LData.top =  new FormAttachment(0, 1000, 572);
				label1LData.width = 429;
				label1LData.height = 32;
				label1.setLayoutData(label1LData);
				label1.setText("                             Copyright 2012., All Rights Reserved.,\r\n                              Vinaykumar M Kolli & Vaishakh B N  ");
				label1.setBackground(SWTResourceManager.getColor(255, 255, 255));
			}
			{
				GenSesKey = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData GenSesKeyLData = new FormData();
				GenSesKeyLData.left =  new FormAttachment(0, 1000, 1083);
				GenSesKeyLData.top =  new FormAttachment(0, 1000, 66);
				GenSesKeyLData.width = 116;
				GenSesKeyLData.height = 25;
				GenSesKey.setLayoutData(GenSesKeyLData);
				GenSesKey.setText("Generate Session Key");
				GenSesKey.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e) {
						BigInteger yb=new BigInteger(PubKey.getText());
						System.out.println("xa and q are"+MkdMain.xa + "  " +MkdMain.q  );
						BigInteger xa1=new BigInteger(MkdMain.xa);
						BigInteger q1=new BigInteger(MkdMain.q);
						
						BigInteger ka = yb.modPow(xa1, q1);
						KeyText.setText(ka.toString());
					}
				});
			}
			{
				Read = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData ReadLData = new FormData();
				ReadLData.left =  new FormAttachment(0, 1000, 1112);
				ReadLData.top =  new FormAttachment(0, 1000, 107);
				ReadLData.width = 60;
				ReadLData.height = 20;
				Read.setLayoutData(ReadLData);
				Read.setText("Read Key");
				Read.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e) {
						KeyText.setVisible(false);
						Readable.setVisible(true);
						Readable.setText(KeyText.getText());
						//Readable.setVisible(false);
						Read.setVisible(false);
						HideKey.setVisible(true);
						
					}
				});
			}
			{
				menu1 = new Menu(getShell(), SWT.BAR);
				getShell().setMenuBar(menu1);
				{
					/*fileMenuItem = new MenuItem(menu1, SWT.CASCADE);
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
					}*/
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
	public static void main() {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		shell.setText("Image Desteganography and Decryption Phase");
		DecryptWindow inst = new DecryptWindow(shell, SWT.NULL);
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
