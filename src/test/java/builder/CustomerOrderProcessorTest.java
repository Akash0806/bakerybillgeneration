package test.java.builder;

import main.java.Exception.InvalidProduct;
import main.java.builder.CustomerOrderProcessor;
import main.java.pack.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CustomerOrderProcessorTest {

    CustomerOrderProcessor customerOrderProcessor;

    @Before
    public void setUp() throws Exception {
        customerOrderProcessor = new CustomerOrderProcessor();
    }

    @Test
    public void getBestPackCombination_WhenMB11Quantity14_ExpectedMapSizeTwo() {
        float v = 9.95f;
        float v1 = 16.95f;
        float v2 = 24.95f;
        List<Pack> packs = new ArrayList();
        Pack twopack = getTwopack(v);
        packs.add(twopack);
        Pack fivePack = getFivePack(v1);
        packs.add(fivePack);
        Pack eightPack = getEightPack(v2);
        packs.add(eightPack);
        Map<Pack,Integer> map = customerOrderProcessor.getPossiblePackCombination(packs, 14);
        assertTrue(map.size() == 2);
        assertThat(map.get(twopack), is(3));
        assertThat(map.get(eightPack), is(1));
    }




    @Test
    public void getBestPackCombination_WhenMB11Quantity31_ExpectedMapZero() {
        List<Pack> packs = new ArrayList();
        Pack twopack = getTwopack(9.95f);
        packs.add(twopack);
        Pack fivePack = getFivePack(16.95f);
        packs.add(fivePack);
        float v3 = 24.95f;
        Pack eightPack = getEightPack(v3);
        packs.add(eightPack);
        Map<Pack,Integer> map = customerOrderProcessor.getPossiblePackCombination(packs, 31);
        assertTrue(map.size() == 0);

    }


    @Test
    public void getBestPackCombination_WhenVS5Quantity10_ExpectedMapSizeOne() {

        List<Pack> packs = new ArrayList();
        Pack threePack = new PackOfThree(6.99f);
        packs.add(threePack);
        Pack fivePack = getFivePack(8.99f);
        packs.add(fivePack);
        Map<Pack,Integer> map = customerOrderProcessor.getPossiblePackCombination(packs, 10);
        assertTrue(map.size() == 1);
        assertThat(map.get(fivePack), is(equalTo(2)));
    }

    @Test
    public void getBestPackCombination_WhenVS5Quantity2_ExpectedMapSizeZero() {

        List<Pack> packs = new ArrayList();
        Pack threePack = new PackOfThree(6.99f);
        packs.add(threePack);
        Pack fivePack = getFivePack(8.99f);
        packs.add(fivePack);
        Map<Pack,Integer> map = customerOrderProcessor.getPossiblePackCombination(packs, 2);
        assertTrue(map.size() == 0);
    }

    @Test
    public void getBestPackCombination_WhenVS5Quantity3_ExpectedMapSizeOne() {

        List<Pack> packs = new ArrayList();
        Pack threePack = new PackOfThree(6.99f);
        packs.add(threePack);
        Pack fivePack = getFivePack(8.99f);
        packs.add(fivePack);
        Map<Pack,Integer> map = customerOrderProcessor.getPossiblePackCombination(packs, 3);
        assertTrue(map.size() == 1);
        assertThat(map.get(threePack), is(equalTo(1)));
    }

    @Test
    public void getBestPackCombination_WhenCFQuantity13_ExpectedMapSizeTwo() {

        List<Pack> packs = new ArrayList();
        Pack threePack = new PackOfThree(5.95f);
        packs.add(threePack);
        Pack fivePack = getFivePack(9.95f);
        packs.add(fivePack);
        Pack packOfnine = new PackOfNine(16.99f);
        packs.add(packOfnine);
        Map<Pack,Integer> map = customerOrderProcessor.getPossiblePackCombination(packs, 13);
        assertTrue(map.size() == 2);
        assertThat(map.get(fivePack), is(equalTo(2)));
        assertThat(map.get(threePack), is(equalTo(1)));
    }

    @Test
    public void getTotalCost_WhenInputNull_ExpectedTotalZero(){
        assertTrue( customerOrderProcessor.getTotalCost(null)==0);
    }

    @Test
    public void getTotalCost_WhenInputEmpty_ExpectedTotalZero(){
        assertTrue( customerOrderProcessor.getTotalCost(null)==0);
    }

    @Test
    public void getTotalCost_WhenInputNotEmpty_ExpectedTotalZero(){
        Map<Pack,Integer> map = new HashMap<>();
        Pack pack3 = new PackOfThree(5.95f);
        map.put(pack3,2);
        Pack pack2 = new PackOfTwo(9.95f);
        map.put(pack2,2);
        assertThat(customerOrderProcessor.getTotalCost(map),is(31.8f));
    }

    @Test(expected = InvalidProduct.class)
    public void vaildateProduct_WhenProductEmpty_ExpectedInvalidProduct(){
           customerOrderProcessor.vaildateProduct("",3);
    }

    @Test(expected = RuntimeException.class)
    public void vaildateProduct_WhenProductEmpty_ExpectedRuntimeException(){
        customerOrderProcessor.vaildateProduct("",0);
    }
    @Test(expected = InvalidProduct.class)
    public void vaildateProduct_WhenProductIsNotAvailable_ExpectedInvalidProduct(){
        customerOrderProcessor.vaildateProduct("VS6",5);
    }




    private PackOfFive getFivePack(float v1) {
        return new PackOfFive(v1);
    }

    private PackOfTwo getTwopack(float v) {
        return new PackOfTwo(v);
    }

    private PackOfEight getEightPack(float v3) {
        return new PackOfEight(v3);
    }

}