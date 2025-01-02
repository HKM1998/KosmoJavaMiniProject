package consolegame.event;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class EventMap {
	ArrayList<EventMapList> eventArray = new ArrayList<EventMapList>();

	public EventMap() {
		// 이벤트 리스트 추가
		// 이벤트 생성 및 가져오기 위한 맵 생성
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
		eventArray.add(new EventMapList(200, 1));
		eventArray.add(new EventMapList(210, 1));
		eventArray.add(new EventMapList(220, 1));

	}

	private int getRandomEventId() {
		Random random = new Random();
		int find = 0;
		double bestValue = Double.MAX_VALUE;
		for (EventMapList e : eventArray) {
			double value = -Math.log(random.nextDouble())/e.weight;
			if (value < bestValue) {
				bestValue = value;
				find = e.eventId;
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
		case 31:e = new Event031_PoliceStation_1();break;
		case 40:e = new Event040_WildDog();break;
		case 50:e = new Event050_ConvinienceStore();break;
		case 51:e = new Event051_ConvinienceStore_1();break;
		case 60:e = new Event060_AbandonedHospital();break;
		case 61:e = new Event061_AbandonedHospital_1();break;
		case 70:e = new Event070_Biker();break;
		case 80:e = new Event080_Marine();break;
		case 81:e = new Event081_Marine_1();break;
		case 90:e = new Event090_MerchantFamily();break;
		case 91:e = new Event091_MerchantFamily_1();break;
		case 100:e = new Event100_USArmy();break;
		case 110:e = new Event110_University();break;
		case 120:e = new Event120_Doin();break;
		case 121:e = new Event121_Philosophy();break;
		case 130:e = new Event130_HomelessMen();break;
		case 140:e = new Event140_WeirdShopper();break;
		case 150:e = new Event150_FillingStation();break;
		case 160:e = new Event160_Assassin();break;
		case 170:e = new Event170_Wildboar();break;
		case 180:e = new Event180_Suddenpoop();break;
		case 190:e = new Event190_Meal();break;
		case 200:e = new Event200_Mart();break;
		case 210:e = new Event210_Peddler();break;
		case 220:e = new Event220_Acquisition();break;
		}
		eventArray.stream().filter(x -> x.eventId == event).collect(Collectors.toList()).forEach(li -> eventArray.remove(li));
		return e;
	}
	
	public void setEvent(int pEventId) {
		// 특정 이벤트가 완료되면 다음 이벤트 발생을 위해 가중치가 높은 연계 이벤트 추가
		// 반드시 이어져야할때 9999
		// 확률일때 1~99
		// 상대적인 확률이기 때문에 남은 이벤트 수에 따라 확률이 달라짐
		// 주석의 C : 이어지는 이벤트		R : 랜덤 확률 이벤트
		switch(pEventId) {
		case 10: // 빈차 이벤트에서 지도 획득한 경우 경찰서 이벤트 가중치 상승
			try {
				eventArray.stream().filter(x -> x.eventId == 30)
				.collect(Collectors.toList()).forEach(li -> li.setWeight(5));
			}
			catch(NullPointerException e) {} // 30번 이벤트가 이미 끝났으면 NullPointerException 발생 가능
			break; 
		case 30: eventArray.add(new EventMapList(31, 9999)); break; // C 겅찰서 이벤트
		case 31: // 경찰서 이벤트에서 경찰의 친구가 된 경우 빈차 이벤트 가중치 상승
			try {
				eventArray.stream().filter(x -> x.eventId == 10)
				.collect(Collectors.toList()).forEach(li -> li.setWeight(5));
			}
			catch(NullPointerException e) {} // 10번 이벤트가 이미 끝났으면 NullPointerException 발생 가능
			break; 
		case 50: eventArray.add(new EventMapList(51, 9999)); break; // C 편의점 이벤트
		case 60: eventArray.add(new EventMapList(61, 9999)); break; // C 편의점 이벤트
		case 80: eventArray.add(new EventMapList(81, 9999)); break; // C 해병 이벤트
		case 90: eventArray.add(new EventMapList(91, 9999)); break; // C 상인가족 이벤트
		case 120: eventArray.add(new EventMapList(121, 5)); break; // R 도인 이벤트
		}
	}
}

class EventMapList {
	int eventId;
	double weight;

	EventMapList(int e, int w) {
		this.eventId = e;
		this.weight = w;
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
}