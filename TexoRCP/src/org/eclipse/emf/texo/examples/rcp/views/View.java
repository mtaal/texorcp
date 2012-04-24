package org.eclipse.emf.texo.examples.rcp.views;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.texo.examples.rcp.binding.BindingFactory;
import org.eclipse.emf.texo.examples.rcp.controller.Controller;
import org.eclipse.emf.texo.examples.rcp.music.Album;
import org.eclipse.emf.texo.examples.rcp.music.Artist;
import org.eclipse.emf.texo.examples.rcp.music.Country;
import org.eclipse.emf.texo.examples.rcp.music.Genre;
import org.eclipse.emf.texo.examples.rcp.music.MusicFactory;
import org.eclipse.emf.texo.examples.rcp.music.Rating;
import org.eclipse.emf.texo.examples.rcp.music.Song;
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
	private EContentAdapter adapter;

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

	public void setCountry(Country country) {
		if (country == null) {
			return;
		}
		lblCountryCode.setImage(Utils.getImage(Utils.getCountryCodeFlag(country
				.getCode())));
		lblCountryName.setText(country.getName());
	}

	public void setAlbum(Album album) {
		if (album == null) {
			return;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("MMMMM yyyy");
		lblAlbumName.setText(String.format("%s (%s)", album.getName(),
				sdf.format(album.getReleaseDate())));

		setArtist(album.getArtist());
		EList<Genre> genres = album.getGenres();
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

		EList<Rating> ratings = album.getRatings();
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

		EList<Song> songs = album.getSongs();
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

	public void setArtist(Artist artist) {
		if (artist == null) {
			return;
		}
		lblFirstname.setText(artist.getFirstName());
		lblLastname.setText(artist.getLastName());
		lblBirthdate.setText(DateFormat.getDateInstance(DateFormat.LONG)
				.format(artist.getBirthDate()));
		setCountry(artist.getCountry());
	}

	@Override
	public void createPartControl(Composite parent) {

		// register the eAdapter
		MusicFactory.eINSTANCE.eClass();
		adapter = new EContentAdapter() {

			public void notifyChanged(Notification notification) {
//				super.notifyChanged(notification);
//				try {
//					if (notification.getNotifier() instanceof Album) {
//						setAlbum((Album) notification.getNotifier());
//					} else if (notification.getNotifier() instanceof Artist) {
//						setArtist((Artist) notification.getNotifier());
//					} else if (notification.getNotifier() instanceof Country) {
//						setCountry((Country) notification.getNotifier());
//					}
//				} catch (Exception ignoreMe) {
//					// this raises when we close the application, because emf
//					// wants to update but the widgets are already disposed
//				}
			}
		};
		
		Controller.getRegisterAdapters().add(adapter);
		System.out.println("RepresentativeView registered the adapter");

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

		// get an album if there is already one available
//		setAlbum(Controller.getInstance().get);
	}

	public void update() {
//		setAlbum(Controller.getAlbum());
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}

	public void dispose() {
		Controller.getRegisterAdapters().remove(adapter);
		bf.dispose(getClass());
	}
}