package com.kitri.admin.main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.channels.ShutdownChannelGroupException;

import com.kitri.admin.server.Main;

public class PcMainController extends MouseAdapter {
    PcMain pcMain;
    PcMainLogic logic;
    
    public PcMainController(PcMain pcMain) {
	this.pcMain = pcMain;    
	logic = new PcMainLogic(pcMain);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        Object o = e.getSource();
        
        logic.showComDetail(o);
        
        
    }
}
