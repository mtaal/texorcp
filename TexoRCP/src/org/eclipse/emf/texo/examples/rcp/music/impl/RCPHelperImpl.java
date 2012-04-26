/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.texo.examples.rcp.music.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.texo.examples.rcp.music.Album;
import org.eclipse.emf.texo.examples.rcp.music.MusicPackage;
import org.eclipse.emf.texo.examples.rcp.music.RCPHelper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>RCP Helper</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.texo.examples.rcp.music.impl.RCPHelperImpl#getAlbums <em>Albums</em>}</li>
 *   <li>{@link org.eclipse.emf.texo.examples.rcp.music.impl.RCPHelperImpl#getSelected <em>Selected</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RCPHelperImpl extends EObjectImpl implements RCPHelper {
	/**
	 * The cached value of the '{@link #getAlbums() <em>Albums</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlbums()
	 * @generated
	 * @ordered
	 */
	protected EList<Album> albums;

	/**
	 * The cached value of the '{@link #getSelected() <em>Selected</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelected()
	 * @generated
	 * @ordered
	 */
	protected Album selected;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RCPHelperImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MusicPackage.Literals.RCP_HELPER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Album> getAlbums() {
		if (albums == null) {
			albums = new EObjectResolvingEList<Album>(Album.class, this, MusicPackage.RCP_HELPER__ALBUMS);
		}
		return albums;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Album getSelected() {
		if (selected != null && selected.eIsProxy()) {
			InternalEObject oldSelected = (InternalEObject)selected;
			selected = (Album)eResolveProxy(oldSelected);
			if (selected != oldSelected) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MusicPackage.RCP_HELPER__SELECTED, oldSelected, selected));
			}
		}
		return selected;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Album basicGetSelected() {
		return selected;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelected(Album newSelected) {
		Album oldSelected = selected;
		selected = newSelected;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MusicPackage.RCP_HELPER__SELECTED, oldSelected, selected));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MusicPackage.RCP_HELPER__ALBUMS:
				return getAlbums();
			case MusicPackage.RCP_HELPER__SELECTED:
				if (resolve) return getSelected();
				return basicGetSelected();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MusicPackage.RCP_HELPER__ALBUMS:
				getAlbums().clear();
				getAlbums().addAll((Collection<? extends Album>)newValue);
				return;
			case MusicPackage.RCP_HELPER__SELECTED:
				setSelected((Album)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MusicPackage.RCP_HELPER__ALBUMS:
				getAlbums().clear();
				return;
			case MusicPackage.RCP_HELPER__SELECTED:
				setSelected((Album)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MusicPackage.RCP_HELPER__ALBUMS:
				return albums != null && !albums.isEmpty();
			case MusicPackage.RCP_HELPER__SELECTED:
				return selected != null;
		}
		return super.eIsSet(featureID);
	}

} //RCPHelperImpl
