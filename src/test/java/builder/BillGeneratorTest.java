package test.java.builder;

import main.java.builder.BillGenerator;
import main.java.model.OrderSummary;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BillGeneratorTest {
    BillGenerator billGenerator;
    @Before
    public void setup(){
        billGenerator = new BillGenerator(false);
    }

    @Test
    public void generateBill_ReadFromFile_ExpectedOrderSummary(){
            billGenerator.generateBill();
            List<OrderSummary> orderSummaries = billGenerator.getOrderSummaries();
            Assert.assertTrue(orderSummaries.size()==3);
    }

}
