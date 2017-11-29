package com.kitri.admin.main.controlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import com.kitri.admin.server.PacketInformation;
import com.kitri.admin.server.Server;

public class ControlAgeRestrictionController implements ActionListener {

    ControlAgeRestriction ageRestriction;

    public ControlAgeRestrictionController(ControlAgeRestriction ageRestriction) {
	this.ageRestriction = ageRestriction;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();

	if (o == ageRestriction.restrictionButton) {
	    restrictionMessage();
	}
    }

    public void restrictionMessage() {
	Calendar cal = Calendar.getInstance();
	int currentYear = cal.get(Calendar.YEAR);
	
	currentYear -= 19;
	
	Server.serverThread.broadCast(PacketInformation.Operation.RESTRICTION, PacketInformation.PacketType.YEAR_OF_AGE,
		currentYear + "");
    }

}
