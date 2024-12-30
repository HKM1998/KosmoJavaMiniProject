package consolegame.thread;

import consolegame.console.ConsolePrint;

// 타이틀 화면 출력용 쓰레드
public class TitleThread implements Runnable{
	
	@Override
	public void run() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("                                     ,----,.        ,----,.\r\n"
				+ "                                   ,'   ,' |      ,'   ,' |\r\n"
				+ "      ,----,       ,----..       ,'   .'   |    ,'   .'   |\r\n"
				+ "    .'   .' \\     /   /   \\    ,----.'    .'  ,----.'    .'\r\n"
				+ "  ,----,'    |   /   .     :   |    |   .'    |    |   .'\r\n"
				+ "  |    :  .  ;  .   /   ;.  \\  :    :  |--,   :    :  |--,\r\n"
				+ "  ;    |.'  /  .   ;   /  ` ;  :    |  ;.' \\  :    |  ;.' \\\r\n"
				+ "  `----'/  ;   ;   |  ; \\ ; |  |    |      |  |    |      |\r\n"
				+ "    /  ;  /    |   :  | ; | '  `----'.'\\   ;  `----'.'\\   ;\r\n"
				+ "   ;  /  /-,   .   |  ' ' ' :    __  \\  .  |    __  \\  .  |\r\n"
				+ "  /  /  /.`|   '   ;  \\; /  |  /   /\\/  /  :  /   /\\/  /  :\r\n"
				+ "./__;      :    \\   \\  ',  /  / ,,/  ',-   . / ,,/  ',-   .\r\n"
				+ "|   :    .'      ;   :    /   \\ ''\\       ;  \\ ''\\       ;\r\n"
				+ ";   | .'          \\   \\ .'     \\   \\    .'    \\   \\    .'\r\n"
				+ "`---'              `---`        `--`-,-'       `--`-,-'\r\n"
				+ "");
		
		ConsolePrint.printTitle(sb);
		return;
	}
	
}
