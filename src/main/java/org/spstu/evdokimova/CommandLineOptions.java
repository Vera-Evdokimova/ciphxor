package org.spstu.evdokimova;

import com.beust.jcommander.Parameter;

public class CommandLineOptions {
    @Parameter(names = {"-c", "-d", "--key"}, description = "File encryption key")
    public String key;

    @Parameter
    public String inputFilename;

    @Parameter(names = {"-0", "--outputname"}, description = "Output file name")
    public String outputFilename;
}