/*
	ParserFileVisitor
 */

package ejbm.parser;

import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.contentstream.*;
import org.apache.pdfbox.text.*;

import static java.nio.file.FileVisitResult.*;

/**
 * Extends FileVistor to for a recursive search of journal articles for semantic parsing.
 */
public class ParserFileVisitor extends SimpleFileVisitor<Path> {

    private static String JOURNAL_NAME_SHORT = "EJBM Einstein J. Biol. Med.";
    private static String[] ARTICLE_TYPES = 
    { 
        "BLOG POST",
        "CASE REPORT",
        "COMMENTARY",
        "BRIEF COMMUNICATION",
        "HISTORICAL PERSPECTIVE",
        "MEDICAL ETHICS",
        "MEDICAL REVIEW"
    };

    private Path path;
    private String[] content;
    private String fullContent;

    private String firstPage;
    private String lastPage;
    private String publicationYear;
    private String volumeNumber;
    private String articleType;

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {

        if (attrs.isRegularFile() || attrs.isSymbolicLink()) {
            if (path.toString().toLowerCase().endsWith(".pdf")) {

                this.path = path;

                try {
                    PDDocument pddDocument = PDDocument.load(path.toFile());
                    PDFTextStripper textStripper = new PDFTextStripper();

                    fullContent = textStripper.getText(pddDocument);

                    textStripper.setStartPage( 1 );
                    textStripper.setEndPage( 1 );
                    content = textStripper.getText(pddDocument).split("\\n");
                    pddDocument.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("Caught IOException in ParserFileVisitor visitFile().");
                }
                
                parseHeader();
                parseArticleType();



                printOutput();
            }
        }

        return CONTINUE;
    }

    private void printOutput() {
        System.out.println("-------- " + path.getFileName().toString() + " --------");
        System.out.println("First Page: " + firstPage);
        System.out.println("Last Page: " + lastPage);
        System.out.println("Publication Year: " + publicationYear);
        System.out.println("Volume No: " + volumeNumber);
        System.out.println();
        System.out.println("Article Type: " + articleType);
        System.out.println("++++++++");
        System.out.println(fullContent);
        System.out.println("--------");
    }

    private void parseHeader() {
        String tail = content[0].split(JOURNAL_NAME_SHORT + " \\(")[1];
        publicationYear = tail.split("\\)")[0];

        tail = tail.split("\\) ")[1];
        volumeNumber = tail.split("\\:")[0];

        tail = tail.split("\\:")[1];
        firstPage = tail.split("-")[0];

        lastPage = tail.split("-")[1];
    }

    private void parseArticleType() {
        articleType = "UKNOWN";
        for (String type : ARTICLE_TYPES) {
            if (content[1].equals(type)) {
                articleType = type;
                break;
            }
        }
    }

    @Override
    public FileVisitResult postVisitDirectory(Path path, IOException ioException) {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path path, IOException ioException) {
        return CONTINUE;
    }
}