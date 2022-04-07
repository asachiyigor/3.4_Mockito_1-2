package ru.netology.manager;

import ru.netology.domain.FilmsItem;
import ru.netology.repository.FilmRepo;

public class FilmManager {
    private FilmRepo repository;
    int manLimit = 10;

    public FilmManager() {
    }

    public FilmManager(int manLimit) {
        this.manLimit = manLimit;
    }

    public FilmManager(FilmRepo repository) {
        this.repository = repository;
    }

    public void add(FilmsItem item) {
        repository.save(item);
    }

    public FilmsItem[] findLast() {
        FilmsItem[] films = repository.findAll();
        int resultLength;
        if (films.length > manLimit) {
            resultLength = manLimit;
        } else {
            resultLength = films.length;
        }
        FilmsItem[] result = new FilmsItem[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }

    public FilmsItem[] findAll() {
        return repository.findAll();
    }
}
