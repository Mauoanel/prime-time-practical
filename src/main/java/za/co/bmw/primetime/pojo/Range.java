package za.co.bmw.primetime.pojo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Range {

    private int lowerNumber;
    private int upperNumber;
    private boolean sieveOfEratosthenes;

    public int getLowerNumber() {
        return lowerNumber;
    }

    public void setLowerNumber(int lowerNumber) {
        this.lowerNumber = lowerNumber;
    }

    public int getUpperNumber() {
        return upperNumber;
    }

    public void setUpperNumber(int upperNumber) {
        this.upperNumber = upperNumber;
    }

    public boolean getSieveOfEratosthenes() {
        return sieveOfEratosthenes;
    }

    public void setSieveOfEratosthenes(boolean sieveOfEratosthenes) {
        this.sieveOfEratosthenes = sieveOfEratosthenes;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
}
