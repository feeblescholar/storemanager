package com.feeblescholar.filehandler;

import org.jetbrains.annotations.NotNull;

public class FileHandlerFactory implements AbstractFileHandlerFactory {

    @Override
    public FileHandler createFileHandler(@NotNull FileType fileType) {
        return switch (fileType) {
            case XML -> new XMLHandler();
        };
    }
}
