package manager;

import domain.Book;
import domain.Product;
import domain.SmartPhone;
import repository.ProductRepository;

public class ManagerProduct {
    int numberDisplayedFilms = 10;
    private ProductRepository repository;

    public ManagerProduct(ProductRepository repository) {
        this.repository = repository;
    }

    public ManagerProduct(int numberDisplayedFilms) {
        this.numberDisplayedFilms = numberDisplayedFilms;
    }

    public void setNumberDisplayedFilms(int numberDisplayedFilms) {
        this.numberDisplayedFilms = numberDisplayedFilms;
    }

    public int getNumberDisplayedFilms() {
        return numberDisplayedFilms;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public void remove(int id) {
        repository.removeById(id);
    }

    public Product[] findAll() {
        return repository.findAll();
    }

    public void removeALl() {
        repository.removeAll();
    }

    public Product[] findAllFixReverse() {
        Product[] product = repository.findAll();
        int resultLength;
        if (product.length < numberDisplayedFilms) {
            resultLength = product.length;
        } else {
            resultLength = numberDisplayedFilms;
        }
        Product[] tmp = new Product[resultLength];
        for (int i = product.length - resultLength; i < product.length; i++) {
            int index = product.length - i + (product.length - resultLength - 1);
            tmp[i - (product.length - resultLength)] = product[index];
        }
        return tmp;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) { // если в параметре product лежит объект класса Book
            Book book = (Book) product; // положем его в переменную типа Book чтобы пользоваться методами класса Book
            if (book.getAuthor().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            if (book.getName().contains(search)) {
                return true;
            }
            return false;
        }
        if (product instanceof SmartPhone) {
            SmartPhone smartphone = (SmartPhone) product;
            if (smartphone.getManufacturer().contains(search)) {
                return true;
            }
            if (smartphone.getName().contains(search)) {
                return true;
            }
            return false;
        }

        return false;
    }
}



