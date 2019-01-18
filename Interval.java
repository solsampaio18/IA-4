
class Interval{
    private double value1;
    private double value2;
    private boolean isLast;//o último intervalo é [a,b] e não [a,b[ como os outros, daí a necessidade de apontar isso

    public Interval(double value1, double value2, boolean isLast) {
        this.value1 = value1;
        this.value2 = value2;
        this.isLast = isLast;
    }

    public Interval(double value1){ //construtor do primeiro intervalo
        this.value1 = value1;
        this.isLast = false;
    }

    public boolean isInside(double value){ //para ver se está dentro do intervalo
        return value >= value1 && value < value2 ||
                value == value2 && isLast;
    }

    public void setValue2(double value2) {
        this.value2 = value2;
    }

    public void setValue2(double value2, boolean isLast) {
        this.value2 = value2;
        this.isLast = isLast;
    }

    public double getValue1() {
        return value1;
    }

    public double getValue2() {
        return value2;
    }

    public boolean isLast() {
        return isLast;
    }

    @Override
    public String toString() {
        if(isLast) return "[" + value1 + "," + value2 + "]";
        else return "[" + value1 + "," + value2 + "[";
    }
}