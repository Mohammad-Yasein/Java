import java.io.Serializable;

public class IPhone extends Phone implements Serializable, Ringable {
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }

    @Override
    public void displayInfo() {
        System.out.printf("IPhone %s from %s\n", getVersionNumber(), getCarrier());
    }

    @Override
    public String ring() {
        return "IPhone " + getVersionNumber() + " says " + getRingTone();
    }

    @Override
    public String unlock() {
        return "Unlocking via facial recognition";
    }
}
