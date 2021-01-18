/*
 * Define the multi-hashing table, as an array of entries with the declared capacity
 */
public class MultiHashTable extends HashTable {

  public MultiHashTable(int capacity, int k) {
    this.k = k;
    s = new int[k];
    this.capacity = capacity;
    arr = new Entry[capacity];
    generateKHashFunctions();
  }


  /*
   * Add to the hashtable if any one of the k entries are available
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
    return false;
  }


  public void generateKHashFunctions() {
    for (int i = 0; i < s.length; i++) {
      s[i] = Math.abs(rand.nextInt());
    }
  }
}


