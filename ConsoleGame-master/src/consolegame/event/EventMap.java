package consolegame.event;

import java.util.ArrayList;

import consolegame.Main;
import consolegame.character.Character;
import consolegame.item.Item;

public class EventMap {
	ArrayList<EventMapList> eventArray = new ArrayList<EventMapList>();
	int totalWeight = 0;

	public EventMap() {
		Character c = Main.character;
		// 이벤트 리스트 추가
		// 이벤트 생성 및 가져오기 위한 맵 생성
		if (Item.hasItem(c, 0)) {
			eventArray.add(new EventMapList(0, 0)); // 이벤트ID, 가중치
		}
		eventArray.add(new EventMapList(0, 0));
		eventArray.add(new EventMapList(10, 1));
		eventArray.add(new EventMapList(20, 1));
		eventArray.add(new EventMapList(30, 1));
		eventArray.add(new EventMapList(40, 1));
		eventArray.add(new EventMapList(50, 1));
		eventArray.add(new EventMapList(60, 1));
		eventArray.add(new EventMapList(70, 1));
		eventArray.add(new EventMapList(80, 1));
		eventArray.add(new EventMapList(90, 1));
		eventArray.add(new EventMapList(100, 1));
		eventArray.add(new EventMapList(110, 1));
		eventArray.add(new EventMapList(120, 1));
		eventArray.add(new EventMapList(130, 1));
		eventArray.add(new EventMapList(140, 1));
		eventArray.add(new EventMapList(150, 1));
		eventArray.add(new EventMapList(160, 1));
		eventArray.add(new EventMapList(170, 1));
		eventArray.add(new EventMapList(180, 1));
		eventArray.add(new EventMapList(190, 1));

	}

	private int getRandomEventId() {
		totalWeight = 0;
		eventArray.forEach(x -> totalWeight += x.weight);
		eventArray.forEach(x -> x.percent = x.weight / totalWeight);
		double random = Math.random();
		int find = 0;
		double sum = 0;
		for (EventMapList e : eventArray) {
			sum += e.percent;
			if (sum >= random) {
				find = e.eventId;
				break;
			}
		}

		return find;
	}

	public Event getEvent() {
		Event e = null;
		int event = getRandomEventId();
		switch (event) {
		case 0:	e = new Event000_Start();break;
		case 10:e = new Event010_EmptyCar();break;
		case 20:e = new Event020_FakeReligion();break;
		case 30:e = new Event030_PoliceStation();break;
		case 40:e = new Event040_WildDog();break;
		case 50:e = new Event050_ConvinienceStore();break;
		case 60:e = new Event060_AbandonedHospital();break;
		case 70:e = new Event070_Biker();break;
		case 80:e = new Event080_Marine();break;
		case 90:e = new Event090_MerchantFamily();break;
		case 100:e = new Event100_USArmy();break;
		case 110:e = new Event110_University();break;
		case 120:e = new Event120_Doin();break;
		case 130:e = new Event130_HomelessMen();break;
		case 140:e = new Event140_WeirdShopper();break;
		case 150:e = new Event150__Filling_Station();break;
		case 160:e = new Event160_GangAssassin();break;
		case 170:e = new Event170_Wildboar();break;
		case 180:e = new Event180_Suddenpoop();break;
		case 190:e = new Event190_Meal();break;
		}
		eventArray.stream().filter(x -> x.eventId == event).findFirst().get().setWeight(0);
		return e;
	}
}

class EventMapList {
	int eventId;
	double weight;
	double percent;

	EventMapList(int e, int w) {
		this.eventId = e;
		this.weight = w;
		this.percent = 0;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}
}