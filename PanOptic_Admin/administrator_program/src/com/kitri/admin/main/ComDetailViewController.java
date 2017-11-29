package com.kitri.admin.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComDetailViewController implements ActionListener {
    
    ComDetailView view;
    
    public ComDetailViewController(ComDetailView view) {
	this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();
	
	if(o == view.closeButton){
	    view.setVisible(false);
	} else if(o == view.messengerButton) {
	    view.messenger.setVisible(true);
	}
	
    }

}
