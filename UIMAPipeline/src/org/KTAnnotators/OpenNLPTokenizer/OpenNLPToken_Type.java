
/* First created by JCasGen Fri Jul 06 14:47:10 IST 2018 */
package org.KTAnnotators.OpenNLPTokenizer;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Mon Jul 09 11:55:50 IST 2018
 * @generated */
public class OpenNLPToken_Type extends Annotation_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = OpenNLPToken.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.KTAnnotators.OpenNLPTokenizer.OpenNLPToken");
 
  /** @generated */
  final Feature casFeat_text;
  /** @generated */
  final int     casFeatCode_text;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getText(int addr) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "org.KTAnnotators.OpenNLPTokenizer.OpenNLPToken");
    return ll_cas.ll_getStringValue(addr, casFeatCode_text);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setText(int addr, String v) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "org.KTAnnotators.OpenNLPTokenizer.OpenNLPToken");
    ll_cas.ll_setStringValue(addr, casFeatCode_text, v);}
    
  
 
  /** @generated */
  final Feature casFeat_tag;
  /** @generated */
  final int     casFeatCode_tag;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getTag(int addr) {
        if (featOkTst && casFeat_tag == null)
      jcas.throwFeatMissing("tag", "org.KTAnnotators.OpenNLPTokenizer.OpenNLPToken");
    return ll_cas.ll_getStringValue(addr, casFeatCode_tag);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTag(int addr, String v) {
        if (featOkTst && casFeat_tag == null)
      jcas.throwFeatMissing("tag", "org.KTAnnotators.OpenNLPTokenizer.OpenNLPToken");
    ll_cas.ll_setStringValue(addr, casFeatCode_tag, v);}
    
  
 
  /** @generated */
  final Feature casFeat_NamedEntityTag;
  /** @generated */
  final int     casFeatCode_NamedEntityTag;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getNamedEntityTag(int addr) {
        if (featOkTst && casFeat_NamedEntityTag == null)
      jcas.throwFeatMissing("NamedEntityTag", "org.KTAnnotators.OpenNLPTokenizer.OpenNLPToken");
    return ll_cas.ll_getStringValue(addr, casFeatCode_NamedEntityTag);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setNamedEntityTag(int addr, String v) {
        if (featOkTst && casFeat_NamedEntityTag == null)
      jcas.throwFeatMissing("NamedEntityTag", "org.KTAnnotators.OpenNLPTokenizer.OpenNLPToken");
    ll_cas.ll_setStringValue(addr, casFeatCode_NamedEntityTag, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public OpenNLPToken_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_text = jcas.getRequiredFeatureDE(casType, "text", "uima.cas.String", featOkTst);
    casFeatCode_text  = (null == casFeat_text) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_text).getCode();

 
    casFeat_tag = jcas.getRequiredFeatureDE(casType, "tag", "uima.cas.String", featOkTst);
    casFeatCode_tag  = (null == casFeat_tag) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_tag).getCode();

 
    casFeat_NamedEntityTag = jcas.getRequiredFeatureDE(casType, "NamedEntityTag", "uima.cas.String", featOkTst);
    casFeatCode_NamedEntityTag  = (null == casFeat_NamedEntityTag) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_NamedEntityTag).getCode();

  }
}



    