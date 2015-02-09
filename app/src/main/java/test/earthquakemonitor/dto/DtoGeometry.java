package test.earthquakemonitor.dto;

/**
 * Created by luisangelgarcia on 05/02/15.
 */
public class DtoGeometry {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================
    private String type;
    private double[] coordinates;

    // ===========================================================
    // Constructors
    // ===========================================================

    public DtoGeometry() {
    }

    public DtoGeometry(String type, double[] coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }
    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public String toString() {
        String coor = "";
        for (int i = 0; i < coordinates.length; i++) {
            if (i < coordinates.length - 1) {
                coor += coordinates[i] + ",\n";
            } else {
                coor += coordinates[i] + "\n";
            }
        }
        return "- geometry: {\n" +
                "type: " + type + ",\n" +
                "- coordinates: [\n" +
                coor +
                "]" +
                "},";
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
