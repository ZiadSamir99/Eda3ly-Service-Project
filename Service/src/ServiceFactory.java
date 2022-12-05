public class ServiceFactory {
    public Services createService(String Service)
    {
        if (Service == null || Service.isEmpty())
            return null;
        switch (Service) {
            case "recharge":
                return MobileRecharge.getInstance();
            case "Internet":
                return Internet.getInstance();
            case "internet":
                return Internet.getInstance();
            case "Recharge":
                return MobileRecharge.getInstance();
            default:
                throw new IllegalArgumentException("Unknown service "+Service);
        }
    }
}
