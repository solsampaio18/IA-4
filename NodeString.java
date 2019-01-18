class NodeString extends Node {
    private String value;

    public NodeString(String value, String attribute) {
        super(attribute);
        this.value = value;
    }
}