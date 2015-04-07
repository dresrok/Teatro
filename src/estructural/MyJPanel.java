/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructural;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author Paleox
 */
public class MyJPanel extends JPanel{
    private Silla silla;
    

    public void setSilla(Silla silla){
        this.silla = silla;
    }
    
    public Silla getSilla(){
        return this.silla;
    }
}
