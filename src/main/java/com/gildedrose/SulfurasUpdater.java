package com.gildedrose;

public class SulfurasUpdater implements ItemUpdater {
    @Override
    public void updateItem(Item item) {
        // Sufuras não tem alteração in quality ou sellIn
    }

    @Override
    public boolean isEqual(String descricao) {
        return descricao.equals(Constantes.ITEM_SULFURAS);
    }
}
