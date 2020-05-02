package ood.lsp.food;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class IStorageTest {
    private List<Food> foodList = new ArrayList<>();
    private ControlQuality controlQuality;

    @Before
    public void generatedFoods() {
        Food baton = new Bread("baton", new LocalDate(2020, 4, 15), new LocalDate(2020, 5, 15));
        baton.setShelfLife(14);

        Food chicken = new Meat("chicken", new LocalDate(2020, 4, 15), new LocalDate(2020, 5, 15));
        chicken.setShelfLife(40);

        Food kefir = new Milk("kefir", new LocalDate(2020, 4, 15), new LocalDate(2020, 5, 15));
        kefir.setShelfLife(80);

        Food cola = new Water("cola", new LocalDate(2020, 4, 15), new LocalDate(2020, 5, 15));
        cola.setShelfLife(108);

        this.foodList.add(baton);
        this.foodList.add(chicken);
        this.foodList.add(kefir);
        this.foodList.add(cola);

        this.controlQuality = new ControlQuality(this.foodList);
        this.controlQuality.doControl();
    }

    @Test
    public void whenReturnShelfLife() {
        String createDate = "2020-03-20";
        String expireDate =  "2020-04-20";
        LocalDate today = LocalDate.now();

        Food food = new Food("chicken", LocalDate.parse(createDate), LocalDate.parse(expireDate));
        int periodFull = Days.daysBetween(LocalDate.parse(createDate), LocalDate.parse(expireDate)).getDays();
        int periodToday = Days.daysBetween(LocalDate.parse(createDate), today).getDays();
        Integer expected = Math.abs((periodToday * 100) / periodFull);
        assertThat(food.getShelfLife(), is(expected));
    }

    @Test
    public void whenAddToWareHouse() {
        assertThat(this.controlQuality.getFoodsFromWareHouse().get(0).getName(), is("baton"));
    }

    @Test
    public void whenAddToShop() {
        assertThat(this.controlQuality.getFoodsFromShop().get(0).getName(), is("chicken"));
    }

    @Test
    public void whenAddToShopWithDiscount() {
        assertThat(this.controlQuality.getFoodsFromShop().get(1).getName(), is("kefir"));
        assertThat(this.controlQuality.getFoodsFromShop().get(1).getDiscount(), is(25));
    }

    @Test
    public void whenAddToTrash() {
        assertThat(this.controlQuality.getFoodsFromTrash().get(0).getName(), is("cola"));
    }
}
