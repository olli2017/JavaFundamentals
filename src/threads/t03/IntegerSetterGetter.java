package threads.t03;

import java.util.Random;

public class IntegerSetterGetter extends Thread {

    private SharedResource resource;
    private boolean run;
    private Random rand = new Random();

    IntegerSetterGetter(String name, SharedResource resource) {
        super(name);
        this.resource = resource;
        run = true;
    }

    void stopThread() {
        run = false;
    }

    public void run() {
        int action;
        try {
            while (run) {
                action = rand.nextInt(1000);
                if (action % 2 == 0)
                    getIntegersFromResource();
                else
                    setIntegersIntoResource();
            }
            System.out.printf("Поток %s завершил работу.%n", getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getIntegersFromResource() throws InterruptedException {
        Integer number;

        synchronized (resource) {
            System.out.printf("Поток %s хочет извлечь число.%n", getName());
            number = resource.getElement();

            int count = UserResourceThread.getCounter();
            UserResourceThread.setCounter(count + 1);

            while (number == null) {
                System.out.printf("Поток %s ждет пока очередь заполнится.%n", getName());

                if (UserResourceThread.getCounter() != 5)
                    resource.wait();
                else
                    this.setIntegersIntoResource();

                System.out.printf("Поток %s возобновил работу.%n", getName());
                number = resource.getElement();
            }
            count = UserResourceThread.getCounter();
            UserResourceThread.setCounter(count - 1);
            System.out.printf("Поток %s извлек число %d%n",getName(), number);
        }
    }


    private void setIntegersIntoResource() {
        Integer number = rand.nextInt(500);
        synchronized (resource) {
            resource.setElement(number);
            System.out.printf("Поток %s записал число %d%n", getName(), number);
            resource.notify();
        }
    }
}
