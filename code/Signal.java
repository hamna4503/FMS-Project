public class Signal {
    private int value;

    public static final Signal INCREASE = new Signal (0);
    public static final Signal DECREASE=new Signal (1);
    public static final Signal DO_NOTHING=new Signal (2);
    public static final Signal BRAKE=new Signal (3);


    private Signal(int x){
    this.value = x;
    }

public String toString()
{
    switch (this.value)
    {
        case 0: return ("Signaling Increase of Speed...");
        case 1: return ("Signaling Decrease of Speed...");
        case 3: return ("Signaling Brake...");
        default: return ("Signaling No Change...");
    }
}
public int getValue(){
        return(this.value);
}
}

