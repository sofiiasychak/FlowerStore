package flower.store.delivery;

import flower.store.businessmodel.Item;
import java.util.List;

public interface Delivery {
    String deliver(List<Item> items);
    String getMethodName();
}