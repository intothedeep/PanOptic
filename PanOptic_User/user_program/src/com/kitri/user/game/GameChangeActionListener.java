package com.kitri.user.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameChangeActionListener implements ActionListener{
	UserProgramView game;
	public GameChangeActionListener(UserProgramView game) {
		this.game = game;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == game.enternetBtn){
			game.clGameContentsPane.show(game.gameContentsPane, "1");
		}
		if(o == game.issueGameBtn){
			game.clGameContentsPane.show(game.gameContentsPane, "2");
		}
		if(o == game.onlineGameBtn){
			game.clGameContentsPane.show(game.gameContentsPane, "3");
		}
		if(o == game.actionGameBtn){
			game.clGameContentsPane.show(game.gameContentsPane, "4");
		}
		if(o == game.cdGameBtn){
			game.clGameContentsPane.show(game.gameContentsPane, "5");
		}
		if(o == game.sportsGameBtn){
			game.clGameContentsPane.show(game.gameContentsPane, "6");
		}
		if(o == game.ectBtn){
			game.clGameContentsPane.show(game.gameContentsPane, "7");
		}
		
	}

}
