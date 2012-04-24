package org.eclipse.emf.texo.examples.rcp.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.texo.examples.rcp.controller.Controller;

public class Load extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if (!Controller.isConnected()) {
			Controller.connect();
		}

		// // convert EObjects to Album
		// EList<EObject> objList = Controller.load();
		// EList<Album> albums = new BasicEList<Album>();
		// for (int i = 0; i < objList.size(); i++) {
		// EObject o = objList.get(i);
		// if (o instanceof Album) {
		// albums.add((Album) o);
		// }
		// }
		// Controller.getInstance().getAlbumList().getAlbums().clear();
		// Controller.getInstance().getAlbumList().getAlbums().addAll(albums);
		Controller.getInstance().getContents().clear();
		EList<EObject> list = Controller.load();
		Controller.getInstance().getContents().addAll(list);
		System.out.println("loaded " + list.size() + "albums from XML");
		return null;
	}
}