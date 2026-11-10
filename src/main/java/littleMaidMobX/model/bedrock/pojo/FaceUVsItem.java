package littleMaidMobX.model.bedrock.pojo;

import com.google.gson.annotations.SerializedName;

public class FaceUVsItem {

    @SerializedName("down")
    private FaceItem down;

    @SerializedName("east")
    private FaceItem east;

    @SerializedName("north")
    private FaceItem north;

    @SerializedName("south")
    private FaceItem south;

    @SerializedName("up")
    private FaceItem up;

    @SerializedName("west")
    private FaceItem west;

    public FaceUVsItem() {}

    public FaceUVsItem(FaceItem down, FaceItem east, FaceItem north, FaceItem south, FaceItem up, FaceItem west) {
        this.down = down;
        this.east = east;
        this.north = north;
        this.south = south;
        this.up = up;
        this.west = west;
    }

    public FaceItem getDown() {
        return down;
    }

    public FaceItem getUp() {
        return up;
    }

    public FaceItem getNorth() {
        return north;
    }

    public FaceItem getSouth() {
        return south;
    }

    public FaceItem getWest() {
        return west;
    }

    public FaceItem getEast() {
        return east;
    }

    /**
     * 0: Down, 1: Up, 2: North, 3: South, 4: West, 5: East
     */
    public FaceItem getFace(int directionIndex) {
        switch (directionIndex) {
            case 0:
                return down;
            case 1:
                return up;
            case 2:
                return north;
            case 3:
                return south;
            case 4:
                return west;
            case 5:
                return east;
            default:
                return null;
        }
    }
}
