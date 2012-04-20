package org.eclipse.emf.texo.examples.rcp.gui.widgets.edit;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.emf.texo.examples.rcp.music.Album;
import org.eclipse.emf.texo.examples.rcp.util.Utils;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class AlbumEditComposite extends Composite {
	private Text txtName;
	private DateTime dtReleaseDate;
	private Combo cRating;
	private List genreList;
	private List songList;

	private DataBindingContext bindingContext;
	private TableViewer viewer;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public AlbumEditComposite(Composite parent, int style) {
		super(parent, style);
		bindingContext = new DataBindingContext();
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

		dtReleaseDate = new DateTime(this, SWT.BORDER);
		dtReleaseDate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Label lblRating = new Label(this, SWT.NONE);
		lblRating.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblRating.setText("rating");

		cRating = new Combo(this, SWT.NONE);
		cRating.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		Group grpRatings = new Group(this, SWT.NONE);
		grpRatings.setText("ratings");
		grpRatings.setLayout(new GridLayout(1, false));
		GridData gd_grpRatings = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 2, 1);
		gd_grpRatings.heightHint = 100;
		grpRatings.setLayoutData(gd_grpRatings);

		TableViewer viewer = new TableViewer(grpRatings);
		viewer.setContentProvider(new ArrayContentProvider());
		viewer.setLabelProvider(new RatingsLabelProvider());
		viewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		Button btnAddRating = new Button(grpRatings, SWT.NONE);
		btnAddRating.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		btnAddRating.setText("add Rating");

		Group grpGenres = new Group(this, SWT.NONE);
		grpGenres.setLayout(new GridLayout(1, false));
		GridData gd_grpGenres = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 2, 1);
		gd_grpGenres.heightHint = 100;
		grpGenres.setLayoutData(gd_grpGenres);
		grpGenres.setText("genres");

		genreList = new List(grpGenres, SWT.BORDER);
		genreList.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.keyCode == SWT.DEL) {
					System.out.println("delete the selected item");
				}
			}
		});
		genreList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,
				2, 1));

		Button btnAddGenre = new Button(grpGenres, SWT.NONE);
		btnAddGenre.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		btnAddGenre.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// cGenre.getSelectionIndex();
				// genreList.add();
			}
		});
		btnAddGenre.setText("add Genre");

		Group grpSongs = new Group(this, SWT.NONE);
		grpSongs.setLayout(new GridLayout(1, false));
		GridData gd_grpSongs = new GridData(SWT.FILL, SWT.CENTER, true, false,
				2, 1);
		gd_grpSongs.heightHint = 100;
		grpSongs.setLayoutData(gd_grpSongs);
		grpSongs.setText("songs");

		songList = new List(grpSongs, SWT.BORDER);
		songList.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				2, 1));

		Button btnAddSong = new Button(grpSongs, SWT.NONE);
		btnAddSong.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		btnAddSong.setText("add Song");

	}

	public void setAlbum(Album album) {
		bindingContext.bindValue(
				SWTObservables.observeText(txtName, SWT.Modify),
				PojoObservables.observeValue(album, "name"));
		bindingContext.bindValue(
				WidgetProperties.selection().observe(dtReleaseDate),
				PojoObservables.observeValue(album, "releaseDate"));
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	class RatingsLabelProvider extends LabelProvider implements
			ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			return "";
		}

		public Image getColumnImage(Object obj, int index) {
//			return getImage(obj);
			return Utils.getImage(getText(obj));
		}

		public Image getImage(Object obj) {
			return PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}
	}
}