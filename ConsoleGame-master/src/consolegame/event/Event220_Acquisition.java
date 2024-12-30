package consolegame.event;

import consolegame.Main;
import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;

public class Event220_Acquisition extends Event {
		public Event220_Acquisition() {
			setEventId(220);
			setName("획득");
			setScore(0);
			setWeight(0);
		}

		@Override
		public void printChoice() {
			Selection selection = new Selection();
			selection.addSelection("  수상한데 뭐 든것도 없는것 같고 그냥 제자리 두고 가자 ");
			selection.addSelection("  내가 헛것을 보는건 아니겠지?? 당장 지갑을 뒤적거린다.");
			this.setsCount(selection.count);
			selection.print();
		}
	
		@Override
		public void printScript() {
			StringBuilder script = new StringBuilder();
			script.append(getEventId() + ". " + getName() + "\n");
			script.append(" 무기력하게 길을 걷던 도중 무언가 발견했습니다. \n");
			script.append(" 가까이 다가가서 주워보니 지갑입니다.  ");
			ConsolePrint.printScript(script, getIsLoaded());
		}

		@Override
		public void getResult(String pChoice) {
			StringBuilder script = new StringBuilder();
			if (pChoice.equals("1")) {
			script.append("당신은 얻은게 없다.\n");
			script.append("씁슬하구만...");
			} else if (pChoice.equals("2"));
			script.append("세상에 이게 얼마야??? 아싸!!오늘은 고기 파티다!!!(자금 +500) ");
			Main.character.setMoney(Main.character.getMoney() + 500);
			ConsolePrint.printResult(script, getIsLoaded());

	}
}
