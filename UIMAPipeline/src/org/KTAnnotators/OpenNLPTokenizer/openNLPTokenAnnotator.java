package org.KTAnnotators.OpenNLPTokenizer;

import java.io.FileInputStream;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;

public class openNLPTokenAnnotator extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		// TODO Auto-generated method stub
		tokenizeLang(aJCas);
		
	}
	
	
	void tokenizeLang(JCas aJCas){
        //Tokenizer tk = SimpleTokenizer.INSTANCE;

        try{
        	String text = aJCas.getDocumentText();
            FileInputStream fs = new FileInputStream("D:/EclipseProjects/UIMAPipeline/Models/en-token.bin");
            TokenizerModel mod = new TokenizerModel(fs);
            TokenizerME tk = new TokenizerME(mod);
            Span tkSpans[] = tk.tokenizePos(text);  //get the spans of tokens
            String tokens[] = tk.tokenize(text);    //get the token text
            
            
            for(int i=0;i<tkSpans.length;i++) {
            	OpenNLPToken tok = new OpenNLPToken(aJCas);
            	tok.setBegin(tkSpans[i].getStart());  	//mark the starting point
            	tok.setEnd(tkSpans[i].getEnd());		//mark the ending point
            	tok.setText(tokens[i]);					//set the text
            	tok.addToIndexes();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
