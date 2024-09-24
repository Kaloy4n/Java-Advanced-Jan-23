package tanks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Terrain {
    private String type;
    private List<Tank> tanks;
    private int area;

    public Terrain(String type, int area) {
        this.type = type;
        this.area = area;
        this.tanks = new ArrayList<>();
    }

    public String addTank(Tank tank) {
        if (tanks.contains(tank)) {
            return "Tank with this brand and model already exists!";
        }
        if (type.equalsIgnoreCase("Swamp") && tank.getWeight() > 14000) {
            return String.format("This %s is too heavy for this terrain!", tank.getBrand());
        }
        tanks.add(tank);
        return String.format("Tank %s %s added.", tank.getBrand(), tank.getModel());
    }

    public boolean removeTank(String brand, String model) {
        for (Tank tank : tanks) {
            if (tank.getBrand().equals(brand) && tank.getModel().equals(model)) {
                tanks.remove(tank);
                return true;
            }
        }
        return false;
    }

    public String getTanksByBarrelCaliberMoreThan(int barrelCaliber) {
        List<Tank> filteredTanks = tanks.stream()
                .filter(tank -> tank.getBarrelCaliber() > barrelCaliber)
                .collect(Collectors.toList());

        if (filteredTanks.isEmpty()) {
            return "There are no tanks with the specified caliber.";
        }

        String tankBrands = filteredTanks.stream()
                .map(Tank::getBrand)
                .collect(Collectors.joining(", "));
        return String.format("Tanks with caliber more than %dmm: %s", barrelCaliber, tankBrands);
    }

    public Tank getTankByBrandAndModel(String brand, String model) {
        for (Tank tank : tanks) {
            if (tank.getBrand().equals(brand) && tank.getModel().equals(model)) {
                return tank;
            }
        }
        return null;
    }

    public String getTheMostArmoredTank() {
        return tanks.stream()
                .max((t1, t2) -> Integer.compare(t1.getArmor(), t2.getArmor()))
                .map(tank -> String.format("%s %s is the most armored tank with %dmm. armor thickness.",
                        tank.getBrand(), tank.getModel(), tank.getArmor()))
                .orElse("There are no tanks in the terrain.");
    }

    public int getCount() {
        return tanks.size();
    }

    public String getStatistics() {
        if (tanks.isEmpty()) {
            return String.format("There are no tanks in the %s.", type.toLowerCase());
        }
        StringBuilder stats = new StringBuilder(String.format("Tanks located in the %s:\n", type.toLowerCase()));
        for (Tank tank : tanks) {
            stats.append("-- ").append(tank.getBrand()).append(" ").append(tank.getModel()).append("\n");
        }
        return stats.toString().trim();
    }
}