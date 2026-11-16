package com.feeblescholar.filehandler;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * Transcribes container DSL to the following XML format (and back): <br>
 * &lt;objects&gt; &lt;object&gt; &lt;attribute&gt;value&lt;/attribute&gt; ... &lt;/object&gt; ... &lt;/objects&gt;
 */
public class XMLHandler implements FileHandler {

    @Override
    public void writeToDirectory(@NotNull File directory, @NotNull String filename, @NotNull String dsl) throws IOException {
        StringBuilder xml = new StringBuilder("<objects>\n");
        if (!dsl.isBlank()) {
            for (String object : dsl.split("\\|")) {
                xml.append("\t<object>\n");
                for (String pair : object.split("#")) {
                    String[] keyValue = pair.split(":", 2);
                    String key = keyValue[0].trim();
                    String value = escape(keyValue[1].trim());
                    xml.append("\t\t<").append(key).append('>').append(value).append("</").append(key).append(">\n");
                }
                xml.append("\t</object>\n");
            }
        }
        xml.append("</objects>\n");

        Files.writeString(new File(directory, filename).toPath(), xml, StandardCharsets.UTF_8);
    }

    @Override
    public String readFromDirectory(@NotNull File directory, @NotNull String filename) throws IOException {
        throw new UnsupportedOperationException();
    }

    private static String escape(@NotNull String value) {
        return value.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }
}
