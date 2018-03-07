package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void fruitAfterOneDayPast(){

        Item[] items=new Item[]{new Item("fruit",5,5)};
        GildedRose app=new GildedRose(items);
        app.updateQuality();
        assertEquals(4,items[0].sellIn);
        assertEquals(4, items[0].quality);
    }

    @Test
    public void fruitExpiredQualityTwiceAsFast(){
        Item[] items=new Item[]{new Item("fruit",0,5)};
        GildedRose app=new GildedRose(items);
        app.updateQuality();
        assertEquals(-1,items[0].sellIn);
        assertEquals(3, items[0].quality);

    }

    @Test
    public void fruitQualityZero(){
        Item[] items=new Item[]{new Item("fruit",5,0)};
        GildedRose app=new GildedRose(items);
        app.updateQuality();
        assertEquals(4,items[0].sellIn);
        assertEquals(0, items[0].quality);

    }

    @Test
    public void agedBrieIcreasesQuality(){
        Item[] items=new Item[]{new Item("Aged Brie",10,5)};
        GildedRose app=new GildedRose(items);
        app.updateQuality();
        assertEquals(9,items[0].sellIn);
        assertEquals(6, items[0].quality);

    }
    @Test
    public void agedBrieQualityNoMoreThanFifty(){
        Item[] items=new Item[]{new Item("Aged Brie",10,50)};
        GildedRose app=new GildedRose(items);
        app.updateQuality();
        assertEquals(9,items[0].sellIn);
        assertEquals(50, items[0].quality);

    }

    @Test
    public void sulfurasNeverGetOld(){

        Item[] items=new Item[]{new Item("Sulfuras, Hand of Ragnaros",5,5)};
        GildedRose app=new GildedRose(items);
        app.updateQuality();
        assertEquals(5,items[0].sellIn);
        assertEquals(5, items[0].quality);
    }
    @Test
    public void backStagePassesBeforTenDays(){

        Item[] items=new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert",15,5)};
        GildedRose app=new GildedRose(items);
        app.updateQuality();
        assertEquals(14,items[0].sellIn);
        assertEquals(6, items[0].quality);
    }

    @Test
    public void backStagePassesAfterTenDays(){

        Item[] items=new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert",10,5)};
        GildedRose app=new GildedRose(items);
        app.updateQuality();
        assertEquals(9,items[0].sellIn);
        assertEquals(7, items[0].quality);
    }
    @Test
    public void backStagePassesAfterFiveDays(){

        Item[] items=new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert",5,5)};
        GildedRose app=new GildedRose(items);
        app.updateQuality();
        assertEquals(4,items[0].sellIn);
        assertEquals(8, items[0].quality);
    }
    @Test
    public void backStagePassesExpired(){

        Item[] items=new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert",0,5)};
        GildedRose app=new GildedRose(items);
        app.updateQuality();
        assertEquals(-1,items[0].sellIn);
        assertEquals(0, items[0].quality);
    }
    @Test
    public void conjuredItemDegradesTwiceAsFast(){
        Item[] items=new Item[]{new Item("conjured",10,5)};
        GildedRose app=new GildedRose(items);
        app.updateQuality();
        assertEquals(9,items[0].sellIn);
        assertEquals(3, items[0].quality);

    }
    @Test
    public void conjuredItemExpiredQualityZero(){
        Item[] items=new Item[]{new Item("conjured",0,5)};
        GildedRose app=new GildedRose(items);
        app.updateQuality();
        assertEquals(-1,items[0].sellIn);
        assertEquals(0, items[0].quality);

    }


}
