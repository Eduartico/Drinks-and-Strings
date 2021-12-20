public class FerengiClient extends AlienClient
{ @Override
    public OrderingStrategy createOrderingStrategy() {return new SmartStrategy();}
}