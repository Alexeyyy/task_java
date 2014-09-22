package com.company;

import java.io.*;

/**
 * Created by 1 on 22.09.2014.
 */
public class ModuleLoader extends ClassLoader {
    private String pathToBin;

    public ModuleLoader(String pathToBin, ClassLoader parent) {
        super(parent);
        this.pathToBin = pathToBin;
    }

    @Override
    public Class<?> findClass(String className) throws ClassNotFoundException {
        try {
            //Получим байт-код  из файла и загружаем класс в run
            byte b[] = fetchClassFromFS(pathToBin + className + ".class");
            return defineClass(className, b,0, b.length);
        } catch(FileNotFoundException e) {
            return super.findClass(className);
        } catch (IOException e) {
            return super.findClass(className);
        }
    }

    private byte[] fetchClassFromFS(String path) throws FileNotFoundException, IOException {
        InputStream is = new FileInputStream(new File(path));

        long length = new File(path).length();

        if(length > Integer.MAX_VALUE) {
            System.out.println("File is too large...");
            return null;
        }

        byte[] bytes = new byte[(int)length];

        //читаем байты
        int offset = 0;
        int numRead = 0;

        while(offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }

        //уверяемся, что все было считано
        if(offset < bytes.length) {
            throw new IOException("Could not completely read file...");
        }

        is.close();
        return bytes;
    }
}
