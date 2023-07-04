
package myfinance.gu.handler;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import myfinance.exception.ModelException;
import myfinance.gu.MainFrame;
import myfinance.gu.dialog.AddEditDialog;
import myfinance.gu.dialog.ErrorDialog;
import myfinance.saveload.SaveData;
import myfinance.settings.HandlerCode;

/**
 *
 * @author Stepan Babaev
 */
public class AddEditDialogHandler extends Handler implements WindowListener, KeyListener{
    
    private final AddEditDialog dialog;

    public AddEditDialogHandler(MainFrame frame, AddEditDialog dialog) {
        super(frame);
        this.dialog = dialog;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case HandlerCode.ADD -> addEdit(true);
            case HandlerCode.EDIT -> addEdit(false);
            case HandlerCode.CANCEL -> closeDialog();
        }
        super.actionPerformed(ae);
    }
    
    private void addEdit(boolean add) {
        try {
            if (add) SaveData.getInstance().add(dialog.getCommonFromForm());
            else SaveData.getInstance().edit(dialog.getCommon(), dialog.getCommonFromForm());
            closeDialog();
        }
        catch (ModelException ex) {
            ErrorDialog.show(frame, ex.getMessage());
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {}

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
            addEdit(dialog.isAdd());
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {}

    @Override
    public void windowOpened(WindowEvent we) {}

    @Override
    public void windowClosing(WindowEvent we) {
        closeDialog();
    }

    @Override
    public void windowClosed(WindowEvent we) { }

    @Override
    public void windowIconified(WindowEvent we) {}

    @Override
    public void windowDeiconified(WindowEvent we) {}

    @Override
    public void windowActivated(WindowEvent we) {}

    @Override
    public void windowDeactivated(WindowEvent we) {}

    private void closeDialog() {
        dialog.closeDialog();
    }
    
}
