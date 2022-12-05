

public class Reciept_factory {

    public Reciepts creatReciept(String reciept) {
        if(reciept.equalsIgnoreCase("Landline"))
        {
            return new Landline();
        }
        return null;
    }
}
