package org.eclipse.viatra.solver.language.ui.syntaxcoloring

import com.google.inject.Inject
import java.util.WeakHashMap
import org.eclipse.jface.text.TextAttribute
import org.eclipse.swt.graphics.RGB
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration
import org.eclipse.xtext.ui.editor.syntaxcoloring.PreferenceStoreAccessor
import org.eclipse.xtext.ui.editor.syntaxcoloring.TextAttributeProvider
import org.eclipse.xtext.ui.editor.utils.EditorUtils
import org.eclipse.xtext.ui.editor.utils.TextStyle

class SolverSemanticTextAttributeProvider extends TextAttributeProvider {

	val defaultTextStyle = new TextStyle
	val colorID2TextAttribute = new WeakHashMap<String, TextAttribute>

	@Inject
	new(IHighlightingConfiguration highlightingConfig, IPreferenceStoreAccess preferenceStoreAccess,
		PreferenceStoreAccessor prefStoreAccessor) {
		super(highlightingConfig, preferenceStoreAccess, prefStoreAccessor)
	}

	override getAttribute(String id) {
		if (isMetamodelElementColorID(id)) {
			if (colorID2TextAttribute.containsKey(id)) {
				return colorID2TextAttribute.get(id)
			} else {
				val style = metamodelElementTextStyle(id)
				colorID2TextAttribute.put(id, style)
				return style
			}
		} else {
			super.getAttribute(id)
		}
	}

	private def isMetamodelElementColorID(String id) {
		id.startsWith(SolverSemanticHighlightCalculator.SYMBOL_CODE)
	}

	private def TextAttribute metamodelElementTextStyle(String id) {
		val texts = id.split(' ')
		val backgroundColor = new RGB(
			Float.parseFloat(texts.get(1)),
			Float.parseFloat(texts.get(2)),
			Float.parseFloat(texts.get(3))
		)
		return new TextAttribute(EditorUtils.colorFromRGB(defaultTextStyle.color),
			EditorUtils.colorFromRGB(backgroundColor), defaultTextStyle.style,
			EditorUtils.fontFromFontData(defaultTextStyle.getFontData()));
	}

}
