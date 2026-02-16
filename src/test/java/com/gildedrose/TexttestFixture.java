package com.gildedrose;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
                new Item(Constantes.ITEM_DEXTERIY, 10, 20), //
                new Item(Constantes.ITEM_AGEDBRIE, 2, 0), //
                new Item(Constantes.ITEM_ELIXIR, 5, 7), //
                new Item(Constantes.ITEM_SULFURAS, 0, 80), //
                new Item(Constantes.ITEM_SULFURAS, -1, 80),
                new Item(Constantes.ITEM_BACKSTAGE, 15, 20),
                new Item(Constantes.ITEM_BACKSTAGE, 10, 49),
                new Item(Constantes.ITEM_BACKSTAGE, 5, 49),
                // this conjured item does not work properly yet
                new Item(Constantes.ITEM_CONJURED, 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
