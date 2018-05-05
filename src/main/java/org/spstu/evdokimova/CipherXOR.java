package org.spstu.evdokimova;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CipherXOR {
    private static byte[] file;

    public CipherXOR(CommandLineOptions cmd) throws IOException {
        this.encrypt(cmd.inputFilename, cmd.key);
        this.finalise(cmd.outputFilename, cmd.inputFilename);
    }

    private void encrypt(String text, String keyWord) throws IOException {
        file = Files.readAllBytes(Paths.get(text));
        byte[] keyarr = new byte[keyWord.length() / 2];
        for (int i = 0; i < keyWord.length(); i += 2) {
            keyarr[i / 2] = (byte) ((Character.digit(keyWord.charAt(i), 16) << 4)
                    + Character.digit(keyWord.charAt(i + 1), 16));
        }
        int key = 0;
        for (int i = 0; i < file.length; i++) {
            file[i] = (byte) (file[i] ^ keyarr[key++]);
            if (key == keyarr.length) key = 0;
        }
    }

    private void finalise(String output, String input) throws IOException {
        if (output == null)
            Files.write(Paths.get(input + ".xor"), file);
        else
            Files.write(Paths.get(output), file);
    }
}
