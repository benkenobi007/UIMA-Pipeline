

/* First created by JCasGen Fri Jul 06 16:34:20 IST 2018 */
package org.KTAnnotators.OpenNLPChunker;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Mon Jul 09 11:55:50 IST 2018
 * XML source: D:/EclipseProjects/UIMAPipeline/desc/OpenNLPPipelineDescriptor.xml
 * @generated */
public class openNLPChunk extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(openNLPChunk.class);
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
  protected openNLPChunk() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public openNLPChunk(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public openNLPChunk(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public openNLPChunk(JCas jcas, int begin, int end) {
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
  //* Feature: chunkType

  /** getter for chunkType - gets 
   * @generated
   * @return value of the feature 
   */
  public String getChunkType() {
    if (openNLPChunk_Type.featOkTst && ((openNLPChunk_Type)jcasType).casFeat_chunkType == null)
      jcasType.jcas.throwFeatMissing("chunkType", "org.KTAnnotators.OpenNLPChunker.openNLPChunk");
    return jcasType.ll_cas.ll_getStringValue(addr, ((openNLPChunk_Type)jcasType).casFeatCode_chunkType);}
    
  /** setter for chunkType - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setChunkType(String v) {
    if (openNLPChunk_Type.featOkTst && ((openNLPChunk_Type)jcasType).casFeat_chunkType == null)
      jcasType.jcas.throwFeatMissing("chunkType", "org.KTAnnotators.OpenNLPChunker.openNLPChunk");
    jcasType.ll_cas.ll_setStringValue(addr, ((openNLPChunk_Type)jcasType).casFeatCode_chunkType, v);}    
  }

    