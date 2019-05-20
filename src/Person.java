public class Person {
    protected double mass;
    protected int destinationFloor;
    protected int patienceLevel;

    public Person(double mass, int destinationFloor, int patienceLevel) {
        this.mass = mass;
        this.destinationFloor = destinationFloor;
        this.patienceLevel = patienceLevel;
    }

    public Person() {
    }

    public double getMass() {
        return mass;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public int getPatienceLevel() {
        return patienceLevel;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setPatienceLevel(int patienceLevel) {
        this.patienceLevel = patienceLevel;
    }
    public boolean spaceInElevator(){
        // kod najpierw trzeba napisac kod klasy winda i pozniej dac ja jako argument funkcji i na podstawie obciazenia zwrocic wartosc boolowska
        return true;
    }
    public void deletePerson(Person person){
        person = null;
    }
    public void decreasingPatienceLevel(){
        int temp;
        temp=getPatienceLevel();
        temp = temp - 1;
        setPatienceLevel(temp);
    }


}
