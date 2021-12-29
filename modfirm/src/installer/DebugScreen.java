package installer;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;

public class DebugScreen {
	protected Shell shlDebug;
	private Text text;
	private Shell shell;
	private DebugScreen debugScreen;
	private MainWindow mainWindow;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DebugScreen window = new DebugScreen();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shlDebug = new Shell( SWT.CLOSE | SWT.TITLE | SWT.MIN );
		
		shlDebug.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				shlDebug.setVisible(false);
				MainWindow mainWindow = new MainWindow();
				mainWindow.open();
			}
		});
		shlDebug.setSize(450, 300);
		shlDebug.setText("Debug");
		
		text = new Text(shlDebug, SWT.BORDER | SWT.V_SCROLL);
		text.setEditable(false);
		text.setBounds(10, 31, 247, 185);
		
		Label lblLogs = new Label(shlDebug, SWT.NONE);
		lblLogs.setBounds(10, 10, 55, 15);
		lblLogs.setText("Logs:");
		
		Button btnOpenLogsFolder = new Button(shlDebug, SWT.NONE);
		btnOpenLogsFolder.setBounds(31, 226, 105, 25);
		btnOpenLogsFolder.setText("Open Logs Folder");
		
		Button btnOpenModsFolder = new Button(shlDebug, SWT.NONE);
		btnOpenModsFolder.setBounds(298, 226, 105, 25);
		btnOpenModsFolder.setText("Open Mods Folder");
		
		Button btnCheckForUpdates = new Button(shlDebug, SWT.NONE);
		btnCheckForUpdates.setBounds(298, 195, 105, 25);
		btnCheckForUpdates.setText("Check for Updates");
		
		Label label = new Label(shlDebug, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(267, 10, 2, 241);
		
		Button btnLogInstallation = new Button(shlDebug, SWT.NONE);
		btnLogInstallation.setBounds(142, 226, 95, 25);
		btnLogInstallation.setText("Log Installation");
		
		Label lblYouAreRunning = new Label(shlDebug, SWT.WRAP);
		lblYouAreRunning.setAlignment(SWT.CENTER);
		lblYouAreRunning.setBounds(298, 95, 105, 15);
		lblYouAreRunning.setText("You are running:");
		
		Label lblVForx = new Label(shlDebug, SWT.CENTER);
		lblVForx.setBounds(298, 116, 105, 15);
		lblVForx.setText("v1 for 1.18.x");
		
		Label lblVisitOnGithub = new Label(shlDebug, SWT.CENTER);
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
		lblVisitOnGithub.setBounds(298, 137, 105, 15);
		lblVisitOnGithub.setText("Visit on Github");
		
		Label lblModfirm = new Label(shlDebug, SWT.CENTER);
		lblModfirm.setFont(SWTResourceManager.getFont("Bahnschrift", 25, SWT.BOLD));
		lblModfirm.setBounds(277, 10, 149, 40);
		lblModfirm.setText("MODFIRM");
		
		Label lblClientModUpdater = new Label(shlDebug, SWT.WRAP);
		lblClientModUpdater.setText("Client mod updater for HighSky by NoThrottle");
		lblClientModUpdater.setAlignment(SWT.CENTER);
		lblClientModUpdater.setBounds(287, 56, 128, 33);

		//Center the Window
		Monitor primary = display.getPrimaryMonitor();
	    Rectangle bounds = primary.getBounds();
	    Rectangle rect = shlDebug.getBounds();
	    int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    shlDebug.setLocation(x, y);
		
		shlDebug.open();
		shlDebug.layout();
		while (!shlDebug.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	//Hide window when closed.
	public void close() {
		shell.close();	
	}
}
