package com.solid.liskov;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class FileManager {

    private RandomAccessFile randomAccessFile;

    public FileManager(String rootPath, String fileName) throws FileNotFoundException {
        randomAccessFile = new RandomAccessFile(rootPath+fileName, "rw");
    }

    public void close() throws IOException
    {
        randomAccessFile.close();
    }

    public void writeString(String field, int maxLen)
            throws IOException
    {
        StringBuffer sb = new StringBuffer(field);
        if (sb.length() >= maxLen) {
            sb.setLength(maxLen);
        }
        else {

            for (int i = sb.length(); i < maxLen; i++) {
                sb.append(" ");
            }
        }
        randomAccessFile.writeChars(sb.toString());
    }

    public void writeInt(int field) throws IOException
    {
        randomAccessFile.writeInt(field);
    }

    public void writeFloat(float field) throws IOException
    {
        randomAccessFile.writeFloat(field);
    }


}
