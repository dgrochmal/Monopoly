package dan.gamecenter;

import dan.player.Player;
import dan.property.Railroad;
import dan.property.RegProperty;
import dan.property.Utility;

public class Monopolize {

	public Monopolize(Player p1) {
		assembleMonopolies(p1);
	}

	private static void assembleMonopolies(Player p1) {
		//TODO did not correctly identify monopoly of light blue properties
		boolean o = false;
		boolean t = false;
		boolean th = false;
		boolean f = false;
		//Sees if the player owns a monopoly
		for(int i = 0; i < p1.getProperties().size(); i++){
			if(p1.getProperties().get(i).getName().equals("Electric Company")){
				o = true;
			}
			if(p1.getProperties().get(i).getName().equals("Water Works")){
				t = true;
			}
		}
		//If the player has a monopoly, than it sets each property as monopolized
		if(o && t){
			for(int i = 0; i < p1.getProperties().size(); i++){
				if(p1.getProperties().get(i).getName().equals("Electric Company")){
					Utility p = (Utility) p1.getProperties().get(i);
					p.setCount(2);
				}
				if(p1.getProperties().get(i).getName().equals("Water Works")){
					Utility p = (Utility) p1.getProperties().get(i);
					p.setCount(2);
				}
			}
		}
		o = false;
		t = false;
		
		//Sees if the player owns a monopoly
		for(int i = 0; i < p1.getProperties().size(); i++){
			if(p1.getProperties().get(i).getName().equals("Baltic Avenue")){
				o = true;
			}
			if(p1.getProperties().get(i).getName().equals("Mediterranean Avenue")){
				t = true;
			}
		}
		//If the player has a monopoly, than it sets each property as monopolized
		if(o && t){
			for(int i = 0; i < p1.getProperties().size(); i++){
				if(p1.getProperties().get(i).getName().equals("Baltic Avenue")){
					RegProperty p = (RegProperty) p1.getProperties().get(i);
					p.setMonopolized(true);
				}
				if(p1.getProperties().get(i).getName().equals("Mediterranean Avenue")){
					RegProperty p = (RegProperty) p1.getProperties().get(i);
					p.setMonopolized(true);
				}
			}
		}
		o = false;
		t = false;
		
		//Sees if the player owns a monopoly
		for(int i = 0; i < p1.getProperties().size(); i++){
			if(p1.getProperties().get(i).getName().equals("Oriental Avenue")){
				o = true;
			}
			if(p1.getProperties().get(i).getName().equals("Vermont Avenue")){
				t = true;
			}
			if(p1.getProperties().get(i).getName().equals("Connecticut Avenue")){
				th = true;
			}
		}
		//If the player has a monopoly, than it sets each property as monopolized
		if(o && t && th){
			for(int i = 0; i < p1.getProperties().size(); i++){
				if(p1.getProperties().get(i).getName().equals("Oriental Avenue")){
					RegProperty p = (RegProperty) p1.getProperties().get(i);
					p.setMonopolized(true);
				}
				if(p1.getProperties().get(i).getName().equals("Vermont Avenue")){
					RegProperty p = (RegProperty) p1.getProperties().get(i);
					p.setMonopolized(true);
				}
				if(p1.getProperties().get(i).getName().equals("Connecticut Avenue")){
					RegProperty p = (RegProperty) p1.getProperties().get(i);
					p.setMonopolized(true);
				}
			}
		}
		o = false;
		t = false;
		th = false;
		
		//Sees if the player owns a monopoly
		for(int i = 0; i < p1.getProperties().size(); i++){
			if(p1.getProperties().get(i).getName().equals("St. Charles Place")){
				o = true;
			}
			if(p1.getProperties().get(i).getName().equals("States Avenue")){
				t = true;
			}
			if(p1.getProperties().get(i).getName().equals("Virginia Avenue")){
				th = true;
			}
		}
		//If the player has a monopoly, than it sets each property as monopolized
		if(o && t && th){
			for(int i = 0; i < p1.getProperties().size(); i++){
				if(p1.getProperties().get(i).getName().equals("St. Charles Place")){
					RegProperty p = (RegProperty) p1.getProperties().get(i);
					p.setMonopolized(true);
				}
				if(p1.getProperties().get(i).getName().equals("States Avenue")){
					RegProperty p = (RegProperty) p1.getProperties().get(i);
					p.setMonopolized(true);
				}
				if(p1.getProperties().get(i).getName().equals("Virginia Avenue")){
					RegProperty p = (RegProperty) p1.getProperties().get(i);
					p.setMonopolized(true);
				}
			}
		}
		o = false;
		t = false;
		th = false;
		
		//Sees if the player owns a monopoly
		for(int i = 0; i < p1.getProperties().size(); i++){
			if(p1.getProperties().get(i).getName().equals("St. James Place")){
				o = true;
			}
			if(p1.getProperties().get(i).getName().equals("Tennessee Avenue")){
				t = true;
			}
			if(p1.getProperties().get(i).getName().equals("New York Avenue")){
				th = true;
			}
		}
		//If the player has a monopoly, than it sets each property as monopolized
		if(o && t && th){
			for(int i = 0; i < p1.getProperties().size(); i++){
				if(p1.getProperties().get(i).getName().equals("St. James Place")){
					RegProperty p = (RegProperty) p1.getProperties().get(i);
					p.setMonopolized(true);
				}
				if(p1.getProperties().get(i).getName().equals("Tennessee Avenue")){
					RegProperty p = (RegProperty) p1.getProperties().get(i);
					p.setMonopolized(true);
				}
				if(p1.getProperties().get(i).getName().equals("New York Avenue")){
					RegProperty p = (RegProperty) p1.getProperties().get(i);
					p.setMonopolized(true);
				}
			}
		}
		o = false;
		t = false;
		th = false;
		
		//Sees if the player owns a monopoly
		for(int i = 0; i < p1.getProperties().size(); i++){
			if(p1.getProperties().get(i).getName().equals("Kentucky Avenue")){
				o = true;
			}
			if(p1.getProperties().get(i).getName().equals("Indiana Avenue")){
				t = true;
			}
			if(p1.getProperties().get(i).getName().equals("Illinois Avenue")){
				th = true;
			}
		}
		//If the player has a monopoly, than it sets each property as monopolized
		if(o && t && th){
			for(int i = 0; i < p1.getProperties().size(); i++){
				if(p1.getProperties().get(i).getName().equals("Kentucky Avenue")){
					RegProperty p = (RegProperty) p1.getProperties().get(i);
					p.setMonopolized(true);
				}
				if(p1.getProperties().get(i).getName().equals("Indiana Avenue")){
					RegProperty p = (RegProperty) p1.getProperties().get(i);
					p.setMonopolized(true);
				}
				if(p1.getProperties().get(i).getName().equals("Illinois Avenue")){
					RegProperty p = (RegProperty) p1.getProperties().get(i);
					p.setMonopolized(true);
				}
			}
		}
		o = false;
		t = false;
		th = false;
		
		//Sees if the player owns a monopoly
		for(int i = 0; i < p1.getProperties().size(); i++){
			if(p1.getProperties().get(i).getName().equals("Atlantic Avenue")){
				o = true;
			}
			if(p1.getProperties().get(i).getName().equals("Ventor Avenue")){
				t = true;
			}
			if(p1.getProperties().get(i).getName().equals("Marvin Gardens")){
				th = true;
			}
		}
		//If the player has a monopoly, than it sets each property as monopolized
		if(o && t && th){
			for(int i = 0; i < p1.getProperties().size(); i++){
				if(p1.getProperties().get(i).getName().equals("Atlantic Avenue")){
					RegProperty p = (RegProperty) p1.getProperties().get(i);
					p.setMonopolized(true);
				}
				if(p1.getProperties().get(i).getName().equals("Ventor Avenue")){
					RegProperty p = (RegProperty) p1.getProperties().get(i);
					p.setMonopolized(true);
				}
				if(p1.getProperties().get(i).getName().equals("Marvin Gardens")){
					RegProperty p = (RegProperty) p1.getProperties().get(i);
					p.setMonopolized(true);
				}
			}
		}
		o = false;
		t = false;
		th = false;
		
		//Sees if the player owns a monopoly
		for(int i = 0; i < p1.getProperties().size(); i++){
			if(p1.getProperties().get(i).getName().equals("Pacific Avenue")){
				o = true;
			}
			if(p1.getProperties().get(i).getName().equals("North Carolina Avenue")){
				t = true;
			}
			if(p1.getProperties().get(i).getName().equals("Pennsylvania Avenue")){
				th = true;
			}
		}
		//If the player has a monopoly, than it sets each property as monopolized
		if(o && t && th){
			for(int i = 0; i < p1.getProperties().size(); i++){
				if(p1.getProperties().get(i).getName().equals("Pacific Avenue")){
					RegProperty p = (RegProperty) p1.getProperties().get(i);
					p.setMonopolized(true);
				}
				if(p1.getProperties().get(i).getName().equals("North Carolina Avenue")){
					RegProperty p = (RegProperty) p1.getProperties().get(i);
					p.setMonopolized(true);
				}
				if(p1.getProperties().get(i).getName().equals("Pennsylvania Avenue")){
					RegProperty p = (RegProperty) p1.getProperties().get(i);
					p.setMonopolized(true);
				}
			}
		}
		o = false;
		t = false;
		th = false;
		
		//Sees if the player owns a monopoly
		for(int i = 0; i < p1.getProperties().size(); i++){
			if(p1.getProperties().get(i).getName().equals("Park Place")){
				o = true;
			}
			if(p1.getProperties().get(i).getName().equals("Boardwalk")){
				t = true;
			}
		}
		//If the player has a monopoly, than it sets each property as monopolized
		if(o && t && th){
			for(int i = 0; i < p1.getProperties().size(); i++){
				if(p1.getProperties().get(i).getName().equals("Park Place")){
					RegProperty p = (RegProperty) p1.getProperties().get(i);
					p.setMonopolized(true);
				}
				if(p1.getProperties().get(i).getName().equals("Boardwalk")){
					RegProperty p = (RegProperty) p1.getProperties().get(i);
					p.setMonopolized(true);
				}
			}
		}
		o = false;
		t = false;
		
		checkTwoRailroads(p1, "Pennsylvania Railroad", "B. & O. Railroad");
		checkTwoRailroads(p1, "Pennsylvania Railroad", "Reading Railroad");
		checkTwoRailroads(p1, "Pennsylvania Railroad", "Short Line Railroad");
		checkTwoRailroads(p1, "Reading Railroad", "B. & O. Railroad");
		checkTwoRailroads(p1, "Short Line Railroad", "B. & O. Railroad");
		checkTwoRailroads(p1, "Reading Railroad", "Short Line Railroad");
		
		checkThreeRailroads(p1, "Reading Railroad", "Pennsylvania Railroad", "B. & O. Railroad");
		checkThreeRailroads(p1, "Reading Railroad", "Short Line Railroad", "B. & O. Railroad");
		checkThreeRailroads(p1, "Reading Railroad", "Short Line Railroad", "Pennsylvania Railroad");
		checkThreeRailroads(p1, "Pennsylvania Railroad", "B. & O. Railroad", "Short Line Railroad");
		
		for(int i = 0; i < p1.getProperties().size(); i++){
			if(p1.getProperties().get(i).getName().equals("Reading Railroad")){
				o = true;
			}
			if(p1.getProperties().get(i).getName().equals("Pennsylvania Railroad")){
				t = true;
			}
			if(p1.getProperties().get(i).getName().equals("B. & O. Railroad")){
				th = true;
			}
			if(p1.getProperties().get(i).getName().equals("Short Line Railroad")){
				f = true;
			}
		}
		//If the player has a monopoly, than it sets each property as monopolized
		if(o && t && th && f){
			for(int i = 0; i < p1.getProperties().size(); i++){
				if(p1.getProperties().get(i).getName().equals("Reading Railroad")){
					Railroad p = (Railroad) p1.getProperties().get(i);
					p.setCost(4);
				}
				if(p1.getProperties().get(i).getName().equals("Pennsylvania Railroad")){
					Railroad p = (Railroad) p1.getProperties().get(i);
					p.setCost(4);
				}
				if(p1.getProperties().get(i).getName().equals("B. & O. Railroad")){
					Railroad p = (Railroad) p1.getProperties().get(i);
					p.setCost(4);
				}
				if(p1.getProperties().get(i).getName().equals("Short Line Railroad")){
					Railroad p = (Railroad) p1.getProperties().get(i);
					p.setCost(4);
				}
			}
		}
		o = false;
		t = false;
		th = false;
		f = false;
	}

	private static void checkTwoRailroads(Player p1, String string1, String string2) {
		boolean o = false;
		boolean t = false;
		for(int i = 0; i < p1.getProperties().size(); i++){
			if(p1.getProperties().get(i).getName().equals(string1)){
				o = true;
			}
			if(p1.getProperties().get(i).getName().equals(string2)){
				t = true;
			}
		}
		//If the player has a monopoly, than it sets each property as monopolized
		if(o && t){
			for(int i = 0; i < p1.getProperties().size(); i++){
				if(p1.getProperties().get(i).getName().equals(string1)){
					Railroad p = (Railroad) p1.getProperties().get(i);
					p.setCount(2);
				}
				if(p1.getProperties().get(i).getName().equals(string2)){
					Railroad p = (Railroad) p1.getProperties().get(i);
					p.setCount(2);
				}
			}
		}
		
	}

	private static void checkThreeRailroads(Player p1, String string1, String string2, String string3) {
		boolean o = false;
		boolean t = false;
		boolean th = false;
		for(int i = 0; i < p1.getProperties().size(); i++){
			if(p1.getProperties().get(i).getName().equals(string1)){
				o = true;
			}
			if(p1.getProperties().get(i).getName().equals(string2)){
				t = true;
			}
			if(p1.getProperties().get(i).getName().equals(string3)){
				th = true;
			}
		}
		//If the player has a monopoly, than it sets each property as monopolized
		if(o && t && th){
			for(int i = 0; i < p1.getProperties().size(); i++){
				if(p1.getProperties().get(i).getName().equals(string1)){
					Railroad p = (Railroad) p1.getProperties().get(i);
					p.setCount(3);
				}
				if(p1.getProperties().get(i).getName().equals(string2)){
					Railroad p = (Railroad) p1.getProperties().get(i);
					p.setCount(3);
				}
				if(p1.getProperties().get(i).getName().equals(string3)){
					Railroad p = (Railroad) p1.getProperties().get(i);
					p.setCount(3);
				}
			}
		}
	}
	
}
