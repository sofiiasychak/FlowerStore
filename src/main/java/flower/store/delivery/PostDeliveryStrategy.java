package flower.store.delivery;

import flower.store.businessmodel.Item;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class PostDeliveryStrategy implements Delivery {
    @Override
    public String deliver(List<Item> items) {
        return "Order sent via Local Post. ";
    }
    @Override
    public String getMethodName() { return "Local Post"; }
}