package consolegame.event;

import java.util.List;
import java.util.Random;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item001_Passport;
import consolegame.item.Item006_Ammunition;

public class Event030_PoliceStation extends Event {
	public Event030_PoliceStation() {
		setEventId(030);
		setName("경찰서");
		setScore(0);
		setWeight(0);
	}

	// 선택지 생성 메서드 반드시 오버라이딩
	@Override
	public void printChoice(Character c) {                             //구현하려고 하던 바는 경찰서에서 2번을 선택하고 칼 혹은 총으로 공격하려 했을 경우
		// 선택지 작성                                                    //칼은 90% 확률로 지고 체력 -2, 10% 확률로 승리하고 탄약3개 획득
		Selection selection = new Selection();                         //총은 50% 확률로 지고 체력 -2, 50% 확률로 승리하고 탄약3개 획득 이었습니다.
                                                                       //그런데 구현을 하고 보니 아무리 해도 이걸 getResult로 내려 보내는게 잘 안되고
		selection.addSelection("어쩌다가 혼자 이렇게 남게 됐나요?.");          //탄약을 3개 추가 하는 방법도 몰라서 보류 했습니다
		                                                               
		selection.addSelection("그냥 무시하고 무기만 탈취 하려 한다");
		
		

						



		selection.print();
	}

	// 이벤트 스크립트 바로 화면에 출력
	@Override
	public void printScript() {
		// 화면 출력 스크립트 작성 형식은 추후 지정할 예정
		// 아래는 예시
		StringBuilder script = new StringBuilder();
		script.append(getEventId() + ". " + getName() + "\n");
		script.append("경찰서를 들어 갔는데 스산하다.\n");
		script.append("아무도 없는 줄 알고 물건을 뒤지려 하자 갑자기 누구냐며 소리친다.\n");
		script.append("그 사람은 자신이 이 지역의 자치 경찰이라 한다.\n");	
		script.append("나는 그 사람의 장단을 맞춰주며 우선 정보를 캐낼까 아니면 무기를 우선 탈취할까?\n");

		ConsolePrint.printScript(script);
	}

//	@Override                                                    
	public void getResult(Character c, String pChoice) {                //위에 구현한 결과 getResult로 가져 오려다 포기

		if (pChoice.equals("2")) {                                      // 2번을 골랐을 경우 공격하는 것 추가
			if (Item.hasItem(c, 000)) {                                 // 칼을 가지고 있을 경우 공격

				Random random = new Random();                           // java.util.Random 임포트 후

				if (random.nextInt(10) < 9) {                           // 칼은 90% 확률로 체력 -2
					c.setHealth(c.getHealth() - 2);
				} else if (!Item.hasItemType(c, "Ammunition")) {
					c.getItem().add(new Item006_Ammunition());          // 10% 확률로 승리시 탄약이 없을 때 탄약 추가
				} else {
					c.getItem().add(new Item006_Ammunition());          // 10% 확률로 승리시 탄약이 있을 때도 추가
				}

			}
			if (Item.hasItem(c, 8)) {                                    // 총을 가지고 있을 경우 공격 (008은 8진수 인식 오류로 8로 수정)

				Random random1 = new Random();
				if (random1.nextInt(10) < 5) {                           // 칼은 50% 확률로 패배 후 체력 -2, 50% 확률로 승리 후 탄약 획득
					c.setHealth(c.getHealth() - 2);
				} else if (!Item.hasItemType(c, "Ammunition")) {         // 기존에 탄약이 없을 경우 추가
					c.getItem().add(new Item006_Ammunition());
				} else {                                                 // 기존에 탄약이 있을 때도 추가
					c.getItem().add(new Item006_Ammunition());
				}

			}

		}
//		if (pChoice.equals("1")) {                          //
//			
//		}

	}
}