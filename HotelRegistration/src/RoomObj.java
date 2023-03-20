public class RoomObj {
    private int roomNumber;
    private boolean petAllowed;
    private int numberOfBeds;
    private int suiteStatus;
    private String cleanStatus;
    private double price;

    public RoomObj(int roomNumber, boolean petAllowed, int numberOfBeds, int suiteStatus, String cleanStatus,
                   double price){

        setRoomNumber(roomNumber);
        setPetAllowed(petAllowed);
        setNumberOfBeds(numberOfBeds);
        setSuite(suiteStatus);
        setCleanStatus(cleanStatus);
        setPrice(price);

    }

    public int getRoomNumber() {
        return roomNumber;
    }

    private void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
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

    public int isSuite() {
        return suiteStatus;
    }

    private void setSuite(int suite) {
        suiteStatus = suite;
    }

    public String getCleanStatus(){
        return this.cleanStatus;
    }

    private void setCleanStatus(String color){
        this.cleanStatus = color;
    }

    public double getPrice(){
        return this.price;
    }

    private void setPrice(double price){
        this.price = price;
    }
}
