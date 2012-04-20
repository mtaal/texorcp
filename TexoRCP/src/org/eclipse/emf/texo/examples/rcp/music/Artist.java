/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.texo.examples.rcp.music;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Artist</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.texo.examples.rcp.music.Artist#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.emf.texo.examples.rcp.music.Artist#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.emf.texo.examples.rcp.music.Artist#getFirstName <em>First Name</em>}</li>
 *   <li>{@link org.eclipse.emf.texo.examples.rcp.music.Artist#getLastName <em>Last Name</em>}</li>
 *   <li>{@link org.eclipse.emf.texo.examples.rcp.music.Artist#getBirthDate <em>Birth Date</em>}</li>
 *   <li>{@link org.eclipse.emf.texo.examples.rcp.music.Artist#getCountry <em>Country</em>}</li>
 *   <li>{@link org.eclipse.emf.texo.examples.rcp.music.Artist#getGenre <em>Genre</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.texo.examples.rcp.music.MusicPackage#getArtist()
 * @model annotation="elver.org/displayLabel value='${firstName} ${lastName}'"
 *        annotation="elver.org/naturalOrdering value='lastName,firstName'"
 *        annotation="elver.org/displayAttributes value='lastName,firstName'"
 * @generated
 */
public interface Artist extends EObject {
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
	 * @see org.eclipse.emf.texo.examples.rcp.music.MusicPackage#getArtist_Id()
	 * @model id="true"
	 *        annotation="teneo.jpa value='@Id @GeneratedValue'"
	 * @generated
	 */
	long getId();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.texo.examples.rcp.music.Artist#getId <em>Id</em>}' attribute.
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
	 * @see org.eclipse.emf.texo.examples.rcp.music.MusicPackage#getArtist_Version()
	 * @model annotation="teneo.jpa value='@Version'"
	 * @generated
	 */
	Long getVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.texo.examples.rcp.music.Artist#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(Long value);

	/**
	 * Returns the value of the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Name</em>' attribute.
	 * @see #setFirstName(String)
	 * @see org.eclipse.emf.texo.examples.rcp.music.MusicPackage#getArtist_FirstName()
	 * @model
	 * @generated
	 */
	String getFirstName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.texo.examples.rcp.music.Artist#getFirstName <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Name</em>' attribute.
	 * @see #getFirstName()
	 * @generated
	 */
	void setFirstName(String value);

	/**
	 * Returns the value of the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Name</em>' attribute.
	 * @see #setLastName(String)
	 * @see org.eclipse.emf.texo.examples.rcp.music.MusicPackage#getArtist_LastName()
	 * @model annotation="elver.org/searchable value='true'"
	 * @generated
	 */
	String getLastName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.texo.examples.rcp.music.Artist#getLastName <em>Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Name</em>' attribute.
	 * @see #getLastName()
	 * @generated
	 */
	void setLastName(String value);

	/**
	 * Returns the value of the '<em><b>Birth Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Birth Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Birth Date</em>' attribute.
	 * @see #setBirthDate(Date)
	 * @see org.eclipse.emf.texo.examples.rcp.music.MusicPackage#getArtist_BirthDate()
	 * @model
	 * @generated
	 */
	Date getBirthDate();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.texo.examples.rcp.music.Artist#getBirthDate <em>Birth Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Birth Date</em>' attribute.
	 * @see #getBirthDate()
	 * @generated
	 */
	void setBirthDate(Date value);

	/**
	 * Returns the value of the '<em><b>Country</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Country</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Country</em>' reference.
	 * @see #setCountry(Country)
	 * @see org.eclipse.emf.texo.examples.rcp.music.MusicPackage#getArtist_Country()
	 * @model
	 * @generated
	 */
	Country getCountry();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.texo.examples.rcp.music.Artist#getCountry <em>Country</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Country</em>' reference.
	 * @see #getCountry()
	 * @generated
	 */
	void setCountry(Country value);

	/**
	 * Returns the value of the '<em><b>Genre</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Genre</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Genre</em>' reference.
	 * @see #setGenre(Genre)
	 * @see org.eclipse.emf.texo.examples.rcp.music.MusicPackage#getArtist_Genre()
	 * @model
	 * @generated
	 */
	Genre getGenre();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.texo.examples.rcp.music.Artist#getGenre <em>Genre</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Genre</em>' reference.
	 * @see #getGenre()
	 * @generated
	 */
	void setGenre(Genre value);

} // Artist
