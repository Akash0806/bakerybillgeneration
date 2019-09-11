package test.java.builder;

import main.java.builder.CustomerOrderProcessor;
import main.java.pack.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CustomerOrderProcessorTest {

    CustomerOrderProcessor orderBuilder;

    @Before
    public void setUp() throws Exception {
        orderBuilder = new CustomerOrderProcessor();
    }

    @Test
    public void getBestPackCombination_WhenPacksSizeThree_ExpectedMapSizeTwo() {
        List<Pack> packs = new ArrayList();
        Pack twopack = new PackOfTwo(9.95f);
        packs.add(twopack);
        Pack fivePack = new PackOfFive(16.95f);
        packs.add(fivePack);
        Pack eightPack = new PackOfEight(24.95f);
        packs.add(eightPack);
        Map<Integer, Pack> map = orderBuilder.getPossiblePackCombination(packs, 14);
        assertTrue(map.size() == 2);
        assertThat(map.get(1), is(equalTo(eightPack)));
        assertThat(map.get(3), is(equalTo(twopack)));
    }

    @Test
    public void getBestPackCombination_WhenPacksSizeTwo_ExpectedMapSizeOne() {

        List<Pack> packs = new ArrayList();
        Pack threePack = new PackOfThree(6.99f);
        packs.add(threePack);
        Pack fivePack = new PackOfFive(8.99f);
        packs.add(fivePack);
        Map<Integer, Pack> map = orderBuilder.getPossiblePackCombination(packs, 10);
        assertTrue(map.size() == 1);
        assertThat(map.get(2), is(equalTo(fivePack)));
    }

    @Test
    public void getBestPackCombination_WhenInputThree_ExpectedMapSizeOne() {

        List<Pack> packs = new ArrayList();
        Pack threePack = new PackOfThree(6.99f);
        packs.add(threePack);
        Pack fivePack = new PackOfFive(8.99f);
        packs.add(fivePack);
        Map<Integer, Pack> map = orderBuilder.getPossiblePackCombination(packs, 3);
        assertTrue(map.size() == 1);
        assertThat(map.get(1), is(equalTo(threePack)));
    }

    @Test
    public void getBestPackCombination_WhenPacksSizeTwo_ExpectedMapSizeTwo() {

        List<Pack> packs = new ArrayList();
        Pack threePack = new PackOfThree(5.95f);
        packs.add(threePack);
        Pack fivePack = new PackOfFive(9.95f);
        packs.add(fivePack);
        Pack packOfnine = new PackOfNine(16.99f);
        packs.add(packOfnine);
        Map<Integer, Pack> map = orderBuilder.getPossiblePackCombination(packs, 13);
        assertTrue(map.size() == 2);
        assertThat(map.get(2), is(equalTo(fivePack)));
        assertThat(map.get(1), is(equalTo(threePack)));
    }
}