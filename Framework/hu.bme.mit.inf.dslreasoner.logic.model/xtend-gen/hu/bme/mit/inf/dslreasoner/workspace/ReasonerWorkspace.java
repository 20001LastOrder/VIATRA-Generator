package hu.bme.mit.inf.dslreasoner.workspace;

import com.google.common.base.Objects;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public abstract class ReasonerWorkspace {
  protected final String targetFolder;
  
  protected final String prefix;
  
  private final ResourceSet resSet = new ResourceSetImpl();
  
  public ReasonerWorkspace(final String targetFolder, final String prefix) {
    this.targetFolder = targetFolder;
    this.prefix = prefix;
  }
  
  public abstract ReasonerWorkspace subWorkspace(final String targetFolder, final String prefix);
  
  public abstract URI getWorkspaceURI();
  
  public abstract void init();
  
  public abstract void clear();
  
  /**
   * Creates the target folder and clears the workspace for the reasoning
   */
  public void initAndClear() {
    this.init();
    this.clear();
  }
  
  protected abstract URI getURI(final String name);
  
  protected Resource getResource(final String name) {
    try {
      final Resource prevoius = this.resSet.getResource(this.getURI(name), false);
      boolean _notEquals = (!Objects.equal(prevoius, null));
      if (_notEquals) {
        prevoius.delete(Collections.EMPTY_MAP);
      }
      final URI resourceURI = this.getURI(name);
      return this.resSet.createResource(resourceURI);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public abstract File getFile(final String name);
  
  public abstract void refreshFile(final String name);
  
  private static final HashMap<String, Boolean> savingOption = ObjectExtensions.<HashMap<String, Boolean>>operator_doubleArrow(new HashMap<String, Boolean>(), ((Procedure1<HashMap<String, Boolean>>) (HashMap<String, Boolean> it) -> {
    it.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.valueOf(true));
  }));
  
  /**
   * Writes a model
   */
  public URI writeModel(final EObject modelRoot, final String name) {
    try {
      final Resource resource = this.getResource(name);
      resource.getContents().add(modelRoot);
      resource.save(ReasonerWorkspace.savingOption);
      return resource.getURI();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String writeModelToString(final EObject modelRoot, final String name) {
    try {
      final Resource resource = this.getResource(name);
      resource.getContents().add(modelRoot);
      final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      resource.save(outputStream, null);
      return outputStream.toString();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public <RootType extends EObject> RootType reloadModel(final Class<RootType> type, final String name) {
    try {
      try {
        final Resource resource = this.resSet.getResource(this.getURI(name), false);
        boolean _isLoaded = resource.isLoaded();
        if (_isLoaded) {
          resource.unload();
        }
        resource.load(Collections.EMPTY_MAP);
        boolean _equals = Objects.equal(resource, null);
        if (_equals) {
          String _string = this.getURI(name).toString();
          throw new FileNotFoundException(_string);
        } else {
          EObject _get = resource.getContents().get(0);
          return ((RootType) _get);
        }
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          String _string_1 = this.getURI(name).toString();
          throw new FileNotFoundException(_string_1);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public <RootType extends EObject> RootType readModel(final Class<RootType> type, final String name) {
    try {
      try {
        final Resource resource = this.resSet.getResource(this.getURI(name), true);
        boolean _equals = Objects.equal(resource, null);
        if (_equals) {
          String _string = this.getURI(name).toString();
          throw new FileNotFoundException(_string);
        } else {
          EObject _get = resource.getContents().get(0);
          return ((RootType) _get);
        }
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          String _string_1 = this.getURI(name).toString();
          String _plus = (_string_1 + "reason: ");
          String _message = e.getMessage();
          String _plus_1 = (_plus + _message);
          throw new FileNotFoundException(_plus_1);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void deactivateModel(final String name) {
    final Resource resource = this.resSet.getResource(this.getURI(name), true);
    resource.unload();
    this.renameFile(name);
  }
  
  protected static final String deactivationPostfix = ".deactivated";
  
  protected abstract void renameFile(final String name);
  
  public abstract List<String> allFiles();
  
  public abstract URI writeText(final String name, final CharSequence content);
  
  public abstract String readText(final String name);
}
