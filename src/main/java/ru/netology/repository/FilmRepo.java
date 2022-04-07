package ru.netology.repository;

import ru.netology.domain.FilmsItem;

public class FilmRepo {
    private FilmsItem[] films = new FilmsItem[1];

    public FilmsItem[] findAll() {
        return films;
    }

    public void save(FilmsItem item) {
        int length = films.length + 1;
        FilmsItem[] tmp = new FilmsItem[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        films = tmp;
    }

    public FilmsItem findById(int id) {
        for (FilmsItem item : films) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = films.length - 1;
        FilmsItem[] tmp = new FilmsItem[length];
        int index = 0;
        for (FilmsItem item : films) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        films = tmp;
    }

    public void removeAll() {
        films = new FilmsItem[0];
    }
}
