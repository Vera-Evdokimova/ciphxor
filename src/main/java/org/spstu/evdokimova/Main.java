package org.spstu.evdokimova;

public class Main {
    public static void main(String args[]) {
        try {
            CommandLineOptions options = CommandLineOptions.parse(args);
            CipherXOR cipherXOR = new CipherXOR(options);
            cipherXOR.encrypt();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
