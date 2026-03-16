package Bai6;

import java.lang.management.*;

class DeadlockDetector implements Runnable {

    @Override
    public void run() {

        ThreadMXBean bean = ManagementFactory.getThreadMXBean();

        while (true) {

            long[] ids = bean.findDeadlockedThreads();

            if (ids != null) {
                System.out.println("Phát hiện DEADLOCK!");

                ThreadInfo[] infos =
                        bean.getThreadInfo(ids);

                for (ThreadInfo info : infos) {
                    System.out.println(info.getThreadName());
                }
            } else {
                System.out.println("Không phát hiện deadlock.");
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}