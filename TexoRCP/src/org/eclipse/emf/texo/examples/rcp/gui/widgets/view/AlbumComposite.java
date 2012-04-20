package org.eclipse.emf.texo.examples.rcp.gui.widgets.view;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;

public class AlbumComposite extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public AlbumComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(3, false));
		
		Label lblName = new Label(this, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		lblName.setText("Name");
		
		Label lblReleasedText = new Label(this, SWT.NONE);
		lblReleasedText.setText("was released at");
		
		Label lblReleased = new Label(this, SWT.NONE);
		lblReleased.setText("releaseDate");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
