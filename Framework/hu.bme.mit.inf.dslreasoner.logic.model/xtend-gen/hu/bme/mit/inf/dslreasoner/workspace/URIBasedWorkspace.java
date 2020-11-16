package hu.bme.mit.inf.dslreasoner.workspace;

import hu.bme.mit.inf.dslreasoner.workspace.FileSystemWorkspace;
import hu.bme.mit.inf.dslreasoner.workspace.ProjectWorkspace;
import hu.bme.mit.inf.dslreasoner.workspace.ReasonerWorkspace;
import java.io.File;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class URIBasedWorkspace extends ReasonerWorkspace {
  private final ReasonerWorkspace delegatedWorkspace;
  
  public URIBasedWorkspace(final String targetFolder, final String prefix) {
    super(targetFolder, prefix);
    final URI targetFolderURI = URI.createURI(targetFolder);
    boolean _isFile = targetFolderURI.isFile();
    if (_isFile) {
      FileSystemWorkspace _fileSystemWorkspace = new FileSystemWorkspace(targetFolder, prefix);
      this.delegatedWorkspace = _fileSystemWorkspace;
    } else {
      boolean _isPlatformResource = targetFolderURI.isPlatformResource();
      if (_isPlatformResource) {
        ProjectWorkspace _projectWorkspace = new ProjectWorkspace(targetFolder, prefix);
        this.delegatedWorkspace = _projectWorkspace;
      } else {
        this.delegatedWorkspace = null;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Unknown URI: ");
        _builder.append(targetFolder);
        throw new UnsupportedOperationException(_builder.toString());
      }
    }
  }
  
  @Override
  public ReasonerWorkspace subWorkspace(final String targetFolder, final String prefix) {
    return this.delegatedWorkspace.subWorkspace(targetFolder, prefix);
  }
  
  @Override
  public URI getWorkspaceURI() {
    return this.delegatedWorkspace.getWorkspaceURI();
  }
  
  @Override
  public void init() {
    this.delegatedWorkspace.init();
  }
  
  @Override
  public void clear() {
    this.delegatedWorkspace.clear();
  }
  
  @Override
  protected URI getURI(final String name) {
    return this.delegatedWorkspace.getURI(name);
  }
  
  @Override
  public File getFile(final String name) {
    return this.delegatedWorkspace.getFile(name);
  }
  
  @Override
  public void refreshFile(final String name) {
    this.delegatedWorkspace.refreshFile(name);
  }
  
  @Override
  protected void renameFile(final String name) {
    this.delegatedWorkspace.renameFile(name);
  }
  
  @Override
  public List<String> allFiles() {
    return this.delegatedWorkspace.allFiles();
  }
  
  @Override
  public URI writeText(final String name, final CharSequence content) {
    return this.delegatedWorkspace.writeText(name, content);
  }
  
  @Override
  public String readText(final String name) {
    return this.delegatedWorkspace.readText(name);
  }
}
