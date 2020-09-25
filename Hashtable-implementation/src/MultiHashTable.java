import java.util.Random;

/*
 * Define the multi-hashing table, as an array of entries with the declared capacity
 */
public class MultiHashTable {

  static final int CAPACITY = 1000;
  static final int FLOWS = 1000;
  static final int k = 3;
  int[] s;
  Entry[] arr;

  public void generateKHashFunctions() {
    s = new int[k];
    for (int i = 0; i < s.length; i++) {
      s[i] = new Random().nextInt();
    }
  }

  public boolean put(int flowId) {
    for (int i = 0; i < s.length; i++) {
      int result = flowId ^ s[i];
      Entry entry = new Entry(result);
      int hash = entry.hashCode();
      if (arr[hash] == null) {
        arr[hash] = entry;
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
