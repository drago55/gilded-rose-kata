package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            boolean isSulfuras = items[i].name.equals("Sulfuras, Hand of Ragnaros");
            boolean aged_brie = items[i].name.equals("Aged Brie");
            boolean isBackstagePasses = items[i].name.equals("Backstage passes to a TAFKAL80ETC concert");
            boolean isConjured = items[i].name.equals("conjured");
            boolean isGeneric = !isSulfuras && !aged_brie && !isBackstagePasses && !isConjured;

            if (isSulfuras) {
                continue;
            }
            items[i].sellIn = items[i].sellIn - 1;

            boolean isExpired = items[i].sellIn < 0;
            boolean maxQualityReached = items[i].quality < 50;

            if (isGeneric) {
                setQualityGreaterThanZero(items[i]);
                if (isExpired) {
                    setQualityGreaterThanZero(items[i]);
                }
            }

            if (aged_brie) {
                if (maxQualityReached) {
                    increaseQuality(items[i]);
                }
            }

            if (isBackstagePasses) {
                increaseQuality(items[i]);

                if (items[i].sellIn < 11) {
                    increaseQuality(items[i]);
                }


                if (items[i].sellIn < 6) {
                    increaseQuality(items[i]);
                }

                if (isExpired) {
                    items[i].quality = 0;
                }
            }

            if (isConjured) {

                decreaseQuality(items[0]);
                decreaseQuality(items[0]);

                if (isExpired) {
                    items[i].quality = 0;
                }
            }


        }

    }


    private void setQualityGreaterThanZero(Item item) {
        if (item.quality > 0) {
            decreaseQuality(item);
        }
    }

    private void decreaseQuality(Item item) {
        item.quality = item.quality - 2;
    }

    private void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }

}