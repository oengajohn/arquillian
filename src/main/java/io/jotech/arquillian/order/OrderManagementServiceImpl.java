package io.jotech.arquillian.order;

import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class OrderManagementServiceImpl implements OrderManagementService {
    @Override
    public boolean addItem(String item) {
        return false;
    }

    @Override
    public boolean removeItem(String item) {
        return false;
    }

    @Override
    public boolean updateItem(String string) {
        return false;
    }
}
