package org.KTAnnotators.OpenNLPNER;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.KTAnnotators.OpenNLPTokenizer.OpenNLPToken;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;

public class OpenNLPNERAnnotator extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		// get tokens list from JCAS
		FSIndex tokenIndex = aJCas.getAnnotationIndex(OpenNLPToken.type);
		Iterator itr = tokenIndex.iterator();
		List<String> tokenStr = new ArrayList<String>();
		while(itr.hasNext()) {
			OpenNLPToken tok = (OpenNLPToken) itr.next();
			tokenStr.add(tok.getText());
//			System.out.println(tok.getText());
		}
	    
		
		//Perform NER tagging on the tokens
		String[] tokens = (String[]) tokenStr.toArray(new String[tokenStr.size()]);
		
		//Location NER
		try {
			System.out.println("Running OpenNLP NameFinder (location)");
			FileInputStream fs = new FileInputStream("D:/EclipseProjects/UIMAPipeline/Models/en-ner-location.bin");
			runNameFinder(aJCas, tokens, fs);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//Person NER
		try {
			System.out.println("Running OpenNLP NameFinder (Person)");
			FileInputStream fs = new FileInputStream("D:/EclipseProjects/UIMAPipeline/Models/en-ner-person.bin");
			runNameFinder(aJCas, tokens, fs);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	void runNameFinder(JCas aJCas, String[] tokens, FileInputStream fs) throws Exception{
        TokenNameFinderModel tmodel = new TokenNameFinderModel(fs);

        NameFinderME namfind = new NameFinderME(tmodel);
        Span names[] = namfind.find(tokens);
        double probs[] = namfind.probs();

        //Update the NER tag in JCAS
        FSIndex tokenIndex = aJCas.getAnnotationIndex(OpenNLPToken.type);
        Iterator itr = tokenIndex.iterator();
        int i = 0;
        
        while(itr.hasNext() && i<names.length) {
        	OpenNLPToken tok = (OpenNLPToken)itr.next();
        	if(names[i].getStart()==tok.getBegin()) {
        		tok.setNamedEntityTag(names[i++].getType());     //ner tag set
        		System.out.println(tok.getNamedEntityTag() +" "+ tok.getText());
        	}
        }
        
        /*for(Span s : names){
            System.out.println(s.toString() +" "+ tokens[s.getStart()]+ " "+ probs[s.getStart()]);
        }*/
	}

}
