package com.gildedrose;

public class ConjuredUpdater implements ItemUpdater{
    @Override
    public void updateItem(Item item) {
        decreaseQuality(item, 2);
        item.sellIn--;
        if (item.sellIn < 0){
            decreaseQuality(item, 2);
        }
    }

    @Override
    public boolean isEqual(String descricao) {
        return descricao.equals(Constantes.ITEM_CONJURED);
    }

    private void decreaseQuality(Item item, int amount) {
        item.quality = Math.max(0, item.quality - amount);
    }
}
