/*
	ParserFileVisitor
 */

package ejbm.parser;

import java.io.*;
/*import java.nio.file;

import static java.nio.file.FileVisitResult.*;

public class ParserFileVisitor extends FileVisitor<Path> {

    public ParserFileVisitor(File initLocation) {
    	System.out.println("initLocation = " + initLocation);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("file = " + file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException e) throws IOException {
        if (e == null) {
            Files.delete(dir);
            return FileVisitResult.CONTINUE;
        } else {
            // directory iteration failed
            throw e;
        }
    }

}*/

public class ParserFileVisitor {

    public ParserFileVisitor(File initLocation) {
        System.out.println("initLocation = " + initLocation);
    }

}