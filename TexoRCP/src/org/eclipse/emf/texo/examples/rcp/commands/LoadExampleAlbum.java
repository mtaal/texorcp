package org.eclipse.emf.texo.examples.rcp.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.texo.examples.rcp.controller.Controller;
import org.eclipse.emf.texo.examples.rcp.util.Utils;

public class LoadExampleAlbum extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Controller.setAlbum(Utils.getSampleAlbum());
		System.out.println("loaded example data");
		return null;
	}
}