public class EmailService extends BaseMessageService{
    private String localEmailAddress;

    public EmailService(String serviceStatus, String serviceType, String localEmailAddress) {
        super(serviceStatus, serviceType);
        this.localEmailAddress = localEmailAddress;
    }

    public void setLocalEmailAddress(String localEmailAddress) {
        this.localEmailAddress = localEmailAddress;
    }

    public String getLocalEmailAddress() {
        return localEmailAddress;
    }

    @Override
    public void sendMessage(String message, String recipient) {
        logMessage(message);
        System.out.println(localEmailAddress + " is sending Email to " + recipient + " with message: " + message);
    }

    public String getServiceType(){
        return super.getServiceType() + " Email";
    }
}
