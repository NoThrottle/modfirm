package installer;

import java.io.File;

import javax.imageio.ImageIO;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.DisposeEvent;

public class MainWindow {

	protected Shell shlHighskyModpackUpdate;
	Runtime rt = Runtime.getRuntime();
	private Text text;
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			MainWindow window = new MainWindow();
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
	    Rectangle rect = shlHighskyModpackUpdate.getBounds();
	    int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    shlHighskyModpackUpdate.setLocation(x, y);
	    
	    Label lblFetchingVersion = new Label(shlHighskyModpackUpdate, SWT.NONE);
	    lblFetchingVersion.setText("Fetching Version...");//before
	    lblFetchingVersion.setAlignment(SWT.CENTER);
	    lblFetchingVersion.setBounds(27, 137, 117, 15);
	    
	    Label lblGetNewVersion = new Label(shlHighskyModpackUpdate, SWT.NONE);
	    lblGetNewVersion.setText("Fetching Version...");//before
	    lblGetNewVersion.setAlignment(SWT.CENTER);
	    lblGetNewVersion.setBounds(27, 182, 117, 15);

	    //Launch
		shlHighskyModpackUpdate.open();
		shlHighskyModpackUpdate.layout();
		
		//Do Updates Here
	    lblFetchingVersion.setText(UpdateManager.ClientVersion("readable"));//after
		lblGetNewVersion.setText(UpdateManager.ServerVersion("readable"));//after
		
		Button btnVerifyMods = new Button(shlHighskyModpackUpdate, SWT.NONE);
		btnVerifyMods.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				
				
				
			}
		});
		btnVerifyMods.setBounds(178, 226, 75, 25);
		btnVerifyMods.setText("Verify Mods");
		
		
		while (!shlHighskyModpackUpdate.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlHighskyModpackUpdate = new Shell( SWT.CLOSE | SWT.TITLE | SWT.MIN );
		shlHighskyModpackUpdate.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				rt.exit(0);
			}
		});
		
		shlHighskyModpackUpdate.setVisible(true);
		shlHighskyModpackUpdate.setSize(450, 300);
		shlHighskyModpackUpdate.setText("HighSky Modpack Update");
		
		Label lblYourCurrentVersion = new Label(shlHighskyModpackUpdate, SWT.NONE);
		lblYourCurrentVersion.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblYourCurrentVersion.setAlignment(SWT.CENTER);
		lblYourCurrentVersion.setBounds(12, 116, 145, 15);
		lblYourCurrentVersion.setText("Your Current Version:");
		
		Label lblNewestVersion = new Label(shlHighskyModpackUpdate, SWT.NONE);
		lblNewestVersion.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblNewestVersion.setAlignment(SWT.CENTER);
		lblNewestVersion.setText("Newest Version:");
		lblNewestVersion.setBounds(27, 161, 117, 15);
		
		Button btnDebug = new Button(shlHighskyModpackUpdate, SWT.NONE);
		btnDebug.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shlHighskyModpackUpdate.setVisible(false);
				DebugScreen debugscreen = new DebugScreen();
				debugscreen.open();
			}
		});
		btnDebug.setBounds(349, 226, 75, 25);
		btnDebug.setText("Debug");
		
		text = new Text(shlHighskyModpackUpdate, SWT.BORDER | SWT.V_SCROLL);
		text.setEditable(false);
		text.setBounds(178, 31, 246, 189);
		
		Label label = new Label(shlHighskyModpackUpdate, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(168, 10, 2, 241);
		
		Label lblNewLabel = new Label(shlHighskyModpackUpdate, SWT.NONE);
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setVisible(true);
		lblNewLabel.setImage(SWTResourceManager.getImage(MainWindow.class, "/installer/HSMC(1).png"));
		lblNewLabel.setBounds(33, 10, 100, 100);
		
		Button btnInstall = new Button(shlHighskyModpackUpdate, SWT.NONE);
		btnInstall.setBounds(47, 226, 75, 25);
		btnInstall.setText("Install");
		
		Label lblNewLabel_1 = new Label(shlHighskyModpackUpdate, SWT.NONE);
		lblNewLabel_1.setBounds(178, 10, 55, 15);
		lblNewLabel_1.setText("Changes:");

	}
}


