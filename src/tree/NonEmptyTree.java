package tree;

import java.util.Collection;

/**
 * This class represents a non-empty search tree. An instance of this class
 * should contain:
 * <ul>
 * <li>A key
 * <li>A value (that the key maps to)
 * <li>A reference to a left Tree that contains key:value pairs such that the
 * keys in the left Tree are less than the key stored in this tree node.
 * <li>A reference to a right Tree that contains key:value pairs such that the
 * keys in the right Tree are greater than the key stored in this tree node.
 * </ul>
 *  
 */
public class NonEmptyTree<K extends Comparable<K>, V> implements Tree<K, V> {

	/* Provide whatever instance variables you need */


	Tree<K,V> left;
	Tree<K,V> right;
	K key;
	V value;



	/**
	 * Only constructor we need.
	 * @param key
	 * @param value
	 * @param left
	 * @param right
	 */


	public NonEmptyTree(K key, V value, Tree<K,V> left, Tree<K,V> right) {

		this.key=key;
		this.value=value;
		this.left = left;
		this.right= right;
	}

	public V search(K key) {

		if(key.compareTo(this.key)<0) {
			return left.search(key);
		}else if(key.compareTo(this.key)==0) {
			return value;
		}else {
			return right.search(key);
		}

	}

	public NonEmptyTree<K, V> insert(K key, V value) {

		if(key.compareTo(this.key)<0) {
			left=left.insert(key, value);
		}else if(key.compareTo(this.key)==0) {
			this.value=value;
		}else {
			right= right.insert(key, value);
		}
		return this;
	}

	public Tree<K, V> delete(K key) {

		Tree<K,V> empty=EmptyTree.getInstance();

		if(key.compareTo(this.key)<0) {

			left=left.delete(key);

		}else if(key.compareTo(this.key)>0) {

			right=right.delete(key);

		}else if(key.compareTo(this.key)==0) {
			
			try {
				this.key=left.max();
				this.value=search(left.max());
				left=left.delete(left.max());
			}catch(TreeIsEmptyException e) {
				try {
					this.key=right.min();
					this.value=search(right.min());
					right=right.delete(right.min());
				}catch(TreeIsEmptyException e2) {
					return empty;
				}
			}
		}

		return this;

	}

	public K max() {
		try {
			return right.max();
		}catch(TreeIsEmptyException e) {
			return key;
		}
	}

	public K min() {
		try {
			return left.min();
		}catch(TreeIsEmptyException e) {
			return key;
		}
	}

	public int size() {
		return 1+left.size()+right.size();
	}

	public void addKeysToCollection(Collection<K> c) {
		c.add(key);

		left.addKeysToCollection(c);
		right.addKeysToCollection(c);
	}

	public Tree<K,V> subTree(K fromKey, K toKey) {
		Tree<K,V> sub=EmptyTree.getInstance();
		NonEmptyTree<K,V> sub2;
		
		if(key.compareTo(fromKey)>=0 && key.compareTo(toKey)<=0) {
			sub2=new NonEmptyTree<K,V>(key,value,sub,sub);
			sub2=subTreeAux(fromKey,toKey,sub2); 
		}else if(key.compareTo(fromKey)<0) {
			sub=right.subTree(fromKey, toKey);
			return sub;
			
		}else if(key.compareTo(toKey)>0) {
			sub=left.subTree(fromKey, toKey);
			return sub;
		}
		
		else {
			return sub;
		}
		
		return sub2;
		
	}

	private NonEmptyTree<K,V> subTreeAux(K fromKey,K toKey, NonEmptyTree<K,V> sub) {

		sub.left=left.subTree(fromKey, toKey); 
		sub.right=right.subTree(fromKey, toKey);
	
		return sub;
	}

	public int height() {
		int maximum=1;
		int leftMax=0;
		int rightMax=0;

		leftMax=left.height();
		rightMax=right.height();

		if(leftMax>rightMax) {
			maximum+=leftMax;
		}else {
			maximum+=rightMax;
		}

		return maximum;
	}


	public void inorderTraversal(TraversalTask<K,V> p) {

		left.inorderTraversal(p);
		p.performTask(key, value);
		right.inorderTraversal(p);

	}

	public void rightRootLeftTraversal(TraversalTask<K,V> p) {
		right.rightRootLeftTraversal(p);
		p.performTask(key, value);
		left.rightRootLeftTraversal(p);

	}	
}