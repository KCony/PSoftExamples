package event_demo;

import java.util.*;

public class Model {
    private Map<String, Building> buildings = new HashMap<>();

    public void init() {
        buildings.put("MRC", new Building("MRC", 21, 548, 1481));
    }

    public int[] getCoords(String name) {
        Building bdg = buildings.get(name);
        if (bdg != null) {
            return new int[]{bdg.getX(), bdg.getY()};
        }
        else {
            return new int[]{};
        }
    }

    public Building getBuilding(String name) {
        return buildings.get(name);
    }
}
