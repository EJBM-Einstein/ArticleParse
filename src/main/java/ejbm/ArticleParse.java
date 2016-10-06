/*
	Article Parse
 */

import ejbm.parser.*;
import java.io.*;

public class ArticleParse {

    public static void main(String[] args) {

    	if (args.length == 0) {
    		printUsageInterface();
    		System.exit(1);
    	}

    	Parser parser = new Parser();

        System.out.println("Running ArticleParse ... (prints PDFs encountered)\n");

        for (String fileName : args) {
        	File location = new File(fileName);
        	parser.run(location);
        }

    }

    /**
     * Prints the purpose and usage for the main application ArticleParse
     */
    private static void printUsageInterface() {
    	String message = "";
    	message += "+++ ArticleParse +++\n";
    	message += "\n";
    	message += "    PURPOSE: Given a list of locations (files or directories) reads each PDF document encountered.\n";
    	message += "    The content of the PDF is semantically parsed. For example the authors of the article can be selected and saved.\n";
    	message += "\n";
    	message += "    USAGE: ArticleParse <location_1> [ .. <location_n> ]\n";

    	System.err.print(message);
    }

}