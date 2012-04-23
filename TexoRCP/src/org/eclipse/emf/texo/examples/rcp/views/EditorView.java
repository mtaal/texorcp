package org.eclipse.emf.texo.examples.rcp.views;

import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.texo.examples.rcp.binding.BindingFactory;
import org.eclipse.emf.texo.examples.rcp.controller.Controller;
import org.eclipse.emf.texo.examples.rcp.music.Album;
import org.eclipse.emf.texo.examples.rcp.music.MusicPackage;
import org.eclipse.emf.texo.examples.rcp.util.Utils;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class EditorView extends ViewPart {
	public static final String ID = "org.eclipse.emf.texo.examples.rcp.views.editorview";
	private Text name;
	private DateTime releaseDate;
	private Text artistFirstName;
	private Text artistLastName;

	private BindingFactory bf = BindingFactory.getInstance();

	public EditorView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;
		gridLayout.horizontalSpacing = 0;
		gridLayout.marginHeight = 0;
		gridLayout.verticalSpacing = 0;
		parent.setLayout(gridLayout);

		final Album album = Controller.getAlbum();

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

		bf.bind(getClass(), name, album, MusicPackage.Literals.ALBUM__NAME);
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
				MusicPackage.Literals.ALBUM__RELEASE_DATE);
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
				MusicPackage.Literals.ARTIST__FIRST_NAME);
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
		bf.bind(getClass(), artistLastName, album, featureAlbumArtistLastName);
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
		bf.bind(getClass(), dtBirthday, album, featureAlbumArtistBirthday);
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
				MusicPackage.Literals.COUNTRY__CODE);
		// COUNTRY CODE -->
		// <!-- COUNTRY NAME
		 Text txtCountryName = new Text(grpCountry, SWT.BORDER);
		 txtCountryName.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true,
		 false, 1, 1));
		 
		 bf.bind(getClass(), txtCountryName, album.getArtist().getCountry(), MusicPackage.Literals.COUNTRY__NAME);

		// COUNTRY NAME -->
	}

	// public void setAlbum(Album album) {
	// ac.setAlbum(album);
	// }

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}

	public void dispose() {
		bf.dispose(getClass());
	}
}