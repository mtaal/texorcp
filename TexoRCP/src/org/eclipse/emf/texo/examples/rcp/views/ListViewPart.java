package org.eclipse.emf.texo.examples.rcp.views;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.texo.examples.rcp.controller.Controller;
import org.eclipse.emf.texo.examples.rcp.music.Album;
import org.eclipse.emf.texo.examples.rcp.music.AlbumDataBase;
import org.eclipse.emf.texo.examples.rcp.music.MusicPackage;
import org.eclipse.emf.texo.examples.rcp.music.Rating;
import org.eclipse.emf.texo.examples.rcp.util.Utils;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

public class ListViewPart extends ViewPart {

	public static final String ID = "org.eclipse.emf.texo.examples.rcp.views.ListViewPart"; //$NON-NLS-1$
	private Table table;
	private TableViewer tableViewer;
	private EContentAdapter adapter;
	private Album lastSelection;

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
				// System.out.println("<!--");
				//
				// System.out.println("event-Type:\t"
				// + notification.getEventType());
				// System.out.println("notification.getNotifier() = "
				// + notification.getNotifier());
				// System.out.println("feature:\t" + notification.getFeature());
				// EStructuralFeature feature = (EStructuralFeature)
				// notification
				// .getFeature();
				// System.out.println("feature ID: "
				// + notification.getFeatureID(notification.getNotifier()
				// .getClass()));
				// if (feature != null) {
				// System.out.println("feature Name: " + feature.getName());
				// System.out.println("-->");
				// }
				if (notification.getNotifier() instanceof Album) {
					// update the list too..
					tableViewer.refresh(true);
					return;
				}
				if (notification.getNotifier() instanceof AlbumDataBase) {
					switch (notification.getFeatureID(AlbumDataBase.class)) {
					case MusicPackage.ALBUM_DATA_BASE__ALBUMS:
						IObservableList albumsList = EMFProperties.list(
								MusicPackage.Literals.ALBUM_DATA_BASE__ALBUMS)
								.observe(
										((AlbumDataBase) notification
												.getNotifier()));
						if (!tableViewer.getTable().isDisposed()) {
							tableViewer.setInput(albumsList);
						}
						System.out.println("now there are " + albumsList.size()
								+ " albums in the list");
						return;
					case MusicPackage.ALBUM_DATA_BASE__SELECTED:
						Album a = ((AlbumDataBase) notification.getNotifier())
								.getSelected();
						System.out.println(a.getName() + " selected.");
						return;

					default:
						break;
					}
				}
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
				tblclmnName.setWidth(21);
				// tblclmnName.setText("");
			}
			{
				TableViewerColumn tableViewerColumn = new TableViewerColumn(
						tableViewer, SWT.NONE);
				TableColumn tblclmnName = tableViewerColumn.getColumn();
				tblclmnName.setWidth(75);
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
				tblclmnReleasedIn.setWidth(40);
				tblclmnReleasedIn.setText("Year");
			}
			{
				TableViewerColumn tableViewerColumn = new TableViewerColumn(
						tableViewer, SWT.NONE);
				TableColumn tblclmnSongs = tableViewerColumn.getColumn();
				tblclmnSongs.setWidth(41);
				tblclmnSongs.setText("Titles");
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

			tableViewer.setLabelProvider(new AlbumListLabelProvider());
			tableViewer
					.addSelectionChangedListener(new ISelectionChangedListener() {

						@Override
						public void selectionChanged(SelectionChangedEvent event) {
							StructuredSelection selection = (StructuredSelection) tableViewer
									.getSelection();
							Controller.getAlbumDataBase().setSelected(
									(Album) selection.getFirstElement());

							if (lastSelection != null) {
								lastSelection.eAdapters().remove(adapter);
							}
							lastSelection = (Album) selection.getFirstElement();
							lastSelection.eAdapters().add(adapter);
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

	class AlbumListLabelProvider extends LabelProvider implements
			ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			Album a = (Album) obj;
			switch (index) {
			case 0:
				// RATING
				int high = 0;
				for (Iterator<Rating> iterator = a.getRatings().iterator(); iterator
						.hasNext();) {
					Rating r = iterator.next();
					if (r.equals(Rating.HIGH)) {
						high++;
					}
				}
				int total = a.getRatings().size();
				double rating = (double) high / (double) total;
				DecimalFormat f = new DecimalFormat("#0.00");
				return f.format(rating);
			case 1:
				// NAME
				return a.getName();
			case 2:
				// ARTIST
				return String.format("%s %s", a.getArtist().getFirstName(), a
						.getArtist().getLastName());
			case 3:
				// RELEASE DATE
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
				return sdf.format(a.getReleaseDate());
			case 4:
				// SONG COUNT
				return String.format("%d", a.getSongs().size());

			default:
				break;
			}
			return index + " " + obj.toString();
		}

		public Image getColumnImage(Object obj, int index) {
			Album a = (Album) obj;
			switch (index) {
			case 0:
				// rating
				int high = 0;
				for (Iterator<Rating> iterator = a.getRatings().iterator(); iterator
						.hasNext();) {
					Rating r = iterator.next();
					if (r.equals(Rating.HIGH)) {
						high++;
					}
				}
				int total = a.getRatings().size();
				Rating r = Rating.LOW;
				if (high > total - high) {
					r = Rating.HIGH;
				}
				return Utils.getImage(Utils.getRating(r));

			default:
				return null;
			}
		}

		public Image getImage(Object obj) {
			return PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}
	}
}