package consolegame.Ending;

import consolegame.console.ConsolePrint;

public class Ending005_Philosophy extends Ending{

	public Ending005_Philosophy(){
		this.setEndingId(5);
		this.setEndingName("철학가");
	}
	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append("엔딩 " + getEndingId()+". " + getEndingName());
		script.append("당신은 정체불명의 도인을 만나면서\n");
		script.append("세상의 본질과 인간의 내면성 그리고\n");
		script.append("그에 대한 해답에 대해 긴 시간 고민을 가지고\n");
		script.append("해답을 찾기 위한 여정을 시작하였습니다.\n");
		script.append("지금과 같은 시대에 당신과 같은 생각을 가진 사람이 늘어난다면\n");
		script.append("살기 좋은 세상이 될 수도 있겠군요....!\n");
		script.append(".     \n");
		script.append(".     \n");
		script.append(".     \n");
		script.append("하지만 그것은 먼 훗날의 이야기로 당신이 남긴 책은 후대에나\n");
		script.append("세상에 영향을 끼칠 것 같습니다.\n");
		
		ConsolePrint.printEndingScript(script);
		
	}

}
