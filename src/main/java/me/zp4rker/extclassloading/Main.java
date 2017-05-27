package me.zp4rker.extclassloading;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author ZP4RKER
 */
public class Main {

    public static void main(String[] args) {
        try {
            URL url = new URL("file://" + getDirectory().getPath() + "/ZLevels.jar");
            URL[] urls = { url };
            URLClassLoader cl = new URLClassLoader(urls);
            Class c = cl.loadClass("me.zp4rker.zlevels.ZLevels");
            Field version = c.getField("VERSION");
            System.out.println(version.get(c));
            Method m = c.getDeclaredMethod("getDirectory");
            Object result = m.invoke(c);
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static File getDirectory() {
        return new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile();
    }

}
