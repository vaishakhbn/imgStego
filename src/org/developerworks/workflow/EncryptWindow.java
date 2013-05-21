package org.developerworks.workflow;



import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;

import javax.swing.JOptionPane;
import javax.swing.text.html.Option;

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
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
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
public class EncryptWindow extends org.eclipse.swt.widgets.Composite {

	private Menu menu1;
	public static int progress=0;
	private Button HideKey;
	private Text Readable;
	private Button Read;
	private Text PubKey;
	private Button GenSesKey;
	private Label label1;
	private Button button2;
	private Button Browse;
	private Text textSave;
	private Label labelSave;
	private ProgressBar progressBar1;
	public static byte[] enBytes;
	public String EnText;
	private Button DataFile;
	private Text KeyText;
	private Label KeyLabel;
	private Button EncryptButton;
	private Text DataFileArea;
	private Group ManualEntry;
	private Text DataFileName;
	private Label Dummy;
	private Group Encryption;
	private Button StegAlgo;
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
    protected String FileFile;

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	public EncryptWindow(Composite parent, int style) {
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
			this.setSize(1200, 609);
			this.setBackground(SWTResourceManager.getColor(128, 0, 255));
			FormLayout thisLayout = new FormLayout();
			this.setLayout(thisLayout);
			{
				FormData ReadableLData = new FormData();
				ReadableLData.left =  new FormAttachment(0, 1000, 1079);
				ReadableLData.top =  new FormAttachment(0, 1000, 144);
				ReadableLData.width = 108;
				ReadableLData.height = 15;
				Readable = new Text(this, SWT.NONE);
				Readable.setLayoutData(ReadableLData);
				Readable.setVisible(false);
			}
			{
				Read = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData ReadLData = new FormData();
				ReadLData.left =  new FormAttachment(0, 1000, 1110);
				ReadLData.top =  new FormAttachment(0, 1000, 159);
				ReadLData.width = 60;
				ReadLData.height = 22;
				Read.setLayoutData(ReadLData);
				Read.setText("Read Key");
				Read.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e){
					Read.setVisible(false);
					HideKey.setVisible(true);
					KeyText.setVisible(false);
					Readable.setVisible(true);
					Readable.setText(KeyText.getText());
					//Readable.setVisible(false);
					
				}});
			}
			{
				FormData PubKeyLData = new FormData();
				PubKeyLData.left =  new FormAttachment(0, 1000, 857);
				PubKeyLData.top =  new FormAttachment(0, 1000, 132);
				PubKeyLData.width = 202;
				PubKeyLData.height = 15;
				PubKey = new Text(this, SWT.NONE);
				PubKey.setLayoutData(PubKeyLData);
			}
			{
				GenSesKey = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData GenSesKeyLData = new FormData();
				GenSesKeyLData.left =  new FormAttachment(0, 1000, 1077);
				GenSesKeyLData.top =  new FormAttachment(0, 1000, 117);
				GenSesKeyLData.width = 116;
				GenSesKeyLData.height = 25;
				GenSesKey.setLayoutData(GenSesKeyLData);
				GenSesKey.setText("Generate Session Key");
				GenSesKey.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e){
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
				button2 = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData button2LData = new FormData();
				button2LData.left =  new FormAttachment(0, 1000, 726);
				button2LData.top =  new FormAttachment(0, 1000, 571);
				button2LData.width = 103;
				button2LData.height = 25;
				button2.setLayoutData(button2LData);
				button2.setText("Compare Images");
				button2.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e){
						Display display = Display.getDefault();
						Shell shell = new Shell(display);
						Compare help=new Compare(shell,SWT.NULL);
						Point size = help.getSize();
						//shell.setLayout(new FillLayout());
						shell.layout();
						//new Label(shell, SWT.NONE).setText("Operation:");
					    //final Label returnVal = new Label(shell, SWT.NONE);
					    //returnVal.setLayoutData(new FillLayout(SWT.NULL));
						//returnVal.setText("");
                         Compare.giveNames(FileName.getText(),textSave.getText());
                         Compare.show();
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
			{
				Browse = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData BrowseLData = new FormData();
				BrowseLData.left =  new FormAttachment(0, 1000, 1077);
				BrowseLData.top =  new FormAttachment(0, 1000, 81);
				BrowseLData.width = 54;
				BrowseLData.height = 21;
				Browse.setLayoutData(BrowseLData);
				Browse.setText("Save\r\n");
				Browse.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e){
						Display display = Display.getDefault();
						Shell shell = new Shell(display);
						shell.layout();
						FileDialog dialog = new FileDialog(shell, SWT.SAVE);
						String path = dialog.open();
						textSave.setText(path);
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
							textSave.setText(files[i]);
							textSave.setEditable(true);
						}

					}
				});
			}
			{
				textSave = new Text(this, SWT.NONE);
				FormData textSaveLData = new FormData();
				textSaveLData.left =  new FormAttachment(0, 1000, 857);
				textSaveLData.top =  new FormAttachment(0, 1000, 81);
				textSaveLData.width = 202;
				textSaveLData.height = 21;
				textSave.setLayoutData(textSaveLData);
			}
			{
				labelSave = new Label(this, SWT.NONE);
				FormData labelSaveLData = new FormData();
				labelSaveLData.left =  new FormAttachment(0, 1000, 857);
				labelSaveLData.top =  new FormAttachment(0, 1000, 60);
				labelSaveLData.width = 144;
				labelSaveLData.height = 15;
				labelSave.setLayoutData(labelSaveLData);
				labelSave.setText("Save the Output Image to ");
				labelSave.setBackground(SWTResourceManager.getColor(128, 0, 255));
			}
			{
				KeyText = new Text(this, SWT.NONE|SWT.PASSWORD);
				FormData KeyTextLData = new FormData();
				KeyTextLData.left =  new FormAttachment(0, 1000, 1077);
				KeyTextLData.top =  new FormAttachment(0, 1000, 139);
				KeyTextLData.width = 110;
				KeyTextLData.height = 20;
				KeyText.setLayoutData(KeyTextLData);
			}
			{
				KeyLabel = new Label(this, SWT.NONE);
				FormData KeyLabelLData = new FormData();
				KeyLabelLData.left =  new FormAttachment(0, 1000, 857);
				KeyLabelLData.top =  new FormAttachment(0, 1000, 117);
				KeyLabelLData.width = 208;
				KeyLabelLData.height = 15;
				KeyLabel.setLayoutData(KeyLabelLData);
				KeyLabel.setText("Enter the Receiver's Public Key");
			}
			{
				Encryption = new Group(this, SWT.NONE);
				GridLayout EncryptionLayout = new GridLayout();
				EncryptionLayout.makeColumnsEqualWidth = true;
				Encryption.setLayout(EncryptionLayout);
				FormData EncryptionLData = new FormData();
				EncryptionLData.left =  new FormAttachment(0, 1000, 862);
				EncryptionLData.top =  new FormAttachment(0, 1000, 187);
				EncryptionLData.width = 320;
				EncryptionLData.height = 361;
				Encryption.setLayoutData(EncryptionLData);
				Encryption.setText("Ist Level Security-Encryption");
				{
					DataFile = new Button(Encryption, SWT.PUSH | SWT.CENTER);
					GridData DataFileLData = new GridData();
					DataFile.setLayoutData(DataFileLData);
					DataFile.setText("Select the Data File");
					DataFile.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e){
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
					        //code to be written here to get the filename entered and retriving the file contents from there
					        //Image image=new Image(display,FileName.getText());
					        //imageLabel.setImage(image);
					        //shell.open();
					        while (!shell.isDisposed()) {
								if (!display.readAndDispatch())
									display.sleep();
							}
					      //  File f=new File(DataFile.getText());
					        //f.get
						}

						private void displayFiles(String[] files) {
							// TODO Auto-generated method stub
							 for (int i = 0; files != null && i < files.length; i++) {
							      DataFileName.setText(files[i]);  try{ FileReader fr=new FileReader(DataFileName.getText());
									BufferedReader br=new BufferedReader(fr);
									String FileContents=new String();
									String s=null;
									while((s=br.readLine())!=null){ FileContents=FileContents+s; System.out.println(s); } 
									System.out.println("the file contents are"+FileContents);
									DataFileArea.setText(FileContents);
								  DataFileName.setEditable(true);
							      }catch(Exception eee){}								}
						}
					});
				}
				{
					DataFileName = new Text(Encryption, SWT.NONE);
					GridData DataFileNameLData = new GridData();
					DataFileNameLData.widthHint = 304;
					DataFileNameLData.heightHint = 15;
					DataFileName.setLayoutData(DataFileNameLData);
					DataFileName.setBackground(SWTResourceManager.getColor(204, 179, 203));
				}
				{
					Dummy = new Label(Encryption, SWT.NONE);
					GridData DummyLData = new GridData();
					DummyLData.widthHint = 77;
					DummyLData.heightHint = 15;
					Dummy.setLayoutData(DummyLData);
					Dummy.setText("Your Data is");
				}
				{
					ManualEntry = new Group(Encryption, SWT.NONE);
					GridLayout ManualEntryLayout = new GridLayout();
					ManualEntryLayout.makeColumnsEqualWidth = true;
					ManualEntry.setLayout(ManualEntryLayout);
					GridData ManualEntryLData = new GridData();
					ManualEntryLData.widthHint = 303;
					ManualEntryLData.heightHint = 220;
					ManualEntry.setLayoutData(ManualEntryLData);
					ManualEntry.setBackground(SWTResourceManager.getColor(128, 128, 0));
					{
						DataFileArea = new Text(ManualEntry, SWT.MULTI | SWT.WRAP);
						GridData DataFileAreaLData = new GridData();
						DataFileAreaLData.widthHint = 289;
						DataFileAreaLData.heightHint = 213;
						DataFileArea.setLayoutData(DataFileAreaLData);
					}
				}
				{
					EncryptButton = new Button(Encryption, SWT.PUSH);
					GridData EncryptButtonLData = new GridData();
					EncryptButtonLData.widthHint = 79;
					EncryptButtonLData.heightHint = 22;
					EncryptButtonLData.horizontalSpan = 3;
					EncryptButton.setLayoutData(EncryptButtonLData);
					EncryptButton.setText("Encrypt Data");
					EncryptButton.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {
							try{
								AES4all aesalgorithm=new AES4all();
								int i=0;
								progressBar1.setVisible(true);								//code for progress bar
								progressBar1.setSelection(20); 
								//Thread.sleep(100);
																
									    	//JOptionPane.showMessageDialog(null,"Wait while the data is being encrypted", "Success",JOptionPane.INFORMATION_MESSAGE);
									    
								//code for reading the contents of the file to be encrypted
								String FileContents=new String();
										//String FinalContent=new String();
										/*if(!DataFileName.getText().equals(null)){
											System.out.println(DataFileName.getText());
											FileReader fr=new FileReader(DataFileName.getText());
											BufferedReader br=new BufferedReader(fr);
											
											String s=null;
											char ch[];
											while((s=br.readLine())!=null){ ch=s.toCharArray(); for(int i=0;i<ch.length;i++) ch[i]=(int)((int)ch[i]+Integer.parseInt(KeyText.getText())); s=ch.toString(); s=Integer.toString(Integer.valueOf(s)+Integer.parseInt(KeyText.getText())); FileContents=FileContents+s; System.out.println(s); } 
											System.out.println("the file contents are"+FileContents);
											DataFileArea.setText(FileContents);
											FinalContent=FileContents;
										}*/
										// if(DataFileName.getText().equals(new String())) { FinalContent=DataFileArea.getText(); } //else { FinalContent=FileContents;}
										String sDemoMesage =FileContents;
										byte[] c=PdfTry.loadFile(DataFileName.getText());
										//String data=FileContents;// DataFileArea.getText();
										/*AES aes=new AES();
										aes.setKey("kWmHe8xIsDpfzK4d");  // choose 16 byte password
										System.out.println("Original text : ["+data+"] ["+data.length()+" bytes]");
										
										String encrypted = aes.Encrypt(data); 
										System.out.println("Encrypted text : ["+encrypted+"] ["+encrypted.length()+" bytes]");
										String hex = Util.toHEX(encrypted.getBytes()).replace(" ", "");
										System.out.println("Encrypted text (as hex) : ["+hex+"] ["+hex.length()+" bytes]");
										
										String unencrypted = aes.Decrypt(new String(Util.hex2byte(hex))); 
										System.out.println("Unencrypted text : ["+unencrypted+"] ["+unencrypted.length()+" bytes]");*/
										System.out.println("The contents are"+sDemoMesage);
										byte[] demoMesageBytes = c;//sDemoMesage.getBytes();
										 progressBar1.setSelection(50); //Thread.sleep(100);}
										
										
										//shared secret
										byte[] demoKeyBytes = new byte[] {  0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07,
												0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f};
										// Initialization Vector - usually a random data, stored along with the shared secret,
										// or transmitted along with a message.
										// Not all the ciphers require IV - we use IV in this particular sample
										byte[] demoIVBytes = new byte[] { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07,
												0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f};
										String sPadding = "ISO10126Padding"; //"ISO10126Padding", "PKCS5Padding"
										
										System.out.println("Demo Key (base64): "+ new String(SimpleBase64Encoder.encode(demoKeyBytes)));
										System.out.println("Demo IV  (base64): "+ new String(SimpleBase64Encoder.encode(demoIVBytes)));
										
										byte[] demo1EncryptedBytes = aesalgorithm.demo1encrypt(demoKeyBytes, demoIVBytes, sPadding, demoMesageBytes);
										//Str4ing ENC=new String(SimpleBase64Encoder.encode(demo1EncryptedBytes));
										/* byte[] demo2EncryptedBytes = AES4all.demo2encrypt(demoKeyBytes, sPadding, demoMesageBytes);
									        System.out.println("Demo2 encrypted (base64): "+ new String(SimpleBase64Encoder.encode(demo2EncryptedBytes)));*/
										EnText=new String(demo1EncryptedBytes);
										System.out.println("The Encrypted bytes(String) which are input to the steganography  are :"+EnText);
										enBytes=demo1EncryptedBytes;
										 progressBar1.setSelection(100); //Thread.sleep(100);}
										
										
										System.out.println("Obtained Encrypted bytes are"+demo1EncryptedBytes);
										
										DataFileArea.setText(Util.toHEX(demo1EncryptedBytes));
										
										//DataFileArea.setText(encrypted);
										System.out.println("Demo1 encrypted (base64): "+EnText );
										// byte[] demo1DecryptedBytes = aesalgorithm.demo1decrypt(demoKeyBytes, demoIVBytes, sPadding, demo1EncryptedBytes);
									      //System.out.println("Demo1 decrypted message : "+new String(demo1DecryptedBytes));
										JOptionPane.showMessageDialog(null,"The data is successfully encrypted", "Success",JOptionPane.INFORMATION_MESSAGE);
										progressBar1.setVisible(false);
										
										EncryptButton.setEnabled(false);
							} catch(Exception ee){}
							//  byte[] demo2EncryptedBytes = demo2encrypt(demoKeyBytes, sPadding, demoMesageBytes);
							//  System.out.println("Demo2 encrypted (base64): "+ new String(SimpleBase64Encoder.encode(demo2EncryptedBytes)));
							//  byte[] demo2DecryptedBytes = demo2decrypt(demoKeyBytes, sPadding, demo2EncryptedBytes);
							//  System.out.println("Demo2 decrypted message : "+new String(demo2DecryptedBytes));
							
							
						}
						
					});
				}
		{
			GridData progressBar1LData = new GridData();
			progressBar1LData.widthHint = 304;
			progressBar1LData.heightHint = 17;
			progressBar1 = new ProgressBar(Encryption, SWT.NONE);
			progressBar1.setLayoutData(progressBar1LData);
			progressBar1.setVisible(false);
		}
			}

			{
				StegAlgo = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData StegAlgoLData = new FormData();
				StegAlgoLData.left =  new FormAttachment(0, 1000, 966);
				StegAlgoLData.top =  new FormAttachment(0, 1000, 571);
				StegAlgoLData.width = 159;
				StegAlgoLData.height = 31;
				StegAlgo.setLayoutData(StegAlgoLData);
				StegAlgo.setText("Apply SteganoGraphy");
				StegAlgo.setDragDetect(false);
				StegAlgo.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e) {
						progressBar1.setVisible(true);
						int i=0;
						 progressBar1.setSelection(15); 
							//Thread.sleep(100);
						
						String key=KeyText.getText();
						System.out.println(key.getBytes());
						System.out.println(key);
						int keyvalue = Integer.parseInt(key);	
					SteganoAlgorithm steg=new SteganoAlgorithm(keyvalue);
					int returnValue;
					String Data=new String();
					String FileTheData=new String();
					String filename=new String(DataFileName.getText());
					System.out.println(filename);
					//File file=new File(filename);
					//int keyvalue=Integer.parseInt(KeyText.getText());
					FileFile=filename;
					progressBar1.setSelection(60); 
					//Thread.sleep(100);
				
					if(DataFileName.getText().equalsIgnoreCase("")){ returnValue=steg.encode(FileName.getText(),textSave.getText(),DataFileArea.getText()/*EnText*/); System.out.println("got it"); }
					else
					{
						try {
							Data=readFileAsString(filename);
							System.out.println("Data is"+ Data);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
						
						returnValue=steg.encode(FileName.getText(),textSave.getText(),DataFileArea.getText()/*EnText*/);
											
					}
					progressBar1.setSelection(95); 
					//Thread.sleep(100);
				
					if(returnValue==1)JOptionPane.showMessageDialog(null,"The data is successfully hidden into the image", "Success",JOptionPane.INFORMATION_MESSAGE);
					StegAlgo.setEnabled(false);	
					progressBar1.setVisible(false);
					//steg.open();
			}
					private String readFileAsString(String filePath) throws IOException {
				        StringBuffer fileData = new StringBuffer();
				        BufferedReader reader = new BufferedReader(
				                new FileReader(filePath));
				        char[] buf = new char[1024];
				        int numRead=0;
				        while((numRead=reader.read(buf)) != -1){
				            String readData = String.valueOf(buf, 0, numRead);
				            fileData.append(readData);
				        }
				        reader.close();
				        return fileData.toString();
				    }
					public String readInputStreamAsString(InputStream in) throws IOException {
						
						 
						
						     BufferedInputStream bis = new BufferedInputStream(in);
						
						     ByteArrayOutputStream buf = new ByteArrayOutputStream();
						
						     int result = bis.read();
						
						     while(result != -1) {
						
						      byte b = (byte)result;
						
						      buf.write(b);
						
						      result = bis.read();
						
						     }  
						
						     return buf.toString();
						
						 }

					});
			}
			{
				imageLabel = new Label(this, SWT.NONE);
				FormData imageLabelLData = new FormData();
				imageLabelLData.left =  new FormAttachment(0, 1000, 22);
				imageLabelLData.top =  new FormAttachment(0, 1000, 12);
				imageLabelLData.width = 817;
				imageLabelLData.height = 547;
				imageLabel.setLayoutData(imageLabelLData);
			}
			{
				LabelForFIle = new Label(this, SWT.NONE);
				FormData LabelForFIleLData = new FormData();
				LabelForFIleLData.left =  new FormAttachment(0, 1000, 856);
				LabelForFIleLData.top =  new FormAttachment(0, 1000, 18);
				LabelForFIleLData.width = 164;
				LabelForFIleLData.height = 21;
				LabelForFIle.setLayoutData(LabelForFIleLData);
				LabelForFIle.setText("Select the Source image");
				LabelForFIle.setBackground(SWTResourceManager.getColor(128, 0, 255));
				LabelForFIle.setFont(SWTResourceManager.getFont("Segoe UI", 9, 1, false, false));
			}
			{
				button1 = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData button1LData = new FormData();
				button1LData.left =  new FormAttachment(0, 1000, 1077);
				button1LData.top =  new FormAttachment(0, 1000, 31);
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
				FileNameLData.left =  new FormAttachment(0, 1000, 856);
				FileNameLData.top =  new FormAttachment(0, 1000, 39);
				FileNameLData.width = 203;
				FileNameLData.height = 18;
				FileName = new Text(this, SWT.NONE);
				FileName.setLayoutData(FileNameLData);
			}
			{
				label1 = new Label(this, SWT.NONE);
				FormData label1LData = new FormData();
				label1LData.left =  new FormAttachment(0, 1000, 200);
				label1LData.top =  new FormAttachment(0, 1000, 571);
				label1LData.width = 429;
				label1LData.height = 29;
				label1.setLayoutData(label1LData);
				label1.setText("                             Copyright 2012., All Rights Reserved.,\r\n                              Vinaykumar M Kolli & Vaishakh B N  ");
				label1.setBackground(SWTResourceManager.getColor(255, 255, 255));
			}
			{
				HideKey = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData HideKeyLData = new FormData();
				HideKeyLData.left =  new FormAttachment(0, 1000, 1111);
				HideKeyLData.top =  new FormAttachment(0, 1000, 160);
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
		shell.setText("Image Steganography and Encrytion Phase");
		EncryptWindow inst = new EncryptWindow(shell, SWT.NULL);
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
