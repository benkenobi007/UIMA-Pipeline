

/* First created by JCasGen Fri Jun 29 12:26:24 IST 2018 */
package org.KTAnnotators.TokenAnnotator;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Mon Jul 09 12:21:19 IST 2018
 * XML source: D:/EclipseProjects/UIMAPipeline/desc/CoreNLPAggregateDescriptor.xml
 * @generated */
public class MyTokenType extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(MyTokenType.class);
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
  protected MyTokenType() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public MyTokenType(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public MyTokenType(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public MyTokenType(JCas jcas, int begin, int end) {
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
  //* Feature: MyTokenString

  /** getter for MyTokenString - gets Text of the token
   * @generated
   * @return value of the feature 
   */
  public String getMyTokenString() {
    if (MyTokenType_Type.featOkTst && ((MyTokenType_Type)jcasType).casFeat_MyTokenString == null)
      jcasType.jcas.throwFeatMissing("MyTokenString", "org.KTAnnotators.TokenAnnotator.MyTokenType");
    return jcasType.ll_cas.ll_getStringValue(addr, ((MyTokenType_Type)jcasType).casFeatCode_MyTokenString);}
    
  /** setter for MyTokenString - sets Text of the token 
   * @generated
   * @param v value to set into the feature 
   */
  public void setMyTokenString(String v) {
    if (MyTokenType_Type.featOkTst && ((MyTokenType_Type)jcasType).casFeat_MyTokenString == null)
      jcasType.jcas.throwFeatMissing("MyTokenString", "org.KTAnnotators.TokenAnnotator.MyTokenType");
    jcasType.ll_cas.ll_setStringValue(addr, ((MyTokenType_Type)jcasType).casFeatCode_MyTokenString, v);}    
  }

    