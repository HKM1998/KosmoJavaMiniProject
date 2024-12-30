package consolegame.event;

import consolegame.Main;
import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;

public class Event091_MerchantFamily_1 extends Event {
	public Event091_MerchantFamily_1() {
		setEventId(91);
		setName("대덕상회");
		setScore(0);
		setWeight(0);
	}

	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("사내는 주방으로 보이는 곳으로 나를 안내하였고, \n");
		script.append("이내 건물안에는 맛있는 음식 냄새가 가득찹니다.\n");
		script.append(".......달그락\n");
		script.append("사내가 미소를 지으며 스프를 내 앞에 내려놓습니다.\n");
		script.append("\"어서 식기 전에 드세요. 제 특제 스픕니다!\"\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void printChoice() {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection("배고픔에 굶주려 허겁지겁 먹는다");
		
		selection.addSelection("한번 스프의 냄새부터 음미한다");
		this.setsCount(selection.count);
		selection.print();
	}

	@Override
	public void getResult(String pChoice) { 
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		if (pChoice.equals("1")) { 
			script.append("허겁지겁 스프를 먹다보니 갑자기 졸음이 몰려오는 느낌이 듭니다.\n");
			script.append("뭔가 잘못됨을 직감하고 나가려 하자 몸이 마음대로 움직이지 않습니다.\n");
			script.append("\"들어올땐 마음대로지만 나갈땐 아니란다?\"\n");
			script.append("사내의 웃음기 가득한 목소리를 마지막으로 당신은 잠에 빠지고 맙니다.\n");
			Main.character.setHealth(-1);
		}else if (pChoice.equals("2")) { 
			script.append("스프를 먹으려던 찰나 배고픔을 이겨내고 불현듯 이 상황에 이상함을 느낍니다.\n");
			script.append("그러던 중 냄새에서 거슬리는 향이 느껴집니다...!\n");
			script.append("\"따뜻한 환대는 감사합니다만 죄송하게도 급히 가야할 일이 생겼습니다.\"\n");
			script.append("라며 급하게 자리를 뜨려 하자 부부는 \"들어올땐 마음대로지만 나갈땐 아니란다?\"\n");
			if(Item.hasItem(Main.character, 8)) {
				script.append("라며 당신을 잡으려 합니다.\n");
				script.append("당신은 다급하게 총을 꺼내 위협하며 무사히 도망칠수 있었습니다.\n");
			}else if(Item.hasItem(Main.character, 0)) {
				script.append("라며 당신을 잡으려 합니다.\n");
				script.append("당신은 다급하게 칼을 꺼내 위협하며 무사히 도망칠수 있었습니다.\n");
				script.append("아뿔싸! 급하게 도망치던 중 칼을 떨어뜨리고 맙니다.\n");
				script.append("(- 칼)\n");
				Main.character.removeItem(0);
			}else {
				script.append("라며 당신을 잡으려 합니다. 당신은 다급하게 도망치려 하였지만\n");
				script.append("이내 사내가 휘두른 몽둥이에 상처를 입고 맙니다.\n");
				script.append("(체력 -1)\n");
				Main.character.setHealth(Main.character.getHealth() - 1); 
			}
		}
		ConsolePrint.printResult(script, getIsLoaded());
	}
}
