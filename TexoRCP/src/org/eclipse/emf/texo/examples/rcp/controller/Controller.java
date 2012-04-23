package org.eclipse.emf.texo.examples.rcp.controller;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.texo.examples.rcp.music.Album;
import org.eclipse.emf.texo.examples.rcp.music.MusicFactory;
import org.eclipse.emf.texo.examples.rcp.music.MusicPackage;
import org.eclipse.emf.texo.examples.rcp.osgi.services.PersistenceService;
import org.eclipse.emf.texo.examples.rcp.util.Utils;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

public class Controller {
	private static Controller instance;
	private static Album album;
	private Adapter adapter;
//	private static PersistenceService service;

	public static Controller getInstance() {
		if (instance == null) {
			instance = new Controller();
//			service = getPersistenceService();
			connect();
		}
		album = Utils.getSampleAlbum();
		album.eAdapters().add(new AdapterImpl() {
			
			public void notifyChanged(Notification notification) {
				super.notifyChanged(notification);
				System.out.println("Controller - model has changed!!!");
			}
		});
		return instance;
	}

	public static boolean connect() {
		getInstance();
		// init
		// Initialize the model
//		MusicPackage.eINSTANCE.eClass();
		//
		System.out.println("connected");
//		return service.connect();
		return true;
	}

	public static boolean isConnected() {
		getInstance();
//		return service.isConnected();
		return true;
	}

	public static boolean disconnect() {
		getInstance();
//		return service.disconnect();
		return true;
	}

	public static boolean save(Album album) {
		getInstance();
//		return service.save(album);
		return true;
	}

	public static Album load() {
		getInstance();
//		return service.load();
		return Utils.getSampleAlbum();
	}

	public static Album getAlbum() {
		getInstance();
		return album;
	}

	public static void setAlbum(Album newAlbum) {
		getInstance();
		album = newAlbum;
	}

	public static PersistenceService getPersistenceService() {
		try {
			BundleContext context = FrameworkUtil.getBundle(Controller.class)
					.getBundleContext();
			ServiceReference<?> serviceReference = context
					.getServiceReference(PersistenceService.class.getName());
			return (PersistenceService) context.getService(serviceReference);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
