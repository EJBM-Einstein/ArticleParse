/*
	Parser
 */

package ejbm.parser;

import java.io.*;

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