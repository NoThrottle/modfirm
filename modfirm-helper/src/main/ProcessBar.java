package main;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class ProcessBar {

	protected static Shell shlApplicationName = new Shell();


	public static void main(String[] args) {
		try {
			ProcessBar window = new ProcessBar();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {
		Display display = Display.getDefault();
//		prelaunch();
		smallContents();
		shlApplicationName.open();
		shlApplicationName.layout();
		while (!shlApplicationName.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	Label lblGeneratingWhat = new Label(shlApplicationName, SWT.NONE);
	static ProgressBar progressBar = new ProgressBar(shlApplicationName, SWT.NONE);
	Button btnCancel = new Button(shlApplicationName, SWT.NONE);
	Text text = new Text(shlApplicationName, SWT.BORDER | SWT.V_SCROLL);
	
	Button btnLogs = new Button(shlApplicationName, SWT.NONE);
	private boolean logs = false;

	
	public static void updateBar(
			int min,
			int max,
			boolean checkfornext,
			int min2,
			int max2
			// no point in having more
			) {
		
		int sum;
		
		if (!checkfornext) {
			min2 = 0;
			max2 = 0;
		}
		
		sum = (max + max2) - (min + min2);
		
		progressBar.setSelection(sum);
	}
	
	
	private void prelaunch() {
		
		launch();
		
		btnLogs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				logs = !logs;
				launch();
			}
		});
		
	}
	
	private void launch() {
		
		shlApplicationName.setText("Application Name");
		
		if (logs) {
			bigSizes();
		}else {
			smallContents();
		}	
		
	}
	
	private void bigSizes() {
		
		shlApplicationName.setSize(450, 247);

		lblGeneratingWhat.setText("Generating Whatdog?");

		progressBar.setBounds(10, 31, 414, 29);

		btnCancel.setBounds(349, 173, 75, 25);

		text.setVisible(true);
		text.setEditable(false);
		text.setBounds(10, 66, 333, 132);
		
		btnLogs.setBounds(349, 142, 75, 25);
		
		
	}
	
	private void smallContents() {
		
		shlApplicationName.setSize(450, 138);
		
		lblGeneratingWhat.setBounds(10, 10, 414, 15);
		lblGeneratingWhat.setText("Generating What?");
		
		progressBar.setBounds(10, 31, 414, 29);
		
		btnCancel.setBounds(349, 66, 75, 25);
		btnCancel.setText("Cancel");
		
		text.setVisible(false);

		btnLogs.setBounds(268, 66, 75, 25);
		btnLogs.setText("Logs");
		


	}
}
