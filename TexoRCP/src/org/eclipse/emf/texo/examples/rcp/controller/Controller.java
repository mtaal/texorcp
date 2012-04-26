package org.eclipse.emf.texo.examples.rcp.controller;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.texo.examples.rcp.music.Album;
import org.eclipse.emf.texo.examples.rcp.music.MusicFactory;
import org.eclipse.emf.texo.examples.rcp.music.RCPHelper;
import org.eclipse.emf.texo.examples.rcp.osgi.services.PersistenceService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

public class Controller extends ResourceImpl {
	// public static final int CONTROLLER__SELECTED_ALBUM = 100;

	private static Controller instance;
	private static PersistenceService service;
	// private static Album dummyAlbum = Utils.getNewAlbum();
	// private static Album selectedAlbum = dummyAlbum;
	// private static IObservableList albumList;
	private static RCPHelper helper;

	private static EContentAdapter adapter;

	public static RCPHelper getRCP() {
		getInstance();
		return helper;
	}

	public static Album getSelectedAlbum() {
		return getRCP().getSelected();
	}

	public static void add(EContentAdapter adapter) {
		getInstance().eAdapters().add(adapter);
	}

	public static void remove(EContentAdapter adapter2) {
		getInstance().eAdapters().remove(adapter);
	}

	public static Controller getInstance() {
		if (instance == null) {
			instance = new Controller();
			service = getPersistenceService();
			connect();

			helper = MusicFactory.eINSTANCE.createRCPHelper();
			// albumList = new WritableList(new BasicEList<Album>(),
			// Album.class);
			// adapter = new EContentAdapter() {
			//
			// public void notifyChanged(Notification notification) {
			// super.notifyChanged(notification);
			//
			// if (notification.getNotifier() instanceof Controller) {
			// switch (notification.getFeatureID(Controller.class)) {
			// case Controller.RESOURCE__CONTENTS: {
			// if (notification.getNewValue() instanceof Album) {
			// Controller.albumList.add((Album) notification
			// .getNewValue());
			// System.out
			// .println("added an Album to the List of Albums.");
			// return;
			// }
			// }
			// }
			// }
			// }
			// };
			// instance.eAdapters().add(adapter);
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

	public static EList<Album> getAlbumList() {
		return getRCP().getAlbums();
	}
}