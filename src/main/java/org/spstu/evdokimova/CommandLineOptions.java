package org.spstu.evdokimova;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.util.regex.Pattern;

public class CommandLineOptions {
    @Parameter(names = {"-o", "--outputname"}, description = "Output file name")
    private String outputFilename;
    @Parameter(names = {"-c", "-d", "--key"}, description = "File encryption key")
    private String key;
    @Parameter
    private String inputFilename;

    public static CommandLineOptions parse(String[] args) {
        CommandLineOptions options = new CommandLineOptions();
        JCommander jc = JCommander.newBuilder()
                .addObject(options)
                .build();
        jc.parse(args);
        if (!Pattern.compile("[\\da-fA-F]+").matcher(options.key).matches() && options.key.length() % 2 != 0)
            jc.usage();
        return options;
    }

    public String getKey() {
        return key;
    }

    public String getInputFilename() {
        return inputFilename;
    }

    public String getOutputFilename() {
        return outputFilename;
    }
}