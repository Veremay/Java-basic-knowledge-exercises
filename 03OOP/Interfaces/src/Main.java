public class Main {
    public static void main(String[] args) {
        ControllableDevice light = new SmartLight();
        ControllableDevice thermostat = new SmartThermostat();

        light.turnOn();
        light.getStatus();
        thermostat.turnOn();
        ((SmartThermostat)thermostat).setTemperature(20.0);
        thermostat.getStatus();
    }
}
