package com.kitri.admin.main.controlPanel;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class WindowAdapterExt extends WindowAdapter {
	JFrame frame;
	
	public WindowAdapterExt(JFrame frame) {
		this.frame = frame;
	}
    public void windowClosing(WindowEvent e) {
    	frame.setVisible(false);
    }
}
