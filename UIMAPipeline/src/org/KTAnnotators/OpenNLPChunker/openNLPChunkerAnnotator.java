package org.KTAnnotators.OpenNLPChunker;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.KTAnnotators.OpenNLPTokenizer.OpenNLPToken;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;

import opennlp.tools.chunker.ChunkerME;
import opennlp.tools.chunker.ChunkerModel;
import opennlp.tools.util.Span;

public class openNLPChunkerAnnotator extends JCasAnnotator_ImplBase {

	List<String> tokenStr = new ArrayList<String>();		//list of tokens
	List<String> tagStr = new ArrayList<String>();			//list of tags
	List<Integer> tokenStart = new ArrayList<Integer>();	//list of token start locations, required for chunking
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		
		//get list of tokens and tags from JCas
		FSIndex tokenIndex = aJCas.getAnnotationIndex(OpenNLPToken.type);
		Iterator itr = tokenIndex.iterator();
		
		while(itr.hasNext()) {
			OpenNLPToken tok = (OpenNLPToken) itr.next();
			tokenStr.add(tok.getText());
			tagStr.add(tok.getTag());
			tokenStart.add(tok.getBegin());
//				System.out.println(tok.getText());
		}
		String[] tokens = tokenStr.toArray(new String[tokenStr.size()]);
		String[] tags = tagStr.toArray(new String[tagStr.size()]);
		
		//perform chunking
		try {
			chunkSent(aJCas,tokens,tags);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	void chunkSent(JCas aJCas,String[] tokens, String[] tags) throws Exception{

        InputStream fs = new FileInputStream("D:\\EclipseProjects\\UIMAPipeline\\Models\\en-chunker.bin");
        ChunkerModel chmodel = new ChunkerModel(fs);
        ChunkerME chunker = new ChunkerME(chmodel);
        String chunks[] = chunker.chunk(tokens,tags);
        Span[] chunkSpans = chunker.chunkAsSpans(tokens, tags);		//get the chunk spans
//        double[] probs = chunker.probs();
        
        
        for(Span s : chunkSpans) {
        	openNLPChunk ch = new openNLPChunk(aJCas);
//        	System.out.println("Start : "+tokenStart.get(s.getStart())+" Last: "+tokenStart.get(s.getEnd()));
        	ch.setBegin(tokenStart.get(s.getStart()));		//s.getStart : gives the index of the first token in chunk
        	ch.setEnd(tokenStart.get(s.getEnd()));		//s.getEnd : gives index of the first token not in the chunk
        	ch.setChunkType(s.getType());					//Specify the type of chunk        	
        	ch.addToIndexes();
        }

        System.out.println();
        System.out.println("OpenNLP Chunker : ");
        for(String s:chunks){
            System.out.println(s);
        }
        /*
        for(double d:probs){
            System.out.println(d);
        }*/
    }
	

}
