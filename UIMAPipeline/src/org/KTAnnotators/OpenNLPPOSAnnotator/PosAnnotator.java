package org.KTAnnotators.OpenNLPPOSAnnotator;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.KTAnnotators.CoreDocument.MyCoreDocument;
import org.KTAnnotators.OpenNLPTokenizer.OpenNLPToken;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

public class PosAnnotator extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
	
		System.out.println("CoreNLP tokens not found");
		System.out.println("Attempting pos tagging with OpenNLP");
		processWithOpenNLP(aJCas);
		
	}
	
/*	void processWithCoreNLP(JCas aJCas, CoreDocument doc) throws Exception{
		List<CoreLabel> tokens = doc.tokens();
		List<String> tokenStr = new ArrayList<String>();
		for(CoreLabel token : tokens) {
			tokenStr.add(token.toString());
		}
		
		String[] tokArr = (String[]) tokenStr.toArray(new String[tokenStr.size()]);
		
		try {
			posTagger(aJCas,tokArr);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
*/	
	void processWithOpenNLP(JCas aJCas) {
		//get the tokens from CAS
				FSIndex tokenIndex = aJCas.getAnnotationIndex(OpenNLPToken.type);
				Iterator itr = tokenIndex.iterator();
				List<String> tokenStr = new ArrayList<String>();
				while(itr.hasNext()) {
					OpenNLPToken tok = (OpenNLPToken) itr.next();
					tokenStr.add(tok.getText());
//					System.out.println(tok.getText());
				}
			    
				
				//Perform POS tagging on the tokens
				String[] tokens = (String[]) tokenStr.toArray(new String[tokenStr.size()]);
				try {
					posTagger(aJCas,tokens);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
	}
	
	//POS Tagging function
	void posTagger(JCas aJCas, String[] tokens) throws Exception {
        InputStream fs = new FileInputStream("D:/EclipseProjects/UIMAPipeline/Models/en-pos-maxent.bin");
        POSModel pModel = new POSModel(fs);
        POSTaggerME tagger = new POSTaggerME(pModel);
        String tags[] = tagger.tag(tokens);
        double probs[] = tagger.probs();

        
        System.out.println("Token\t\tTag\t\tProb");
        for(int i=0;i<tokens.length;i++){
            System.out.println(tokens[i] + "\t\t"+tags[i] + "\t\t"+probs[i]);
        }
        
        //update the cas
        //add pos tag to token annotation
        FSIndex tokenIndex = aJCas.getAnnotationIndex(OpenNLPToken.type);
		Iterator itr = tokenIndex.iterator();
		int i=0;
		
		while(itr.hasNext() && i<tags.length) {
			OpenNLPToken tok = (OpenNLPToken) itr.next();
			tok.setTag(tags[i++]);
		}
    }

}
