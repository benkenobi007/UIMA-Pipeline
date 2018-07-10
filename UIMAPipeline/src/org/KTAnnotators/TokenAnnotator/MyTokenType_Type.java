
/* First created by JCasGen Fri Jun 29 12:26:24 IST 2018 */
package org.KTAnnotators.TokenAnnotator;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Mon Jul 09 12:21:19 IST 2018
 * @generated */
public class MyTokenType_Type extends Annotation_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = MyTokenType.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.KTAnnotators.TokenAnnotator.MyTokenType");
 
  /** @generated */
  final Feature casFeat_MyTokenString;
  /** @generated */
  final int     casFeatCode_MyTokenString;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getMyTokenString(int addr) {
        if (featOkTst && casFeat_MyTokenString == null)
      jcas.throwFeatMissing("MyTokenString", "org.KTAnnotators.TokenAnnotator.MyTokenType");
    return ll_cas.ll_getStringValue(addr, casFeatCode_MyTokenString);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setMyTokenString(int addr, String v) {
        if (featOkTst && casFeat_MyTokenString == null)
      jcas.throwFeatMissing("MyTokenString", "org.KTAnnotators.TokenAnnotator.MyTokenType");
    ll_cas.ll_setStringValue(addr, casFeatCode_MyTokenString, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public MyTokenType_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_MyTokenString = jcas.getRequiredFeatureDE(casType, "MyTokenString", "uima.cas.String", featOkTst);
    casFeatCode_MyTokenString  = (null == casFeat_MyTokenString) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_MyTokenString).getCode();

  }
}



    