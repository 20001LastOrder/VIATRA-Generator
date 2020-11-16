package hu.bme.mit.inf.dslreasoner.workspace;

import com.google.common.base.Objects;
import hu.bme.mit.inf.dslreasoner.workspace.ReasonerWorkspace;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class ProjectWorkspace extends ReasonerWorkspace {
  private final NullProgressMonitor monitor = new NullProgressMonitor();
  
  private IContainer target;
  
  public ProjectWorkspace(final String targetFolder, final String prefix) {
    super(targetFolder, prefix);
  }
  
  @Override
  protected URI getURI(final String name) {
    return URI.createURI((((this.targetFolder + "/") + this.prefix) + name), true);
  }
  
  protected URI getDirUri() {
    return URI.createURI(this.targetFolder, true);
  }
  
  @Override
  public URI getWorkspaceURI() {
    return this.getDirUri();
  }
  
  @Override
  public void init() {
    this.target = ResourcesPlugin.getWorkspace().getRoot();
    List<String> _xifexpression = null;
    boolean _isPlatformResource = this.getDirUri().isPlatformResource();
    if (_isPlatformResource) {
      _xifexpression = ((List<String>)Conversions.doWrapArray(this.getDirUri().segments())).subList(1, ((List<String>)Conversions.doWrapArray(this.getDirUri().segments())).size());
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Only platform resources are supported, but recieved: \"");
      URI _dirUri = this.getDirUri();
      _builder.append(_dirUri);
      _builder.append("\"!");
      throw new UnsupportedOperationException(_builder.toString());
    }
    final List<String> segments = _xifexpression;
    for (final String nameSegment : segments) {
      this.target = this.createContainer(this.target, nameSegment);
    }
  }
  
  @Override
  public void clear() {
    try {
      final Consumer<IResource> _function = (IResource it) -> {
        try {
          it.delete(false, this.monitor);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      ((List<IResource>)Conversions.doWrapArray(this.target.members())).forEach(_function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected IContainer _createContainer(final IWorkspaceRoot root, final String name) {
    try {
      final IProject project = root.getProject(name);
      boolean _exists = project.exists();
      if (_exists) {
        boolean _isOpen = project.isOpen();
        boolean _not = (!_isOpen);
        if (_not) {
          project.open(this.monitor);
        }
      } else {
        project.create(this.monitor);
      }
      return project;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected IContainer _createContainer(final IProject root, final String name) {
    try {
      final IFolder folder = root.getFolder(name);
      boolean _exists = folder.exists();
      boolean _not = (!_exists);
      if (_not) {
        folder.create(true, true, this.monitor);
      }
      return folder;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected IContainer _createContainer(final IFolder root, final String name) {
    try {
      final IFolder folder = root.getFolder(name);
      boolean _exists = folder.exists();
      boolean _not = (!_exists);
      if (_not) {
        folder.create(true, true, this.monitor);
      }
      return folder;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected IFile _getTargetFile(final IFolder targetFolder, final String name) {
    return targetFolder.getFile(name);
  }
  
  protected IFile _getTargetFile(final IProject targetProject, final String name) {
    return targetProject.getFile(name);
  }
  
  @Override
  public URI writeText(final String name, final CharSequence content) {
    try {
      final IFile file = this.getTargetFile(this.target, name);
      boolean _exists = file.exists();
      boolean _not = (!_exists);
      if (_not) {
        byte[] _bytes = content.toString().getBytes();
        ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_bytes);
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        file.create(_byteArrayInputStream, true, _nullProgressMonitor);
        return URI.createPlatformResourceURI(file.getProjectRelativePath().toString(), true);
      }
      byte[] _bytes_1 = content.toString().getBytes();
      ByteArrayInputStream _byteArrayInputStream_1 = new ByteArrayInputStream(_bytes_1);
      NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
      file.appendContents(_byteArrayInputStream_1, true, false, _nullProgressMonitor_1);
      return URI.createPlatformResourceURI(file.getProjectRelativePath().toString(), true);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public String readText(final String name) {
    try {
      final IFile file = this.getTargetFile(this.target, name);
      InputStream _contents = file.getContents();
      InputStreamReader _inputStreamReader = new InputStreamReader(_contents);
      final BufferedReader in = new BufferedReader(_inputStreamReader);
      String result = "";
      String line = null;
      while ((!Objects.equal((line = in.readLine()), null))) {
        result = result.concat(line);
      }
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  protected void renameFile(final String name) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public ReasonerWorkspace subWorkspace(final String targetFolder, final String prefix) {
    return new ProjectWorkspace(((this.targetFolder + "/") + targetFolder), (this.prefix + prefix));
  }
  
  @Override
  public List<String> allFiles() {
    try {
      final Function1<IResource, String> _function = (IResource it) -> {
        return it.getName();
      };
      return ListExtensions.<IResource, String>map(((List<IResource>)Conversions.doWrapArray(this.target.members())), _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public File getFile(final String name) {
    final IFile file = this.getTargetFile(this.target, name);
    IPath _xifexpression = null;
    boolean _isLinked = file.isLinked();
    if (_isLinked) {
      _xifexpression = file.getRawLocation();
    } else {
      _xifexpression = file.getLocation();
    }
    final IPath uri = _xifexpression;
    return uri.toFile();
  }
  
  @Override
  public void refreshFile(final String name) {
    try {
      final IFile file = this.getTargetFile(this.target, name);
      file.refreshLocal(1, this.monitor);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected IContainer createContainer(final IContainer root, final String name) {
    if (root instanceof IFolder) {
      return _createContainer((IFolder)root, name);
    } else if (root instanceof IProject) {
      return _createContainer((IProject)root, name);
    } else if (root instanceof IWorkspaceRoot) {
      return _createContainer((IWorkspaceRoot)root, name);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(root, name).toString());
    }
  }
  
  public IFile getTargetFile(final IContainer targetFolder, final String name) {
    if (targetFolder instanceof IFolder) {
      return _getTargetFile((IFolder)targetFolder, name);
    } else if (targetFolder instanceof IProject) {
      return _getTargetFile((IProject)targetFolder, name);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(targetFolder, name).toString());
    }
  }
}
