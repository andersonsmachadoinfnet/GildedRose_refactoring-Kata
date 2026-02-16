package com.gildedrose;

public class NormalItemUpdater implements ItemUpdater{
    @Override
    public void updateItem(Item item) {
        decreaseQuality(item, 1);
        item.sellIn--;

        if (item.sellIn < 0){
            decreaseQuality(item, 1);
        }
    }

    @Override
    public boolean isEqual(String descricao) {
        return true;
    }

    private void decreaseQuality(Item item, int amount) {
        item.quality = Math.max(0, item.quality - amount);
    }
}
