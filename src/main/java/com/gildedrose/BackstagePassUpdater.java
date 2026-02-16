package com.gildedrose;

public class BackstagePassUpdater implements ItemUpdater {
    @Override
    public void updateItem(Item item) {
        increaseQuality(item, 1);
        if (item.sellIn <= 10) {
            increaseQuality(item, 1);
        }
        if (item.sellIn <= 5) {
            increaseQuality(item, 1);
        }
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    @Override
    public boolean isEqual(String descricao) {
        return descricao.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void increaseQuality(Item item, int amount) {
        item.quality = Math.min(50, item.quality + amount);
    }
}
