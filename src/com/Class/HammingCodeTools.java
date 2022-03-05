package com.Class;

import com.Class.tools.*;

import java.util.Scanner;

public class HammingCodeTools {
    public static void runCodes() {
    }

    public static void info2HammingCode(String value, int paridad) {
        Info2HammingCode fin = new Info2HammingCode(value, paridad);
        fin.findK();
        fin.createHammingCode();
    }

    public static void hammingCode2Info() {
        HammingCode2Info fin = new HammingCode2Info();
        fin.setParityMode();
        fin.findK();
        fin.convertHammingCode2Info();
        fin.outputOriInfo();
    }
}