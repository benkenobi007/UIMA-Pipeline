package org.KTAnnotators.RelationExtractor;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.KTAnnotators.CoreDocument.MyCoreDocument;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;

import edu.stanford.nlp.ie.machinereading.structure.EntityMention;
import edu.stanford.nlp.ie.machinereading.structure.MachineReadingAnnotations;
import edu.stanford.nlp.ie.machinereading.structure.RelationMention;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreEntityMention;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.RelationExtractorAnnotator;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

public class myRelationExtractorAnnotator extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		//get doc from JCAS
		FSIndex docIndex = aJCas.getAnnotationIndex(MyCoreDocument.class);
		Iterator itr = docIndex.iterator();
		MyCoreDocument mydoc = (MyCoreDocument)itr.next();
		CoreDocument doc = mydoc.coredoc;
		
		//annotate the document
		Properties props = new Properties();
		props.setProperty("annotators", "relation");
		StanfordCoreNLP pipeline = new StanfordCoreNLP(props,false); // false since requirements should not be enforced
		pipeline.annotate(doc);
		
		//Relation Extraction
        try {

            for (CoreMap s : doc.annotation().get(CoreAnnotations.SentencesAnnotation.class)) {
                System.out.println("Sentence : " + s.get(CoreAnnotations.TextAnnotation.class));
                List<RelationMention> rls = s.get(MachineReadingAnnotations.RelationMentionsAnnotation.class);
                for (RelationMention r1 : rls) {
                    System.out.println("Relation Type = " + r1.getType());

                    System.out.println("Entities : ");
                    for(EntityMention arg : r1.getEntityMentionArgs()){
                        System.out.println(arg.getValue());
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
		//Update the document in CAS
//		mydoc.removeFromIndexes();
		mydoc.coredoc = doc;
//		mydoc.addToIndexes();
	
		//Test relation extractor on updated text
		String newTxt = replaceEnititiesWithCanonicalMentions(doc);
		System.out.println("Relation Extraction with canonical Text");
		relationAnnotator(newTxt);
	    

	}
	
	String replaceEnititiesWithCanonicalMentions(CoreDocument document) {
		
		int offset = 0;		//offset for indexing purposes
		
		String updatedText = document.text();
		for(CoreSentence sentence : document.sentences()) {
            //System.out.println("Sentence #"+(i++) + " : "+sentence.text());
            List<CoreEntityMention> originalEntityMentions = sentence.entityMentions();
            for (CoreEntityMention originalEntityMention : originalEntityMentions) {

                //Replace each entity mention with canonical mention
                int beg = originalEntityMention.tokens().get(0).beginPosition() + offset;
                int numTok = originalEntityMention.tokens().size();
                int end = originalEntityMention.tokens().get(numTok-1).endPosition()+offset;
                updatedText = updatedText.substring(0,beg) + originalEntityMention.canonicalEntityMention().get() + updatedText.substring(end,updatedText.length());

                
                offset += originalEntityMention.canonicalEntityMention().get().toString().length() - originalEntityMention.toString().length();
            }
        }
//		System.out.println("Text with canonical entities : ");
//        System.out.println(updatedText);
        
        return updatedText;
	}
	
	//Performs relation extraction on updated text
	void relationAnnotator(String text) {
		Annotation doc = new Annotation(text);
         Properties props = new Properties();

         props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,depparse");
         StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
         pipeline.annotate(doc);
         RelationExtractorAnnotator r = new RelationExtractorAnnotator(props);
         r.annotate(doc);
         
         for (CoreMap s : doc.get(CoreAnnotations.SentencesAnnotation.class)) {
             System.out.println("Sentence : " + s.get(CoreAnnotations.TextAnnotation.class));
             List<RelationMention> rls = s.get(MachineReadingAnnotations.RelationMentionsAnnotation.class);
             for (RelationMention r1 : rls) {
//                 r1.getArgNames();
                 System.out.println("Relation Type = " + r1.getType());

                 System.out.println("Entities : ");
                 for(EntityMention arg : r1.getEntityMentionArgs()){
                     System.out.println(arg.getValue());
//                     System.out.println(arg);
                 }

//                 System.out.println(r1.toString());
             }
         }
	}

}
