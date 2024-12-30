package consolegame.event;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.item.Item;
import consolegame.item.Item000_Knife;
import consolegame.item.Item006_Ammunition;
import consolegame.item.Item008_Gun;
import consolegame.item.Item009_Can;
import consolegame.item.Item010_Meat;
import consolegame.item.Item011_Preservedfood;

public class Event200_Mart extends Event {
	public Event200_Mart() {
		setEventId(200);
		setName("마트");
		setScore(0);
		setWeight(0);
	}

		@Override
		public void printChoice(Character c) {
			Selection selection = new Selection();
			selection.addSelection(" 칼을 산다. "); 
			selection.addSelection(" 통조림을 산다. "); 
			selection.addSelection(" 총을 산다. "); 
			selection.addSelection(" 탄약을 산다. "); 
			selection.addSelection(" 고기를 산다. "); 
			selection.addSelection(" 보존식량을 산다. ");
			selection.addSelection(" 가진게 아무것도 없다.. 그냥 나가자."); 
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
				script.append("음 조금 녹슨것 같지만\n");
				script.append("뭐 괜찮겠지.\n");
				c.addItem(new Item000_Knife());
				c.setMoney(c.getMoney()-100);
			}else{pChoice.equals("2");
				script.append("마음에 드는 맛은 아니지만..뭐..\n");	
				script.append("이거라도 챙겨야겠지.\n");	
				c.addItem(new Item009_Can());
				c.setMoney(c.getMoney()-50);
			}
			
			if (pChoice.equals("3"))
			script.append("음 이거라면 누구든 \n");
			script.append("상대할수 있을것 같은 자신감이 솟는다.\n");
			script.append("난 강해졌다.\n");
			c.addItem(new Item008_Gun());
			c.setMoney(c.getMoney()-200);
			
			if (pChoice.equals("4"))
			script.append("아차 탄약도 챙겨야지.\n");
			c.addItem(new Item006_Ammunition());
			c.setMoney(c.getMoney()-50);
		
			if (pChoice.equals("5"))
			script.append("어떤 동물의 고기인지는\n");
			script.append("모르겠으나 어쨋든\n");
			script.append("맛있어 보이는 고기다.\n");
			c.addItem(new Item010_Meat());
			c.setMoney(c.getMoney()-200);
			if (pChoice.equals("6"))
			script.append("이 제품의 표지만 봐도\n");
			script.append("굉장히 맛이 있을것\n");
			script.append("같아 보이진 않는다.\n");
			script.append("영어로 뭐라고 적혀있는거지..\n");
			script.append("p..rotin..?.\n");
			c.addItem(new Item011_Preservedfood());
			c.setMoney(c.getMoney()-50);
			if (pChoice.equals("7"))
			script.append("배도 고프고..\n");
			script.append("돈도 없고... \n");
			script.append("서럽다. \n");
			ConsolePrint.printResult(script);
		}
	
	
}
