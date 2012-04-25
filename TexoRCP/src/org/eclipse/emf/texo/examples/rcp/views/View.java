package org.eclipse.emf.texo.examples.rcp.views;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.texo.examples.rcp.binding.BindingFactory;
import org.eclipse.emf.texo.examples.rcp.controller.Controller;
import org.eclipse.emf.texo.examples.rcp.music.Album;
import org.eclipse.emf.texo.examples.rcp.music.AlbumDataBase;
import org.eclipse.emf.texo.examples.rcp.music.Artist;
import org.eclipse.emf.texo.examples.rcp.music.Genre;
import org.eclipse.emf.texo.examples.rcp.music.MusicPackage;
import org.eclipse.emf.texo.examples.rcp.music.Rating;
import org.eclipse.emf.texo.examples.rcp.music.Song;
import org.eclipse.emf.texo.examples.rcp.music.impl.AlbumDataBaseImpl;
import org.eclipse.emf.texo.examples.rcp.util.Utils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.SWTResourceManager;

public class View extends ViewPart {
	public static final String ID = "org.eclipse.emf.texo.examples.rcp.views.view";
	private static final SimpleDateFormat sdf = new SimpleDateFormat(
			"MMMMM yyyy");

	private EContentAdapter adapter;
	private Album album;

	private BindingFactory bf = BindingFactory.getInstance();
	private Label lblFirstname;
	private Label lblLastname;
	private Label lblBirthdate;
	private Label lblLivingAt;
	private Label lblAlbumName;
	private Label lblCountryCode;
	private Label lblCountryName;
	private List songList;
	private Label lblRatedHigh;
	private Label lblRatedLow;
	private Label lblGenres;
	private Label lblRatedCount;

	public View() {
	}

	public void setAlbumDetails(Album a) {
		lblAlbumName.setText(String.format("%s (%s)", a.getName(),
				sdf.format(a.getReleaseDate())));
	}

	public void setArtist(Artist a) {
		lblFirstname.setText(a.getFirstName());
		lblLastname.setText(a.getLastName());
		lblBirthdate.setText(DateFormat.getDateInstance(DateFormat.LONG)
				.format(a.getBirthDate()));
		// country
		lblCountryCode.setImage(Utils.getImage(Utils.getCountryCodeFlag(a
				.getCountry().getCode())));
		lblCountryName.setText(a.getCountry().getName());
	}

	public void setGenres(EList<Genre> genres) {
		if (genres != null) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < genres.size(); i++) {
				sb.append(genres.get(i).getName());
				if (i < genres.size() - 1) {
					sb.append(", ");
				}
			}
			lblGenres.setText(sb.toString());
		}
	}

	public void setRatings(EList<Rating> ratings) {
		if (ratings != null) {
			int highCount = 0;
			for (int i = 0; i < ratings.size(); i++) {
				if (ratings.get(i).equals(Rating.HIGH)) {
					highCount++;
				}
			}
			lblRatedHigh.setImage(Utils.getImage(Utils.getRating(Rating.HIGH)));
			lblRatedCount.setText(String.format("%d Vs %s", highCount,
					ratings.size() - highCount));
			lblRatedLow.setImage(Utils.getImage(Utils.getRating(Rating.LOW)));
		}
	}

	public void setSongs(EList<Song> songs) {
		if (songs != null) {
			String[] titles = new String[songs.size()];

			songList.removeAll();
			for (int i = 0; i < songs.size(); i++) {
				Song song = songs.get(i);
				String trackNumber = String.format("%d", song.getTrack());
				if (trackNumber.length() < 2) {
					trackNumber = "0" + trackNumber;
				}
				titles[i] = String.format("%s - %s", trackNumber,
						song.getName());
			}
			Arrays.sort(titles);
			songList.setItems(titles);
		}
	}

	public void updateAdapter(Album album) {
		if (album == null) {
			return;
		}
		// check if its a new album
		if (this.album != album) {
			System.out.println("View got a new album " + album);
			if (this.album != null) {
				this.album.eAdapters().remove(adapter);
			}
			this.album = album;
			this.album.eAdapters().add(adapter);
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		adapter = new EContentAdapter() {
			public void notifyChanged(Notification notification) {
				super.notifyChanged(notification);
				if (notification.getNotifier() instanceof Album) {
					System.out.println("updating Album... ATTRIBUTE "
							+ ((EStructuralFeature) notification.getFeature())
									.getName());
					Album a = (Album) notification.getNotifier();
					updateAdapter(a); // create new adapter
					switch (notification.getFeatureID(Album.class)) {
					case MusicPackage.ALBUM__NAME:
						setAlbumDetails(a);
						break;
					case MusicPackage.ALBUM__RELEASE_DATE:
						setAlbumDetails(a);
						break;

					case MusicPackage.ALBUM__ARTIST:
						setArtist(a.getArtist());
						break;

					case MusicPackage.ALBUM__GENRES:
						setGenres(a.getGenres());
						break;

					case MusicPackage.ALBUM__RATINGS:
						setRatings(a.getRatings());
						break;

					case MusicPackage.ALBUM__SONGS:
						setSongs(a.getSongs());
						break;

					default:
						System.out.println("Album Feature ID not handled yet: "
								+ notification.getFeatureID(Album.class));
						break;
					}
					return;
				}
				if (notification.getNotifier() instanceof AlbumDataBase) {
					switch (notification.getFeatureID(AlbumDataBase.class)) {
					case MusicPackage.ALBUM_DATA_BASE__SELECTED:
						System.out.println("AlbumDatabase.select()");
						AlbumDataBaseImpl adb = (AlbumDataBaseImpl) notification
								.getNotifier();
						Album a = adb.getSelected();
						updateAdapter(a);
						// complete update
						setAlbumDetails(a);
						setAlbumDetails(a);
						setAlbumDetails(a);
						setArtist(a.getArtist());
						setGenres(a.getGenres());
						setRatings(a.getRatings());
						setSongs(a.getSongs());
						System.out.println("updated.view!");
						break;

					default:
						break;
					}
				}
			}
		};
		// register the eAdapter
		Controller.getRegisterAdapters().add(adapter);

		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;
		gridLayout.horizontalSpacing = 0;
		gridLayout.marginHeight = 0;
		gridLayout.verticalSpacing = 0;
		parent.setLayout(gridLayout);
		{ // GROUP ARTIST
			Group grpAboutTheArtist = new Group(parent, SWT.NONE);
			grpAboutTheArtist.setLayout(new GridLayout(2, false));
			grpAboutTheArtist.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
					true, false, 1, 1));
			grpAboutTheArtist.setText("about the Artist");

			lblFirstname = new Label(grpAboutTheArtist, SWT.RIGHT);
			lblFirstname.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
					false, 1, 1));
			lblFirstname.setText("<first name of Artist>");

			lblLastname = new Label(grpAboutTheArtist, SWT.NONE);
			lblLastname.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
					false, 1, 1));
			lblLastname.setText("<last name of artist>");

			Label lblWasBorn = new Label(grpAboutTheArtist, SWT.RIGHT);
			lblWasBorn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
					false, 1, 1));
			lblWasBorn.setText("was born");

			lblBirthdate = new Label(grpAboutTheArtist, SWT.NONE);
			lblBirthdate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
					false, 1, 1));
			lblBirthdate.setText("<birthdate of artist>");

			lblLivingAt = new Label(grpAboutTheArtist, SWT.CENTER);
			lblLivingAt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
					false, 2, 1));
			lblLivingAt.setText("living at");

			lblCountryCode = new Label(grpAboutTheArtist, SWT.NONE);
			lblCountryCode.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
					false, false, 1, 1));
			lblCountryCode.setAlignment(SWT.RIGHT);
			lblCountryCode.setText("<country code>");

			lblCountryName = new Label(grpAboutTheArtist, SWT.NONE);
			lblCountryName.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true,
					true, 1, 1));
			lblCountryName.setText("<country name>");
		}
		{ // GROUP ALBUM
			Group grpAboutTheAlbum = new Group(parent, SWT.NONE);
			grpAboutTheAlbum.setLayout(new GridLayout(3, false));
			grpAboutTheAlbum.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
					true, true, 1, 1));
			grpAboutTheAlbum.setText("about the album");

			lblAlbumName = new Label(grpAboutTheAlbum, SWT.CENTER);
			lblAlbumName.setFont(SWTResourceManager.getFont("Tahoma", 16,
					SWT.BOLD));
			lblAlbumName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
					false, 3, 1));
			lblAlbumName.setText("<album title>");

			lblGenres = new Label(grpAboutTheAlbum, SWT.CENTER);
			lblGenres.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
					false, 3, 1));
			lblGenres.setText("<genres>");

			lblRatedHigh = new Label(grpAboutTheAlbum, SWT.RIGHT);
			GridData gd_lblRatedHigh = new GridData(SWT.FILL, SWT.CENTER, true,
					false, 1, 1);
			gd_lblRatedHigh.widthHint = 32;
			gd_lblRatedHigh.heightHint = 16;
			lblRatedHigh.setLayoutData(gd_lblRatedHigh);
			lblRatedHigh.setText("rated High");

			lblRatedCount = new Label(grpAboutTheAlbum, SWT.CENTER);
			GridData gd_lblRatedCount = new GridData(SWT.LEFT, SWT.CENTER,
					false, false, 1, 1);
			gd_lblRatedCount.widthHint = 50;
			lblRatedCount.setLayoutData(gd_lblRatedCount);
			lblRatedCount.setText("<ratings>");

			lblRatedLow = new Label(grpAboutTheAlbum, SWT.NONE);
			GridData gd_lblRatedLow = new GridData(SWT.FILL, SWT.CENTER, true,
					false, 1, 1);
			gd_lblRatedLow.heightHint = 16;
			lblRatedLow.setLayoutData(gd_lblRatedLow);
			lblRatedLow.setText("rated Low");

			songList = new List(grpAboutTheAlbum, SWT.BORDER);
			songList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
					3, 1));
			// COUNTRY NAME -->
		}
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}

	public void dispose() {
		try {
			Controller.getRegisterAdapters().remove(adapter);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (album != null) {
			album.eAdapters().remove(adapter);
		}
		bf.dispose(getClass());
	}
}