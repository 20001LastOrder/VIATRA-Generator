/**
 * generated by Xtext 2.12.0
 */
package ca.mcgill.ecse.dslreasoner.formatting2;

import ca.mcgill.ecse.dslreasoner.services.VampireLanguageGrammarAccess;
import ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSComment;
import ca.mcgill.ecse.dslreasoner.vampireLanguage.VLSFofFormula;
import ca.mcgill.ecse.dslreasoner.vampireLanguage.VampireModel;
import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class VampireLanguageFormatter extends AbstractFormatter2 {
  @Inject
  @Extension
  private VampireLanguageGrammarAccess _vampireLanguageGrammarAccess;
  
  protected void _format(final VampireModel vampireModel, @Extension final IFormattableDocument document) {
    EList<VLSComment> _comments = vampireModel.getComments();
    for (final VLSComment vLSComment : _comments) {
      document.<VLSComment>format(vLSComment);
    }
    EList<VLSFofFormula> _formulas = vampireModel.getFormulas();
    for (final VLSFofFormula vLSFofFormula : _formulas) {
      document.<VLSFofFormula>format(vLSFofFormula);
    }
  }
  
  protected void _format(final VLSFofFormula formula, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.<VLSFofFormula>append(formula, _function);
  }
  
  protected void _format(final VLSComment comment, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.<VLSComment>append(comment, _function);
  }
  
  public void format(final Object comment, final IFormattableDocument document) {
    if (comment instanceof XtextResource) {
      _format((XtextResource)comment, document);
      return;
    } else if (comment instanceof VLSComment) {
      _format((VLSComment)comment, document);
      return;
    } else if (comment instanceof VLSFofFormula) {
      _format((VLSFofFormula)comment, document);
      return;
    } else if (comment instanceof VampireModel) {
      _format((VampireModel)comment, document);
      return;
    } else if (comment instanceof EObject) {
      _format((EObject)comment, document);
      return;
    } else if (comment == null) {
      _format((Void)null, document);
      return;
    } else if (comment != null) {
      _format(comment, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(comment, document).toString());
    }
  }
}
