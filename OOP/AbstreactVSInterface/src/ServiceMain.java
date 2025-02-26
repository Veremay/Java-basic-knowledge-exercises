public class ServiceMain {
    public static void main(String[] args) {
        MessageService emailService = new EmailService("on", "premium", "148390@qq.com");
        MessageService smsService = new SmsService("on", "normal", "096-1236-1294");

        emailService.sendMessage("Hello", "myhuu@gmail.com");
        smsService.sendMessage("Hi", "096-7685-3464");

        MessageService[] messageServices = new MessageService[2];
        messageServices[0] =emailService;
        messageServices[1] = smsService;

        for (int i = 0; i < messageServices.length; i++) {
            messageServices[i].sendMessage("nice to meet u", "fhudos");

            ServiceMain serviceMain = new ServiceMain(); //static方法内不能调用非static方法，除非new一个新对象
            serviceMain.testPolyParam(messageServices[i]);

        }
    }

    public void testPolyParam(MessageService messageService){
        if (messageService instanceof EmailService){
            System.out.println("local address: " + ((EmailService)messageService).getLocalEmailAddress());
            System.out.println(((EmailService)messageService).getServiceType());
        } else if (messageService instanceof SmsService) {
            System.out.println("local address: " + ((SmsService)messageService).getLocalSmsAddress());
            System.out.println(((SmsService)messageService).getServiceType());
        } else {
            System.out.println("Service type error.");
        }
    }
}
