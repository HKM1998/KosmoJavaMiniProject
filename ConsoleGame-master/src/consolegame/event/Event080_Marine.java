package consolegame.event;

import consolegame.Main;
import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;

public class Event080_Marine extends Event {
	public Event080_Marine() {
		setEventId(80);
		setName("해병대");
		setScore(0);
		setWeight(0);
	}

	// 이벤트 스크립트 바로 화면에 출력
	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("멀리서 각진 걸음으로 걸어오던 해병 전투복의 무리가 점점 다가옵니다.\n");
		script.append("당신은 도망치려 하였으나 그들이 들고 있는 총을 보고는 도망치기를 포기합니다.\n\n");
		script.append("\"한번 해병은 영원한 해병! 우리 해병은 불순한 일당이\n");
		script.append("질서를 어지럽히는걸 용서치 않는다! 넌 누구냐!!\"\n");
		ConsolePrint.printScript(script, getIsLoaded());
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice() {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("\"충성! 해병 1511기 입니다!\"(거짓말)");
		
		selection.addSelection("\"아 저는 그냥 지나가는 시민입니다.\"");
		this.setsCount(selection.count);
		selection.print();
	}
	
	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		if (pChoice.equals("1")) { 
			script.append("\"흠...해병 출신인가? 우선 전우회 건물로 이동해서 이야기를 듣기로하지\"\n");
			script.append("그들은 당신을 의심하는 눈초리를 거두지 않았습니다.\n");
			script.append("거짓말에 식은땀을 흘리며 해병 전우회로 끌려갑니다.\n");
			Main.eMap.setEvent(this.getEventId()); // 연결 이벤트 설정
		}else if (pChoice.equals("2")) {
			script.append("\"그 말을 우리더러 믿으라는거야? 딱봐도 거동이 수상한 불순분자로 보이는구만!\"\n");
			script.append("당신은 자연스러운 연기를 펼쳤으나 그들에게서 벗어나는 것에 실패했습니다.\n");
			script.append("다급하게 그들 사이로 뚫고 빠져나가려고 합니다.\n");
			script.append("...................\n");
			script.append("다행히 당신은 상처없이 그들에게 도망치는 것에 성공합니다.\n");
		}
		ConsolePrint.printResult(script, getIsLoaded());
	}
}
