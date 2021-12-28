package installer;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class IncorrectInstallation {

	protected Shell shlCorrectingInstallation;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			IncorrectInstallation window = new IncorrectInstallation();
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
		shlCorrectingInstallation.open();
		shlCorrectingInstallation.layout();
		while (!shlCorrectingInstallation.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlCorrectingInstallation = new Shell();
		shlCorrectingInstallation.setSize(311, 235);
		shlCorrectingInstallation.setText("Correcting Installation");
		
		Label lblYouRanThe = new Label(shlCorrectingInstallation, SWT.WRAP);
		lblYouRanThe.setAlignment(SWT.CENTER);
		lblYouRanThe.setBounds(10, 10, 274, 37);
		lblYouRanThe.setText("You ran the .jar file outside your .mods folder. \r\nDon't worry, we will install it for you.");
		
		ProgressBar progressBar = new ProgressBar(shlCorrectingInstallation, SWT.SMOOTH);
		progressBar.setSelection(51);
		progressBar.setBounds(71, 53, 213, 15);
		
		text = new Text(shlCorrectingInstallation, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		text.setBounds(10, 74, 274, 112);
		
		Label lblLogs = new Label(shlCorrectingInstallation, SWT.NONE);
		lblLogs.setBounds(10, 53, 55, 15);
		lblLogs.setText("Logs:");

	}
}
