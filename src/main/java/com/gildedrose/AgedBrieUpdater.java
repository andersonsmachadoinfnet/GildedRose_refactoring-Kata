package com.gildedrose;

public class AgedBrieUpdater implements ItemUpdater {
    @Override
    public void updateItem(Item item) {
        increaseQuality(item, 1);
        item.sellIn--;

        if (item.sellIn < 1) {
            increaseQuality(item, 1);
        }
    }

    @Override
    public boolean isEqual(String descricao) {
        return descricao.equals(Constantes.ITEM_AGEDBRIE);
    }

    private void increaseQuality(Item item, int amount) {
        item.quality = Math.min(50, item.quality + amount);
    }
}
