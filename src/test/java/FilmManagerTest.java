import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FilmManagerTest {

    @Test
    void shouldAddIfAlreadyContains() {

        FilmManager film = new FilmManager();

        film.setFilms(new String[]{"1. Последний богатырь: Корень зла", "2. Ассасин: Битва миров", "3. Мортал Комбат", "4. Шан-Чи и легенда десяти колец", "5. Гнев человеческий", "6. В метре друг от друга", "7. Во всё тяжкое"});

        String[] expected = {"1. Последний богатырь: Корень зла", "2. Ассасин: Битва миров", "3. Мортал Комбат", "4. Шан-Чи и легенда десяти колец", "5. Гнев человеческий", "6. В метре друг от друга", "7. Во всё тяжкое"};
        String[] actual = film.findAll();

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindLast3Films() {

        FilmManager film = new FilmManager(3);

        film.setFilms(new String[]{"1. Последний богатырь: Корень зла", "2. Ассасин: Битва миров", "3. Мортал Комбат", "4. Шан-Чи и легенда десяти колец", "5. Гнев человеческий", "6. В метре друг от друга", "7. Во всё тяжкое"});

        String[] expected = {("7. Во всё тяжкое"), ("6. В метре друг от друга"), ("5. Гнев человеческий")};
        String[] actual = film.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAdd1Film() {

        FilmManager film = new FilmManager();

        film.setFilms(new String[]{"1. Последний богатырь: Корень зла", "2. Ассасин: Битва миров", "3. Мортал Комбат", "4. Шан-Чи и легенда десяти колец", "5. Гнев человеческий", "6. В метре друг от друга"});

        film.add("7. Во всё тяжкое");

        String[] expected = {"1. Последний богатырь: Корень зла", "2. Ассасин: Битва миров", "3. Мортал Комбат", "4. Шан-Чи и легенда десяти колец", "5. Гнев человеческий", "6. В метре друг от друга", "7. Во всё тяжкое"};
        String[] actual = film.findAll();

        assertArrayEquals(expected, actual);
    }
}