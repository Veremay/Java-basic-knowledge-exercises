public class SmartThermostat implements ControllableDevice{

    private boolean isOn = false;

    private double temperature = 25.0;


    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Smart thermostat is turned on!");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Smart thermostat is turned off!");
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        System.out.println("Temperature set to: " + temperature + "°C");
    }


    @Override
    public void getStatus() {
        String status = isOn ? "ON": "OFF";
        System.out.println("Smart thermostat status: " + status + ", temperature: " + temperature + "°C");
    }
}
