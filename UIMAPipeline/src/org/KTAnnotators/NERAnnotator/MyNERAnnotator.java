package org.KTAnnotators.NERAnnotator;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.KTAnnotators.CoreDocument.MyCoreDocument;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.trees.Tree;

public class MyNERAnnotator extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		//get doc from JCAS
		FSIndex docIndex = aJCas.getAnnotationIndex(MyCoreDocument.class);
		Iterator itr = docIndex.iterator();
		MyCoreDocument mydoc = (MyCoreDocument)itr.next();
		CoreDocument doc = mydoc.coredoc;
		
		//annotate the document
		Properties props = new Properties();
		props.setProperty("annotators", "ner");
		StanfordCoreNLP pipeline = new StanfordCoreNLP(props,false); // false since requirements should not be enforced
		pipeline.annotate(doc);
		
		// list of the ner tags for the first sentence
        CoreSentence sentence = doc.sentences().get(0);
        List<String> nerTags = sentence.nerTags();
        System.out.println("Example: ner tags");
        System.out.println(nerTags);
        System.out.println();
        
		//Update the document in CAS
//		mydoc.removeFromIndexes();
		mydoc.coredoc = doc;
//		mydoc.addToIndexes();
		
	}

}
