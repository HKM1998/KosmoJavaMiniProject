package consolegame.Ending;

import consolegame.console.ConsolePrint;

public class Ending006_NormalEnding_04 extends Ending{

	public Ending006_NormalEnding_04(){
		this.setEndingId(6);
		this.setEndingName("추방자");
	}
	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append("엔딩 " + getEndingId()+". " + getEndingName() + "\n");
		script.append("당신은 여러 사람과 상황들을 마주하며\n");
		script.append("적막한 이 세상을 살아가는데 회의감이 들기 시작했습니다.\n");
		script.append("평범하게 살아 가기에는 세상은 당신을 내버려 두지 않는군요...!\n");
		script.append("당신은 오히려 이제 마주치는 사람\n");
		script.append("아니 적들을 구분없이 처리하기로 다짐합니다.\n");
		script.append("비록 새로운 인연이 시작되지는 못하겟지만 모르는 사람에게\n");
		script.append("목숨을 위협 받는 일을 줄어들지도 모르겠군요.\n");
		script.append("새로운 인연이 시작되지는 않겠지만 말이죠.\n");
		script.append("그래도 죽지만 않으면 된 것 아니겠어요...?\n");
		ConsolePrint.printEndingScript(script);
		
	}
}
