package installer;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class VerifyMods {

	protected Shell shlVerifyMods;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			VerifyMods window = new VerifyMods();
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
		shlVerifyMods.open();
		shlVerifyMods.layout();
		while (!shlVerifyMods.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlVerifyMods = new Shell();
		shlVerifyMods.setSize(450, 265);
		shlVerifyMods.setText("Verify Mods");
		
		ProgressBar progressBar = new ProgressBar(shlVerifyMods, SWT.NONE);
		progressBar.setBounds(10, 31, 414, 23);
		
		Label lblComparingYourmods = new Label(shlVerifyMods, SWT.NONE);
		lblComparingYourmods.setBounds(10, 10, 414, 15);
		lblComparingYourmods.setText("Comparing your .mods folder to mod list from the server of a similar version.");
		
		Label lblVerified = new Label(shlVerifyMods, SWT.NONE);
		lblVerified.setBounds(298, 60, 126, 15);
		lblVerified.setText("Verified: 0");
		
		Label lblMissing = new Label(shlVerifyMods, SWT.NONE);
		lblMissing.setBounds(298, 81, 126, 15);
		lblMissing.setText("Missing: 0");
		
		Label lblWrongHash = new Label(shlVerifyMods, SWT.NONE);
		lblWrongHash.setBounds(298, 102, 126, 15);
		lblWrongHash.setText("Wrong Hash: 0");
		
		Label lblOtherMods = new Label(shlVerifyMods, SWT.NONE);
		lblOtherMods.setBounds(298, 123, 126, 15);
		lblOtherMods.setText("Other Mods: 0");
		
		text = new Text(shlVerifyMods, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		text.setEditable(false);
		text.setBounds(10, 60, 282, 156);
		
		Button btnCancel = new Button(shlVerifyMods, SWT.NONE);
		btnCancel.setBounds(349, 191, 75, 25);
		btnCancel.setText("Cancel");

	}

}
