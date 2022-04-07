public class FilmManager {

    int manLimit = 10;
    private String[] films = new String[0];

    public FilmManager() {
    }

    public FilmManager(int manLimit) {
        this.manLimit = manLimit;
    }

    public String[] findLast() {
        int resultLength;
        if (films.length > manLimit) {
            resultLength = manLimit;
        } else {
            resultLength = films.length;
        }
        String[] result = new String[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }

    public void setFilms(String[] films) {
        this.films = films;
    }

    public void add(String film) {
        int length = films.length + 1;
        String[] tmp = new String[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public String[] findAll() {
        return films;
    }

}
