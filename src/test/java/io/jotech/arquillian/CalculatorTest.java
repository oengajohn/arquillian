package io.jotech.arquillian;

import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import io.jotech.arquillian.util.ArquillianWarUtils;


@ExtendWith(ArquillianExtension.class)
class CalculatorTest {
    @Deployment
    public static Archive<?> createTestArchive() {
        var archive= ArquillianWarUtils.getBasicWebArchive()
                .addClasses(Calculator.class,CalculatorImpl.class);
        System.out.println(archive.toString(true));
        return archive;
    }

    @Inject
    private Calculator calculator;

    @Test
    public void add() {
        assertNotNull(calculator);
        //given
        var a = 12;
        var b = 14;
        var numbers = new int[]{};
        //when
        var actual = calculator.add(a,b,numbers);
        //then
        var expected = 26;
        assertEquals(expected,actual);
    }


}