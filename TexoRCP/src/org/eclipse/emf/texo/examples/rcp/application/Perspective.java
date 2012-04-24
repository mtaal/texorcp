package org.eclipse.emf.texo.examples.rcp.application;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IFolderLayout;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		layout.setFixed(true);
		{
			IFolderLayout folderLayout = layout.createFolder("folder", IPageLayout.TOP, 0.5f, IPageLayout.ID_EDITOR_AREA);
			folderLayout.addView("org.eclipse.emf.texo.examples.rcp.views.ListViewPart");
		}
		layout.addView("org.eclipse.emf.texo.examples.rcp.views.view", IPageLayout.RIGHT, 0.37f, "folder");
		layout.addView("org.eclipse.emf.texo.examples.rcp.views.editorview", IPageLayout.BOTTOM, 0.5f, "org.eclipse.emf.texo.examples.rcp.views.view");
	}
}