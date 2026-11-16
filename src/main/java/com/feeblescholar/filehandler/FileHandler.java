package com.feeblescholar.filehandler;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * File handler interface that allows DSL to be managed through files on the disk.
 */
public interface FileHandler {
    /**
     * @param directory The target directory.
     * @param filename The name of the file to be written.
     * @param dsl The DSL to be transcribed to the target file.
     */
    void writeToDirectory(File directory, String filename, String dsl);

    /**
     * @param directory The source directory.
     * @param filename The name of the file to read from.
     */
    String readFromDirectory(File directory, String filename) throws FileNotFoundException;
}
