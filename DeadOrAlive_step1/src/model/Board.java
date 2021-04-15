package model;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private List<Thing> things = new ArrayList<>();

	public void load(Thing thing) { // player, bomb, apple을 통칭시켜서 기억
		things.add(thing);
	}
}
