/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.texo.examples.rcp.music;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Album Data Base</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.texo.examples.rcp.music.AlbumDataBase#getAlbums <em>Albums</em>}</li>
 *   <li>{@link org.eclipse.emf.texo.examples.rcp.music.AlbumDataBase#getSelected <em>Selected</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.texo.examples.rcp.music.MusicPackage#getAlbumDataBase()
 * @model
 * @generated
 */
public interface AlbumDataBase extends EObject {
	/**
	 * Returns the value of the '<em><b>Albums</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.texo.examples.rcp.music.Album}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Albums</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Albums</em>' reference list.
	 * @see org.eclipse.emf.texo.examples.rcp.music.MusicPackage#getAlbumDataBase_Albums()
	 * @model
	 * @generated
	 */
	EList<Album> getAlbums();

	/**
	 * Returns the value of the '<em><b>Selected</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selected</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selected</em>' reference.
	 * @see #setSelected(Album)
	 * @see org.eclipse.emf.texo.examples.rcp.music.MusicPackage#getAlbumDataBase_Selected()
	 * @model
	 * @generated
	 */
	Album getSelected();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.texo.examples.rcp.music.AlbumDataBase#getSelected <em>Selected</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selected</em>' reference.
	 * @see #getSelected()
	 * @generated
	 */
	void setSelected(Album value);

} // AlbumDataBase