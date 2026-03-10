import entity.Entity;
import service.impl.SortService;


public class Main {

    public static void main(String[] args) {
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - i;
        }
        Entity entity = new Entity(array);
        System.out.println(entity);
        SortService service = new SortService();
        service.quickSort(entity);
        System.out.println(entity);
    }
}