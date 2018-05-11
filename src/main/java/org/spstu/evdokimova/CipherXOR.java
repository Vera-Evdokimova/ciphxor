package org.spstu.evdokimova;

import java.io.*;

public class CipherXOR {
    private static byte[] key;

    public CipherXOR(CommandLineOptions cmd) throws IOException {
        genKey(cmd.key);
        this.encrypt(cmd.inputFilename, cmd.outputFilename);
    }

    private void genKey(String keyWord) {
        key = new byte[keyWord.length() / 2];
        for (int i = 0; i < keyWord.length(); i += 2)
            key[i / 2] = (byte) ((Character.digit(keyWord.charAt(i), 16) << 4)
                    + Character.digit(keyWord.charAt(i + 1), 16));
    }

    private void encrypt(String text, String output) throws IOException {
        output = output == null ? text + ".xor" : output;
        byte[] time = new byte[key.length];
        BufferedInputStream bf = new BufferedInputStream(new FileInputStream(new File(text)));
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(output)))) {
            int t = bf.read(time);
            while (t != -1) {
                for (int i = 0; i < t; i++)
                    out.write((byte) (time[i] ^ key[i]));
                out.flush();
                t = bf.read(time);
            }
        }
    }

}
