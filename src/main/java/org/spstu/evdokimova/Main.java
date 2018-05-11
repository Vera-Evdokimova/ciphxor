package org.spstu.evdokimova;

import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        CommandLineOptions options = new CommandLineOptions(args);
        try {
            new CipherXOR(options);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
