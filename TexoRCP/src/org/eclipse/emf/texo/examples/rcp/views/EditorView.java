package org.eclipse.emf.texo.examples.rcp.views;

import org.eclipse.emf.texo.examples.rcp.controller.Controller;
import org.eclipse.emf.texo.examples.rcp.gui.widgets.edit.AlbumEditComposite;
import org.eclipse.emf.texo.examples.rcp.music.Album;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class EditorView extends ViewPart {
	public EditorView() {
	}

	public static final String ID = "org.eclipse.emf.texo.examples.rcp.views.editorview";
	private AlbumEditComposite ac;

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		
		ac = new AlbumEditComposite(parent, SWT.NONE);
		ac.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		setAlbum(Controller.getInstance().getAlbum());
	}
	
	public void setAlbum(Album album) {
		ac.setAlbum(album);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}
}