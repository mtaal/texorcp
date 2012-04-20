/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.texo.examples.rcp.music;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Album</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.texo.examples.rcp.music.Album#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.emf.texo.examples.rcp.music.Album#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.emf.texo.examples.rcp.music.Album#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.texo.examples.rcp.music.Album#getArtist <em>Artist</em>}</li>
 *   <li>{@link org.eclipse.emf.texo.examples.rcp.music.Album#getReleaseDate <em>Release Date</em>}</li>
 *   <li>{@link org.eclipse.emf.texo.examples.rcp.music.Album#getGenres <em>Genres</em>}</li>
 *   <li>{@link org.eclipse.emf.texo.examples.rcp.music.Album#getSongs <em>Songs</em>}</li>
 *   <li>{@link org.eclipse.emf.texo.examples.rcp.music.Album#getRatings <em>Ratings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.texo.examples.rcp.music.MusicPackage#getAlbum()
 * @model annotation="elver.org/displayLabel value='${name}'"
 *        annotation="elver.org/naturalOrdering value='name'"
 * @generated
 */
public interface Album extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(long)
	 * @see org.eclipse.emf.texo.examples.rcp.music.MusicPackage#getAlbum_Id()
	 * @model id="true"
	 *        annotation="teneo.jpa value='@Id @GeneratedValue'"
	 * @generated
	 */
	long getId();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.texo.examples.rcp.music.Album#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(long value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(Long)
	 * @see org.eclipse.emf.texo.examples.rcp.music.MusicPackage#getAlbum_Version()
	 * @model annotation="teneo.jpa value='@Version'"
	 * @generated
	 */
	Long getVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.texo.examples.rcp.music.Album#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(Long value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.emf.texo.examples.rcp.music.MusicPackage#getAlbum_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.texo.examples.rcp.music.Album#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Artist</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Artist</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Artist</em>' reference.
	 * @see #setArtist(Artist)
	 * @see org.eclipse.emf.texo.examples.rcp.music.MusicPackage#getAlbum_Artist()
	 * @model
	 * @generated
	 */
	Artist getArtist();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.texo.examples.rcp.music.Album#getArtist <em>Artist</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Artist</em>' reference.
	 * @see #getArtist()
	 * @generated
	 */
	void setArtist(Artist value);

	/**
	 * Returns the value of the '<em><b>Release Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Release Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Release Date</em>' attribute.
	 * @see #setReleaseDate(Date)
	 * @see org.eclipse.emf.texo.examples.rcp.music.MusicPackage#getAlbum_ReleaseDate()
	 * @model
	 * @generated
	 */
	Date getReleaseDate();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.texo.examples.rcp.music.Album#getReleaseDate <em>Release Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Release Date</em>' attribute.
	 * @see #getReleaseDate()
	 * @generated
	 */
	void setReleaseDate(Date value);

	/**
	 * Returns the value of the '<em><b>Genres</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.texo.examples.rcp.music.Genre}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Genres</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Genres</em>' reference list.
	 * @see org.eclipse.emf.texo.examples.rcp.music.MusicPackage#getAlbum_Genres()
	 * @model annotation="teneo.jpa value='@ManyToMany'"
	 * @generated
	 */
	EList<Genre> getGenres();

	/**
	 * Returns the value of the '<em><b>Songs</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.texo.examples.rcp.music.Song}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Songs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Songs</em>' containment reference list.
	 * @see org.eclipse.emf.texo.examples.rcp.music.MusicPackage#getAlbum_Songs()
	 * @model containment="true"
	 *        annotation="teneo.jpa value='@OneToMany'"
	 * @generated
	 */
	EList<Song> getSongs();

	/**
	 * Returns the value of the '<em><b>Ratings</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.texo.examples.rcp.music.Rating}.
	 * The literals are from the enumeration {@link org.eclipse.emf.texo.examples.rcp.music.Rating}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ratings</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ratings</em>' attribute list.
	 * @see org.eclipse.emf.texo.examples.rcp.music.Rating
	 * @see org.eclipse.emf.texo.examples.rcp.music.MusicPackage#getAlbum_Ratings()
	 * @model unique="false"
	 * @generated
	 */
	EList<Rating> getRatings();

} // Album
