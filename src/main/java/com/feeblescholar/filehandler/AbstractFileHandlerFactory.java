package com.feeblescholar.filehandler;

import org.jetbrains.annotations.NotNull;

public interface AbstractFileHandlerFactory {
    enum FileType {
        XML
    }

    FileHandler createFileHandler(@NotNull FileType fileType);
}
