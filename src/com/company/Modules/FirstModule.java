package com.company.Modules;

import com.company.Module;

/**
 * Created by 1 on 22.09.2014.
 */
public class FirstModule implements Module {
    @Override
    public void load() {
        System.out.println("Module " + this.getClass() + " loading...");
    }

    @Override
    public int run() {
        System.out.println("Module " + this.getClass() + " running...");
        return Module.EXIT_SUCCESS;
    }

    @Override
    public void unload() {
        System.out.println("Module " + this.getClass() + " unloading...");
    }
}
