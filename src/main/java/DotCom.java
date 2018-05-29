import java.util.ArrayList;
import java.util.List;

public class DotCom {
    private String name;

    private List<Integer> locations = new ArrayList<>();
    private List<Integer> hits = new ArrayList<>();

    private int dotComLength;
    private int gridRowLength;

    private boolean sunk = false;

    /* Constructors */
    public DotCom(String name) {
        setName(name);
        setGridRowLength(7);
        setDotComLength(3);
        setLocations();
    }

    public DotCom(String name, int lengthOfDotCom, int gridRowLength) {
        setName(name);
        setDotComLength(lengthOfDotCom);
        setGridRowLength(gridRowLength);
        setLocations();
    }

    /* Name */
    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /* Locations */
    private void setLocations() {
        int pointer = 0;
        int location = (int) Math.round(Math.random() * (gridRowLength-dotComLength));
        while (pointer < dotComLength) {
            locations.add(location);
            pointer++;
            location++;
        }
    }

    public List<Integer> getLocations() {
        return locations;
    }

    /* Hits */
    public List<Integer> getHits() {
        return hits;
    }

    /* Dot Com Length */
    public void setDotComLength(int dotComLength) {
        if (dotComLength > 0) {
            this.dotComLength = dotComLength;
        }
    }

    public int getDotComLength() {
        return dotComLength;
    }

    /* Grid Row Length */
    public int getGridRowLength() {
        return gridRowLength;
    }

    public void setGridRowLength(int gridRowLength) {
        if (gridRowLength > 0) {
            this.gridRowLength = gridRowLength;
        }
    }

    /* Is Sunk? */
    public boolean isSunk() {
        return sunk;
    }

    /* Methods */
    public String checkYourSelf(String guess) {
        if (isSunk() == true) { return "Sunk"; }
        try {
            int intGuess = Integer.parseInt(guess);
            if (locations.contains(intGuess) && !hits.contains(intGuess)) {
                hits.add(intGuess);
                if (hits.size() == locations.size()) {
                    sunk = true;
                    return "Kill!";
                } else {
                    return "Hit!";
                }
            } else if (!locations.contains(intGuess)){
                return "Miss!";
            } else if (locations.contains(intGuess) && hits.contains(intGuess)) {
                return "Already hit!";
            }
        }
        catch (NumberFormatException e) {
            return "Not a valid guess.";
        }
        return "Didn't catch that...";
    }
}
