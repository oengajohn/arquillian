package io.jotech.arquillian.order;

import javax.ejb.EJB;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ArquillianExtension.class)
class OrderManagementServiceTest {
    @Deployment
    public static Archive<?> createDeployment(){
        var archive = ShrinkWrap
                .create(WebArchive.class,"test.war")
                .addClasses(
                        OrderManagementService.class,
                        OrderManagementServiceImpl.class
                ).addAsWebInfResource(EmptyAsset.INSTANCE,"beans.xml");
        System.out.println(archive.toString(true));
        return archive;
    }
    @EJB
    private OrderManagementService orderManagementService;

    @Test
    void addItem() {
        var test1 = orderManagementService.addItem("Test1");
        assertTrue(test1);

    }

    @Test
    void removeItem() {
    }

    @Test
    void updateItem() {
    }
}