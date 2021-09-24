package com.techelevator.dao;

import com.techelevator.model.Food;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.List;

public class JdbcFoodDaoTests extends FinalCapstoneDaoTests{

    private static final Food Food_A = new Food(1, "Pillsbury Golden Layer Buttermilk Biscuits Artificial Flavor Refrigerated Dough", 307, new BigDecimal("13.24"),new BigDecimal("5.88"), new BigDecimal("41.18"), "1 serving", "Baked Foods");
    private static final Food Food_B = new Food(2, "Pillsbury Cinnamon Rolls With Icing Refrigerated Dough", 330, new BigDecimal("11.27"), new BigDecimal("4.34"), new BigDecimal("53.42"), "1 serving 1 roll with icing)", "Baked Foods");
    private static final Food Food_C = new Food(3, "Kraft Foods Shake N Bake Original Recipe Coating For Pork Dry", 377, new BigDecimal("3.70"), new BigDecimal("6.10"), new BigDecimal("79.80"), "1 serving", "Baked Foods");
    private static final Food Food_D = new Food(4, "George Weston Bakeries Thomas English Muffins", 232, new BigDecimal("1.80"), new BigDecimal("8.00"), new BigDecimal("46.00"), "1 serving", "Baked Foods");
    private static final Food Food_E = new Food(6, "Waffle Buttermilk Frozen Ready-To-Heat Toasted", 309, new BigDecimal("9.49"), new BigDecimal("7.42"), new BigDecimal("48.39"), "1 oz", "Baked Foods");


    private JdbcFoodDao sut;



    @Before
     public void setup() {
        DataSource dataSource = this.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcFoodDao(jdbcTemplate);

    }

    @Test
    public void getAllFoods_returns_all_food() {
        List<Food> foods = sut.getAllFood();

        Assert.assertEquals(5, foods.size());

        assertFoodsMatch(Food_A, foods.get(0));
        assertFoodsMatch(Food_B, foods.get(1));
        assertFoodsMatch(Food_C, foods.get(2));
        assertFoodsMatch(Food_D, foods.get(3));
        assertFoodsMatch(Food_E, foods.get(4));


    }

    @Test
    public void getFoodById_returns_correct_food_for_id() {
        Food food = sut.getFoodById(1);
        assertFoodsMatch(Food_A, food);

        food = sut.getFoodById(2);
        assertFoodsMatch(Food_B, food);

    }

    @Test
    public void getFoodById_returns_null_when_id_is_not_found() {
        Food food = sut.getFoodById(150);
        Assert.assertNull(food);

        food = sut.getFoodById(100);
        Assert.assertNull(food);
    }
/*

    @Test
    public void getFoodByName_returns_correct_food_by_name() {
        Food food = sut.getFoodByName("Pillsbury Golden Layer Buttermilk Biscuits Artificial Flavor Refrigerated Dough");
        Assert.assertEquals(Food_A, food);

        food = sut.getFoodByName("Waffle Buttermilk Frozen Ready-To-Heat Toasted");
        Assert.assertEquals(Food_E, food);

    }

    @Test
    public void getFoodByName_returns_null_when_name_is_not_found() {
        Food food = sut.getFoodByName("Chicken Burger");
        Assert.assertNull(food);

        food = sut.getFoodByName("Moon pie");
        Assert.assertNull(food);
    }
*/


    private void assertFoodsMatch(Food expected, Food actual) {
        Assert.assertEquals(expected.getFood_id(), actual.getFood_id());
        Assert.assertEquals(expected.getFood_name(), actual.getFood_name());
        Assert.assertEquals(expected.getCalories(), actual.getCalories());
        Assert.assertEquals(expected.getFat(), actual.getFat());
        Assert.assertEquals(expected.getProtein(), actual.getProtein());
        Assert.assertEquals(expected.getCarbohydrate(), actual.getCarbohydrate());
        Assert.assertEquals(expected.getServing_size(), actual.getServing_size());
        Assert.assertEquals(expected.getFood_group(), actual.getFood_group());

    }



}
