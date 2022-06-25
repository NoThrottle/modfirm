package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.io.*;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;

public class Processing {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateFileList("mine");
	}

	
	public static void GenerateFileList(String _Path) {
		Path folder = _Path.toPath().toFile();
		String pwdwdath = "hi";
		
		Path mine = pwdwdath.toString().to;
		
	}
	
	private static List<String> listFilesForFolder(final File folder) {
		
		File[] listOfFiles = folder.listFiles();
		List<String> files = new ArrayList<String>();

		for (File file : listOfFiles) {
		    if (file.isFile()) {
		    	files.add(file.getName().toString());
		        System.out.println(files);
		    }
		}
		return files;
	}

	
	private static String getFileChecksum(MessageDigest digest, File file) throws IOException
	{
	    //Get file input stream for reading the file content
	    FileInputStream fis = new FileInputStream(file);
	     
	    //Create byte array to read data in chunks
	    byte[] byteArray = new byte[1024];
	    int bytesCount = 0; 
	      
	    //Read file data and update in message digest
	    while ((bytesCount = fis.read(byteArray)) != -1) {
	        digest.update(byteArray, 0, bytesCount);
	    };
	     
	    //close the stream; We don't need it now.
	    fis.close();
	     
	    //Get the hash's bytes
	    byte[] bytes = digest.digest();
	     
	    //This bytes[] has bytes in decimal format;
	    //Convert it to hexadecimal format
	    StringBuilder sb = new StringBuilder();
	    for(int i=0; i< bytes.length ;i++)
	    {
	        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	    }
	     
	    //return complete hash
	   return sb.toString();
	}
	
}
