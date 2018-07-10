package org.KTAnnotators.CorefAnnotator;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.KTAnnotators.CoreDocument.MyCoreDocument;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;

import edu.stanford.nlp.coref.data.CorefChain;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreEntityMention;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class CorefAnnotator extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		
		//get document from JCAS
		FSIndex docIndex = aJCas.getAnnotationIndex(MyCoreDocument.type);
		Iterator itr = docIndex.iterator();
		MyCoreDocument mydoc = (MyCoreDocument)itr.next();
		CoreDocument doc = mydoc.coredoc;
		
		//annotate the document
		Properties props = new Properties();
		props.setProperty("annotators", "coref");
		StanfordCoreNLP pipeline = new StanfordCoreNLP(props,false); // false since requirements should not be enforced
		pipeline.annotate(doc);
		
		//test coref results
		// coreference between entity mentions
        List<CoreEntityMention> originalEntityMentions = doc.sentences().get(0).entityMentions();
        for(CoreEntityMention originalEntityMention : originalEntityMentions) {
            //CoreEntityMention originalEntityMention = document.sentences().get(3).entityMentions().get(1);
            System.out.println("Example: original entity mention");
            System.out.println(originalEntityMention);
            System.out.println("Example: canonical entity mention");
            System.out.println(originalEntityMention.canonicalEntityMention().get());
           // System.out.println();
        }

        // get document wide coref info
        Map<Integer, CorefChain> corefChains = doc.corefChains();
        System.out.println("Example: coref chains for document");
        System.out.println(corefChains);
        System.out.println();
        
        //Update the document in CAS
		mydoc.coredoc = doc;

	}
	
	

}
