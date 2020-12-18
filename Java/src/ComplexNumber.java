public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj instanceof ComplexNumber){
            ComplexNumber cn = (ComplexNumber) obj;
            if(Double.compare(this.getRe(),cn.getRe())==0 && Double.compare(this.getIm(),cn.getIm())==0){
                return true;
            }
        }

        return false;
    }

    public int hashCode() {
        return Double.hashCode(this.getIm())+Double.hashCode(this.getRe());
    }

}