package org.spstu.evdokimova;

import com.beust.jcommander.JCommander;

import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        CommandLineOptions options = new CommandLineOptions();
        JCommander.newBuilder()
                .addObject(options)
                .build()
                .parse(args);
        try {
            new CipherXOR(options);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
