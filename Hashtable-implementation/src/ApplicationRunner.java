import java.util.Random;

public class ApplicationRunner {

  static final int FLOWS = 1000;

  public static void main(String[] args) {
    // Generate flowIds for each flow randomly and try to put in the hashtable
    MultiHashTable map = new MultiHashTable();

    for (int i = 0; i < FLOWS; i++) {
      int flowId = Math.abs(new Random().nextInt());
      map.put(flowId);
    }

    // outputs
    System.out.println("Number of flows in the hashtable = " + map.numEntries);
    for (int i = 0; i < map.CAPACITY; i++) {
      if (map.arr[i] != null) {
        System.out.println("Flow Id=" + map.arr[i].flowId);
      }else {
        System.out.println(0);
      }
    }
  }

}
