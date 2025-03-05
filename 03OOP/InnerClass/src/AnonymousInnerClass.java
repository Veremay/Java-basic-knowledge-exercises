public class AnonymousInnerClass {
    public static void main(String[] args) {

        CellPhone cellPhone = new CellPhone();
        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("爸爸起床");
            }
        });
        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("妈妈起床");
            }
        });
    }
}

class CellPhone{
    public void alarmClock(Bell bell){
        bell.ring();
    }
}


interface Bell {
    void ring();
}



