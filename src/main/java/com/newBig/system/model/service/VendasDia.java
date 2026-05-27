package com.newBig.system.model.service;

public class VendasDia {
    private static int vendaDia = 0;

    public static void setVendaDia() {
        VendasDia.vendaDia += 1;
    }

    public static int getVendaDia() {
        return vendaDia;
    }
}
