import java.util.Random;

public abstract class HashTable {
  Random rand = new Random();
  int capacity;
  int numEntries;
  Entry[] arr;
  int[] s;
  int k;

  public abstract boolean put(int flowId);

  public abstract void generateKHashFunctions();

}
