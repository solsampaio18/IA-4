class NodeDouble extends Node{
    private Interval interval;

    public NodeDouble(Interval interval, String attribute) {
        super(attribute);
        this.interval = interval;
    }

    public Interval getInterval() {
        return interval;
    }
}