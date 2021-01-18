public class DLeftHashTable extends HashTable {

  int segments;
  Segment[] segmentArr;

  public DLeftHashTable(int capacity, int segments) {
    this.capacity = capacity / segments;
    this.segments = segments;
    s = new int[segments];
    segmentArr = new Segment[segments];
    for (int i = 0; i < segments; i++) {
      segmentArr[i] = new Segment(this.capacity);
      segmentArr[i].arr = new Entry[this.capacity];
    }
    generateKHashFunctions();
  }

  public void generateKHashFunctions() {
    for (int i = 0; i < s.length; i++) {
      s[i] = Math.abs(rand.nextInt());
    }
  }

  @Override
  public boolean put(int flowId) {
    for (int i = 0; i < s.length; i++) {
      Entry[] arr = segmentArr[i].arr;
      int result = flowId ^ s[i];
      Entry entry = new Entry(result);
      int hash = entry.hashCode();
      if (arr[hash % this.capacity] == null) {
        arr[hash % this.capacity] = new Entry(flowId);
        numEntries++;
        return true;
      }
    }
    return false;
  }
}
