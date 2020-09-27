/*
 * Segment class for d-left hash table. Each segment will contain an array of entries
 */
public class Segment {

  int capacity;
  Entry[] arr;

  public Segment(int capacity) {
    this.capacity = capacity;
    arr = new Entry[capacity];
  }
}
