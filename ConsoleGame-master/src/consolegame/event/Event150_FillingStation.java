package consolegame.event;

import consolegame.Main;
import consolegame.console.ConsolePrint;
import consolegame.item.Item000_Knife;
import consolegame.item.Item005_PainKiller;
import consolegame.item.Item012_Thash;

public class Event150_FillingStation extends Event {
	public Event150_FillingStation() {
		setEventId(150);
		setName("주유소");
		setScore(0);
		setWeight(0);
	}

	@Override
	public void printChoice() {
		Selection selection = new Selection();

		selection.addSelection("큰 상자 (소지금 -200)");
		selection.addSelection("작은 상자(소지금 -100)");
		selection.addSelection("돈을 지불하지않고 두개다 빼앗고 남자도 죽인다.");
		
		this.setsCount(selection.count);
		selection.print();
	}

	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("저 멀리 무인주유소가 보이는듯 하다. \n");
		script.append("당신이 주유소에 가까워질수록 주유소 입구에서 무언가 수상한 상자를\n");
		script.append("들고있는 30대 중반의 남성이 보인다.\n");
		script.append("남성의 근처로 가보니 큰 상자는 200원 작은상자는 100원에 판매한다고 적힌 팻말을 들고서있다.\n");
		script.append("상자안의 내용물이 뭔지는 모르겠다 하지만 궁금하다. 사볼까.?\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void getResult(String pChoice) {
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		if (pChoice.equals("1")) { // 1번은 금액 200원을 쓰고 칼 획득
			if (Main.character.getMoney() > 200) {
				Main.character.setMoney(Main.character.getMoney() - 200);
				Main.character.getItem().add(new Item000_Knife());
				script.append("소지금 200을 사용하여 큰 상자를 구매하였습니다.(+ 칼)\n");
			} else {
				script.append("당신은 소지금이 부족하여 큰 상자를 구매할 수 없었습니다.\n");
			}

		} else if (pChoice.equals("2")) { // 2번은 금액 200원을 쓰고 진통제 획득
			if (Main.character.getMoney() > 100) {
				Main.character.setMoney(Main.character.getMoney() - 100);
				Main.character.getItem().add(new Item005_PainKiller()); // 아이템 005 진통제 임포트
				script.append("소지금 100을 사용하여 작은상자를 구매하였습니다.(+ 진통제)\n");
			} else {
				script.append("당신은 소지금이 부족하여 작은상자를 구매할 수 없었습니다.");
			}
			if(pChoice.equals("3")) {
				script.append("당신은 남자의 상자와 목숨을 빼았았다.(+칼, +진통제, +쓰레기짓)");
				Main.character.addItem(new Item000_Knife());
				Main.character.addItem(new Item005_PainKiller());
				Main.character.addItem(new Item012_Thash());				
			}
			
		}
		ConsolePrint.printResult(script, getIsLoaded()); // 결과 출력부
	}
}
