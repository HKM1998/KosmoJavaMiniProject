package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;

public class Event200_Mart extends Event {
	public Event200_Mart() {
		setEventId(170);
		setName("마트");
		setScore(0);
		setWeight(0);
	}

		@Override
		public void printChoice(Character c) {
			Selection selection = new Selection();
			selection.addSelection(" 1.칼을 산다. "); // (자금 -100)
			selection.addSelection(" 2.통조림을 산다. "); // (자금- 50)
			selection.addSelection(" 3.총을 산다. "); // (자금- 200)
			selection.addSelection(" 4.탄약을 산다. "); // (자금- 50)
			selection.addSelection(" 5.고기를 산다. "); // (자금- 200)
			selection.addSelection(" 6.보존식량을 산다. "); // (자금- 50)
			
			selection.addSelection(" 7. 가진게 아무것도 없다.. 그냥 나가자."); // 
			this.setsCount(selection.count);
			selection.print();
		}
		
		@Override
		public void printScript() {
			StringBuilder script = new StringBuilder();
			script.append(getEventId() + ". " + getName() + "\n");
			script.append(" 길을가다 마트를 발견했다. \n");
			script.append(" 뭐라도 좀 사러가자. \n");
			ConsolePrint.printScript(script);
		}
	
		@Override
		public void getResult(Character c, String pChoice) {
			StringBuilder script = new StringBuilder();
			if (pChoice.equals("1"))  {
				script.append("음 조금 녹슨것 같지만");
				script.append("뭐 괜찮겠지.");
		//		c.getItem().add(000, Knife); 
				c.setMoney(getMoney()-100);
			}else{pChoice.equals("2");
				script.append("마음에 드는 맛은 아니지만..뭐..");	
				script.append("이거라도 챙겨야겠지.");	
				c.setMoney(getMoney()-50);
			}
			
			if (pChoice.equals("3"))
			script.append("음 이거라면 누구든 ");
			script.append("상대할수 있을것 같은 자신감이 솟는다.");
			script.append("난 강해졌다.");
			c.setMoney(getMoney()-200);
			
			if (pChoice.equals("4"))
			script.append("아차 탄약도 챙겨야지.");
			c.setMoney(getMoney()-50);
		
			if (pChoice.equals("5"))
			script.append("어떤 동물의 고기인지는");
			script.append("모르겠으나 어쨋든");
			script.append("맛있어 보이는 고기다.");
			c.setMoney(getMoney()-200);
			if (pChoice.equals("6"))
			script.append("이 제품의 표지만 봐도");
			script.append("굉장히 맛이 있을것");
			script.append("같아 보이진 않는다.");
			script.append("영어로 뭐라고 적혀있는거지..");
			script.append("p..rotin..?.");
			c.setMoney(getMoney()-50);
			if (pChoice.equals("7"))
			script.append("배도 고프고..");
			script.append("돈도 없고... ");
			script.append("서럽다. ");
			ConsolePrint.printResult(script);
		}
		private int getMoney() {
			
			return 0;
		}
	
		private int getMental() {
			return 0;
		}
	
		private int getHealth() {
			return 0;
			
	}
}
