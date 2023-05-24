package omokThings;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.CountDownLatch;

public class MyMouseListener extends MouseAdapter {
    // MAYBE ADD ALL OF THIS INTO MAIN OMOK CLASS AND MAYBE ITLL WORK.
    private static CountDownLatch latch;

    public MyMouseListener() {
        latch = new CountDownLatch(1);
    }

    public static void waitForClick() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static MouseAdapter getMouseListener() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                latch.countDown();
            }
        };
    }
}
