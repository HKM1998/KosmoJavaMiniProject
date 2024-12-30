package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;

public class Event180_Suddenpoop extends Event {
	public Event180_Suddenpoop() {
		setEventId(170);
		setName("급똥");
		setScore(0);
		setWeight(0);
	}

	@Override
	public void printChoice(Character c) {
		// 선택지 작성
		Selection selection = new Selection();

		selection.addSelection(" 1. 꾸르르르르르... 윽..힘들더라도 조금만 참고 얼른 버려진 건물을 찾아보자.. ");
		
		selection.addSelection(" 2. 아흑... 참기 너무 힘든거 같다..근처 풀밭이라도 가서 해결하자. ");

		selection.print();
	}
	@Override
	public void printScript() {	
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append(".\n");
		script.append(" 크흡.. 걷던 도중 대장의 움직임이 심상치 않다. 아무래도 당장이라도 지릴것 같다.\n");
		script.append("\n");
		script.append("\n");

		ConsolePrint.printScript(script);
	}

	@Override
	public void getResult(Character c, String pChoice) {
		StringBuilder script = new StringBuilder();
		if (pChoice.equals("1")) {
			script.append("주변에 건물이라곤 전혀 찾을수없다.");
			script.append("아무래도 큰일난것 같다.");
			script.append("눈앞이 아득해진다.");
			script.append("이런.. 가는 길에 참지 못하고 지려버렸다."); 
			
			c.setMental(getMental()-3);													// 정신력 -3
			
		}else {pChoice.equals("2");
			script.append("안되겠다 지금 당장 바지를 내리고 싸야할것 같다.");
			script.append("수치스럽다.");
			script.append("푸드드드득...크흑");
			c.setMental(getMental()-2); // 정신력 -2
		}
			
		}

	private int getMental() {
		return 0;
	}
		
	}

