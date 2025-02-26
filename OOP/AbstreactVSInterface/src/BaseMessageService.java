public abstract class BaseMessageService implements MessageService{
    private String ServiceStatus;
    private String ServiceType;

    public BaseMessageService(String serviceStatus, String serviceType) {
        this.ServiceStatus = serviceStatus;
        this.ServiceType = serviceType;
    }

    public String getServiceStatus() {
        return ServiceStatus;
    }

    public String getServiceType() {
        return ServiceType;
    }

    public void setServiceStatus(String serviceStatus) {
        ServiceStatus = serviceStatus;
    }

    public void setServiceType(String serviceType) {
        ServiceType = serviceType;
    }

    void logMessage(String message){
        System.out.println("Logging message: " + message);
    }

}
