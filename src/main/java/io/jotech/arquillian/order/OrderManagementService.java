package io.jotech.arquillian.order;

public interface OrderManagementService {
    boolean addItem(String item);

    boolean removeItem(String item);

    boolean updateItem(String string);


}
