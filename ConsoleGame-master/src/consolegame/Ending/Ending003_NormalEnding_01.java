package consolegame.Ending;

import consolegame.console.Console;
import consolegame.console.ConsolePrint;

public class Ending003_NormalEnding_01 extends Ending{
	
	public Ending003_NormalEnding_01() {
		this.setEndingId(5);   
		this.setEndingName("운수 좋은 날");}
	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append("당신은 멍하니 길을 걷다가 맨홀에 빠졌다.\n");
		script.append("우당 탕 탕 쾅! 쿵!!!!!.\n");
		script.append("어딘가 부러졌는지 몸이 움직이지 않는다..\n");
		script.append("너무 어지럽다.. 아프다.\n");
		script.append("지독한 통증과 더불어 이만 쉬고싶단 생각을 함과 동시에 몸에 힘이 빠진다.\n");
		script.append("힘들다...\n");
		script.append("집에 가고싶다...\n");
		script.append("괴롭다.. 피곤하고..배도 고프고 하반신에 감각이 없다..\n");
		script.append("당신은 이러한 상념을 끝으로 눈 앞이 깜깜해진다.\n");
		script.append("\n\n\n\n  ###  #######  ###   \r\n"
				+ "                            \r\n"
				+ "                            \r\n"
				+ "      #    #      # # #     \r\n"
				+ "      #    #      #         \r\n"
				+ "    # #    #      # # #     \r\n"
				+ "  #   #    #      #         \r\n"
				+ "   ###    ###    ###### ### \n\n\n\n");
		ConsolePrint.printScript(script);
	}
	
}
