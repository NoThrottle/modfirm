package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.io.*;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Processing {

	static String path = Window.Path();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateFileList();
	}

	
	public static void GenerateFileList() {
//		Window.
		
	}
	
	private static List<String> listFilesForFolder(final File folder) {
		
		File[] listOfFiles = folder.listFiles();
		List<String> files = new ArrayList<String>();

		for (File file : listOfFiles) {
		    if (file.isFile()) {
		    	files.add(file.getName().toString());
//		        System.out.println(files);
		    }
		}
		return files;
	}
		
}
