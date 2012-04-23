package org.eclipse.emf.texo.examples.rcp.views;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.texo.examples.rcp.binding.BindingFactory;
import org.eclipse.emf.texo.examples.rcp.controller.Controller;
import org.eclipse.emf.texo.examples.rcp.music.Album;
import org.eclipse.emf.texo.examples.rcp.music.Genre;
import org.eclipse.emf.texo.examples.rcp.music.MusicFactory;
import org.eclipse.emf.texo.examples.rcp.music.MusicPackage;
import org.eclipse.emf.texo.examples.rcp.music.Rating;
import org.eclipse.emf.texo.examples.rcp.music.Song;
import org.eclipse.emf.texo.examples.rcp.util.Utils;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISaveablePart2;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

public class EditorView extends ViewPart implements ISaveablePart2 {
	public static final String ID = "org.eclipse.emf.texo.examples.rcp.views.editorview";
	private Text name;
	private DateTime releaseDate;
	private Text artistFirstName;
	private Text artistLastName;
	private Adapter adapter;

	private BindingFactory bf = BindingFactory.getInstance();

	public EditorView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		MusicFactory.eINSTANCE.eClass();
		adapter = new AdapterImpl() {

			public void notifyChanged(Notification notification) {
				super.notifyChanged(notification);
				System.out.println("View (1) - model has changed!!!");
			}
		};
		final Album album = Controller.getAlbum();
		album.eAdapters().add(adapter);

		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;
		gridLayout.horizontalSpacing = 0;
		gridLayout.marginHeight = 0;
		gridLayout.verticalSpacing = 0;
		parent.setLayout(gridLayout);

		Button button1 = new Button(parent, SWT.PUSH);
		button1.setText("Write model to console");
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				System.out.println(album.getName());
				System.out.println(album.getReleaseDate());
				System.out.println(album.getArtist().getFirstName());
				System.out.println(album.getArtist().getCountry().getCode());
			}
		});

		Button button2 = new Button(parent, SWT.PUSH);
		button2.setText("Change model");
		button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String reversedNumber = new StringBuffer(album.getName())
						.reverse().toString();
				album.setName(reversedNumber);
				String reversedArtistFirstName = new StringBuffer(album
						.getArtist().getFirstName()).reverse().toString();
				album.getArtist().setFirstName(reversedArtistFirstName);
				String reversedArtistLastName = new StringBuffer(album
						.getArtist().getLastName()).reverse().toString();
				album.getArtist().setLastName(reversedArtistLastName);
			}
		});

		// ALBUM GROUP
		Group grpAlbum = new Group(parent, SWT.NONE);
		grpAlbum.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		grpAlbum.setText("album");
		grpAlbum.setLayout(new GridLayout(2, false));

		// <!-- NAME
		Label lblName = new Label(grpAlbum, SWT.NONE);
		lblName.setText("name");

		name = new Text(grpAlbum, SWT.BORDER);
		name.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		bf.bind(getClass(), name, album, MusicPackage.Literals.ALBUM__NAME,
				true);
		// NAME -->
		// <!-- RELEASE DATE
		Label lblReleaseDate = new Label(grpAlbum, SWT.NONE);
		lblReleaseDate.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblReleaseDate.setText("release Date");

		releaseDate = new DateTime(grpAlbum, SWT.BORDER);
		releaseDate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		bf.bind(getClass(), releaseDate, album,
				MusicPackage.Literals.ALBUM__RELEASE_DATE, false);
		// RELEASE DATE -->

		// GROUP ARTIST
		Group grpArtist = new Group(parent, SWT.NONE);
		grpArtist.setLayout(new GridLayout(2, false));
		grpArtist.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 2, 1));
		grpArtist.setText("artist");

		// <!-- FIRST NAME
		Label lblFirstName = new Label(grpArtist, SWT.NONE);
		lblFirstName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblFirstName.setText("first name");

		artistFirstName = new Text(grpArtist, SWT.BORDER);
		artistFirstName.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true,
				false, 1, 1));
		// works with FeaturePath and without! - last name example will be done
		// with FeaturePath
		bf.bind(getClass(), artistFirstName, album.getArtist(),
				MusicPackage.Literals.ARTIST__FIRST_NAME, true);

		// FIRST NAME -->
		// <!-- LAST NAME
		Label lblLastName = new Label(grpArtist, SWT.NONE);
		lblLastName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblLastName.setText("last name");

		artistLastName = new Text(grpArtist, SWT.BORDER);
		artistLastName.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true,
				false, 1, 1));

		FeaturePath featureAlbumArtistLastName = FeaturePath.fromList(
				MusicPackage.Literals.ALBUM__ARTIST,
				MusicPackage.Literals.ARTIST__LAST_NAME);
		bf.bind(getClass(), artistLastName, album, featureAlbumArtistLastName,
				true);
		// LAST NAME -->

		// <!-- BIRTHDAY

		Label lblBirthdate = new Label(grpArtist, SWT.NONE);
		lblBirthdate.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblBirthdate.setText("birthdate");

		DateTime dtBirthday = new DateTime(grpArtist, SWT.BORDER);
		dtBirthday.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));

		FeaturePath featureAlbumArtistBirthday = FeaturePath.fromList(
				MusicPackage.Literals.ALBUM__ARTIST,
				MusicPackage.Literals.ARTIST__BIRTH_DATE);
		bf.bind(getClass(), dtBirthday, album, featureAlbumArtistBirthday,
				false);
		// BIRTHDAY -->

		// GROUP COUNTRY
		Group grpCountry = new Group(grpArtist, SWT.NONE);
		grpCountry.setLayout(new GridLayout(2, false));
		grpCountry.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 2, 1));
		grpCountry.setText("country");

		// <!-- COUNTRY CODE
		ComboViewer cCode = new ComboViewer(grpCountry, SWT.DROP_DOWN
				| SWT.READ_ONLY);
		GridData gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 1,
				1);
		gridData.widthHint = 50;
		cCode.getCombo().setLayoutData(gridData);
		cCode.setContentProvider(new ArrayContentProvider());
		cCode.setLabelProvider(new LabelProvider() {
			public String getText(Object element) {
				return (String) element;
			};
		});

		cCode.setInput(Utils.getCountryCodes());
		bf.bind(getClass(), cCode, album.getArtist().getCountry(),
				MusicPackage.Literals.COUNTRY__CODE, false);
		// COUNTRY CODE -->
		// <!-- COUNTRY NAME
		Text txtCountryName = new Text(grpCountry, SWT.BORDER);
		txtCountryName.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true,
				false, 1, 1));

		bf.bind(getClass(), txtCountryName, album.getArtist().getCountry(),
				MusicPackage.Literals.COUNTRY__NAME, true);

		// COUNTRY NAME -->

		Group grpRatings = new Group(parent, SWT.NONE);
		grpRatings.setText("ratings");
		grpRatings.setLayout(new GridLayout(1, false));
		GridData gd_grpRatings = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 2, 1);
		gd_grpRatings.heightHint = 100;
		grpRatings.setLayoutData(gd_grpRatings);

		// emf binding for table
		TableViewer viewerRating = new TableViewer(grpRatings);
		ObservableListContentProvider cp = new ObservableListContentProvider();
		viewerRating.setContentProvider(cp);

		viewerRating.setLabelProvider(new RatingsLabelProvider());
		viewerRating.getTable().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		IObservableList ratingData = EMFProperties.list(
				MusicPackage.Literals.ALBUM__RATINGS).observe(album);
		viewerRating.setInput(ratingData);

		 // btn to add a rating
		Button btnAddRating = new Button(grpRatings, SWT.NONE);
		btnAddRating.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		btnAddRating.setText("add Rating");
		
		// end rating

		Group grpGenres = new Group(parent, SWT.NONE);
		grpGenres.setLayout(new GridLayout(1, false));
		GridData gd_grpGenres = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 2, 1);
		gd_grpGenres.heightHint = 100;
		grpGenres.setLayoutData(gd_grpGenres);
		grpGenres.setText("genres");

		TableViewer viewerGenre = new TableViewer(grpGenres);
		viewerGenre.setContentProvider(new ObservableListContentProvider());
		viewerGenre.setLabelProvider(new GenreLabelProvider());
		viewerGenre.getTable().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		IObservableList genreData = EMFProperties.list(
				MusicPackage.Literals.ALBUM__GENRES).observe(album);
		viewerGenre.setInput(genreData);
		System.out.println("genreData.size() = "+genreData.size());

		 // btn to add a genre
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

		Group grpSongs = new Group(parent, SWT.NONE);
		grpSongs.setLayout(new GridLayout(1, false));
		GridData gd_grpSongs = new GridData(SWT.FILL, SWT.CENTER, true, false,
				2, 1);
		gd_grpSongs.heightHint = 100;
		grpSongs.setLayoutData(gd_grpSongs);
		grpSongs.setText("songs");

		TableViewer viewerSongs = new TableViewer(grpSongs);
		viewerSongs.setContentProvider(new ObservableListContentProvider());
		viewerSongs.setLabelProvider(new SongLabelProvider());
		viewerSongs.getTable().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		IObservableList songsData = EMFProperties.list(
				MusicPackage.Literals.ALBUM__SONGS).observe(album);
		viewerSongs.setInput(songsData);

		// btn to add a song
		
		Button btnAddSong = new Button(grpSongs, SWT.NONE);
		btnAddSong.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		btnAddSong.setText("add Song");
	}

	// public void setAlbum(Album album) {
	// ac.setAlbum(album);
	// }

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}

	public void dispose() {
		Controller.getAlbum().eAdapters().remove(adapter);
		bf.dispose(getClass());
	}

	class RatingsLabelProvider extends LabelProvider implements
			ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			return "";
		}

		public Image getColumnImage(Object obj, int index) {
			Rating rating = Enum.valueOf(Rating.class, getText(obj));
			return Utils.getImage(Utils.getRating(rating));
		}

		public Image getImage(Object obj) {
			return PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}
	}

	class GenreLabelProvider extends LabelProvider implements
			ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			return ((Genre) obj).getName();
		}

		public Image getColumnImage(Object obj, int index) {
			return null; // getImage(obj);
		}

		public Image getImage(Object obj) {
			return PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}
	}

	class SongLabelProvider extends LabelProvider implements
			ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			Song s = ((Song) obj);
			return String.format("%d - %s", s.getTrack(), s.getName());
		}

		public Image getColumnImage(Object obj, int index) {
			return null; // getImage(obj);
		}

		public Image getImage(Object obj) {
			return PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveOnCloseNeeded() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int promptToSaveOnClose() {
		// TODO Auto-generated method stub
		return 0;
	}
}