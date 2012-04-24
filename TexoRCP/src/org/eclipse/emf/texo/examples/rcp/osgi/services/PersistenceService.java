package org.eclipse.emf.texo.examples.rcp.osgi.services;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * IMPORTANT:<br>
 * the service is only starting if<br>
 * Service-Component: OSGI-INF/PersistenceService.xml<br>
 * Bundle-ActivationPolicy: lazy<br>
 * is in your MANIFEST.MF
 * 
 * @author lumo
 * 
 */
public interface PersistenceService {

	public boolean connect();

	public boolean disconnect();

	public Boolean isConnected();

	public boolean save(EList<EObject> data);

	public EList<EObject> load();
}