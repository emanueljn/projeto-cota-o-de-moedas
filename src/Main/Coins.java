package Main;

import java.util.Map;

public class Coins {
    private double usd;
    private double brl;
    private double ars;
    private double cop;
    private Map<String, Double> conversionRates;

    public Coins(double usd, double brl, double ars, double cop) {
        this.usd = usd;
        this.brl = brl;
        this.ars = ars;
        this.cop = cop;
    }

    public double getUsd() {
        return usd;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    public double getBrl() {
        return brl;
    }

    public void setBrl(double brl) {
        this.brl = brl;
    }

    public double getArs() {
        return ars;
    }

    public void setArs(double ars) {
        this.ars = ars;
    }

    public double getCop() {
        return cop;
    }

    public void setCop(double cop) {
        this.cop = cop;
    }

    @Override
    public String toString() {
        return "Main.Coins{" +
                "usd=" + usd +
                ", brl=" + brl +
                ", ars=" + ars +
                ", cop=" + cop +
                '}';
    }
}
