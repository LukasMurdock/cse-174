public class FreeTimeRow {
    String fullName;
    double hoursOfSleep;
    int numberOfClasses;
    double freeTime;

    FreeTimeRow(String fullName, double hoursOfSleep,
                int numberOfClasses) {
        this.fullName = fullName;
        this.hoursOfSleep = hoursOfSleep;
        this.numberOfClasses = numberOfClasses;
        calculateFreeTime();
    }

    public void calculateFreeTime() {
        this.freeTime =
            120 - (
                this.hoursOfSleep
                    * 5
                    + this.numberOfClasses
                    * 8.72
            );
    }
}