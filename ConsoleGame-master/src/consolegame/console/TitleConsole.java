package consolegame.console;

import java.util.Scanner;

public class TitleConsole {
	// 타이틀 화면
	public static void start(Scanner scan) {
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
				+ "`---'              `---`        `--`-,-'       `--`-,-'\r\n" + "");
		title: while (true) {
			ConsolePrint.clear();
			ConsolePrint.printTitle(sb);
			// 입력 키에 따라 시작 종료
			System.out.println("[S] : 게임시작\t [E] : 게임종료\n");
//		if (!Main.hasSaveFile) {
//		}
			select: while (true) {
				switch (scan.next().toUpperCase()) {
				case "S":
					break title;
				case "E":
					ConsolePrint.finishGame(scan);
					break select;
				}
			}
		}
		return;
	}
}
