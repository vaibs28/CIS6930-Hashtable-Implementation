
public abstract class HashTable {
  int capacity;
  int numEntries;
  Entry[] arr;
  int[] s;
  int k;

  public abstract boolean put(int flowId);

  public abstract void generateKHashFunctions();

}
