import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void testRemoveWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "помада", 499);
        Product product2 = new Product(11, "духи", 5499);
        Product product3 = new Product(111, "крем", 1899);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(11);

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "помада", 499);
        Product product2 = new Product(11, "духи", 5499);
        Product product3 = new Product(111, "крем", 1899);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(1111));
    }
}
