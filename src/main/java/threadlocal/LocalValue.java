package threadlocal;

/**
 * Created with IntelliJ IDEA.
 * Project: test-jar
 * Author: Kevin
 * Date: 16/8/26
 * Time: 上午11:29
 */
public class LocalValue{

    private static final ThreadLocal<Long> TIME_THREADLOCAL  = new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public Long getValue() {
        return TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws Exception{

        for(int i = 0; i< 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    LocalValue localValue = new LocalValue();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(localValue.getValue());
                }
            });
            thread.start();
            thread.join();
        }
    }

}
