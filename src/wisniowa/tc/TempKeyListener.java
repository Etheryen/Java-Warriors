package wisniowa.tc;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TempKeyListener extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        System.out.println(e.getKeyChar());
        System.out.println(e.getKeyCode());
        System.out.println("dowolny klawisz zostal wcisniety");
    }
}
