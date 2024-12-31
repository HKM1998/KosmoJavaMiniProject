package consolegame.Ending;

import consolegame.console.ConsolePrint;

public class Ending001_GoodEnding extends Ending {

	public Ending001_GoodEnding(){
		this.setEndingId(5);
		this.setEndingName("소탕");}
	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder(); // 이벤트 010 Item001_Passport 엔딩 선결조건(Passport지만 스크립트 상 미스테리 지도)
		script.append("엔딩 " + getEndingId()+". " + getEndingName());
		script.append("빈차에서 알수없는 지도를 얻은 당신은");
		script.append("이게 무슨 지도일까 곰곰히 생각합니다.");
		script.append("산 등고선 어딘가 쯤에 표시된 x표..");
		script.append(".     \n");
		script.append(".     \n");
		script.append(".     \n");
		script.append("우선 그 곳을 가봅니다. 그러자 당신은 눈을 의심할 장면을 목격합니다.");
		script.append("또다른 거대한 아편 밭이 눈앞에 펼쳐져 있습니다.");
		script.append("그런데 때마침 뒤에서 사부락 소리가 들리기 시작합니다.");
		script.append("당신은 주변 풀숲에 급하게 숨습니다.");
		script.append("아뿔싸! 녀석들은 갱단들이었습니다.");
		script.append("녀석들은 당신이 불태웠던 곳 뿐만 아니라");
		script.append("산 어딘가에도 몰래 대규모 아편 재배를 하고 있었죠.");
		script.append("당신은 이 모든 것을 경찰에 얘기를 한 뒤 몰래 잠복하여");
		script.append("그들이 다시 한번 방문 했을 때 갱단 일당들을 일거에 검거 했습니다.");
		script.append(".     \n");
		script.append(".     \n");
		script.append(".     \n");
		script.append("그렇게 하여 비록 힘든 여정이긴 하였으나 다사다난한 일들을 뒤로 하고 ");
		script.append("당신은 무사히 집으로 돌아갈 수 있게 되었습니다.");

		ConsolePrint.printEndingScript(script);
	}

}
