public class RomulanClient extends AlienClient
{ @Override
    public OrderingStrategy createOrderingStrategy() {return new ImpatientStrategy();}
}
