package org.KTAnnotators.ParseAnnotator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.KTAnnotators.CoreDocument.MyCoreDocument;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

// Performs parse, depparse operations
public class MyParseAnnotator extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		//get doc from JCAS
				FSIndex docIndex = aJCas.getAnnotationIndex(MyCoreDocument.class);
				Iterator itr = docIndex.iterator();
				MyCoreDocument mydoc = (MyCoreDocument)itr.next();
				CoreDocument doc = mydoc.coredoc;
				
				//annotate the document
				Properties props = new Properties();
				props.setProperty("annotators", "parse,depparse");
				StanfordCoreNLP pipeline = new StanfordCoreNLP(props,false); // false since requirements should not be enforced
				pipeline.annotate(doc);
				
				// constituency parse for the second sentence
		        CoreSentence sentence = doc.sentences().get(1);
		        Tree constituencyParse = sentence.constituencyParse();
		        System.out.println("Example: constituency parse");
		        System.out.println(constituencyParse);
		        System.out.println();
		        
				//Update the document in CAS
//				mydoc.removeFromIndexes();
				mydoc.coredoc = doc;
//				mydoc.addToIndexes();

	}

}
