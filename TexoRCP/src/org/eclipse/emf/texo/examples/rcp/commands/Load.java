package org.eclipse.emf.texo.examples.rcp.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.texo.examples.rcp.controller.Controller;
import org.eclipse.emf.texo.examples.rcp.music.Album;

public class Load extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if (!Controller.isConnected()) {
			Controller.connect();
		}
		Album album = Controller.load();
		System.out.println("loaded album from XML '"+album.getName()+"'");
		Controller.setAlbum(album);
		return null;
	}
}