package org.eclipse.emf.texo.examples.rcp.gui.widgets.edit;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;

public class CountryComposite extends Composite {
	private Text txtname;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CountryComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(2, false));
		
		Combo cCode = new Combo(this, SWT.NONE);
		cCode.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		txtname = new Text(this, SWT.BORDER);
		txtname.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
