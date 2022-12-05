
public class Landline implements Reciepts{
    Duration duration;
    @Override
    public double CalBills() {
        return duration.cost();
    }

    @Override
    public void SetDuration(Duration dur) {

        duration = dur;
        duration.printDuration();
    }


}
