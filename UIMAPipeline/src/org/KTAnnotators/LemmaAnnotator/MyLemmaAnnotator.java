package org.KTAnnotators.LemmaAnnotator;

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
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

public class MyLemmaAnnotator extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		
		//get doc from JCAS
		FSIndex docIndex = aJCas.getAnnotationIndex(MyCoreDocument.class);
		Iterator itr = docIndex.iterator();
		MyCoreDocument mydoc = (MyCoreDocument)itr.next();
		CoreDocument doc = mydoc.coredoc;
		
		//annotate the document
		Properties props = new Properties();
		props.setProperty("annotators", "lemma");
		StanfordCoreNLP pipeline = new StanfordCoreNLP(props,false); // false since requirements should not be enforced
		pipeline.annotate(doc);
		
		//Check the lemmas
		List<String> lemmas = new LinkedList<String>();
        List<CoreMap> sentences = doc.annotation().get(CoreAnnotations.SentencesAnnotation.class);
        for(CoreMap sent: sentences) {
            // Iterate over all tokens in a sentence
            for (CoreLabel token: sent.get(CoreAnnotations.TokensAnnotation.class)) {
                // Retrieve and add the lemma for each word into the list of lemmas
                lemmas.add(token.get(CoreAnnotations.LemmaAnnotation.class));
            }
        }
        System.out.println("Lemmatization");
        for(String lemma : lemmas){
            System.out.println(lemma);
        }
        
        
		//Update the document in CAS
//		mydoc.removeFromIndexes();
		mydoc.coredoc = doc;
//		mydoc.addToIndexes();

	}

}
