package org.KTAnnotators.TokenAnnotator;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.KTAnnotators.CoreDocument.MyCoreDocument;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.pipeline.TokenizerAnnotator;

public class MyCoreNLPTokenAnnotator extends JCasAnnotator_ImplBase {
	public static String text = "Joe Smith was born in California. " +
            "In 2017, he went to Paris, France in the summer. " +
            "His flight left at 3:00pm on July 10th, 2017. " +
            "After eating some escargot for the first time, Joe said, \"That was delicious!\" " +
            "He sent a postcard to his sister Jane Smith. " +
            "After hearing about Joe's trip, Jane decided she might go to France one day.";

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		// TODO Auto-generated method stub
//		aJCas.setDocumentText(text);
		runCoreNLP(aJCas);
		
		//Code to check the result in CAS
		FSIndex tokenIndex = aJCas.getAnnotationIndex(MyTokenType.type);
		Iterator tokIter = tokenIndex.iterator();
		while(tokIter.hasNext()) {
			MyTokenType tok = (MyTokenType)tokIter.next();
			System.out.println(tok.getMyTokenString());
		}

	}
	
	void runCoreNLP(JCas aJCas) {
		Properties props = new Properties();
		props.setProperty("annotators", "tokenize");
		text = aJCas.getDocumentText();
		/*StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
		CoreDocument document = new CoreDocument(text);
		pipeline.annotate(document);*/
		
		Annotation doc = new Annotation(text);
        TokenizerAnnotator ta = new TokenizerAnnotator();
        ta.annotate(doc);
        CoreDocument document = new CoreDocument(doc);
        List<CoreLabel> tokens = document.tokens();
        
        MyCoreDocument coredocAnnot = new MyCoreDocument(aJCas);
        coredocAnnot.coredoc = document;
        coredocAnnot.addToIndexes();
        
        for(CoreLabel token : tokens){
        	MyTokenType annotation = new MyTokenType(aJCas);
        	annotation.setBegin(token.beginPosition());
        	annotation.setEnd(token.endPosition());
        	annotation.setMyTokenString(token.toString());
        	annotation.addToIndexes();
//            System.out.println(token);
        }
	}
	
	
}
