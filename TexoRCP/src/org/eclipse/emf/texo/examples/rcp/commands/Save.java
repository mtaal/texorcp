package org.eclipse.emf.texo.examples.rcp.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.texo.examples.rcp.controller.Controller;

public class Save extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if (!Controller.isConnected()) {
			Controller.connect();
		}
		// move the stuff into the resource
		// add all albums
		EList<EObject> content = new BasicEList<EObject>();
		content.add(Controller.getRCP());
		System.out.println("added " + Controller.getRCP());
		EList<EReference> contains = Controller.getRCP().eClass()
				.getEAllContainments();
		for (EReference ref : contains) {
			System.err.println(ref.getName());
			content.add((EObject) Controller.getRCP().eGet(ref));
		}
		System.out.println("contained elements: " + content.size());
		 Controller.save(content);
		return null;
	}
}