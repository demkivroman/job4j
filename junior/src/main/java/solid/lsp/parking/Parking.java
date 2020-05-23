package solid.lsp.parking;

public class Parking {
    int vanPlaces;
    int carPlaces;
    Place[][] parkingPlace;

    public Parking(int vanPlaces, int carPlaces) {
        this.vanPlaces = vanPlaces;
        this.carPlaces = carPlaces;
    }
}
