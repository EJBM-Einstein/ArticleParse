/*
	ParserFileVisitor
 */

package ejbm.parser;

import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

import static java.nio.file.FileVisitResult.*;

/**
 * Extends FileVistor to for a recursive search of journal articles for semantic parsing.
 */
public class ParserFileVisitor extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {

        if (attrs.isRegularFile() || attrs.isSymbolicLink()) {
            if (path.toString().toLowerCase().endsWith(".pdf")) {
                System.out.println("Found PDF path:" + path);
            }
        }

        return CONTINUE;
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