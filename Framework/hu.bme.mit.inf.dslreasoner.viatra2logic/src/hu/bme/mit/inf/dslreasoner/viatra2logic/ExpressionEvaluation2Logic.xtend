package hu.bme.mit.inf.dslreasoner.viatra2logic

import hu.bme.mit.inf.dslreasoner.logic.model.builder.LogicProblemBuilder
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Term
import hu.bme.mit.inf.dslreasoner.logic.model.logiclanguage.Variable
import java.util.Map
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable
import org.eclipse.xtext.xbase.XBinaryOperation
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.XNumberLiteral
import org.eclipse.xtext.xbase.XUnaryOperation

import static extension hu.bme.mit.inf.dslreasoner.util.CollectionsUtil.*

class ExpressionEvaluation2Logic {
	val extension LogicProblemBuilder builder = new LogicProblemBuilder
	val NumericProblemSolver numericSolver = new NumericProblemSolver
	
	def Term transformCheck(XExpression expression, Map<PVariable, Variable> variable2Variable) {
		return expression.transform(variable2Variable)
	}
	
	def Term transformEval(PVariable target, XExpression expression, Map<PVariable, Variable> variable2Variable) {
		val test = expression.transform(variable2Variable)
		numericSolver.formNumericProblemTemplate(expression)
	
		return test
	}
	
	static val N_Base = "org.eclipse.xtext.xbase.lib."
	
	static val N_PLUS1 = "operator_plus"
	static val N_MINUS1 = "operator_minus"
	
	static val N_MINUS2 = "operator_minus"
	static val N_PLUS2 = "operator_plus"
	static val N_POWER = "operator_power"
	static val N_MULTIPLY = "operator_multiply"
	static val N_DIVIDE = "operator_divide"
	static val N_MODULO = "operator_modulo"
	static val N_LESSTHAN = "operator_lessThan"
	static val N_LESSEQUALSTHAN = "operator_lessEqualsThan"
	static val N_GREATERTHAN = "operator_greaterThan"
	static val N_GREATEREQUALTHAN = "operator_greaterEqualsThan"
	static val N_EQUALS = "operator_equals"
	static val N_NOTEQUALS = "operator_notEquals"
	static val N_EQUALS3 = "operator_tripleEquals"
	static val N_NOTEQUALS3 = "operator_tripleNotEquals"
	
	
	
	protected def isN(String name, String s) {
		val res = name.startsWith(N_Base) && name.endsWith(s)
		//println('''[«res»] «name» ?= «N_Base»*«s»''')
		return res
	}
	
	static val N_POWER2 = "java.lang.Math.pow"
	
	def protected dispatch Term transform(XBinaryOperation e, Map<PVariable, Variable> variable2Variable) {
		val left = e.leftOperand.transform(variable2Variable)
		val right = e.rightOperand.transform(variable2Variable)
		val feature = e.feature.qualifiedName
		     if(feature.isN(N_MINUS2)) { return Minus(left,right) }
		else if(feature.isN(N_PLUS2)) { return Plus(left,right) }
		else if(feature.isN(N_POWER)) { return Pow(left,right) }
		else if(feature.isN(N_MULTIPLY)) { return Multiply(left,right) }
		else if(feature.isN(N_DIVIDE)) { return Divide(left,right) }
		else if(feature.isN(N_MODULO)) { return Modulo(left,right) }
		else if(feature.isN(N_LESSTHAN)) { return LessThan(left,right) }
		else if(feature.isN(N_LESSEQUALSTHAN)) { return LessOrEqual(left,right) }
		else if(feature.isN(N_GREATERTHAN)) { return MoreThan(left,right) }
		else if(feature.isN(N_GREATEREQUALTHAN)) { return MoreOrEqual(left,right) }
		else if(feature.isN(N_EQUALS)) { return Equals(left,right) }
		else if(feature.isN(N_NOTEQUALS)) { return Distinct(left,right) }
		else if(feature.isN(N_EQUALS3)) { return Equals(left,right) }
		else if(feature.isN(N_NOTEQUALS3)) { return Distinct(left,right) }
		else {
			println("-> " + e.feature+","+e.class)
			println("-> " + e.leftOperand)
			println("-> " + e.rightOperand)
			println("-> " + e.feature.qualifiedName)
			throw new UnsupportedOperationException('''Unsupported binary operator feature: "«e.feature.class.simpleName»" - «e»''')
		}
	}
	
	def protected dispatch Term transform(XUnaryOperation e, Map<PVariable, Variable> variable2Variable) {
		val operand = e.operand.transform(variable2Variable)
		val feature = e.feature.qualifiedName
		if(feature.isN(N_MINUS1)) { return Minus(0.asTerm,operand)}
		else if(feature.isN(N_PLUS1)) { return operand}
		else{
			println("-> " + e.feature+","+e.class)
			println("-> " + e.operand)
			println("-> " + e.feature.qualifiedName)
			throw new UnsupportedOperationException('''Unsupported unary operator feature: "«e.feature.class.simpleName»" - «e»''')
		}
	}
	
	def protected dispatch Term transform(XMemberFeatureCall e, Map<PVariable, Variable> variable2Variable) {
		val transformedArguments = e.actualArguments.map[transform(variable2Variable)]
		val feature = e.feature.qualifiedName
		if(feature == N_POWER2) {
			return Pow(transformedArguments.get(0),transformedArguments.get(1))
		}else {
			println(e.feature+","+e.class)
			println(e.actualArguments.join(", "))
			println(e.feature.qualifiedName)
			throw new UnsupportedOperationException('''Unsupported feature call: "«e.feature.qualifiedName»" - «e»''')
		}
	}
	
	def protected dispatch Term transform(XFeatureCall e, Map<PVariable,Variable> variable2Variable) {
		val featureName = e.feature.qualifiedName
		val entryWithName = variable2Variable.entrySet.filter[it.key.name == featureName].head
		if(entryWithName !== null) {
			return entryWithName.value.toTerm
		} else {
			throw new IllegalArgumentException('''Feature call reference to unavailable variable "«featureName»"''')
		}
	}
	
	def protected dispatch Term transform(XNumberLiteral l, Map<PVariable, Variable> variable2Variable) {
		val s = l.value
		try{ return Integer.parseInt(s).asTerm } catch(NumberFormatException e){}
		try{ return Short.parseShort(s).asTerm } catch(NumberFormatException e){}
		try{ return Double.parseDouble(s).asTerm } catch(NumberFormatException e){}
		try{ return Float.parseFloat(s).asTerm } catch(NumberFormatException e){}
		throw new UnsupportedOperationException('''Unsupported numeric type: "«s»"''')
	}
	
	def protected dispatch Term transform(XExpression e, Map<PVariable, Variable> variable2Variable) {
		throw new UnsupportedOperationException('''Unsupported expression: "«e.class.simpleName»" - «e»''')
	}
}