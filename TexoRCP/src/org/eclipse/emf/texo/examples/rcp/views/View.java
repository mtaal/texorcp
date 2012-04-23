package org.eclipse.emf.texo.examples.rcp.views;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.texo.examples.rcp.binding.BindingFactory;
import org.eclipse.emf.texo.examples.rcp.controller.Controller;
import org.eclipse.emf.texo.examples.rcp.music.Album;
import org.eclipse.emf.texo.examples.rcp.music.MusicFactory;
import org.eclipse.emf.texo.examples.rcp.music.MusicPackage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class View extends ViewPart {
	public static final String ID = "org.eclipse.emf.texo.examples.rcp.views.view";
	private Text name;
	private DateTime releaseDate;
	private Adapter adapter;

	private BindingFactory bf = BindingFactory.getInstance();

	public View() {
	}

	@Override
	public void createPartControl(Composite parent) {
		MusicFactory.eINSTANCE.eClass();
		adapter = new AdapterImpl() {

			public void notifyChanged(Notification notification) {
				super.notifyChanged(notification);
				System.out.println("View (2) - model has changed!!!");
			}
		};
		
		final Album album = Controller.getAlbum();
		album.eAdapters().add(adapter);
		
		System.out.println("View added eAdapter");

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

		Label artistFirstName = new Label(grpArtist, SWT.NONE);
		artistFirstName.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, true,
				false, 1, 1));
		// works with FeaturePath and without! - last name example will be done
		// with FeaturePath
		bf.bind(getClass(), artistFirstName, album.getArtist(),
				MusicPackage.Literals.ARTIST__FIRST_NAME);

		Label artistLastName = new Label(grpArtist, SWT.NONE);
		artistLastName.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true,
				false, 1, 1));
		bf.bind(getClass(), artistLastName, album.getArtist(),
				MusicPackage.Literals.ARTIST__LAST_NAME);
		// LAST NAME -->

		// <!-- BIRTHDAY

		Label lblBirthdate = new Label(grpArtist, SWT.NONE);
		lblBirthdate.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true,
				false, 1, 1));
		lblBirthdate.setText("was born on");

		Label dtBirthday = new Label(grpArtist, SWT.NONE);
		dtBirthday.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1));
		bf.bind(getClass(), dtBirthday, album.getArtist(),
				MusicPackage.Literals.ARTIST__BIRTH_DATE);
		// BIRTHDAY -->

		// GROUP COUNTRY
		Group grpCountry = new Group(grpArtist, SWT.NONE);
		grpCountry.setLayout(new GridLayout(2, false));
		grpCountry.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 2, 1));
		grpCountry.setText("country");

		Label lblCountryFlag = new Label(grpCountry, SWT.NONE);
		lblCountryFlag.setText("flag");

		bf.bind(getClass(), lblCountryFlag, album.getArtist().getCountry(),
				MusicPackage.Literals.COUNTRY__CODE);
		// COUNTRY CODE -->
		// <!-- COUNTRY NAME
		Label lblCountryName = new Label(grpCountry, SWT.NONE);
		lblCountryName.setText("name");

		bf.bind(getClass(), lblCountryName, album.getArtist().getCountry(),
				MusicPackage.Literals.COUNTRY__NAME);

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
		Controller.getAlbum().eAdapters().remove(adapter);
		bf.dispose(getClass());
	}
}