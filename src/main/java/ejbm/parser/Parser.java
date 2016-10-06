/*
	Parser
 */

package ejbm.parser;

import java.io.*;

public class Parser {

    public Parser() {

    }

    public void run(File location) {
    	ParserFileVisitor visitor = new ParserFileVisitor(location);
    	System.out.println("-------");
    }

}