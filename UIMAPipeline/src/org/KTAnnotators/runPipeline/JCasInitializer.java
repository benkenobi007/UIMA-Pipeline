package org.KTAnnotators.runPipeline;

import java.io.File;

import org.apache.uima.UIMAFramework;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceSpecifier;
import org.apache.uima.util.XMLInputSource;


public class JCasInitializer 
{
	AnalysisEngine analysisEngine = null;
	
	//generate the analysis engine from the XML descriptor
	public JCasInitializer(String descriptorName) throws Exception{
		File descFile = new File(descriptorName);
		XMLInputSource descSource = new XMLInputSource(descFile);
		ResourceSpecifier spec = UIMAFramework.getXMLParser().parseResourceSpecifier(descSource);
		analysisEngine = UIMAFramework.produceAnalysisEngine(spec);
	}
	
	//run the UIMA pipeline on the text
	public void process(String text) throws Exception {
		JCas jcas = analysisEngine.newJCas();
		jcas.setDocumentText(text);
		analysisEngine.process(jcas);
	}

}
