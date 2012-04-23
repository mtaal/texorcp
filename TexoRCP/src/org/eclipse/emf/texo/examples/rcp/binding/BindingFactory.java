package org.eclipse.emf.texo.examples.rcp.binding;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.ObservablesManager;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class BindingFactory {
	private static BindingFactory instance;
	private static ObservablesManager mgr;
	private static final boolean DEBUG = false;
	private Map<Class<?>, EMFDataBindingContext> contexts = new HashMap<Class<?>, EMFDataBindingContext>();

	public static BindingFactory getInstance() {
		if (instance == null) {
			instance = new BindingFactory();
			mgr = new ObservablesManager();
		}
		return instance;
	}

	/**
	 * 
	 * @param control
	 * @param obj
	 * @param feature
	 *            the feature instance the property is created for
	 */
	public void bind(Class<?> contextClass, Object control,
			final EObject eObject, EStructuralFeature feature, boolean delayed) {
		bind(contextClass, control, eObject, FeaturePath.fromList(feature),
				delayed);
	}

	public void bind(final Class<?> contextClass, final Object control,
			final EObject eObject, final FeaturePath featurePath,
			final boolean delayed) {

		// this manager collects the new bindings for later cleanup!
		mgr.runAndCollect(new Runnable() {
			public void run() {
				DataBindingContext context = getBindingContext(contextClass);
				Binding binding = null;
				if (control instanceof Text) {
					// if (delayed) {
					// IWidgetValueProperty textProp = WidgetProperties
					// .text(SWT.Modify);
					// IObservableValue uiObs = textProp.observeDelayed(400,
					// (Text) control);
					// IObservableValue mObs;
					//
					// if (eObject instanceof IObservableValue) {
					// mObs = textProp
					// .observeDetail((IObservableValue) eObject);
					// } else {
					// mObs = textProp.observe(eObject);
					// }
					//
					// context.bindValue(uiObs, mObs);
					// } else {
					binding = context.bindValue(
							WidgetProperties.text(SWT.Modify).observe(control),
							EMFProperties.value(featurePath).observe(eObject));
					// }
				} else if (control instanceof Label) {
					binding = context.bindValue(WidgetProperties.text()
							.observe(control), EMFProperties.value(featurePath)
							.observe(eObject));
				} else if (control instanceof ComboViewer) {
					ComboViewer viewer = (ComboViewer) control;
					binding = context.bindValue(WidgetProperties.selection()
							.observe(viewer.getControl()),
							EMFProperties.value(featurePath).observe(eObject));
				} else if (control instanceof DateTime
						|| control instanceof Button) {
					binding = context.bindValue(WidgetProperties.selection()
							.observe(control), EMFProperties.value(featurePath)
							.observe(eObject));
				} else {
					System.err.println("control is instance of "
							+ control.getClass()
							+ " which is not supported by BindingFactory yet.");
				}
				if (DEBUG) {
					System.out.println("added '"
							+ control.getClass().getSimpleName() + "' +"
							+ binding);
				}
			}
		});

	}

	/**
	 * WARNING: this disposes ALL binding contexts!
	 */
	public void dispose() {
		for (Class<?> clazz : contexts.keySet()) {
			dispose(clazz);
		}
		mgr.dispose();
	}

	/**
	 * dispose only the dataBindingContext for the given class
	 * 
	 * @param clazz
	 */
	public void dispose(Class<?> clazz) {
		if (contexts.containsKey(contexts)) {
			contexts.get(clazz).dispose();
			contexts.remove(clazz);
		}
	}

	/**
	 * get the DataBindingContext for a given class - if it does not exists it
	 * gets created
	 * 
	 * @param clazz
	 * @return
	 */
	public EMFDataBindingContext getBindingContext(Class<?> clazz) {
		if (contexts.containsKey(clazz)) {
			return contexts.get(clazz);
		} else {
			EMFDataBindingContext context = new EMFDataBindingContext();
			contexts.put(clazz, context);
			return context;
		}
	}

	// /**
	// * get the DataBindingContext for a given class - if it does not exists it
	// * gets created
	// *
	// * @param clazz
	// * @return
	// */
	// public List<EMFDataBindingContext> getBindingProducts(Class<?> clazz) {
	// if (products.containsKey(clazz)) {
	// return products.get(clazz);
	// } else {
	// List<EMFDataBindingContext> prods = new
	// ArrayList<EMFDataBindingContext>();
	// products.put(clazz, prods);
	// return prods;
	// }
	// }
	//
	// public void removeBinding(Class<?> contextClass, final Object control,
	// final EObject eObject, final FeaturePath featurePath) {
	// final BindingProduct removeMe = new BindingProduct(null, control,
	// eObject, featurePath);
	// List<EMFDataBindingContext> prods = products.get(contextClass);
	// for (int i = 0; i < prods.size(); i++) {
	// final EMFDataBindingContext check = prods.get(i);
	// if (check.equals(removeMe)) {
	// if (DEBUG) {
	// System.out.println("Match found");
	// }
	// check.removeBinding(removeMe.b);
	// prods.remove(i);
	// }
	// }
	// }
	//
	// public int getBindingCount(Class<?> contextClass, Object control) {
	// int count = 0;
	// List<BindingProduct> prods = getBindingProducts(contextClass);
	// for (int i = 0; i < prods.size(); i++) {
	// if (prods.get(i).getControl().equals(control)) {
	// count++;
	// }
	// }
	// return count;
	// }

	/**
	 * drops all current bindings and creates a new binding context
	 * 
	 * @param clazz
	 * @return
	 */
	public DataBindingContext cleanup(Class<?> clazz) {
		dispose(clazz);
		return getBindingContext(clazz);
	}
}