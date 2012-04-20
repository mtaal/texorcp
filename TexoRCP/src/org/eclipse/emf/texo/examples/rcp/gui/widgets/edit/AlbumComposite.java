package org.eclipse.emf.texo.examples.rcp.gui.widgets.edit;

import org.eclipse.emf.texo.examples.rcp.music.Album;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

public class AlbumComposite extends Composite {
	private Text txtName;
	private List listGenres;

	private Album album;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public AlbumComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(2, false));

		Label lblName = new Label(this, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		lblName.setText("Name");

		txtName = new Text(this, SWT.BORDER);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		Label lblReleaseDate = new Label(this, SWT.NONE);
		lblReleaseDate.setText("release Date");

		DateTime dtReleaseDate = new DateTime(this, SWT.BORDER);
		dtReleaseDate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Label lblRating = new Label(this, SWT.NONE);
		lblRating.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblRating.setText("rating");

		Combo cRating = new Combo(this, SWT.NONE);
		cRating.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		Group grpGenres = new Group(this, SWT.NONE);
		grpGenres.setLayout(new GridLayout(1, false));
		grpGenres.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 2, 1));
		grpGenres.setText("genres");

		listGenres = new List(grpGenres, SWT.BORDER);
		listGenres.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.keyCode == SWT.DEL) {
					System.out.println("delete the selected item");
				}
			}
		});
		listGenres.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,
				2, 1));

		Button btnAddGenre = new Button(grpGenres, SWT.NONE);
		btnAddGenre.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		btnAddGenre.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// cGenre.getSelectionIndex();
				// listGenres.add();
			}
		});
		btnAddGenre.setText("add Genre");

		Group grpSongs = new Group(this, SWT.NONE);
		grpSongs.setLayout(new GridLayout(1, false));
		grpSongs.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				2, 1));
		grpSongs.setText("Songs");

		List list = new List(grpSongs, SWT.BORDER);
		list.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		Button btnAddSong = new Button(grpSongs, SWT.NONE);
		btnAddSong.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnAddSong.setText("add Song");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}