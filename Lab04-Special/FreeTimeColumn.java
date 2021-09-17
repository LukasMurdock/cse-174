public class FreeTimeColumn {
    String name;
    String rowName;
    int length;
    char type;
    String alignment;
    String alignmentSymbol;
    String round;

    FreeTimeColumn(String name, String rowName, int length, char type,
                   String alignment) {
        this.name = name;
        this.rowName = rowName;
        this.length = length;
        this.type = type;
        this.alignment = alignment;
        calculateAlignment();
    }

    /**
     * <p>Calculates the printf alignment symbol given label.</p>
     * <p>Checks if given alignment equals "left" and sets printf column
     * alignment to "-", or "+".</p>
     */
    public void calculateAlignment() {
        this.alignmentSymbol = this.alignment == "left" ? "-" : "+";
    }

    /**
     * <p>Sets the column printf rounding.</p>
     *
     * @param round the printf decimal place number
     */
    public void setRound(String round) {
        this.round = round;
    }

    public String getRound() {
        return this.round;
    }

    public String getName() {
        return this.name;
    }

    public String getRowName() {
        return this.rowName;
    }

    public int getLength() {
        return this.length;
    }

    public char getType() {
        return this.type;
    }

    public String getAlignmentSymbol() {
        return this.alignmentSymbol;
    }
}