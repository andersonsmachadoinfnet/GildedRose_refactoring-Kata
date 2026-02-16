package com.gildedrose;

import java.util.ArrayList;

/*
    Respostas para a questão 5 - Avaliação Final de Design.
    a) A estrutura atual facilita a adição de novos tipos de item? Justifique com base no Princípio Aberto-Fechado.
       Sim, pois basta criar uma nova classe de item especializada e incluir na lista de updaters que o motor irá
       funcionar adequadamente. A classe então está aberta para extensão (novos itens), mas fechada para modificação.

    b) A implementação dos ItemUpdater respeita o Princípio da Responsabilidade Única? Explique.
       Sim, pois cada classe que a implementa faz SOMENTE a atualização dos valores. Não há outra funcionalidade
       forçada para cada classe. A classe faz uma única coisa.

    c) Alguma violação do Princípio de Substituição de Liskov pode ser identificada em sua hierarquia? Se sim, corrija-a
       Não vi violação desta regra no código, tendo em vista que a lista de itens é do tipo ItemUpdater (que é uma
       interface), então as subclasses já estão sendo substituídas pela superclasse (que no caso mais moderno é
       uma interface)
 */

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
