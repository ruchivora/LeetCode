/*
	The datastructure used here is hash map and 
	linked list to preserve the order of occurance . 

*/


class LRUCache{

		HashMap<Integer,Node> node_map ;
		Node head ;
		Node tail ;
		int capacity ;

	/*
		This is a constructor . So it is used to initialize 
		the variables or datastructure .
	*/
	 public LRUCache(int capacity) {
	 	this.capacity = capacity ;
	 	node_map  = new HashMap<Integer,Node>(capacity) ;
	 	head.next = tail ;
	 	head.prev = tail ;
	 	tail.next = prev ; 
	 	tail.prev = head ;
	 }

	 public int get(int key) {

	 }

	 public void put(int key, int value) {

	 }

	 public void add(Node node){
	 	// add the node from the front

	 }
	 public void remove(Node node){
	 	// remove the node from the end 
	 	
	 }

	 class Node{
	 	int key ; 
	 	int value ;
	 	Node prev ;
	 	Node next ;
	 }
}