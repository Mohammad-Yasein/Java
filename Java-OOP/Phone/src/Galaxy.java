import java.io.Serializable;

public class Galaxy extends Phone implements Serializable, Ringable {
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }

    @Override
    public void displayInfo() {
        System.out.printf("Galaxy %s from %s\n", getVersionNumber(), getCarrier());
    }

    @Override
    public String ring() {
        return "Galaxy " + getVersionNumber() + " says " + getRingTone();
    }

    @Override
    public String unlock() {
        return "Unlocking via fingerprint";
    }
}
