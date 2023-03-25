public class RoomObj {

    private String guestName;
    private int roomNumber;
    private boolean petAllowed;
    private int numberOfBeds;
    private int suiteLevel;
    public String cleanStatus;
    private double price;

    public RoomObj(String guestName, int roomNumber, boolean petAllowed, int numberOfBeds, int suiteLevel, String cleanStatus,
            double price){

        setGuestName(guestName);
        setRoomNumber(roomNumber);
        setPetAllowed(petAllowed);
        setNumberOfBeds(numberOfBeds);
        setSuiteLevel(suiteLevel);
        setCleanStatus(cleanStatus);
        setPrice(price);

    }

    public String getGuestName(){
        return this.guestName;
    }

    public void setGuestName(String guestName){
        this.guestName = guestName;
    }

    public int getRoomNumber() {
        return this.roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }


    public boolean getPetAllowed() {
        return this.petAllowed;
    }

    public void setPetAllowed(boolean petAllowed) {
        this.petAllowed = petAllowed;
    }

    public int getNumberOfBeds() {
        return this.numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public int getSuiteLevel() {
        return this.suiteLevel;
    }

    public void setSuiteLevel(int suiteLevel) {
        this.suiteLevel = suiteLevel;
    }

    public String getCleanStatus(){
        return this.cleanStatus;
    }

    public void setCleanStatus(String color){
        this.cleanStatus = color;
    }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(double price){
        this.price = price;
    }
}
