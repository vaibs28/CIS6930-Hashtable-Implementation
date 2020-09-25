import java.util.Random;

/*
 * Define the multi-hashing table, as an array of entries with the declared capacity
 */
public class MultiHashTable {

  int capacity;
  int k;
  int[] s;
  Entry[] arr;
  int numEntries;

  public MultiHashTable(int capacity,int k) {
    this.k = k;
    this.capacity = capacity;
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
   * Add to the hashtable if any one of the k entries are available
   */
  public boolean put(int flowId) {
    for (int i = 0; i < s.length; i++) {
      int result = flowId ^ s[i];
      Entry entry = new Entry(result);
      int hash = entry.hashCode();
      if (arr[hash % capacity] == null) {
        arr[hash % capacity] = entry;
        numEntries++;
        return true;
      }
    }
    return false;
  }
}


/*
 * Define the entry in the map
 * 
 */
class Entry {
  int flowId;
  int counter;

  Entry() {}

  Entry(int flowId) {
    this.flowId = flowId;
  }

  Entry(int flowId, int counter) {
    this.flowId = flowId;
    this.counter = counter;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + flowId;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Entry other = (Entry) obj;
    if (flowId != other.flowId)
      return false;
    return true;
  }


}
