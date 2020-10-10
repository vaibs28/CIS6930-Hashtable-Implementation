# Steps to Run:
1. Download and extract the project.
2. cd src
3. make
4. java ApplicationRunner


# Project Structure

The project contains the following files:

1. **ApplicationRunner.java**
This is Entry point for the application from where we are passing in the parameters for the demo and then printing the output on the console as well as writing it to an output file.
On running the application we would get an option to select the implementation we want to run.
On inputting the value, the corresponding hashtable implementation will be run with the parameters.

2. **Entry.java**
This class contains the fields required in an Entry of the HashTable.
In this case we just need the flowId and the counter.

3. **Segment.java**
This class is being used in the implementation of D-Left HashTable.
It would contain an array of entries and the capacity of each segment.

4. **HashTable.java**
This is a top-level Abstract Class from which all the concrete classes will extend.
It has the common properties like capacity,numEntries,entry array, s array and the k values, which are being used in all the implementations.

5. **MultiHashTable.java**
This is the implementation for Multi Hashtable.
It extends from HashTable class and contains the put method which would insert the flowid in the hash table as per the multi hashing rules.
It also implements the generateKHashFunctions method inherited from the HashTable class.

6. **CuckooHashTable.java**
This is the implementation for Cuckoo HashTable.
Apart from the inherited properties of the HashTable it contains one more additional property c, which is the number of cuckoo steps.
It has a put method which inserts the flowId in the hashtable using the cuckoo hashing logic which is implemented in the move method.

7. **DLeftHashTable.java**
This is the implementation for DLeft HashTable. It uses the Segment class to partition the entire hashtable into segments and then insert the flowid in the first available segment from the left.
