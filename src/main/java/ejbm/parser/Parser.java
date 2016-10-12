/*
	Parser
 */

package ejbm.parser;

import java.io.*;
import java.nio.file.*;


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
    	try {
			Path path = location.toPath();
			ParserFileVisitor fileVisitor = new ParserFileVisitor();
			Files.walkFileTree(path, fileVisitor);
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Caught IOException walking file tree.");
			System.exit(1);
		}
    }

}