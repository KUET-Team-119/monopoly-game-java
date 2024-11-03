package domain.player.PlayerManager;

import java.util.ArrayList;
import java.util.List;

import domain.component.property.Property;
import domain.component.property.RailRoadProperty;
import domain.component.property.UtilityProperty;

public class PropertyManager {
    private List<Property> properties;

    public PropertyManager() {
        this.properties = new ArrayList<Property>();
    }

    public void addProperty(Property property) {
        properties.add(property);
    }

    public int countRailRoadProperties() {
        int count = 0;
        for (Property property : properties) {
            if (property instanceof RailRoadProperty) {
                count++;
            }
        }
        return count;
    }

    public int countUtilityProperties() {
        int count = 0;
        for (Property property : properties) {
            if (property instanceof UtilityProperty) {
                count++;
            }
        }
        return count;
    }

    public List<Property> getProperties() {
        return properties;
    }
}
