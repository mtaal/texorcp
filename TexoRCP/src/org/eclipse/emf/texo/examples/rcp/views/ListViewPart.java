package org.eclipse.emf.texo.examples.rcp.views;

import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.texo.examples.rcp.controller.Controller;
import org.eclipse.emf.texo.examples.rcp.music.Album;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;

public class ListViewPart extends ViewPart {

	public static final String ID = "org.eclipse.emf.texo.examples.rcp.views.ListViewPart"; //$NON-NLS-1$
	private Table table;
	private TableViewer tableViewer;
	private EContentAdapter adapter;

	public ListViewPart() {
	}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		adapter = new EContentAdapter() {

			public void notifyChanged(Notification notification) {
				super.notifyChanged(notification);
				System.out.println("<!--");
				
				System.out.println("event-Type:\t"+notification.getEventType());
				System.out.println("notification.getNotifier() = "
						+ notification.getNotifier());
				System.out.println("feature:\t"+notification.getFeature());
				EStructuralFeature feature = (EStructuralFeature) notification.getFeature();
				if (feature!=null){
				System.out.println("feature Name: "+feature.getName());
				System.out.println("-->");
				}
////				super.notifyChanged(notification);
//				System.out.println("notification.getNotifier() = "
//						+ notification.getNotifier());
//				if (notification.getNotifier() instanceof Controller) {
//					// featureID is always -1 no clue why;
//					try {
//						System.out.println("feature changed: "+notification.getFeature());
////						
////						IObservableList albumsList = EMFProperties
////								.list(MusicPackage.Literals.ALBUM_LIST__ALBUMS)
////								.observe(
////										Controller.getInstance().getContents());
////						tableViewer.setInput(albumsList);
////						System.out.println("now there are "
////								+ Controller.getInstance().getAlbumList()
////										.getAlbums().size()
////								+ " albums in the list");
//					} catch (Exception e) {
//						// widget disposed.
//					}
//
//					// switch (notification.getFeatureID(AlbumList.class)) {
//					// case MusicPackage.ALBUM_LIST__ALBUMS:
//					// System.out.println("album count changed!");
//					// break;
//					//
//					// default:
//					// System.out.println(notification.getFeatureID(Controller.class));
//					// System.out.println("wtf?");
//					// break;
//					// }
//				} else {
//					System.out.println("ELSE: "+notification.getNotifier());
//				}
			}
		};
		// register adapter
		Controller.getRegisterAdapters().add(adapter);
		System.out.println("ListView registered the adapter");

		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(1, false));
		{
			tableViewer = new TableViewer(container, SWT.BORDER
					| SWT.FULL_SELECTION);
			table = tableViewer.getTable();
			table.setHeaderVisible(true);
			table.setLinesVisible(true);
			table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1,
					1));
			{
				TableViewerColumn tableViewerColumn = new TableViewerColumn(
						tableViewer, SWT.NONE);
				TableColumn tblclmnName = tableViewerColumn.getColumn();
				tblclmnName.setWidth(100);
				tblclmnName.setText("Name");
			}
			{
				TableViewerColumn tableViewerColumn = new TableViewerColumn(
						tableViewer, SWT.NONE);
				TableColumn tblclmnArtist = tableViewerColumn.getColumn();
				tblclmnArtist.setWidth(100);
				tblclmnArtist.setText("Artist");
			}
			{
				TableViewerColumn tableViewerColumn = new TableViewerColumn(
						tableViewer, SWT.NONE);
				TableColumn tblclmnReleasedIn = tableViewerColumn.getColumn();
				tblclmnReleasedIn.setWidth(100);
				tblclmnReleasedIn.setText("released in");
			}
			{
				TableViewerColumn tableViewerColumn = new TableViewerColumn(
						tableViewer, SWT.NONE);
				TableColumn tblclmnSongs = tableViewerColumn.getColumn();
				tblclmnSongs.setWidth(100);
				tblclmnSongs.setText("Songs");
			}

			ObservableListContentProvider contentProvider = new ObservableListContentProvider();
			tableViewer.setContentProvider(contentProvider);
			tableViewer.getTable().addKeyListener(new KeyListener() {

				@SuppressWarnings("unchecked")
				@Override
				public void keyReleased(KeyEvent e) {
					if (e.keyCode == SWT.DEL) {
						StructuredSelection structuredSelection = (StructuredSelection) tableViewer
								.getSelection();
						// or iterate over all elements
						for (Iterator<Album> iterator = structuredSelection
								.iterator(); iterator.hasNext();) {
							Album a = iterator.next();
							Controller.getInstance().getContents().remove(a);
						}
					}
				}

				@Override
				public void keyPressed(KeyEvent e) {
				}
			});
		}
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	public void dispose() {
		Controller.getRegisterAdapters().remove(adapter);
	}
}