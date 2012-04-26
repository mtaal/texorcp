package org.eclipse.emf.texo.examples.rcp.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.texo.examples.rcp.controller.Controller;
import org.eclipse.emf.texo.examples.rcp.music.Album;
import org.eclipse.emf.texo.examples.rcp.util.Utils;

public class LoadExampleAlbum extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Album a = Utils.getSampleAlbum();
		Controller.getRCP().getAlbums().clear();
		Controller.getRCP().getAlbums().add(a);
		System.out.println("loaded one example album");
		return null;
	}
}