import java.util.Random;

/*
 * Define the cuckoo hash table, as an array of entries with the declared capacity
 */
public class CuckooHashTable extends HashTable {

  int c;

  public CuckooHashTable(int capacity, int k, int c) {
    this.k = k;
    this.capacity = capacity;
    this.c = c;
    s = new int[k];
    arr = new Entry[capacity];
    generateKHashFunctions();
  }

  public void generateKHashFunctions() {
    for (int i = 0; i < s.length; i++) {
      s[i] = Math.abs(new Random().nextInt());
    }
  }

  /*
   * Add to the hash table if any one of the k entries are available, else check if any of the
   * existing entries can be moved
   */
  public boolean put(int flowId) {
    for (int i = 0; i < s.length; i++) {
      int result = flowId ^ s[i];
      Entry entry = new Entry(result);
      int hash = entry.hashCode();

      if (arr[hash % capacity] == null) {
        arr[hash % capacity] = new Entry(flowId);
        numEntries++;
        return true;
      }
    }
    // check if existing entries can be moved
    for (int i = 0; i < k; i++) {
      int result = flowId ^ s[i];
      Entry entry = new Entry(result);
      int hash = entry.hashCode();
      Entry existingEntry = arr[hash % capacity];

      if (move(existingEntry, c)) {
        arr[hash % capacity] = new Entry(flowId);
        numEntries++;
        return true;
      }
    }
    return false;
  }

  /*
   * Check if the existing entry can be moved to a different entry in the hash table
   */
  private boolean move(Entry existingEntry, int c) {
    if (c == 0) {
      // no moves possible
      return false;
    }
    for (int i = 0; i < k; i++) {
      int result = existingEntry.flowId ^ s[i];
      Entry entry = new Entry(result);
      int hash = entry.hashCode();

      if (arr[hash % capacity] == null) {
        arr[hash % capacity] = existingEntry;
        return true;
      }
    }
    return move(existingEntry, c - 1);
  }
}


