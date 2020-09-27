import java.util.Random;
import java.util.Scanner;

public class ApplicationRunner {

  static final int FLOWS = 1000;

  public static void main(String[] args) {
    // Generate flowIds for each flow randomly and try to put in the hashtable
    HashTable map = null;
    Scanner sc = new Scanner(System.in);
    System.out.println("Select the hash table implementation");
    System.out.println("1.Multi Hashing Table\n2.Cuckoo Hash Table\n3.d left hash table");
    int choice = sc.nextInt();
    sc.close();
    switch (choice) {
      case 1:
        map = new MultiHashTable(1000, 3);
        break;

      case 2:
        map = new CuckooHashTable(1000, 3, 2);
        break;

      case 3:
        map = new DLeftHashTable(1000, 4);
        break;

      default:
        System.exit(0);
    }

    for (int i = 0; i < FLOWS; i++) {
      int flowId = Math.abs(new Random().nextInt());
      map.put(flowId);
    }

    // outputs
    System.out.println("Number of flows in the hashtable = " + map.numEntries);
    if (map.getClass().getName().equals("MultiHashTable")
        || map.getClass().getName().equals("CuckooHashTable")) {
      for (int i = 0; i < map.capacity; i++) {
        if (map.arr[i] != null) {
          System.out.println("Flow Id=" + map.arr[i].flowId);
        } else {
          System.out.println(0);
        }
      }
    } else {
      // d left hash table
      DLeftHashTable ht = new DLeftHashTable(1000, 4);
      for (int i = 0; i < FLOWS; i++) {
        int flowId = Math.abs(new Random().nextInt());
        ht.put(flowId);
      }
      for (int i = 0; i < ht.segments; i++) {
        Segment segment = ht.segmentArr[i];
        for (int j = 0; j < segment.capacity; j++) {
          if (segment != null && segment.arr[j] != null)
            System.out.println("Flow Id=" + segment.arr[j].flowId);
          else
            System.out.println(0);
        }
      }
    }

  }

}
