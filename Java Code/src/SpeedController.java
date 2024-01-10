public class SpeedController {

    private Integer requestedSpeed;
    private Integer actualSpeed;
    //Assumed the maximum possible speed of vehicle to be 100.
    public static final int maximumSpeed = 100;
    //Speed of the car can be now lower than 0.
    public static final int minimumSpeed = 0;

    public enum Signal {INCREASE, DECREASE,DO_NOTHING,BRAKE};

    //Initializing the speed of the vehicle.
    //Requested speed is initially null as no value has been entered yet.
    //Actual Speed is initially 0 as the vehicle will be initially on rest.
    public SpeedController() {
        this.requestedSpeed = null;
        this.actualSpeed = 0;
    }

    // Function to check if a value is in the specified range
    private boolean inRange(int speedVal) {
        return (speedVal >= minimumSpeed && speedVal <= maximumSpeed);
    }

    // Invariant method
    private boolean invariant() {
        return (this.requestedSpeed == null || inRange(this.requestedSpeed)) && (inRange(actualSpeed));
    }


    public Signal Increment() {
        this.actualSpeed += 5;
        if(this.invariant()) {
            return(Signal.INCREASE);

        }
        else{
            this.actualSpeed-=5;
            return(Signal.DO_NOTHING);
        }
    }

    public Signal Decrement() {
        this.actualSpeed -= 5;
        if(this.invariant()){
        return(Signal.DECREASE);

        }
        else{
            this.actualSpeed+=5;
            return(Signal.DO_NOTHING);

        }
    }

    public int getCurrentSpeed() {
        return (this.actualSpeed);
    }
    public int getRequestedSpeed() {
        return (this.requestedSpeed);
    }


    public Signal Brake(){
        if(this.getCurrentSpeed()==0){
            return(Signal.DO_NOTHING);

        }
        else{
            this.actualSpeed=0;
            return(Signal.BRAKE);

        }
    }

    public Signal requestChange(int SpeedIn) {
        Signal signalOut = Signal.DO_NOTHING;

        if (inRange(SpeedIn)) {
            this.requestedSpeed = SpeedIn;

// set appropriate value for output variable
            if (SpeedIn > this.actualSpeed) {
                signalOut = Signal.INCREASE;
            }
            if (SpeedIn < this.actualSpeed) {
                signalOut = Signal.DECREASE;
            }
            if(SpeedIn==0){
                signalOut=Signal.BRAKE;
            }
            return signalOut;
        }
        else {
            System.out.print("Speed is out of range.Enter speed within range 0 - 100 MPH.\n");
            return (signalOut);
        }
    }
}
