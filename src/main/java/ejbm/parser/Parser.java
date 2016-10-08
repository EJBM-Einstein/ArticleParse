/*
	Parser
 */

package ejbm.parser;

import java.io.*;

/**
 * The article parser is initialized with a configuration (See ParserConfiguration). When the parser
 * is run with the run() function it will parse all PDF files or recursively search a directory.
 * Parsed articles have their semantic information extracted such as article title, authors, 
 * abstract, references, etc.
 */
public class Parser {

	private ParserConfiguration configuration;

    public Parser(ParserConfiguration configuration) {
    	this.configuration = configuration;
    }

    public void run(File location) {
    	ParserFileVisitor visitor = new ParserFileVisitor(location);
    	System.out.println("-------");
    }

}