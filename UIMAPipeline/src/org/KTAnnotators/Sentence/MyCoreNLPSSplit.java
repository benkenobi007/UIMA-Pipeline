package org.KTAnnotators.Sentence;

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

public class MyCoreNLPSSplit extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		
		runssplit(aJCas);
		
	}
	
	void runssplit(JCas aJCas) {
		
		//get CoreDoc from JCAS
		FSIndex docIndex = aJCas.getAnnotationIndex(MyCoreDocument.class);
		Iterator itr = docIndex.iterator();
		MyCoreDocument mydoc = (MyCoreDocument)itr.next();
		CoreDocument doc = mydoc.coredoc;
		
		Properties props = new Properties();
		props.setProperty("annotators", "ssplit");
		StanfordCoreNLP pipeline = new StanfordCoreNLP(props,false); // false since requirements should not be enforced
		
		pipeline.annotate(doc);
		
		mydoc.coredoc = doc;   //update the coredocument
		
		//get the sentences, add to CAS
		List<CoreSentence> sentences = doc.sentences();
	    for(CoreSentence s : sentences)
	    {
	            System.out.println(s);
	            mySentenceType ms = new mySentenceType(aJCas);
	            int toksize = s.tokens().size();
	            
	            ms.setBegin(s.tokens().get(0).beginPosition());
	            ms.setEnd(s.tokens().get(toksize-1).endPosition());
	            ms.addToIndexes();
	    }
	}

}
