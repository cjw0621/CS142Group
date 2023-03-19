public class RoomObj {
    //create a room object with object parameters int roomnumbers, double price, boolean pet allowed,
    // int number of bed, Boolean issuite

    private int roomNumber;
    private double price;
    private boolean petAllowed;
    private int numberOfBeds;
    private boolean isSuite;

    public RoomObj(int roomNumber, double price, boolean petAllowed, int numberOfBeds, boolean isSuite){
        setRoomNumber(roomNumber);
        setPrice(price);
        setPetAllowed(petAllowed);
        setNumberOfBeds(numberOfBeds);
        setSuite(isSuite);
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    private void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    public boolean isPetAllowed() {
        return petAllowed;
    }

    private void setPetAllowed(boolean petAllowed) {
        this.petAllowed = petAllowed;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    private void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public boolean isSuite() {
        return isSuite;
    }

    private void setSuite(boolean suite) {
        isSuite = suite;
    }
}
