package consolegame.event;

import java.util.ArrayList;

import consolegame.character.Character;
import consolegame.item.Item;

public class EventMap {
	ArrayList<EventMapList> eventArray = new ArrayList<EventMapList>();
	int totalWeight = 0;
	public EventMap(Character c) {
		// 이벤트 리스트 추가
		// 이벤트 생성 및 가져오기 위한 맵 생성
		if(Item.hasItem(c, 0)) {
			 eventArray.add(new EventMapList(0, 0)); // 이벤트ID, 가중치
		}
		
	}
	
	private int getRandomEventId() {
		totalWeight = 0;
		eventArray.forEach(x -> totalWeight += x.weight);
		eventArray.forEach(x -> x.percent = x.weight/totalWeight);
		double random = Math.random();
		int find = 0;
		double sum = 0;
		for(EventMapList e : eventArray) {
			sum += e.percent;
			if(find == 0 && sum >= random) find = e.eventId;
		}
		
		return find;
	}
	
	public Event getEvent() {
		Event e = null;
		
		switch (getRandomEventId()) {
		case 0:
			e = new Event000_Start();
			break;
		}
		
		return e;
	}
}

class EventMapList{
	int eventId;
	double weight;
	double percent;
	
	EventMapList(int e, int w){
		this.eventId = e;
		this.weight = w;
		this.percent = 0;
	}
}