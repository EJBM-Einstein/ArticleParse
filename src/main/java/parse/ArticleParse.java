/*
	Article Parse
 */

import java.io.*;

public class ArticleParse {

    public static void main(String[] args) {

    	if (args.length == 0) {
    		printUsageInterface();
    		System.exit(1);
    	}

        System.out.println("Running Article Parse... (prints PDFs encountered)");

    }

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