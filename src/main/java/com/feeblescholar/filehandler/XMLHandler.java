package com.feeblescholar.filehandler;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Transcribes container DSL to the following XML format (and back): <br>
 * &lt;objects&gt; &lt;object&gt; &lt;attribute&gt;value&lt;/attribute&gt; ... &lt;/object&gt; ... &lt;/objects&gt;
 */
public class XMLHandler implements FileHandler {
    private static final String ROOT_OPEN = "<objects>";
    private static final String ROOT_CLOSE = "</objects>";
    private static final Pattern OBJECT = Pattern.compile("<object>(.*?)</object>", Pattern.DOTALL);
    private static final Pattern ATTRIBUTE = Pattern.compile("<([A-Za-z_]\\w*)>(.*?)</\\1>", Pattern.DOTALL);

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
        String xml = Files.readString(new File(directory, filename).toPath(), StandardCharsets.UTF_8).strip();
        if (!xml.startsWith(ROOT_OPEN) || !xml.endsWith(ROOT_CLOSE)) {
            throw new MalformedFileException(filename + ": missing <objects> root.");
        }
        String body = xml.substring(ROOT_OPEN.length(), xml.length() - ROOT_CLOSE.length());

        List<String> objects = new ArrayList<>();
        for (MatchResult object : matchAll(OBJECT, body, filename)) {
            List<String> pairs = new ArrayList<>();
            for (MatchResult attribute : matchAll(ATTRIBUTE, object.group(1), filename)) {
                pairs.add(attribute.group(1) + ": " + unescape(attribute.group(2)));
            }
            if (pairs.isEmpty()) {
                throw new MalformedFileException(filename + ": <object> without attributes.");
            }
            objects.add(String.join(" # ", pairs));
        }
        return String.join(" | ", objects);
    }

    /**
     * @return Every match of the given pattern, failing if anything but whitespace is between or around them.
     */
    private static List<MatchResult> matchAll(@NotNull Pattern pattern, @NotNull String text, @NotNull String filename)
            throws MalformedFileException {
        List<MatchResult> matches = new ArrayList<>();
        Matcher matcher = pattern.matcher(text);
        int lastEnd = 0;
        while (matcher.find()) {
            requireBlank(text, lastEnd, matcher.start(), filename);
            matches.add(matcher.toMatchResult());
            lastEnd = matcher.end();
        }
        requireBlank(text, lastEnd, text.length(), filename);
        return matches;
    }

    private static void requireBlank(@NotNull String text, int from, int to, @NotNull String filename)
            throws MalformedFileException {
        String between = text.substring(from, to);
        if (!between.isBlank()) {
            throw new MalformedFileException(filename + ": unexpected content: " + between.strip());
        }
    }

    private static String escape(@NotNull String value) {
        return value.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }

    /**
     * The reverse of {@link #escape(String)}: <i>&amp;amp;</i> has to go last, otherwise <i>&amp;amp;lt;</i> would
     * be decoded twice and become <i>&lt;</i>.
     */
    private static String unescape(@NotNull String value) {
        return value.replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", "&");
    }
}
