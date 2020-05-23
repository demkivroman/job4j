package solid.lsp.parking;

public class Place {
    CarType type;
    boolean busy = false;

    public Place(CarType type) {
        this.type = type;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }
}
