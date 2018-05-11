package org.spstu.evdokimova;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.util.regex.Pattern;

public class CommandLineOptions {
    @Parameter(names = {"-c", "-d", "--key"}, description = "File encryption key")
    public String key;

    @Parameter
    public String inputFilename;

    @Parameter(names = {"-o", "--outputname"}, description = "Output file name")
    public String outputFilename;

    private String[] args;

    CommandLineOptions(String[] args) {
        this.args = args;
        this.parse();
    }

    private void parse() {
        JCommander jc = JCommander.newBuilder()
                .addObject(this)
                .build();
        jc.parse(args);
        if (!Pattern.compile("[\\da-fA-F]+").matcher(this.key).matches()
                && this.key.length() % 2 != 0)
            jc.usage();
    }
}