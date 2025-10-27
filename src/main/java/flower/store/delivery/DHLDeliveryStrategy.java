package flower.store.delivery;

import flower.store.businessmodel.Item;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DHLDeliveryStrategy implements Delivery {
    @Override
    public String deliver(List<Item> items) {
        return "Order sent via DHL Express.";
    }
    @Override
    public String getMethodName() { return "DHL Express"; }
}