package org.eclipse.emf.texo.examples.rcp.controller;

import org.eclipse.emf.texo.examples.rcp.music.Album;
import org.eclipse.emf.texo.examples.rcp.osgi.services.PersistenceService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

public class Controller {
	private static Controller instance;
	private static Album album;
	private static PersistenceService service;

	public static Controller getInstance() {
		if (instance == null) {
			instance = new Controller();
		}

		// get the persistence service
		service = getPersistenceService();
		if (!service.isConnected()) {
			service.connect();
		}

		return instance;
	}
	
	public static boolean connect() {
		return service.connect();
	}
	
	public static boolean isConnected() {
		return service.isConnected();
	}
	
	public static boolean disconnect() {
		return service.disconnect();
	}
	
	public static boolean save(Album album) {
		return service.save(album);
	}
	
	public static Album load() {
		return service.load();
	}

	public static Album getAlbum() {
		return album;
	}
	
	public static void setAlbum(Album newAlbum) {
		album = newAlbum;
	}

	public static PersistenceService getPersistenceService() {
		BundleContext context = FrameworkUtil.getBundle(Controller.class)
				.getBundleContext();
		ServiceReference<?> serviceReference = context
				.getServiceReference(PersistenceService.class.getName());
		return (PersistenceService) context.getService(serviceReference);
	}
}
