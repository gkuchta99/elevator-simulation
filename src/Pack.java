public class Pack implements Comparable<Pack>{
    private Integer destinationFloor;
    private int mass;

    public void setMass(int mass) {
        this.mass = mass;
    }

    public void setDestinationFloor(Integer destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public Integer getDestinationFloor() {
        return destinationFloor;
    }

    public int getMass() {
        return mass;
    }
    public Pack(Integer destinationFloor,int mass){
        this.mass=mass;
        this.destinationFloor=destinationFloor;
    }

    @Override
    public int compareTo(Pack pack){
        return this.getDestinationFloor().compareTo(pack.getDestinationFloor());
    }
}
