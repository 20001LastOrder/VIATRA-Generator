package hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage;

import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.BooleanElement;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.IntegerElement;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialBooleanInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialIntegerInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialRealInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.PartialStringInterpretation;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.RealElement;
import hu.bme.mit.inf.dslreasoner.viatrasolver.partialinterpretationlanguage.partialinterpretation.StringElement;
import java.math.BigDecimal;
import java.util.Map;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class PrimitiveValueTrace {
  private final PartialBooleanInterpretation booleanInterpretation;
  
  private final Map<Boolean, BooleanElement> booleanMap;
  
  private final PartialIntegerInterpretation integerInterpretation;
  
  private final Map<Integer, IntegerElement> integerMap;
  
  private final PartialRealInterpretation realInterpretation;
  
  private final Map<BigDecimal, RealElement> realMap;
  
  private final PartialStringInterpretation stringInterpretation;
  
  private final Map<String, StringElement> stringMap;
  
  public PrimitiveValueTrace(final PartialBooleanInterpretation booleanInterpretation, final Map<Boolean, BooleanElement> booleanMap, final PartialIntegerInterpretation integerInterpretation, final Map<Integer, IntegerElement> integerMap, final PartialRealInterpretation realInterpretation, final Map<BigDecimal, RealElement> realMap, final PartialStringInterpretation stringInterpretation, final Map<String, StringElement> stringMap) {
    super();
    this.booleanInterpretation = booleanInterpretation;
    this.booleanMap = booleanMap;
    this.integerInterpretation = integerInterpretation;
    this.integerMap = integerMap;
    this.realInterpretation = realInterpretation;
    this.realMap = realMap;
    this.stringInterpretation = stringInterpretation;
    this.stringMap = stringMap;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.booleanInterpretation== null) ? 0 : this.booleanInterpretation.hashCode());
    result = prime * result + ((this.booleanMap== null) ? 0 : this.booleanMap.hashCode());
    result = prime * result + ((this.integerInterpretation== null) ? 0 : this.integerInterpretation.hashCode());
    result = prime * result + ((this.integerMap== null) ? 0 : this.integerMap.hashCode());
    result = prime * result + ((this.realInterpretation== null) ? 0 : this.realInterpretation.hashCode());
    result = prime * result + ((this.realMap== null) ? 0 : this.realMap.hashCode());
    result = prime * result + ((this.stringInterpretation== null) ? 0 : this.stringInterpretation.hashCode());
    return prime * result + ((this.stringMap== null) ? 0 : this.stringMap.hashCode());
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    PrimitiveValueTrace other = (PrimitiveValueTrace) obj;
    if (this.booleanInterpretation == null) {
      if (other.booleanInterpretation != null)
        return false;
    } else if (!this.booleanInterpretation.equals(other.booleanInterpretation))
      return false;
    if (this.booleanMap == null) {
      if (other.booleanMap != null)
        return false;
    } else if (!this.booleanMap.equals(other.booleanMap))
      return false;
    if (this.integerInterpretation == null) {
      if (other.integerInterpretation != null)
        return false;
    } else if (!this.integerInterpretation.equals(other.integerInterpretation))
      return false;
    if (this.integerMap == null) {
      if (other.integerMap != null)
        return false;
    } else if (!this.integerMap.equals(other.integerMap))
      return false;
    if (this.realInterpretation == null) {
      if (other.realInterpretation != null)
        return false;
    } else if (!this.realInterpretation.equals(other.realInterpretation))
      return false;
    if (this.realMap == null) {
      if (other.realMap != null)
        return false;
    } else if (!this.realMap.equals(other.realMap))
      return false;
    if (this.stringInterpretation == null) {
      if (other.stringInterpretation != null)
        return false;
    } else if (!this.stringInterpretation.equals(other.stringInterpretation))
      return false;
    if (this.stringMap == null) {
      if (other.stringMap != null)
        return false;
    } else if (!this.stringMap.equals(other.stringMap))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("booleanInterpretation", this.booleanInterpretation);
    b.add("booleanMap", this.booleanMap);
    b.add("integerInterpretation", this.integerInterpretation);
    b.add("integerMap", this.integerMap);
    b.add("realInterpretation", this.realInterpretation);
    b.add("realMap", this.realMap);
    b.add("stringInterpretation", this.stringInterpretation);
    b.add("stringMap", this.stringMap);
    return b.toString();
  }
  
  @Pure
  public PartialBooleanInterpretation getBooleanInterpretation() {
    return this.booleanInterpretation;
  }
  
  @Pure
  public Map<Boolean, BooleanElement> getBooleanMap() {
    return this.booleanMap;
  }
  
  @Pure
  public PartialIntegerInterpretation getIntegerInterpretation() {
    return this.integerInterpretation;
  }
  
  @Pure
  public Map<Integer, IntegerElement> getIntegerMap() {
    return this.integerMap;
  }
  
  @Pure
  public PartialRealInterpretation getRealInterpretation() {
    return this.realInterpretation;
  }
  
  @Pure
  public Map<BigDecimal, RealElement> getRealMap() {
    return this.realMap;
  }
  
  @Pure
  public PartialStringInterpretation getStringInterpretation() {
    return this.stringInterpretation;
  }
  
  @Pure
  public Map<String, StringElement> getStringMap() {
    return this.stringMap;
  }
}
