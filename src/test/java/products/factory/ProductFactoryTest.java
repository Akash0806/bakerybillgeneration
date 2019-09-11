package test.java.products.factory;

import main.java.model.Product;
import main.java.products.factory.ProductFactory;
import main.java.products.implementation.BlueberryMuffin;
import main.java.products.implementation.Croissant;
import main.java.products.implementation.VegemiteScroll;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class ProductFactoryTest {
 ProductFactory productFactory = ProductFactory.getInstance();

 @Test
 public void getProduct_WhenProductCodeIsNull_ExpectedNull(){
     Product product = productFactory.getProduct(null);
     assertNull(product);
 }

    @Test
    public void getProduct_WhenProductCodeIsEmpty_ExpectedNull(){
        Product product = productFactory.getProduct("");
        assertNull(product);
    }

    @Test
    public void getProduct_WhenProductCodeIsInvaild_ExpectedNull(){
        Product product = productFactory.getProduct("1235");
        assertNull(product);
    }

    @Test
    public void getProduct_WhenProductCodeIsVS5_ExpectedVegemite(){
        Product product = productFactory.getProduct("VS5");
        assertThat(product, instanceOf(VegemiteScroll.class));
    }

    @Test
    public void getProduct_WhenProductCodeIsMB11_ExpectedBlueberry(){
        Product product = productFactory.getProduct("MB11");
        assertThat(product, instanceOf(BlueberryMuffin.class));
    }
    @Test
    public void getProduct_WhenProductCodeIsCF_ExpectedCroissant(){
        Product product = productFactory.getProduct("CF");
        assertThat(product, instanceOf(Croissant.class));
    }



}