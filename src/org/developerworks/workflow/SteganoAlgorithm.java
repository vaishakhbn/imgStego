
package org.developerworks.workflow;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.awt.image.DataBufferByte;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
public class SteganoAlgorithm
{
	public int key=0xf5;
	public int initial=key;
	public SteganoAlgorithm(int keyvalue){ key=keyvalue; System.out.println("the entered byte of the key is"+key); initial=key; }
	//private int offsetValue;
	//public byte key=(byte);
	//public int length(byte key){ int i; for(i=0;key!=0;i++){key>>=1;} System.out.println("Length of the key is "+i); return i;}
     
	public int encode(String srcpath, String destpath, String message)
{
int ret=0;
try
{

	File file = new File(srcpath);
BufferedImage image_orig = ImageIO.read(file);
BufferedImage image_mod = cloneImage(image_orig);
image_mod = add_text(image_mod, message);
file=new File(destpath);
file.delete();
ImageIO.write(image_mod,"bmp", file);
ret=1; 
}

catch (Exception e)
{
e.printStackTrace();
ret=0;
}
return ret;
}
public String decode(String filename,String str)
{
byte[] decode;
try
{
File file = new File(filename);
BufferedImage image = ImageIO.read(file);
image = cloneImage(image);
decode = decode_text(get_byte_data(image),str);
String s=new String(decode);
//System.out.println(s);
return s;
}
catch (Exception e)
{
JOptionPane.showMessageDialog(null,"There is no hidden message in this image!", "Error",JOptionPane.ERROR_MESSAGE);
return "";
}
}
private BufferedImage add_text(BufferedImage image, String text)
{
byte img[] = get_byte_data(image);
byte msg[] = text.getBytes();
byte len[] = bit_conversion(msg.length);
try
{
encode_text1(img, len, 0);
encode_text(img, msg, 32);
}
catch (Exception e)
{
JOptionPane.showMessageDialog(null,
"Target File cannot hold message!", "Error",
JOptionPane.ERROR_MESSAGE);
}
return image;
}
private BufferedImage cloneImage(BufferedImage image)
{
BufferedImage new_img = new BufferedImage(image.getWidth(), image
.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
Graphics2D graphics = new_img.createGraphics();
graphics.drawRenderedImage(image, null);
graphics.dispose();
return new_img;
}
private byte[] get_byte_data(BufferedImage image)
{
WritableRaster raster = image.getRaster();
DataBufferByte buffer = (DataBufferByte) raster.getDataBuffer();
return buffer.getData();
}
private byte[] bit_conversion(int i)
{
byte byte3 = (byte) ((i & 0xff000000) >>> 24);
byte byte2 = (byte) ((i & 0x00FF0000) >>> 16);
byte byte1 = (byte) ((i & 0x0000FF00) >>> 8);
byte byte0 = (byte) ((i & 0x000000FF));
return (new byte[] { byte3, byte2, byte1, byte0 });
}
private byte[] encode_text(byte[] image, byte[] addition, int offset)
{
	System.out.println("The file length is"+addition.length);
if (addition.length + offset > image.length)
{
throw new IllegalArgumentException("File not long enough!");
}
for (int i = 0; i < addition.length; ++i)
{
int add = addition[i];
for (int bit = 7; bit >= 0; --bit, ++offset)
{
	int b = (add >>> bit) & 1;
	if((key & 1)==0){
	//here oxfe or oxfd based on key value 0 or 1
	System.out.println("previous image offset"+image[offset]);
	image[offset] = (byte) ((image[offset] & 0xFD) | (b<<1)); //this line  for one bit 0xfe and b System.out.println("after image offset"+image[offset]);
	}else { image[offset]=(byte)((image[offset] & 0xFE)| b); } key>>=1;
}
//if(key==0)key=initial;
}
//offsetValue=offset;
System.out.println("The offset is " +offset);
System.out.println("The key is " +key);
return image;
}
private byte[] encode_text1(byte[] image, byte[] addition, int offset)
{
	System.out.println("The file length is"+addition.length);
if (addition.length + offset > image.length)
{
throw new IllegalArgumentException("File not long enough!");
}
for (int i = 0; i < addition.length; ++i)
{
int add = addition[i];
for (int bit = 7; bit >= 0; --bit, ++offset)
{
	int b = (add >>> bit) & 1;
	 image[offset]=(byte)((image[offset] & 0xFE)| b);  
}
//if(key==0)key=initial;
}
//offsetValue=offset;
System.out.println("The offset is " +offset);
System.out.println("The key is " +key);
return image;
}



private byte[] decode_text(byte[] image,String str)
{
	key=initial;
int length = 0;
int offset = 32;
//offset=image.length;
//import the key value here
for (int i = 0; i < 32; ++i)
{
//if((key & 1)==0) length = (length << 1) | (image[i] & 2); else
	length = (length << 1) | (image[i] & 1); //key>>=1; //if(key==0) key=initial;//here 1 instead of 2
}
//length=length>>1;
byte[] result = new byte[length];
System.out.println("Length of the file is"+result.length);
for (int b = 0; b < result.length; ++b)
{
for (int i = 0; i < 8 ; ++i, ++offset)
{
//key has to be rotated here
	if((key&1)==0){
	System.out.println("offset of image "+(image[offset]&2));//here image[offset] & 1 no shift
result[b] = (byte) ((result[b] << 1) | (image[offset] & 2)>>1);} else { result[b]=(byte)((result[b]<<1)|(image[offset] & 1)); } key>>=1;
}
//if(key==0)key=initial;
}
File d=new File(str);
try{ OutputStream o=new FileOutputStream(d);
System.out.println(result.length);//byte buf[]=result;
for(int i=0;i<result.length;i++)
o.write(result[i]);
//ByteArrayOutputStream b=new ByteArrayOutputStream();
//b.write(result);
//b.writeTo(o);
//System.out.println(b);
//o.write(result); 
byte x=(byte)103; for(int i=0;i<70;i++){ System.out.println("x is"+x); x=(byte)(x>>1); if(x==0)x=(byte)103;}
} catch(IOException ae){ }			
return result;
}
}