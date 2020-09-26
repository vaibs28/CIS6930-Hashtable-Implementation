/*
 * Define the entry in the map
 * 
 */
public class Entry {
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
