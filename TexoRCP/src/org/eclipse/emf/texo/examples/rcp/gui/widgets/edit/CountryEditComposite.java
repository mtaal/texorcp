package org.eclipse.emf.texo.examples.rcp.gui.widgets.edit;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.emf.texo.examples.rcp.music.Country;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class CountryEditComposite extends Composite {
	private Text txtName;
	private DataBindingContext bindingContext;
	private Combo cCode;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CountryEditComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(2, false));
		bindingContext = new DataBindingContext();
		
		cCode = new Combo(this, SWT.NONE);
		cCode.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		txtName = new Text(this, SWT.BORDER);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
	}
	
	public void setCountry(Country country) {
		bindingContext.bindValue(SWTObservables.observeSelection(cCode),
				PojoObservables.observeValue(country, "code"));
		bindingContext.bindValue(SWTObservables.observeText(txtName, SWT.Modify),
				PojoObservables.observeValue(country, "name"));
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}