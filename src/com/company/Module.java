package com.company;

/**
 * Created by 1 on 22.09.2014.
 */
public interface Module {
    public static final int EXIT_SUCCESS = 0;
    public static final int EXIT_FAILURE = 1;
    public void load();
    public int run();
    public void unload();
}
