package consolegame.event;

import java.util.Random;

import consolegame.Main;
import consolegame.console.ConsolePrint;

public class Event090_MerchantFamily extends Event {
	public Event090_MerchantFamily() {
		setEventId(90);
		setName("상인가족");
		setScore(0);
	}

	@Override
	public void printScript() {
		if(getIsLoaded()) {
			ConsolePrint.printResult(script, getIsLoaded());
			return;
		}
		script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("황폐한 건물만 끝없이 이어지던 거리에서\n");
		script.append("당신은 대덕상회라는 간판을 단 집을 발견였습니다.\"");
		script.append("피로한 몸과 배고픔에 지쳐 가게 문을 두드립니다.\n");
		script.append("문이 열리자 안에는 부부와 아들딸이 하나씩 있는 가족이 살고있습니다.\n");
		script.append("그들은 내 몰골을 보고 놀라더니, 이내 행색을 안쓰러워 하며 나를 들여보냅니다.\n");
		script.append("\"어서 들어오세요. 잠시 쉬었다 가셔도 됩니다\"\n");

		ConsolePrint.printScript(script, getIsLoaded());
	}

	@Override
	public void printChoice() {
		if(getIsLoaded()) {
			selection.print();
			return;
		}
		selection.addSelection("\"정말 감사합니다. 혹시 실례가 안된다면\n밥 한끼 정도만 얻어 먹을 수 있을까요?\"");
		selection.addSelection("\"정말 감사합니다. 혹시 실례가 안된다면\n하루만 쉬어갈 수 있을까요?\"");
		this.setsCount(selection.count);
		selection.print();
	}

	@Override
	public void printResult(String pChoice) {
		if(getIsLoaded()) {
			ConsolePrint.printResult(script, getIsLoaded());
			return;
		}		
		script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");		
		if (pChoice.equals("1")) {
			script.append("가족 중 아버지로 보이는 사내가 사람 좋은 미소를 머금고 말합니다.\n");
			script.append("\"일단 안으로 들어오세요\"\n");
			script.append("당신은 미심쩍은 느낌이 들었지만 배가 고픈 나머지 의심없이 건물안으로 들어갑니다.\n");
			Main.eMap.setEvent(this.getEventId());
		} else if (pChoice.equals("2")) {
			script.append("가족 중 아버지로 보이는 사내가 사람 좋은 미소를 머금고 말합니다.\n\n");
			script.append("\"그런거야 뭐가 어렵겠습니까? 윗층에 있는 빈방에서 하루 쉬다 가셔도 됩니다.\"\n\n");
			script.append("터벅..터벅..터벅.......철컥\n");
			script.append("그러나 이내 뒤에서 문이 철컥 잠기더니\n");
			script.append("사내가 묵직한 무기를 들고 말합니다.\n\n");
			script.append("\"그걸 믿은거야?\"\n\n");
			script.append("나는 사내를 필사적으로 뿌리치고 창문으로 뛰어 내립니다..\n");
			script.append("쨍그랑..........\n");
			int damege = new Random().nextInt(4);
			if(damege == 0) {
				script.append("놀랍군요!\n");
				script.append("당신은 엄청난 운동신경을 발휘해 무사히 착지했습니다.\n");
			}
			else {
				script.append("당신은 착지를 잘못하여 발목을 삐였습니다.\n");
				script.append("(체력 -" + damege + ")\n");
				Main.character.setHealth(Main.character.getHealth() - damege);
			}
		}
		ConsolePrint.printResult(script, getIsLoaded());
	}
}
