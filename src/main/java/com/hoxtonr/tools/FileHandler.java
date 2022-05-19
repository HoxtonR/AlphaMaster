package com.hoxtonr.tools;

import java.io.*;

public class FileHandler {
    public static String readFile(String filePath) {
        StringBuffer stringBuffer = new StringBuffer();
        byte[] buffer = new byte[2048];
        int count = 0;
        try {
            File file = new File(filePath);
            InputStream inputStream = new FileInputStream(file);
            while (-1 != (count = inputStream.read(buffer))) {
                stringBuffer.append(new String(buffer, 0, count));
            }
            inputStream.close();
            return stringBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeFile(String content, String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
