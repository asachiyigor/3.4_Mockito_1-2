package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.FilmsItem;
import ru.netology.repository.FilmRepo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FilmManagerTest {

    @Mock
    private FilmRepo repository;
    @InjectMocks
    private FilmManager manager;

    private FilmsItem first = new FilmsItem(1, "Последний богатырь: Корень зла");
    private FilmsItem second = new FilmsItem(2, "Ассасин: Битва миров");
    private FilmsItem third = new FilmsItem(3, "Мортал Комбат");
    private FilmsItem fourth = new FilmsItem(4, "Шан-Чи и легенда десяти колец");


    @Test
    public void shouldAddNewMovie() {
        FilmsItem[] returned = new FilmsItem[]{first, second, third, fourth};
        doReturn(returned).when(repository)
                          .findAll();

        manager.add(fourth);

        FilmsItem[] actual = manager.findAll();
        FilmsItem[] expected = {first, second, third, fourth};

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void shouldFindAllFilms() {
        FilmsItem[] returned = new FilmsItem[]{first, second, third, fourth};
        doReturn(returned).when(repository)
                          .findAll();

        FilmsItem[] actual = manager.findAll();
        FilmsItem[] expected = {first, second, third, fourth};

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void shouldFindLast() {
        FilmsItem[] returned = new FilmsItem[]{first};
        doReturn(returned).when(repository)
                          .findAll();

        FilmsItem[] actual = manager.findLast();
        FilmsItem[] expected = {first};

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }
}