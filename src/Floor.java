public class Floor {
    private boolean upSignal;
    private boolean downSignal;
    private int floorNum;

    public int getFloorNum() {
        return floorNum;
    }

    public boolean getUpSignal() {
        return upSignal;
    }

    public boolean getDownSignal() {
        return downSignal;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    public void setDownSignal(boolean downSignal) {
        this.downSignal = downSignal;
    }

    public void setUpSignal(boolean upSignal) {
        this.upSignal = upSignal;
    }

    public boolean pressedButton() {
        // metoda zwraca czy jaki kolwiek sygnal jest wcisniety
        if ((this.upSignal || this.downSignal) == true) {
            return true;
        }
        return false;
    }

    public Floor(int floorNum) {
        this.floorNum = floorNum;
        this.downSignal = false;
        this.upSignal = false;
    }

    public Floor() {
    }
    
}
