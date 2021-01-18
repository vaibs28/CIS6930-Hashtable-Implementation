import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class ApplicationRunner {

  static final int FLOWS = 1000;
  static Random rand = new Random();

  public static void main(String[] args) {
    // Generate flowIds for each flow randomly and try to put in the hashtable
    HashTable map = null;
    Scanner sc = new Scanner(System.in);
    System.out.println("Select the hash table implementation");
    System.out.println("1.Multi Hashing Table\n2.Cuckoo Hash Table\n3.d left hash table");
    int choice = sc.nextInt();

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
        System.out.println("Terminated");
        System.exit(0);
    }

    sc.close();
    for (int i = 0; i < FLOWS; i++) {
      int flowId = Math.abs(rand.nextInt());
      map.put(flowId);
    }

    try {
      printResults(map, choice);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }// main



  private static void printResults(HashTable map, int choice) throws IOException {
    File myObj = new File("output" + choice + ".txt");
    if (!myObj.exists())
      myObj.createNewFile();
    FileWriter myWriter = new FileWriter("output" + choice + ".txt");
    myWriter.write("Number of flows in the hashtable = " + map.numEntries);
    myWriter.write("\n");
    System.out.println("Number of flows in the hashtable = " + map.numEntries);
    if (map.getClass().getName().equals("MultiHashTable")
        || map.getClass().getName().equals("CuckooHashTable")) {
      for (int i = 0; i < map.capacity; i++) {
        if (map.arr[i] != null) {
          myWriter.write(Integer.toString(map.arr[i].flowId) + "\n");
          System.out.println(map.arr[i].flowId);

        } else {
          myWriter.write(Integer.toString(0) + "\n");
          System.out.println(0);
        }
      }
    } else {
      // d left hash table
      DLeftHashTable ht = new DLeftHashTable(1000, 4);
      for (int i = 0; i < FLOWS; i++) {
        int flowId = Math.abs(rand.nextInt());
        ht.put(flowId);
      }
      for (int i = 0; i < ht.segments; i++) {
        Segment segment = ht.segmentArr[i];
        for (int j = 0; j < segment.capacity; j++) {
          if (segment != null && segment.arr[j] != null) {
            System.out.println(segment.arr[j].flowId);
            myWriter.write(Integer.toString(segment.arr[j].flowId) + "\n");
          } else {
            System.out.println(0);
            myWriter.write(Integer.toString(0) + "\n");
          }
        }
      }
    }
    myWriter.close();
  }

}// class
