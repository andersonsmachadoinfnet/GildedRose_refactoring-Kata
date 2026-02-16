package com.gildedrose;

import java.util.ArrayList;

class GildedRose {
    Item[] items;
    private ArrayList<ItemUpdater> updaters = new ArrayList<>();

    public GildedRose(Item[] items) {
        this.items = items;
        updaters.add(new AgedBrieUpdater());
        updaters.add(new BackstagePassUpdater());
        updaters.add(new SulfurasUpdater());
        updaters.add(new ConjuredUpdater());
    }

    public void updateQuality() {
        for (Item item : items) {
            getItemUpdater(item.name).updateItem(item);
        }
    }

    private ItemUpdater getItemUpdater(String itemName) {
        for (ItemUpdater updater : updaters) {
            if (updater.isEqual(itemName)) {
                return updater;
            }
        }
        return new DefaultUpdater();
    }
}
