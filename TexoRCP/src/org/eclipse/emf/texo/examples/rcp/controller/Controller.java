package org.eclipse.emf.texo.examples.rcp.controller;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.texo.examples.rcp.music.AlbumDataBase;
import org.eclipse.emf.texo.examples.rcp.music.MusicFactory;
import org.eclipse.emf.texo.examples.rcp.osgi.services.PersistenceService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

public class Controller extends ResourceImpl {
	private static Controller instance;
	private static PersistenceService service;
	private static AlbumDataBase adb;
	
	public static AlbumDataBase getAlbumDataBase() {
		getInstance();
		return adb;
	}

	public static EList<Adapter> getRegisterAdapters() {
//		return getInstance().eAdapters();
		 return getAlbumDataBase().eAdapters();
	}

	public static Controller getInstance() {
		if (instance == null) {
			instance = new Controller();
			service = getPersistenceService();
			connect();
			// LOADS THE DEFAULT ALBUM
			// album = Utils.getSampleAlbum();
			adb = MusicFactory.eINSTANCE.createAlbumDataBase();
			instance.getContents().add(adb);
		}
		return instance;
	}

	public static boolean connect() {
		getInstance();
		// System.out.println("connected");
		return service.connect();
	}

	public static boolean isConnected() {
		getInstance();
		return service.isConnected();
	}

	public static boolean disconnect() {
		getInstance();
		return service.disconnect();
	}

	public static boolean save(EList<EObject> data) {
		getInstance();
		return service.save(data);
	}

	public static EList<EObject> load() {
		getInstance();
		return service.load();
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