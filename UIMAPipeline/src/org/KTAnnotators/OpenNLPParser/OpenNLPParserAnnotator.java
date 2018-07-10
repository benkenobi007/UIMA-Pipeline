package org.KTAnnotators.OpenNLPParser;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;
import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;

public class OpenNLPParserAnnotator extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		
		System.out.println("Open NLP Parser : ");
		try {
			runParser(aJCas);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	void runParser(JCas aJCas) throws Exception{
		InputStream fs = new FileInputStream("D:/EclipseProjects/UIMAPipeline/Models/en-parser-chunking.bin");
		
		ParserModel pmodel = new ParserModel(fs);
		Parser parser = ParserFactory.create(pmodel);
		
		Parse[] parses = ParserTool.parseLine(aJCas.getDocumentText(), parser, 1);
		for(Parse p : parses) {
			p.show();
		}
	}

}
