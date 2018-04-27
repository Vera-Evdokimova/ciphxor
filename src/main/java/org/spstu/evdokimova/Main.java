package org.spstu.evdokimova;

import com.beust.jcommander.JCommander;

public class Main {
    public static void main(String args[]) {
        CommandLineOptions options = new CommandLineOptions();
        JCommander.newBuilder()
                .addObject(options)
                .build()
                .parse(args);
        System.out.print(options.inputFilename);
    }
}
