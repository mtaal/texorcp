package org.eclipse.emf.texo.examples.rcp.gui.widgets.edit;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.texo.examples.rcp.controller.Controller;
import org.eclipse.emf.texo.examples.rcp.music.Album;
import org.eclipse.emf.texo.examples.rcp.music.MusicPackage;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class AlbumEditComposite extends Composite {
	private Text txtName;
//	private DateTime dtReleaseDate;
//
//	private DataBindingContext bindingContext;
//	private TableViewer viewerRating;
//	private TableViewer viewerGenre;
//	private TableViewer viewerSongs;
//	private Text txtFirstName;
//	private Text txtLastName;
//	private Text txtCountryName;
//	private DateTime dtBirthday;
//	private ComboViewer cCode;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public AlbumEditComposite(Composite parent, int style) {
		super(parent, style);
//		bindingContext = new DataBindingContext();
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;
		gridLayout.horizontalSpacing = 0;
		gridLayout.marginHeight = 0;
		gridLayout.verticalSpacing = 0;
		setLayout(gridLayout);

		Group grpAlbum = new Group(this, SWT.NONE);
		grpAlbum.setLayout(new GridLayout(2, false));
		grpAlbum.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				2, 1));
		
//		Button btnNewButton = new Button(grpAlbum, SWT.NONE);
//		btnNewButton.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
////				System.out.println("Abum's artist country code = "+Controller.getAlbum().getArtist().getCountry().getCode());
////				System.out.println("artists first name = "+Controller.getAlbum().getArtist().getFirstName());
//				System.out.println("release Date: "+Controller.getAlbum().getReleaseDate());
//				System.out.println("albumns name: "+Controller.getAlbum().getName());
//			}
//		});
//		btnNewButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
//		btnNewButton.setText("checkData");
		
		
		Button button1 = new Button(parent, SWT.PUSH);
		button1.setText("Write model");
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				System.out.println(Controller.getAlbum().getName());
				System.out.println(Controller.getAlbum().getArtist().getFirstName());
			}
		});

		Button button2 = new Button(parent, SWT.PUSH);
		button2.setText("Change model");
		button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				System.out.println("before");
				System.out.println(Controller.getAlbum().getName());
//				System.out.println(Controller.getAlbum().getArtist().getFirstName());
//				System.out.println(Controller.getAlbum().getArtist().getLastName());
				String reversedTitle= new StringBuffer(Controller.getAlbum().getName()).reverse().toString();
				Controller.getAlbum().setName(reversedTitle);
				String reversedFirstName= new StringBuffer(Controller.getAlbum().getArtist().getFirstName()).reverse().toString();
				Controller.getAlbum().getArtist().setFirstName(reversedFirstName);
				String reversedLastName= new StringBuffer(Controller.getAlbum().getArtist().getLastName()).reverse().toString();
				Controller.getAlbum().getArtist().setLastName(reversedLastName);
				System.out.println("after");
				System.out.println(Controller.getAlbum().getName());
//				System.out.println(Controller.getAlbum().getArtist().getFirstName());
//				System.out.println(Controller.getAlbum().getArtist().getLastName());
			}
		});
		

		Label lblName = new Label(grpAlbum, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		lblName.setText("Name");

		txtName = new Text(grpAlbum, SWT.BORDER);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

//		Label lblReleaseDate = new Label(grpAlbum, SWT.NONE);
//		lblReleaseDate.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
//				false, 1, 1));
//		lblReleaseDate.setText("release Date");
//
//		dtReleaseDate = new DateTime(grpAlbum, SWT.BORDER);
//		dtReleaseDate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
//				false, 1, 1));
//
//		Group grpArtist = new Group(this, SWT.NONE);
//		grpArtist.setLayout(new GridLayout(2, false));
//		grpArtist.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
//				false, 2, 1));
//		grpArtist.setText("artist");
//
//		Label lblFirstName = new Label(grpArtist, SWT.NONE);
//		lblFirstName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
//				false, 1, 1));
//		lblFirstName.setText("first name");
//
//		txtFirstName = new Text(grpArtist, SWT.BORDER);
//		txtFirstName.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false,
//				1, 1));
//
//		Label lblLastName = new Label(grpArtist, SWT.NONE);
//		lblLastName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
//				false, 1, 1));
//		lblLastName.setText("last name");
//
//		txtLastName = new Text(grpArtist, SWT.BORDER);
//		txtLastName.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false,
//				1, 1));
//
//		Label lblBirthdate = new Label(grpArtist, SWT.NONE);
//		lblBirthdate.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
//				false, 1, 1));
//		lblBirthdate.setText("birthdate");
//
//		dtBirthday = new DateTime(grpArtist, SWT.BORDER);
//		dtBirthday.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
//				false, 1, 1));
//
//		Group grpCountry = new Group(grpArtist, SWT.NONE);
//		grpCountry.setLayout(new GridLayout(2, false));
//		grpCountry.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
//				false, 2, 1));
//		grpCountry.setText("country");
//
//		cCode = new ComboViewer(grpCountry, SWT.DROP_DOWN | SWT.READ_ONLY);
//		GridData gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 1,
//				1);
//		gridData.widthHint = 50;
//		cCode.getCombo().setLayoutData(gridData);
//		cCode.setContentProvider(new ArrayContentProvider());
//		cCode.setLabelProvider(new LabelProvider() {
//			public String getText(Object element) {
//				return (String) element;
//			};
//
////			public Image getImage(Object element) {
////				return Utils.getImage(Utils
////						.getCountryCodeFlag((String) element));
////			}
//		});
//
//		cCode.setInput(Utils.getCountryCodes());
//
//		txtCountryName = new Text(grpCountry, SWT.BORDER);
//		txtCountryName.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true,
//				false, 1, 1));
//
//		Group grpRatings = new Group(this, SWT.NONE);
//		grpRatings.setText("ratings");
//		grpRatings.setLayout(new GridLayout(1, false));
//		GridData gd_grpRatings = new GridData(SWT.FILL, SWT.CENTER, false,
//				false, 2, 1);
//		gd_grpRatings.heightHint = 100;
//		grpRatings.setLayoutData(gd_grpRatings);
//
//		viewerRating = new TableViewer(grpRatings);
//		viewerRating.setContentProvider(new ObservableListContentProvider());
//		viewerRating.setLabelProvider(new RatingsLabelProvider());
//		viewerRating.getTable().setLayoutData(
//				new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
//
//		Button btnAddRating = new Button(grpRatings, SWT.NONE);
//		btnAddRating.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
//				false, 1, 1));
//		btnAddRating.setText("add Rating");
//
//		Group grpGenres = new Group(this, SWT.NONE);
//		grpGenres.setLayout(new GridLayout(1, false));
//		GridData gd_grpGenres = new GridData(SWT.FILL, SWT.CENTER, false,
//				false, 2, 1);
//		gd_grpGenres.heightHint = 100;
//		grpGenres.setLayoutData(gd_grpGenres);
//		grpGenres.setText("genres");
//
//		viewerGenre = new TableViewer(grpGenres);
//		viewerGenre.setContentProvider(new ObservableListContentProvider());
//		viewerGenre.setLabelProvider(new GenreLabelProvider());
//		viewerGenre.getTable().setLayoutData(
//				new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
//
//		Button btnAddGenre = new Button(grpGenres, SWT.NONE);
//		btnAddGenre.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
//				false, 1, 1));
//		btnAddGenre.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				// cGenre.getSelectionIndex();
//				// genreList.add();
//			}
//		});
//		btnAddGenre.setText("add Genre");
//
//		Group grpSongs = new Group(this, SWT.NONE);
//		grpSongs.setLayout(new GridLayout(1, false));
//		GridData gd_grpSongs = new GridData(SWT.FILL, SWT.CENTER, true, false,
//				2, 1);
//		gd_grpSongs.heightHint = 100;
//		grpSongs.setLayoutData(gd_grpSongs);
//		grpSongs.setText("songs");
//
//		viewerSongs = new TableViewer(grpSongs);
//		viewerSongs.setContentProvider(new ObservableListContentProvider());
//		viewerSongs.setLabelProvider(new SongLabelProvider());
//		viewerSongs.getTable().setLayoutData(
//				new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
//
//		Button btnAddSong = new Button(grpSongs, SWT.NONE);
//		btnAddSong.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
//				false, 1, 1));
//		btnAddSong.setText("add Song");

	}

	public void setAlbum(Album album) {
		// TODO CORRECT BINDING
		if (album == null) {
			return;
		}
//		WritableValue value = new WritableValue();
//		value.setValue(album);
//		bindingContext.bindValue(
//				SWTObservables.observeText(txtName, SWT.Modify),
//				PojoObservables.observeValue(album, "name"));
		
//		FeaturePath feature = FeaturePath.fromList(MusicPackage.Literals.ALBUM__NAME);
//		bindingContext.bindValue(
//				WidgetProperties.text(SWT.Modify).observe(txtName),
//				EMFProperties.value(MusicPackage.Literals.ALBUM__NAME).observe(album));
		
//		bindingContext.bindValue(
//				WidgetProperties.selection().observe(dtReleaseDate),
//				PojoObservables.observeValue(album, "releaseDate"));
//		// bind artist stuff
//
//		bindingContext.bindValue(
//				SWTObservables.observeText(txtFirstName, SWT.Modify),
//				PojoObservables.observeValue(album.getArtist(), "firstName"));
//
//		bindingContext.bindValue(
//				SWTObservables.observeText(txtLastName, SWT.Modify),
//				PojoObservables.observeValue(album.getArtist(), "lastName"));
//
//		bindingContext.bindValue(
//				WidgetProperties.selection().observe(dtBirthday),
//				PojoObservables.observeValue(album.getArtist(), "birthDate"));
//
//		bindingContext.bindValue(SWTObservables.observeText(txtCountryName,
//				SWT.Modify), PojoObservables.observeValue(album.getArtist()
//				.getCountry(), "name"));
//
//		// bind the country code...
//		bindingContext.bindValue(SWTObservables.observeSelection(cCode
//				.getCombo()), PojoObservables.observeValue(album.getArtist()
//				.getCountry(), "code"));
//		// bind table and lists.
//		WritableList inputRating = new WritableList(album.getRatings(),
//				Rating.class);
//		viewerRating.setInput(inputRating);
//
//		WritableList inputGenre = new WritableList(album.getGenres(),
//				Genre.class);
//		viewerGenre.setInput(inputGenre);
//
//		WritableList inputSongs = new WritableList(album.getSongs(), Song.class);
//		viewerSongs.setInput(inputSongs);
		System.out.println("Databinding done...");
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

//	class RatingsLabelProvider extends LabelProvider implements
//			ITableLabelProvider {
//		public String getColumnText(Object obj, int index) {
//			return "";
//		}
//
//		public Image getColumnImage(Object obj, int index) {
//			Rating rating = Enum.valueOf(Rating.class, getText(obj));
//			return Utils.getImage(Utils.getRating(rating));
//		}
//
//		public Image getImage(Object obj) {
//			return PlatformUI.getWorkbench().getSharedImages()
//					.getImage(ISharedImages.IMG_OBJ_ELEMENT);
//		}
//	}
//
//	class GenreLabelProvider extends LabelProvider implements
//			ITableLabelProvider {
//		public String getColumnText(Object obj, int index) {
//			return ((Genre) obj).getName();
//		}
//
//		public Image getColumnImage(Object obj, int index) {
//			return null; // getImage(obj);
//		}
//
//		public Image getImage(Object obj) {
//			return PlatformUI.getWorkbench().getSharedImages()
//					.getImage(ISharedImages.IMG_OBJ_ELEMENT);
//		}
//	}
//
//	class SongLabelProvider extends LabelProvider implements
//			ITableLabelProvider {
//		public String getColumnText(Object obj, int index) {
//			Song s = ((Song) obj);
//			return String.format("%d - %s", s.getTrack(), s.getName());
//		}
//
//		public Image getColumnImage(Object obj, int index) {
//			return null; // getImage(obj);
//		}
//
//		public Image getImage(Object obj) {
//			return PlatformUI.getWorkbench().getSharedImages()
//					.getImage(ISharedImages.IMG_OBJ_ELEMENT);
//		}
//	}
}