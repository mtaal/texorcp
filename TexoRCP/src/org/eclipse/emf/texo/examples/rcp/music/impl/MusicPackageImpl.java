/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.texo.examples.rcp.music.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.texo.examples.rcp.music.Album;
import org.eclipse.emf.texo.examples.rcp.music.AlbumDataBase;
import org.eclipse.emf.texo.examples.rcp.music.Artist;
import org.eclipse.emf.texo.examples.rcp.music.Country;
import org.eclipse.emf.texo.examples.rcp.music.Genre;
import org.eclipse.emf.texo.examples.rcp.music.MusicFactory;
import org.eclipse.emf.texo.examples.rcp.music.MusicPackage;
import org.eclipse.emf.texo.examples.rcp.music.Rating;
import org.eclipse.emf.texo.examples.rcp.music.Song;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MusicPackageImpl extends EPackageImpl implements MusicPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass artistEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass albumEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass countryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genreEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass songEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass albumDataBaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ratingEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.emf.texo.examples.rcp.music.MusicPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MusicPackageImpl() {
		super(eNS_URI, MusicFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link MusicPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MusicPackage init() {
		if (isInited) return (MusicPackage)EPackage.Registry.INSTANCE.getEPackage(MusicPackage.eNS_URI);

		// Obtain or create and register package
		MusicPackageImpl theMusicPackage = (MusicPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MusicPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MusicPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theMusicPackage.createPackageContents();

		// Initialize created meta-data
		theMusicPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMusicPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MusicPackage.eNS_URI, theMusicPackage);
		return theMusicPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArtist() {
		return artistEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArtist_Id() {
		return (EAttribute)artistEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArtist_Version() {
		return (EAttribute)artistEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArtist_FirstName() {
		return (EAttribute)artistEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArtist_LastName() {
		return (EAttribute)artistEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArtist_BirthDate() {
		return (EAttribute)artistEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArtist_Country() {
		return (EReference)artistEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArtist_Genre() {
		return (EReference)artistEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlbum() {
		return albumEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAlbum_Id() {
		return (EAttribute)albumEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAlbum_Version() {
		return (EAttribute)albumEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAlbum_Name() {
		return (EAttribute)albumEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlbum_Artist() {
		return (EReference)albumEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAlbum_ReleaseDate() {
		return (EAttribute)albumEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlbum_Genres() {
		return (EReference)albumEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlbum_Songs() {
		return (EReference)albumEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAlbum_Ratings() {
		return (EAttribute)albumEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCountry() {
		return countryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCountry_Code() {
		return (EAttribute)countryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCountry_Version() {
		return (EAttribute)countryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCountry_Name() {
		return (EAttribute)countryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenre() {
		return genreEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenre_Id() {
		return (EAttribute)genreEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenre_Version() {
		return (EAttribute)genreEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenre_Name() {
		return (EAttribute)genreEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSong() {
		return songEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSong_Id() {
		return (EAttribute)songEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSong_Version() {
		return (EAttribute)songEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSong_Track() {
		return (EAttribute)songEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSong_Name() {
		return (EAttribute)songEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlbumDataBase() {
		return albumDataBaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlbumDataBase_Albums() {
		return (EReference)albumDataBaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlbumDataBase_Selected() {
		return (EReference)albumDataBaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRating() {
		return ratingEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MusicFactory getMusicFactory() {
		return (MusicFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		artistEClass = createEClass(ARTIST);
		createEAttribute(artistEClass, ARTIST__ID);
		createEAttribute(artistEClass, ARTIST__VERSION);
		createEAttribute(artistEClass, ARTIST__FIRST_NAME);
		createEAttribute(artistEClass, ARTIST__LAST_NAME);
		createEAttribute(artistEClass, ARTIST__BIRTH_DATE);
		createEReference(artistEClass, ARTIST__COUNTRY);
		createEReference(artistEClass, ARTIST__GENRE);

		albumEClass = createEClass(ALBUM);
		createEAttribute(albumEClass, ALBUM__ID);
		createEAttribute(albumEClass, ALBUM__VERSION);
		createEAttribute(albumEClass, ALBUM__NAME);
		createEReference(albumEClass, ALBUM__ARTIST);
		createEAttribute(albumEClass, ALBUM__RELEASE_DATE);
		createEReference(albumEClass, ALBUM__GENRES);
		createEReference(albumEClass, ALBUM__SONGS);
		createEAttribute(albumEClass, ALBUM__RATINGS);

		countryEClass = createEClass(COUNTRY);
		createEAttribute(countryEClass, COUNTRY__CODE);
		createEAttribute(countryEClass, COUNTRY__VERSION);
		createEAttribute(countryEClass, COUNTRY__NAME);

		genreEClass = createEClass(GENRE);
		createEAttribute(genreEClass, GENRE__ID);
		createEAttribute(genreEClass, GENRE__VERSION);
		createEAttribute(genreEClass, GENRE__NAME);

		songEClass = createEClass(SONG);
		createEAttribute(songEClass, SONG__ID);
		createEAttribute(songEClass, SONG__VERSION);
		createEAttribute(songEClass, SONG__TRACK);
		createEAttribute(songEClass, SONG__NAME);

		albumDataBaseEClass = createEClass(ALBUM_DATA_BASE);
		createEReference(albumDataBaseEClass, ALBUM_DATA_BASE__ALBUMS);
		createEReference(albumDataBaseEClass, ALBUM_DATA_BASE__SELECTED);

		// Create enums
		ratingEEnum = createEEnum(RATING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(artistEClass, Artist.class, "Artist", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArtist_Id(), ecorePackage.getELong(), "id", null, 0, 1, Artist.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getArtist_Version(), ecorePackage.getELongObject(), "version", null, 0, 1, Artist.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getArtist_FirstName(), ecorePackage.getEString(), "firstName", null, 0, 1, Artist.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getArtist_LastName(), ecorePackage.getEString(), "lastName", null, 0, 1, Artist.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getArtist_BirthDate(), ecorePackage.getEDate(), "birthDate", null, 0, 1, Artist.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArtist_Country(), this.getCountry(), null, "country", null, 0, 1, Artist.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArtist_Genre(), this.getGenre(), null, "genre", null, 0, 1, Artist.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(albumEClass, Album.class, "Album", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAlbum_Id(), ecorePackage.getELong(), "id", null, 0, 1, Album.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAlbum_Version(), ecorePackage.getELongObject(), "version", null, 0, 1, Album.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAlbum_Name(), ecorePackage.getEString(), "name", null, 0, 1, Album.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAlbum_Artist(), this.getArtist(), null, "artist", null, 0, 1, Album.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAlbum_ReleaseDate(), ecorePackage.getEDate(), "releaseDate", null, 0, 1, Album.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAlbum_Genres(), this.getGenre(), null, "genres", null, 0, -1, Album.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAlbum_Songs(), this.getSong(), null, "songs", null, 0, -1, Album.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAlbum_Ratings(), this.getRating(), "ratings", null, 0, -1, Album.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(countryEClass, Country.class, "Country", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCountry_Code(), ecorePackage.getEString(), "code", null, 1, 1, Country.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCountry_Version(), ecorePackage.getELongObject(), "version", null, 0, 1, Country.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCountry_Name(), ecorePackage.getEString(), "name", null, 0, 1, Country.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(genreEClass, Genre.class, "Genre", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGenre_Id(), ecorePackage.getELong(), "id", null, 0, 1, Genre.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenre_Version(), ecorePackage.getELongObject(), "version", null, 0, 1, Genre.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenre_Name(), ecorePackage.getEString(), "name", null, 1, 1, Genre.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(songEClass, Song.class, "Song", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSong_Id(), ecorePackage.getELong(), "id", null, 0, 1, Song.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSong_Version(), ecorePackage.getELongObject(), "version", null, 0, 1, Song.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSong_Track(), ecorePackage.getEInt(), "track", null, 0, 1, Song.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSong_Name(), ecorePackage.getEString(), "name", null, 0, 1, Song.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(albumDataBaseEClass, AlbumDataBase.class, "AlbumDataBase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAlbumDataBase_Albums(), this.getAlbum(), null, "albums", null, 0, -1, AlbumDataBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAlbumDataBase_Selected(), this.getAlbum(), null, "selected", null, 0, 1, AlbumDataBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(ratingEEnum, Rating.class, "Rating");
		addEEnumLiteral(ratingEEnum, Rating.LOW);
		addEEnumLiteral(ratingEEnum, Rating.HIGH);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// elver.org/displayLabel
		createDisplayLabelAnnotations();
		// elver.org/naturalOrdering
		createNaturalOrderingAnnotations();
		// elver.org/displayAttributes
		createDisplayAttributesAnnotations();
		// teneo.jpa
		createTeneoAnnotations();
		// elver.org/searchable
		createSearchableAnnotations();
		// elver.org/maxLength
		createMaxLengthAnnotations();
		// elver.org/displayLength
		createDisplayLengthAnnotations();
	}

	/**
	 * Initializes the annotations for <b>elver.org/displayLabel</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createDisplayLabelAnnotations() {
		String source = "elver.org/displayLabel";		
		addAnnotation
		  (artistEClass, 
		   source, 
		   new String[] {
			 "value", "${firstName} ${lastName}"
		   });							
		addAnnotation
		  (albumEClass, 
		   source, 
		   new String[] {
			 "value", "${name}"
		   });							
		addAnnotation
		  (countryEClass, 
		   source, 
		   new String[] {
			 "value", "${name}"
		   });								
		addAnnotation
		  (genreEClass, 
		   source, 
		   new String[] {
			 "value", "${name}"
		   });							
	}

	/**
	 * Initializes the annotations for <b>elver.org/naturalOrdering</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createNaturalOrderingAnnotations() {
		String source = "elver.org/naturalOrdering";			
		addAnnotation
		  (artistEClass, 
		   source, 
		   new String[] {
			 "value", "lastName,firstName"
		   });							
		addAnnotation
		  (albumEClass, 
		   source, 
		   new String[] {
			 "value", "name"
		   });							
		addAnnotation
		  (countryEClass, 
		   source, 
		   new String[] {
			 "value", "name"
		   });								
		addAnnotation
		  (genreEClass, 
		   source, 
		   new String[] {
			 "value", "name"
		   });						
	}

	/**
	 * Initializes the annotations for <b>elver.org/displayAttributes</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createDisplayAttributesAnnotations() {
		String source = "elver.org/displayAttributes";				
		addAnnotation
		  (artistEClass, 
		   source, 
		   new String[] {
			 "value", "lastName,firstName"
		   });																								
	}

	/**
	 * Initializes the annotations for <b>teneo.jpa</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createTeneoAnnotations() {
		String source = "teneo.jpa";					
		addAnnotation
		  (getArtist_Id(), 
		   source, 
		   new String[] {
			 "value", "@Id @GeneratedValue"
		   });		
		addAnnotation
		  (getArtist_Version(), 
		   source, 
		   new String[] {
			 "value", "@Version"
		   });					
		addAnnotation
		  (getAlbum_Id(), 
		   source, 
		   new String[] {
			 "value", "@Id @GeneratedValue"
		   });		
		addAnnotation
		  (getAlbum_Version(), 
		   source, 
		   new String[] {
			 "value", "@Version"
		   });		
		addAnnotation
		  (getAlbum_Genres(), 
		   source, 
		   new String[] {
			 "value", "@ManyToMany"
		   });		
		addAnnotation
		  (getAlbum_Songs(), 
		   source, 
		   new String[] {
			 "value", "@OneToMany"
		   });				
		addAnnotation
		  (getCountry_Code(), 
		   source, 
		   new String[] {
			 "value", "@Id"
		   });				
		addAnnotation
		  (getCountry_Version(), 
		   source, 
		   new String[] {
			 "value", "@Version"
		   });					
		addAnnotation
		  (getGenre_Id(), 
		   source, 
		   new String[] {
			 "value", "@Id @GeneratedValue"
		   });		
		addAnnotation
		  (getGenre_Version(), 
		   source, 
		   new String[] {
			 "value", "@Version"
		   });		
		addAnnotation
		  (getSong_Id(), 
		   source, 
		   new String[] {
			 "value", "@Id @GeneratedValue"
		   });		
		addAnnotation
		  (getSong_Version(), 
		   source, 
		   new String[] {
			 "value", "@Version"
		   });		
	}

	/**
	 * Initializes the annotations for <b>elver.org/searchable</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createSearchableAnnotations() {
		String source = "elver.org/searchable";							
		addAnnotation
		  (getArtist_LastName(), 
		   source, 
		   new String[] {
			 "value", "true"
		   });												
		addAnnotation
		  (getCountry_Code(), 
		   source, 
		   new String[] {
			 "value", "no"
		   });										
	}

	/**
	 * Initializes the annotations for <b>elver.org/maxLength</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createMaxLengthAnnotations() {
		String source = "elver.org/maxLength";																	
		addAnnotation
		  (getCountry_Code(), 
		   source, 
		   new String[] {
			 "value", "2"
		   });											
		addAnnotation
		  (getSong_Track(), 
		   source, 
		   new String[] {
			 "value", "2"
		   });		
		addAnnotation
		  (getSong_Name(), 
		   source, 
		   new String[] {
			 "value", "40"
		   });
	}

	/**
	 * Initializes the annotations for <b>elver.org/displayLength</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createDisplayLengthAnnotations() {
		String source = "elver.org/displayLength";																				
		addAnnotation
		  (getCountry_Name(), 
		   source, 
		   new String[] {
			 "value", "40"
		   });								
	}

} //MusicPackageImpl
