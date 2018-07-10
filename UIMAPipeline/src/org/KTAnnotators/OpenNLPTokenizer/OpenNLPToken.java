

/* First created by JCasGen Fri Jul 06 14:47:10 IST 2018 */
package org.KTAnnotators.OpenNLPTokenizer;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Mon Jul 09 11:55:50 IST 2018
 * XML source: D:/EclipseProjects/UIMAPipeline/desc/OpenNLPPipelineDescriptor.xml
 * @generated */
public class OpenNLPToken extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(OpenNLPToken.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected OpenNLPToken() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public OpenNLPToken(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public OpenNLPToken(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public OpenNLPToken(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: text

  /** getter for text - gets 
   * @generated
   * @return value of the feature 
   */
  public String getText() {
    if (OpenNLPToken_Type.featOkTst && ((OpenNLPToken_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "org.KTAnnotators.OpenNLPTokenizer.OpenNLPToken");
    return jcasType.ll_cas.ll_getStringValue(addr, ((OpenNLPToken_Type)jcasType).casFeatCode_text);}
    
  /** setter for text - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setText(String v) {
    if (OpenNLPToken_Type.featOkTst && ((OpenNLPToken_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "org.KTAnnotators.OpenNLPTokenizer.OpenNLPToken");
    jcasType.ll_cas.ll_setStringValue(addr, ((OpenNLPToken_Type)jcasType).casFeatCode_text, v);}    
   
    
  //*--------------*
  //* Feature: tag

  /** getter for tag - gets 
   * @generated
   * @return value of the feature 
   */
  public String getTag() {
    if (OpenNLPToken_Type.featOkTst && ((OpenNLPToken_Type)jcasType).casFeat_tag == null)
      jcasType.jcas.throwFeatMissing("tag", "org.KTAnnotators.OpenNLPTokenizer.OpenNLPToken");
    return jcasType.ll_cas.ll_getStringValue(addr, ((OpenNLPToken_Type)jcasType).casFeatCode_tag);}
    
  /** setter for tag - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setTag(String v) {
    if (OpenNLPToken_Type.featOkTst && ((OpenNLPToken_Type)jcasType).casFeat_tag == null)
      jcasType.jcas.throwFeatMissing("tag", "org.KTAnnotators.OpenNLPTokenizer.OpenNLPToken");
    jcasType.ll_cas.ll_setStringValue(addr, ((OpenNLPToken_Type)jcasType).casFeatCode_tag, v);}    
   
    
  //*--------------*
  //* Feature: NamedEntityTag

  /** getter for NamedEntityTag - gets 
   * @generated
   * @return value of the feature 
   */
  public String getNamedEntityTag() {
    if (OpenNLPToken_Type.featOkTst && ((OpenNLPToken_Type)jcasType).casFeat_NamedEntityTag == null)
      jcasType.jcas.throwFeatMissing("NamedEntityTag", "org.KTAnnotators.OpenNLPTokenizer.OpenNLPToken");
    return jcasType.ll_cas.ll_getStringValue(addr, ((OpenNLPToken_Type)jcasType).casFeatCode_NamedEntityTag);}
    
  /** setter for NamedEntityTag - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setNamedEntityTag(String v) {
    if (OpenNLPToken_Type.featOkTst && ((OpenNLPToken_Type)jcasType).casFeat_NamedEntityTag == null)
      jcasType.jcas.throwFeatMissing("NamedEntityTag", "org.KTAnnotators.OpenNLPTokenizer.OpenNLPToken");
    jcasType.ll_cas.ll_setStringValue(addr, ((OpenNLPToken_Type)jcasType).casFeatCode_NamedEntityTag, v);}    
  }

    