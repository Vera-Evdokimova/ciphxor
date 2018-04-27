package org.spstu.evdokimova;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CipherXOR {
    private static byte[] file;

    public static void encrypt(String text, String keyWord) throws IOException {
        file = Files.readAllBytes(Paths.get(text));
        byte[] keyarr = keyWord.getBytes();
        for (int i = 0; i < file.length; i++) {
            file[i] = (byte) (file[i] ^ keyarr[i % keyarr.length]);
        }
    }

    public static void finalise(String output) throws IOException {
        if (output == null)
            System.out.println(new String(file));
        else
            Files.write(Paths.get(output), file);
    }
}
