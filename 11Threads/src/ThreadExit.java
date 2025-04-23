public class ThreadExit {
    public static void main(String[] args) throws InterruptedException {
        //手动退出线程，本质上是结束run方法
        T t = new T();
        t.start();
        //主线程沉睡6秒，然后终止子线程
        Thread.sleep(6*1000);
        t.setLoop(false);
    }

    static class T extends Thread{
        private int count=0;
        private boolean loop=true;

        public void setLoop(boolean loop) {
            this.loop = loop;
        }

        @Override
        public void run() {
            super.run();
            while(loop){
                System.out.println("线程"+(++count)+"运行");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}


