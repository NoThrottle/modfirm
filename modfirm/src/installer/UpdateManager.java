package installer;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import installer.networking.HttpRequestLiveTest;
import net.harawata.appdirs.AppDirs;
import net.harawata.appdirs.AppDirsFactory;


public class UpdateManager {

	
	//Debug Only----
	public static void main(String[] args) {

		System.out.println(GetClientModPath(".mc"));
		System.out.println(ClientVersion("readable"));
		System.out.println(Changelog());
		
		
	}
	//Debug only-----
	
	
	
	
	//-----------PUBLIC-RETURNS------------
	public static String ClientVersion(String type) {
		return ProcessClientVersion(type);
	}
	public static String ServerVersion(String type) {

		return GetServerVersion(type);
	}	
	public static Boolean IsRunninginMods() {
		return CorrectInstallation();
	}
	public static String IntegrityCheck() {
		
		return APIKey;
	}
	public static String Changelog() {
		return GetChangelog();
	}

	
	
	//Statics for mod updates
	static Path ClientModPath = GetClientModPath("mods");
	static Path ClientMCPath = GetClientModPath(".mc");
	
	
	
	//-------------PROCESSING-------------
	//Complete
	private static String ProcessClientVersion(String type) {
		
		String version = "Unknown";
		String versioncode = "Unknown";
		String readable = "Unknown";
		
		//Check if the directory actually exists, else return error
		File f = new File(ClientModPath.toString());
		if (!f.isDirectory()) {
		   version = "Error 1"; //You haven't launched Minecraft with fabric installed.
			File g = new File(ClientMCPath.toString());
			if (!g.isDirectory()) {
				version = version + "A"; //Just improves the error depth, not an actual version. You don't have Minecraft Installed
				return version;
			} else {return version;}
		}
		
		
		//Check if version.txt exists. If yes, parse that instead, if no, continue		
		 try {
		      File myObj = new File(ClientModPath.toString() + "/version.txt");
		      try (Scanner myReader = new Scanner(myObj)) {
				while (myReader.hasNextLine()) {
					
					if (readable == "Unknown") {
					    readable = myReader.nextLine();
					} else {
						versioncode = myReader.nextLine();
					}
				    System.out.println(version + " " + versioncode); //logs
				  }
				  myReader.close();
			}
		    } catch (FileNotFoundException e) {
		      System.out.println("Version File not found."); //logs
		      version = "v1 for Patch 01"; //First version did not have version file.		
		      versioncode = "1";
		    }
			
			if (type == "readable") { //returns v1 for Patch 01
				return readable;
			} else if (type == "coded") {//returns an integer(as string)
				return versioncode;
			}
			
		 
		return "Unknown Error";
	}
	
	private static String GetChangelog() {
		
		String toreturn = null;
		
		try {
			toreturn = ValueFromSheet(getinfo.Info("_changelog")).toString();
			toreturn = toreturn.substring(2, toreturn.length()-2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return toreturn;
	}
	
//	private static Boolean VerifyCompleteMods() {
//		
//		
//		listFilesForFolder(ClientModPath.toFile()); //make to variable
//		GetServerModList();
//		//then compare to json from server
//				
//	      //compare
//	      if (VerifyCompleteMods() == true) {
//	    	  //log that everything is fine and complete
//	    	  return version;
//	      } else {
//	    	  version = "Missing Files";
//	    	  return version;
//	    	  //fetch missing mods list and ask the user if they want to update
//	      }
//	
//	      
//	      
//	      
//		return true;
//		
//	}
	
	//Complete
	private static String GetServerVersion(String type) {
		
		String version = "Fetching Version...";
		
		if (type == "readable") { //returns v1 for Patch 01
			try {
				version = ValueFromSheet(getinfo.Info("_versionNew_readable")).toString();
				version = version.substring(2, version.length()-2);
			} catch (IOException e) {
				e.printStackTrace();
				//logs
				version = "Error 23";
			}
		} else if (type == "coded") {//returns an integer(as string)
			try {
				version = ValueFromSheet(getinfo.Info("_versionNew_coded")).toString();
				version = version.substring(2, version.length()-2);
			} catch (IOException e) {
				e.printStackTrace();
				//logs
				version = "Error 23";
			}
		}
		
		return version;	
	}
	
	//Complete
	private static Boolean CorrectInstallation() {
		
		Path runpath = null;
		Path modpath = GetClientModPath("mods");
		Boolean iscorrect = null;
		
		try {
			File runpathfile = new File(UpdateManager.class.getProtectionDomain().getCodeSource().getLocation().toURI());
			runpath = runpathfile.toPath();
		} catch (URISyntaxException e) {
			// Log any errors
			e.printStackTrace();
		}
		
////		Debugging:
//		System.out.println(modpath);
//		System.out.println(runpath);
		
		if (modpath != runpath){
			iscorrect = false;
		} else {
			iscorrect = true;
		}
		
		return iscorrect;
	}
	
	
	
	//------------PRIVATE RETURNS-------------
	
	//Complete
	//I know this should be private returns but im lazy.
	public static Path GetClientModPath(String what) {
		
		AppDirs appDirs = AppDirsFactory.getInstance();
		
		if (what == "mods") {
			Path path = Paths.get(appDirs.getUserDataDir(".minecraft", "mods", null, true));
			return path;
		} else if (what == ".mc") {
			Path path = Paths.get(appDirs.getUserDataDir(".minecraft", null, null, true));
			return path;
		} else {
			return null;
		}

		//send process to log
	}
	
	//Complete
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
	
	//Complete (logs and debug)
    private static String SPREADSHEET_ID = getinfo.Info("_sheetID");
	private static String APIKey = getinfo.Info("_apiKey");;
	private static List ValueFromSheet(String range) throws IOException {
		
		List data = HttpRequestLiveTest.Request(SPREADSHEET_ID, range, APIKey);	
		System.out.println(data);//debug
		return data;
		
	}
	
	
	private static List<String> GetServerModList() {
		
		String fileId = "0BwwA4oUTeiV1UVNwOHItT0xfa2M";
		OutputStream outputStream = new ByteArrayOutputStream();
//		driveService.files().get(fileId)
//		    .executeMediaAndDownloadTo(outputStream);

		
		
		return null;
	}

}
