package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    @DisplayName("Testa o limite máximo de 50 para o item Aged Brie")
    void TestaItemAgedBrieLimite50() {
        Item[] items = new Item[] { new Item(Constantes.ITEM_AGEDBRIE, 0, 49) };
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 5; i++) {
            app.updateQuality();
            assertEquals(50, app.items[0].quality);
        }
    }

    @Test
    @DisplayName("Testa que o item Sulfura não sofre alterações")
    void TestaItemSulfurasSemAlteracao() {
        Item[] items = new Item[] { new Item(Constantes.ITEM_SULFURAS, 0, 49) };
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 5; i++) {
            app.updateQuality();
            assertEquals(49, app.items[0].quality);
        }
    }

    @Test
    @DisplayName("Testa que o item Backstage Pass zera a quantidade após a data da venda")
    void TestaItemBackstagePassZeraAQuantidade() {
        Item[] items = new Item[] { new Item(Constantes.ITEM_BACKSTAGE, 0, 49) };
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 5; i++) {
            app.updateQuality();
            assertEquals(0, app.items[0].quality);
        }
    }
    @Test
    @DisplayName("Testa que o item Conjured perde qualidade 2x mais rápido")
    void TestaItemConjuredPerdeQualidade2() {
        Item[] items = new Item[] { new Item(Constantes.ITEM_CONJURED, 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(46, app.items[0].quality);
    }
}
