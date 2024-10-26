package surfers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Beach {
    private String name;
    private int surfboardsForRent;
    private List<Surfer> surfers;

    public Beach(String name, int surfboardsForRent) {
        this.name = name;
        this.surfboardsForRent = surfboardsForRent;
        this.surfers = new ArrayList<>();
    }

    // Method to add a surfer
    public String addSurfer(Surfer surfer) {
        if (!surfer.getOwnsASurfBoard()) {
            if (surfboardsForRent == 0) {
                return "There are no free surfboards.";
            } else if (surfer.getMoney() < 50) {
                return surfer.getName() + " has not enough money to rent a surfboard.";
            } else {
                // Rent a surfboard, deduct money, and decrease surfboardsForRent
                surfer.setMoney(surfer.getMoney() - 50);
                surfboardsForRent--;
            }
        }

        surfers.add(surfer);
        return String.format("Surfer %s added.", surfer.getName());
    }

    // Method to remove a surfer by name
    public boolean removeSurfer(String name) {
        return surfers.removeIf(surfer -> surfer.getName().equals(name));
    }

    // Method to get the most experienced surfer
    public String getMostExperiencedSurfer() {
        if (surfers.isEmpty()) {
            return "There are no surfers.";
        }
        Surfer mostExperienced = surfers.stream()
                .max(Comparator.comparingInt(Surfer::getExperience))
                .orElse(null);

        return String.format("%s is most experienced surfer with %d years experience.",
                mostExperienced.getName(), mostExperienced.getExperience());
    }

    // Method to get a surfer by name
    public Surfer getSurfer(String name) {
        return surfers.stream().filter(surfer -> surfer.getName().equals(name)).findFirst().orElse(null);
    }

    // Method to get the count of surfers
    public int getCount() {
        return surfers.size();
    }

    // Method to get surfers who own their own surfboards
    public String getSurfersWithPersonalSurfboards() {
        List<String> personalSurfboardOwners = surfers.stream()
                .filter(Surfer::getOwnsASurfBoard)
                .map(Surfer::getName)
                .collect(Collectors.toList());

        if (personalSurfboardOwners.isEmpty()) {
            return "There are no surfers.";
        } else {
            return "Surfers who have their own surfboards: " + String.join(", ", personalSurfboardOwners);
        }
    }

    // Method to get a report of all surfers in order of addition
    public String getReport() {
        if (surfers.isEmpty()) {
            return "There are no surfers on " + this.name + " beach.";
        }
        StringBuilder sb = new StringBuilder("Beach " + this.name + " was visited by the following surfers:");
        sb.append(System.lineSeparator());
        for (int i = 0; i < surfers.size(); i++) {
            Surfer surfer = surfers.get(i);
            if (surfer.getExperience() > 0) {
                sb.append(String.format("%d. %s with %d years experience.",
                        (i + 1), surfer.getName(), surfer.getExperience()));
                sb.append(System.lineSeparator());
            } else {
                sb.append(String.format("%d. %s with no experience.",
                        (i + 1), surfer.getName()));
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString().trim(); // remove last newline
    }
}
