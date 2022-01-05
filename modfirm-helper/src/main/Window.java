package main;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import net.harawata.appdirs.AppDirs;
import net.harawata.appdirs.AppDirsFactory;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DirectoryDialog;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.wb.swt.SWTResourceManager;

public class Window {

	protected Shell shlModfirmHelper;
	private static String retpath;
	private static String devpath;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		
		//check if paths files exist
		
		
		
		try {
			Window window = new Window();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		
		//Center the Window
		Monitor primary = display.getPrimaryMonitor();
	    Rectangle bounds = primary.getBounds();
	    Rectangle rect = shlModfirmHelper.getBounds();
	    int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    shlModfirmHelper.setLocation(x, y);
		
		shlModfirmHelper.open();
		shlModfirmHelper.layout();
		while (!shlModfirmHelper.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	String modspath = GetClientModPath("mods").toString();
	String outputpath = GetClientModPath(".mf").toString();
	private Text text2;
	
	protected void createContents() {
		shlModfirmHelper = new Shell( SWT.CLOSE | SWT.MIN | SWT.TITLE );
		shlModfirmHelper.setSize(450, 288);
		shlModfirmHelper.setText("Modfirm Helper");
		
		Button btnBrowse = new Button(shlModfirmHelper, SWT.NONE);
		btnBrowse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			    DirectoryDialog dialog = new DirectoryDialog(shlModfirmHelper);
			    dialog.setFilterPath(GetClientModPath("mods").toString());
			    modspath = dialog.open();
			    System.out.println("RESULT=" + modspath);
			    
			    if (modspath == null) {
			    	modspath = GetClientModPath("mods").toString();
			    }
			    
			   retpath = modspath;
			    text.setText(modspath);
			}
		});
		btnBrowse.setBounds(349, 107, 75, 25);
		btnBrowse.setText("Browse");
		
		text = new Text(shlModfirmHelper, SWT.BORDER);
		text.setText(modspath);
		text.setBounds(10, 107, 333, 25);
		
		Label lblModsFolderPath = new Label(shlModfirmHelper, SWT.NONE);
		lblModsFolderPath.setBounds(10, 86, 103, 15);
		lblModsFolderPath.setText("Mods Folder Path:");
		
		Label lblOutputPath = new Label(shlModfirmHelper, SWT.NONE);
		lblOutputPath.setBounds(10, 138, 75, 15);
		lblOutputPath.setText("Output Path:");
		
		text2 = new Text(shlModfirmHelper, SWT.BORDER);
		text2.setText(outputpath);
		text2.setBounds(10, 159, 333, 25);
		
		Button btnBrowse2 = new Button(shlModfirmHelper, SWT.NONE);
		btnBrowse2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				DirectoryDialog dialog = new DirectoryDialog(shlModfirmHelper);
			    dialog.setFilterPath(GetClientModPath(".mf").toString());
			    outputpath = dialog.open();
			    System.out.println("RESULT=" + outputpath);
			    
			    if (outputpath == null) {
			    	outputpath = GetClientModPath(".mf").toString();
			    }
			    
			    devpath = outputpath;
			    text2.setText(outputpath);
			}
		});
		btnBrowse2.setText("Browse");
		btnBrowse2.setBounds(349, 159, 75, 25);
		
		Label lblGeneratesModsList = new Label(shlModfirmHelper, SWT.WRAP);
		lblGeneratesModsList.setBounds(224, 21, 200, 30);
		lblGeneratesModsList.setText("Generates Mods List and Hashes from a mods folder.");
		
		Label label = new Label(shlModfirmHelper, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(10, 73, 414, 2);
		
		Label lblHelper = new Label(shlModfirmHelper, SWT.NONE);
		lblHelper.setAlignment(SWT.CENTER);
		lblHelper.setBounds(45, 45, 144, 15);
		lblHelper.setText("Helper");
		
		Label lblJ = new Label(shlModfirmHelper, SWT.NONE);
		lblJ.setFont(SWTResourceManager.getFont("Bahnschrift", 25, SWT.BOLD));
		lblJ.setBounds(45, 10, 144, 41);
		lblJ.setText("MODFIRM");
		
		Label label_1 = new Label(shlModfirmHelper, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(10, 200, 414, 2);
		
		Button btnGenerateAll = new Button(shlModfirmHelper, SWT.NONE);
		btnGenerateAll.setBounds(349, 213, 75, 25);
		btnGenerateAll.setText("Generate All");
		
		Button btnGenerateHashes = new Button(shlModfirmHelper, SWT.NONE);
		btnGenerateHashes.setBounds(10, 213, 98, 25);
		btnGenerateHashes.setText("Generate Hashes");
		
		Button btnGenerateList = new Button(shlModfirmHelper, SWT.NONE);
		btnGenerateList.setBounds(114, 213, 80, 25);
		btnGenerateList.setText("Generate List");
		
		Label lblVisitOnGithub = new Label(shlModfirmHelper, SWT.NONE);
		Display display = Display.getDefault();
		org.eclipse.swt.graphics.Cursor cursor = new Cursor(display, SWT.CURSOR_HAND);
	    lblVisitOnGithub.setCursor(cursor);
		lblVisitOnGithub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
		        Desktop desk = Desktop.getDesktop();
		        try {
					desk.browse(new URI("https://github.com/NoThrottle/modfirm"));
					//Don't change this, please.
				} catch (IOException | URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		});
		lblVisitOnGithub.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		lblVisitOnGithub.setBounds(224, 52, 103, 15);
		lblVisitOnGithub.setText("Visit on Github.");

	}

	public static Path GetClientModPath(String what) {
		
		AppDirs appDirs = AppDirsFactory.getInstance();
		
		if (what == "mods") {
			Path path = Paths.get(appDirs.getUserDataDir(".minecraft", "mods", null, true));
			return path;
		} else if (what == ".mf") {
			Path path = Paths.get(appDirs.getUserDataDir(".modfirm", "dev", null, true));
			new File(path.toString()).mkdirs();//create folder if it doesnt exist.
			return path;
		} else if (what == "config") {
			Path path = Paths.get(appDirs.getUserDataDir(".modfirm", null, null, true));
			new File(path.toString()).mkdirs();//create folder if it doesnt exist.
			return path;
		} else {
			return null;
		}

	}
	
	private void WriteToTxt() {
		try {
		      File myObj = new File("paths.txt");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists. Reading that instead");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	//Complete
	private boolean CheckIfConfigExists() {
		File f = new File(GetClientModPath("config").toString() + "/config.txt");
		if(f.exists()) { 
		   return true;
		} else {
			return false;
		}
	}
	
	
	//-----PUBLIC-RETURNS------
	
	public static String GetModPath() {
		return retpath;
	}
	
	public static String GetDevPath() {
		return devpath;
	}
}
