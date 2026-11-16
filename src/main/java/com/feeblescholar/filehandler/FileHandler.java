package com.feeblescholar.filehandler;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

/**
 * File handler interface that allows DSL to be managed through files on the disk.
 */
public interface FileHandler {
    /**
     * @param directory The target directory.
     * @param filename The name of the file to be written.
     * @param dsl The DSL to be transcribed to the target file.
     * @throws IOException If the file cannot be written.
     */
    void writeToDirectory(@NotNull File directory, @NotNull String filename, @NotNull String dsl) throws IOException;

    /**
     * @param directory The source directory.
     * @param filename The name of the file to read from.
     * @throws IOException If the file does not exist or cannot be read.
     */
    String readFromDirectory(@NotNull File directory, @NotNull String filename) throws IOException;
}
