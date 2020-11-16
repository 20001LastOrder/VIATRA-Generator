package hu.bme.mit.inf.dslreasoner.workspace;

import com.google.common.base.Objects;
import hu.bme.mit.inf.dslreasoner.workspace.ReasonerWorkspace;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class FileSystemWorkspace extends ReasonerWorkspace {
  public FileSystemWorkspace(final String targetFolder, final String prefix) {
    super(targetFolder, prefix);
  }
  
  @Override
  protected URI getURI(final String name) {
    return URI.createFileURI((((this.targetFolder + "/") + this.prefix) + name));
  }
  
  protected URI getFolderURI() {
    return URI.createFileURI(this.targetFolder);
  }
  
  @Override
  public URI getWorkspaceURI() {
    return this.getFolderURI();
  }
  
  @Override
  public void init() {
    String _fileString = this.getFolderURI().toFileString();
    final File folder = new File(_fileString);
    folder.mkdirs();
  }
  
  @Override
  public void clear() {
    String _fileString = this.getFolderURI().toFileString();
    final File folder = new File(_fileString);
    File[] _listFiles = folder.listFiles();
    for (final File file : _listFiles) {
      this.deleteFile(file);
    }
  }
  
  public void deleteFile(final File file) {
    boolean _isDirectory = file.isDirectory();
    if (_isDirectory) {
      final Consumer<File> _function = (File it) -> {
        this.deleteFile(it);
      };
      ((List<File>)Conversions.doWrapArray(file.listFiles())).forEach(_function);
      file.delete();
    } else {
      file.delete();
    }
  }
  
  @Override
  public URI writeText(final String name, final CharSequence content) {
    try {
      final URI uri = this.getURI(name);
      String _fileString = uri.toFileString();
      final PrintWriter writer = new PrintWriter(_fileString, "UTF-8");
      writer.println(content);
      writer.close();
      return uri;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public String readText(final String name) {
    try {
      String line = null;
      String result = "";
      String _fileString = this.getURI(name).toFileString();
      FileReader _fileReader = new FileReader(_fileString);
      final BufferedReader in = new BufferedReader(_fileReader);
      while ((!Objects.equal((line = in.readLine()), null))) {
        result = result.concat(line);
      }
      in.close();
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  protected void renameFile(final String name) {
    final URI uri = this.getURI(name);
    final URI uri2 = this.getURI((name + ReasonerWorkspace.deactivationPostfix));
    String _fileString = uri.toFileString();
    final File file = new File(_fileString);
    String _fileString_1 = uri2.toFileString();
    final File file2 = new File(_fileString_1);
    file.renameTo(file2);
  }
  
  @Override
  public ReasonerWorkspace subWorkspace(final String targetFolder, final String prefix) {
    return new FileSystemWorkspace(((this.targetFolder + "/") + targetFolder), (this.prefix + prefix));
  }
  
  @Override
  public List<String> allFiles() {
    String _fileString = this.getFolderURI().toFileString();
    final File folder = new File(_fileString);
    boolean _isDirectory = folder.isDirectory();
    if (_isDirectory) {
      return (List<String>)Conversions.doWrapArray(folder.list());
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"");
      String _fileString_1 = this.getFolderURI().toFileString();
      _builder.append(_fileString_1);
      _builder.append("\" is not a folder!");
      throw new IllegalArgumentException(_builder.toString());
    }
  }
  
  @Override
  public File getFile(final String name) {
    final URI uri = this.getURI(name);
    String _fileString = uri.toFileString();
    return new File(_fileString);
  }
  
  @Override
  public void refreshFile(final String name) {
  }
}
