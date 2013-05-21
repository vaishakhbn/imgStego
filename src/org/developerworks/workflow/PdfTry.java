package org.developerworks.workflow;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class PdfTry {
	public static byte[] convertDocToByteArray(String sourcePath) {

	      byte[] byteArray=null;
	            try {
	                  InputStream inputStream = new FileInputStream(sourcePath);


	                  String inputStreamToString = inputStream.toString();
	                  byteArray = inputStreamToString.getBytes();

	                  inputStream.close();
	            } catch (FileNotFoundException e) {
	                 System.out.println("File Not found"+e);
	            } catch (IOException e) {
	            	System.out.println("IO Ex"+e);
	            }
	            return byteArray;
	      }
	public static byte[] readFully(InputStream stream) throws IOException
	{
	    byte[] buffer = new byte[8192];
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();

	    int bytesRead;
	    while ((bytesRead = stream.read(buffer)) != -1)
	    {
	        baos.write(buffer, 0, bytesRead);
	    }
	    return baos.toByteArray();
	}
	public static byte[] loadFile(String sourcePath) throws IOException
	{
	    InputStream inputStream = null;
	    try 
	    {
	        inputStream = new FileInputStream(sourcePath);
	        return readFully(inputStream);
	    } 
	    finally
	    {
	        if (inputStream != null)
	        {
	            inputStream.close();
	        }
	    }
	}
	public static void main(String args[])
	{
		PdfTry n=new PdfTry();
		try{
		byte[] c=loadFile("C:/Users/user/Foundstone_SSLDigger_WhitePaper.pdf");
		System.out.println("The Byte array is");
		for(int i=0;i<c.length;i++){ System.out.println(c[i]); }
		String FileData=c.toString();
		
		//System.out.println("The String is"+FileData);
		OutputStream out = new FileOutputStream("C:/Users/user/out4.pdf");
		out.write(c);
		out.close();
		}catch (Exception e){};
		
	}

}
