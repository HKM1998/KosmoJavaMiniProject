package consolegame.ending;

import consolegame.console.ConsolePrint;

public class Ending001_Annihilate extends Ending {

	public Ending001_Annihilate(){
		this.setEndingId(1);
		this.setEndingName("소탕");}
	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();                   // 이벤트 010 UncheckedMap 엔딩 선결조건 + 
		script.append("엔딩 " + getEndingId()+". " + getEndingName() + "\n"); //이벤트 031에서 1번 선택하면 탄약을 선물 받으면서 아저씨로부터 필요할 때 부르면 가겠다는 약속도 듣는 선택지가 생긴다
		script.append("빈차에서 알수없는 지도를 얻은 당신은\n");
		script.append("이게 무슨 지도일까 곰곰히 생각합니다.\n");
		script.append("산 등고선 어딘가 쯤에 표시된 x표..\n");
		script.append(".     \n");
		script.append(".     \n");
		script.append(".     \n");
		script.append("우선 그 곳을 가봅니다. 그러자 당신은 눈을 의심할 장면을 목격합니다.\n");
		script.append("또다른 거대한 아편 밭이 눈앞에 펼쳐져 있습니다.\n");
		script.append("그런데 때마침 뒤에서 사부락 소리가 들리기 시작합니다.\n");
		script.append("당신은 주변 풀숲에 급하게 숨습니다.\n");
		script.append("아뿔싸! 녀석들은 갱단들이었습니다.\n");
		script.append("녀석들은 당신이 불태웠던 곳 뿐만 아니라\n");
		script.append("산 어딘가에도 몰래 대규모 아편 재배를 하고 있었죠.\n");
		script.append("당신은 이 모든 것을 경찰에 얘기를 한 뒤 몰래 잠복하여\n");
		script.append("그들이 다시 한번 방문 했을 때 갱단 일당들을 일거에 검거 했습니다.\n");
		script.append(".     \n");
		script.append(".     \n");
		script.append(".     \n");
		script.append("그렇게 하여 비록 힘든 여정이긴 하였으나 다사다난한 일들을 뒤로 하고\n");
		script.append("당신은 무사히 집으로 돌아갈 수 있게 되었습니다.\n");

		ConsolePrint.printEndingScript(script);
	}

}
