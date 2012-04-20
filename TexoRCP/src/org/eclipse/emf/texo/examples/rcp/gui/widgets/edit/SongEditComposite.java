package org.eclipse.emf.texo.examples.rcp.gui.widgets.edit;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.texo.examples.rcp.music.Song;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

public class SongEditComposite extends Composite {
	private DataBindingContext bindingContext;
	private Text txtName;
	private Spinner spTrack;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public SongEditComposite(Composite parent, int style) {
		super(parent, style);
		bindingContext = new DataBindingContext();
		
		setLayout(new GridLayout(2, false));

		spTrack = new Spinner(this, SWT.BORDER);

		txtName = new Text(this, SWT.BORDER);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
	}
	
	public void setSong(Song song) {
		bindingContext.bindValue(SWTObservables.observeText(txtName, SWT.Modify),
				PojoObservables.observeValue(song, "name"));
		bindingContext.bindValue(SWTObservables.observeSelection(spTrack),
				PojoObservables.observeValue(song, "track"));

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}