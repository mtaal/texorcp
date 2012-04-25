package org.eclipse.emf.texo.examples.rcp.views;

import java.util.Iterator;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.texo.examples.rcp.binding.BindingFactory;
import org.eclipse.emf.texo.examples.rcp.controller.Controller;
import org.eclipse.emf.texo.examples.rcp.gui.widgets.edit.AddGenreDialog;
import org.eclipse.emf.texo.examples.rcp.gui.widgets.edit.AddRatingDialog;
import org.eclipse.emf.texo.examples.rcp.gui.widgets.edit.AddSongDialog;
import org.eclipse.emf.texo.examples.rcp.music.Album;
import org.eclipse.emf.texo.examples.rcp.music.AlbumDataBase;
import org.eclipse.emf.texo.examples.rcp.music.Genre;
import org.eclipse.emf.texo.examples.rcp.music.MusicPackage;
import org.eclipse.emf.texo.examples.rcp.music.Rating;
import org.eclipse.emf.texo.examples.rcp.music.Song;
import org.eclipse.emf.texo.examples.rcp.util.Utils;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

public class EditorView extends ViewPart {
	public static final String ID = "org.eclipse.emf.texo.examples.rcp.views.editorview";
	private Text name;
	private DateTime releaseDate;
	private Text artistFirstName;
	private Text artistLastName;
	private EContentAdapter adapter;
	private Shell parentShell;

	private BindingFactory bf = BindingFactory.getInstance();
	private TableViewer viewerSongs;
	private TableViewer viewerGenre;
	private TableViewer viewerRating;
	private ComboViewer cCode;
	private DateTime dtBirthday;
	private Album album;
	private Text txtCountryName;

	public EditorView() {
	}

	public Shell getParentShell() {
		return parentShell;
	}

	private Album getAlbum() {
		return album;
	}

	public void setAlbum(final Album album) {
		this.album = album;
		// binding
		bf.bind(getClass(), name, album, MusicPackage.Literals.ALBUM__NAME,
				true);
		bf.bind(getClass(), releaseDate, album,
				MusicPackage.Literals.ALBUM__RELEASE_DATE, false);

		// works with FeaturePath and without! - last name example will be done
		// with FeaturePath
		bf.bind(getClass(), artistFirstName, album.getArtist(),
				MusicPackage.Literals.ARTIST__FIRST_NAME, true);

		FeaturePath featureAlbumArtistLastName = FeaturePath.fromList(
				MusicPackage.Literals.ALBUM__ARTIST,
				MusicPackage.Literals.ARTIST__LAST_NAME);
		bf.bind(getClass(), artistLastName, album, featureAlbumArtistLastName,
				true);

		FeaturePath featureAlbumArtistBirthday = FeaturePath.fromList(
				MusicPackage.Literals.ALBUM__ARTIST,
				MusicPackage.Literals.ARTIST__BIRTH_DATE);
		bf.bind(getClass(), dtBirthday, album, featureAlbumArtistBirthday,
				false);
		bf.bind(getClass(), cCode, album.getArtist().getCountry(),
				MusicPackage.Literals.COUNTRY__CODE, false);
		bf.bind(getClass(), txtCountryName, album.getArtist().getCountry(),
				MusicPackage.Literals.COUNTRY__NAME, true);

		IObservableList ratingData = EMFProperties.list(
				MusicPackage.Literals.ALBUM__RATINGS).observe(album);
		viewerRating.setInput(ratingData);

		IObservableList genreData = EMFProperties.list(
				MusicPackage.Literals.ALBUM__GENRES).observe(album);
		viewerGenre.setInput(genreData);

		IObservableList songsData = EMFProperties.list(
				MusicPackage.Literals.ALBUM__SONGS).observe(album);
		viewerSongs.setInput(songsData);
	}

	@Override
	public void createPartControl(Composite parent) {
		this.parentShell = parent.getShell();
		adapter = new EContentAdapter() {

			public void notifyChanged(Notification notification) {
				super.notifyChanged(notification);
				if (notification.getNotifier() instanceof AlbumDataBase) {
					switch (notification.getFeatureID(AlbumDataBase.class)) {
					case MusicPackage.ALBUM_DATA_BASE__SELECTED:
						Album a = ((AlbumDataBase) notification
								.getNotifier()).getSelected();
						setAlbum(a);
						break;

					default:
						break;
					}
				}
			}
		};

		Controller.getRegisterAdapters().add(adapter);
		System.out.println("EditorView registered the adapter");

		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;
		gridLayout.horizontalSpacing = 0;
		gridLayout.marginHeight = 0;
		gridLayout.verticalSpacing = 0;
		parent.setLayout(gridLayout);

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
		name.setText("<Album Name>");
		name.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		// NAME -->
		// <!-- RELEASE DATE
		Label lblReleaseDate = new Label(grpAlbum, SWT.NONE);
		lblReleaseDate.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblReleaseDate.setText("release Date");

		releaseDate = new DateTime(grpAlbum, SWT.BORDER);
		releaseDate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
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
		artistFirstName.setText("<first name of Artist>");
		artistFirstName.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true,
				false, 1, 1));

		// FIRST NAME -->
		// <!-- LAST NAME
		Label lblLastName = new Label(grpArtist, SWT.NONE);
		lblLastName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblLastName.setText("last name");

		artistLastName = new Text(grpArtist, SWT.BORDER);
		artistLastName.setText("<last name of artist>");
		artistLastName.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true,
				false, 1, 1));
		// LAST NAME -->

		// <!-- BIRTHDAY

		Label lblBirthdate = new Label(grpArtist, SWT.NONE);
		lblBirthdate.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblBirthdate.setText("birthdate");

		dtBirthday = new DateTime(grpArtist, SWT.BORDER);
		dtBirthday.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		// BIRTHDAY -->

		// GROUP COUNTRY
		Group grpCountry = new Group(grpArtist, SWT.NONE);
		grpCountry.setLayout(new GridLayout(2, false));
		grpCountry.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 2, 1));
		grpCountry.setText("country");

		cCode = new ComboViewer(grpCountry, SWT.DROP_DOWN | SWT.READ_ONLY);
		Combo combo = cCode.getCombo();
		GridData gridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 1,
				1);
		gridData.widthHint = 50;
		cCode.getCombo().setLayoutData(gridData);
		combo.setText("<code>");
		cCode.setContentProvider(new ArrayContentProvider());
		cCode.setLabelProvider(new LabelProvider() {
			public String getText(Object element) {
				return (String) element;
			};
		});

		cCode.setInput(Utils.getCountryCodes());
		txtCountryName = new Text(grpCountry, SWT.BORDER);
		txtCountryName.setText("<country name>");
		txtCountryName.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true,
				false, 1, 1));

		// COUNTRY NAME -->

		Group grpRatings = new Group(parent, SWT.NONE);
		grpRatings.setText("ratings");
		grpRatings.setLayout(new GridLayout(1, false));
		GridData gd_grpRatings = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 2, 1);
		gd_grpRatings.heightHint = 100;
		grpRatings.setLayoutData(gd_grpRatings);

		viewerRating = new TableViewer(grpRatings);
		ObservableListContentProvider cp = new ObservableListContentProvider();
		viewerRating.setContentProvider(cp);

		viewerRating.setLabelProvider(new RatingsLabelProvider());
		viewerRating.getTable().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		viewerRating.getTable().addKeyListener(new KeyListener() {

			@SuppressWarnings("unchecked")
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.keyCode == SWT.DEL) {
					StructuredSelection structuredSelection = (StructuredSelection) viewerRating
							.getSelection();
					// or iterate over all elements
					for (Iterator<Rating> iterator = structuredSelection
							.iterator(); iterator.hasNext();) {
						Rating g = iterator.next();
						getAlbum().getRatings().remove(g);
					}
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});

		// btn to add a rating
		Button btnAddRating = new Button(grpRatings, SWT.NONE);
		btnAddRating.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AddRatingDialog d = new AddRatingDialog(getParentShell(),
						SWT.DIALOG_TRIM);
				Rating rating = (Rating) d.open();
				getAlbum().getRatings().add(rating);
			}
		});
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

		viewerGenre = new TableViewer(grpGenres);
		viewerGenre.setContentProvider(new ObservableListContentProvider());
		viewerGenre.setLabelProvider(new GenreLabelProvider());
		viewerGenre.getTable().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		viewerGenre.getTable().addKeyListener(new KeyListener() {

			@SuppressWarnings("unchecked")
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.keyCode == SWT.DEL) {
					StructuredSelection structuredSelection = (StructuredSelection) viewerGenre
							.getSelection();
					// or iterate over all elements
					for (Iterator<Genre> iterator = structuredSelection
							.iterator(); iterator.hasNext();) {
						Genre g = iterator.next();
						getAlbum().getGenres().remove(g);
					}
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});

		// btn to add a genre
		Button btnAddGenre = new Button(grpGenres, SWT.NONE);
		btnAddGenre.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		btnAddGenre.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AddGenreDialog d = new AddGenreDialog(getParentShell(),
						SWT.DIALOG_TRIM);
				Genre genre = (Genre) d.open();
				if (genre != null) {
					album.getGenres().add(genre);
				}
			}
		});
		btnAddGenre.setText("add Genre");

		Group grpSongs = new Group(parent, SWT.NONE);
		grpSongs.setLayout(new GridLayout(1, false));
		GridData gd_grpSongs = new GridData(SWT.FILL, SWT.FILL, true, true, 2,
				1);
		gd_grpSongs.heightHint = 100;
		grpSongs.setLayoutData(gd_grpSongs);
		grpSongs.setText("songs");

		viewerSongs = new TableViewer(grpSongs);
		viewerSongs.getTable().addKeyListener(new KeyListener() {

			@SuppressWarnings("unchecked")
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.keyCode == SWT.DEL) {
					StructuredSelection structuredSelection = (StructuredSelection) viewerSongs
							.getSelection();
					// or iterate over all elements
					for (Iterator<Song> iterator = structuredSelection
							.iterator(); iterator.hasNext();) {
						Song s = iterator.next();
						album.getSongs().remove(s);
					}
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		viewerSongs.setContentProvider(new ObservableListContentProvider());
		viewerSongs.setLabelProvider(new SongLabelProvider());
		viewerSongs.getTable().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		// btn to add a song

		Button btnAddSong = new Button(grpSongs, SWT.NONE);
		btnAddSong.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AddSongDialog s = new AddSongDialog(getParentShell(),
						SWT.DIALOG_TRIM);
				Song song = (Song) s.open();
				if (s != null) {
					getAlbum().getSongs().add(song);
				}
			}
		});
		btnAddSong.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		btnAddSong.setText("add Song");
	}

	// public void setAlbum(Album album) {
	// ac.setAlbum(album);
	// }

	@Override
	public void setFocus() {
	}

	public void dispose() {
		try {
			Controller.getRegisterAdapters().remove(adapter);
		} catch (Exception e) {
			// TODO: handle exception
		}
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
}