package org.eclipse.emf.texo.examples.rcp.osgi.services.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLResource.XMLInfo;
import org.eclipse.emf.ecore.xmi.XMLResource.XMLMap;
import org.eclipse.emf.ecore.xmi.impl.XMLInfoImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.emf.texo.examples.rcp.music.MusicPackage;
import org.eclipse.emf.texo.examples.rcp.osgi.services.PersistenceService;

public class PersistenceServiceImpl implements PersistenceService {
	private static URI xmlUri = URI.createFileURI(new File("model.xml")
			.getAbsolutePath());
	private static Resource resource;

	public PersistenceServiceImpl() {
		System.err.println(getClass().getInterfaces()[0].getName()
				+ " is now running.");
	}

	public Boolean isConnected() {
		return resource != null;
	}

	@Override
	public boolean connect() {
		ResourceSet resourceSet = new ResourceSetImpl();
		/*
		 * Register XML Factory implementation using DEFAULT_EXTENSION
		 */
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("*", new XMLResourceFactoryImpl());
		Resource res = resourceSet.getResource(xmlUri, false);
		if (res == null) {
			// System.out.println("created a new resource");
			resource = resourceSet.createResource(xmlUri);
		} else {
			// System.out.println("using existing resource");
			resource = res;
		}
		return true;
	}

	@Override
	public boolean disconnect() {
		resource = null;
		return resource == null;
	}

	public void get(String somethign) {
	}

	public EList<EObject> load() {
		System.out.println("trying to load from: " + xmlUri);
		if (isConnected()) {
			try {
				resource.getResourceSet().getPackageRegistry()
						.put(MusicPackage.eNS_URI, MusicPackage.eINSTANCE);
				resource.load(getOptions());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return resource.getContents();
		}
		return null;
	}

	public static Map<String, Object> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(XMLResource.OPTION_ENCODING, "UTF-8");

		XMLMap map = new XMLMapImpl();
		// put all infos in the map
		addXMLInfo(map, MusicPackage.Literals.ALBUM__ID);
		addXMLInfo(map, MusicPackage.Literals.ALBUM__VERSION);
		addXMLInfo(map, MusicPackage.Literals.ALBUM__NAME);
		addXMLInfo(map, MusicPackage.Literals.ALBUM__RATINGS);
		addXMLInfo(map, MusicPackage.Literals.ALBUM__RELEASE_DATE);

		// addXMLInfo(map, MusicPackage.Literals.COUNTRY__ID);
		addXMLInfo(map, MusicPackage.Literals.COUNTRY__VERSION);
		addXMLInfo(map, MusicPackage.Literals.COUNTRY__CODE);
		addXMLInfo(map, MusicPackage.Literals.COUNTRY__NAME);

		addXMLInfo(map, MusicPackage.Literals.ARTIST__ID);
		addXMLInfo(map, MusicPackage.Literals.ARTIST__VERSION);
		addXMLInfo(map, MusicPackage.Literals.ARTIST__FIRST_NAME);
		addXMLInfo(map, MusicPackage.Literals.ARTIST__LAST_NAME);
		addXMLInfo(map, MusicPackage.Literals.ARTIST__BIRTH_DATE);

		addXMLInfo(map, MusicPackage.Literals.SONG__ID);
		addXMLInfo(map, MusicPackage.Literals.SONG__VERSION);
		addXMLInfo(map, MusicPackage.Literals.SONG__NAME);
		addXMLInfo(map, MusicPackage.Literals.SONG__TRACK);

		addXMLInfo(map, MusicPackage.Literals.ALBUM__ARTIST);
		addXMLInfo(map, MusicPackage.Literals.ALBUM__SONGS);
		addXMLInfo(map, MusicPackage.Literals.ALBUM__RATINGS);
		addXMLInfo(map, MusicPackage.Literals.ALBUM__GENRES);

		options.put(XMLResource.OPTION_XML_MAP, map);
		return options;
	}

	private static void addXMLInfo(XMLMap map, EAttribute attr) {
		XMLInfo xmlInfo = new XMLInfoImpl();
		xmlInfo.setName(attr.getName());
		xmlInfo.setTargetNamespace(resource.getURI().toString());
		xmlInfo.setXMLRepresentation(XMLInfo.ELEMENT);
		map.add(attr, xmlInfo);
	}

	private static void addXMLInfo(XMLMap map, EReference ref) {
		XMLInfo xmlInfo = new XMLInfoImpl();
		xmlInfo.setName(ref.getName());
		xmlInfo.setTargetNamespace(resource.getURI().toString());
		xmlInfo.setXMLRepresentation(XMLInfo.ELEMENT);
		map.add(ref, xmlInfo);
	}

	@Override
	public boolean save(EObject data) {
		EList<EObject> list = new BasicEList<EObject>();
		list.add(data);
		return save(data);
	}

	@Override
	public boolean save(EList<EObject> data) {
		resource.getContents().addAll(data);
		try {
			resource.save(getOptions());
			// return true;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// print to console
		try {
			resource.save(System.out, getOptions());
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		// }
		return false;
	}

	@Override
	public <E extends EObject> EList<E> get(EObject type, int id) {
		System.out.println(String.format("loading %s with id %d", type
				.getClass().getSimpleName(), id));
		return null;
	}

}