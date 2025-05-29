package ai.tribty.misc.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

record SuperHero(String id, String name, int age) implements Comparable<SuperHero> {
    /* class constructor */

    @Override
    public int compareTo(final SuperHero superHero) {
        return this.id.compareTo(superHero.id);
    }

    @Override
    public String toString() {
        return String.format("ID: %s | name: %s | Age: %d", id, name, age);
    }

    public static void main(String[] args) {
        List<SuperHero> superHeroes = new ArrayList<>();

        superHeroes.add(new SuperHero("2", "Iron Man", 35));
        superHeroes.add(new SuperHero("1", "Captain America", 25));
        superHeroes.add(new SuperHero("3", "Hulk", 20));

        // Collections.sort(superHeroes);
        superHeroes.sort(Comparator.reverseOrder());
        /* printing result */
        for (SuperHero superHero : superHeroes) {
            System.out.println(superHero.toString());
        }
    }
}
