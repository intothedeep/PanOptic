package com.kitri.user.game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public class GameViewMouseListener extends MouseAdapter {
	UserProgramView uView;
	

	public GameViewMouseListener(UserProgramView uView) {
		this.uView = uView;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		
		Object o = e.getSource();
		
		int size = uView.hotGamePane.gameLabel.length;
		JLabel temp;
		for (int i = 0; i < size; i++) {
			temp = uView.hotGamePane.gameLabel[i];
			if(o == temp){
				System.out.println("hot game : " + i);
			}
			
			temp  = uView.actionGamePane.gameLabel[i];
			if(o == temp){
				System.out.println("action game : " + i);
			}
			temp = uView.cdGamePane.gameLabel[i];
			if(o == temp){
				System.out.println("cd game : " + i);
			}
			temp = uView.sportsGamePane.gameLabel[i];
			if(o == temp){
				System.out.println("sports game : " + i);
			}
			temp = uView.gameEnternetPane.gameLabel[i];
			if(o == temp){
				System.out.println("Internet : " + i);
			}
			temp = uView.onlineGamePane.gameLabel[i];
			if(o == temp){
				System.out.println("online game : " + i);
			}
			temp = uView.ectGamePane.gameLabel[i];
			if(o == temp){
				System.out.println("ect: " + i);
			}
		}
	}

}
