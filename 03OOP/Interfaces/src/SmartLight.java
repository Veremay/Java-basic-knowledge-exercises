public class SmartLight implements ControllableDevice{

    private boolean isOn = false;

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Smart light is turned on!");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Smart light is turned off!");
    }

    @Override
    public void getStatus() {
        String status = isOn ? "ON": "OFF";
        System.out.println("Smart light status: " + status);
    }


}
