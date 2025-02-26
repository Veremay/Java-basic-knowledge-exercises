public class SmsService extends BaseMessageService{
    private String localSmsAddress;

    public SmsService(String serviceStatus, String serviceType, String localSmsAddress) {
        super(serviceStatus, serviceType);
        this.localSmsAddress = localSmsAddress;
    }

    public String getLocalSmsAddress() {
        return localSmsAddress;
    }

    public void setLocalSmsAddress(String localSmsAddress) {
        this.localSmsAddress = localSmsAddress;
    }


    @Override
    public void sendMessage(String message, String recipient) {
        logMessage(message);
        System.out.println(localSmsAddress + " is sending SMS to " + recipient + " with message: " + message);
    }

    public String getServiceType(){
        return super.getServiceType() + " SMS";
    }
}
