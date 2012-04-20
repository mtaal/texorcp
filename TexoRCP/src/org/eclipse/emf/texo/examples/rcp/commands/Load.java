package org.eclipse.emf.texo.examples.rcp.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.texo.examples.rcp.controller.Controller;

public class Load extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if (!Controller.isConnected()) {
			Controller.connect();
		}
		Controller.setAlbum(Controller.load());
		return null;
	}
}