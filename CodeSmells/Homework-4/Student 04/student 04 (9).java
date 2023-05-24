package HW4_GUI;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

class OmokAction extends AbstractAction {
    private Runnable runnable;
    	
    public OmokAction(String name, ImageIcon icon, String descr, int mnemonic, int accelerator, 
        Runnable runnable) {
        super(name, icon);
        this.runnable = runnable;
        putValue(SHORT_DESCRIPTION, descr);
        putValue(MNEMONIC_KEY, mnemonic);
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(accelerator, ActionEvent.ALT_MASK));
    }
	
    public void actionPerformed(ActionEvent e) {
        runnable.run();
    }
}

