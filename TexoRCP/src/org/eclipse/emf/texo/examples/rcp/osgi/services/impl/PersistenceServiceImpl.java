package org.eclipse.emf.texo.examples.rcp.osgi.services.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.texo.examples.rcp.music.Album;
import org.eclipse.emf.texo.examples.rcp.osgi.services.PersistenceService;

public class PersistenceServiceImpl implements PersistenceService {
	private static URI xmlUri = URI.createFileURI(new File("model.xml").getAbsolutePath());
	private static Resource resource;

	public PersistenceServiceImpl() {
		System.err.println(getClass().getInterfaces()[0].getName()
				+ " is now running.");
	}

	public Boolean isConnected() {
		return true;
	}

	@Override
	public boolean connect() {
		ResourceSet resSet = new ResourceSetImpl();
		Resource res = resSet.getResource(xmlUri, false);
		if (res==null) {
			System.out.println("created a new resource");
			resource = resSet.createResource(xmlUri);
		} else {
			System.out.println("using existing resource");
			resource = res;
		}
		return true;
	}

	@Override
	public boolean disconnect() {
		return true;
	}
	
	public void get(String somethign) {
	}

	public Album load() {
		System.out.println("trying to load from: "+xmlUri);
		if (isConnected()) {
			try {
				resource.load(getOptions());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return (Album) resource.getContents().get(0);
		}
		return null;
	}
	
	@Override
	public boolean save(Album album) {
		System.out.println("trying to save to: "+xmlUri);
		if (!album.eResource().isModified()){
			// no saving needed -> succeeded
			return true; 
		}
		else {
			resource.getContents().add(album);
			try {
				resource.save(getOptions());
//				return true;
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
		}
		return false;
	}
	
	public static Map<String, Object> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(XMLResource.OPTION_ENCODING, "UTF-8");
		return options;
	}
}