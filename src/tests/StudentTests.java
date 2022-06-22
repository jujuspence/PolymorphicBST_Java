package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Set;

import org.junit.Test;


import tree.EmptyTree;
import tree.NonEmptyTree;
import tree.PlaceKeysValuesInArrayLists;
import tree.PolymorphicBST;

public class StudentTests {
	
	@Test
	public void addKeysToCollectionTest() {
		//PolymorphicBST<Integer,String> u=new PolymorphicBST<Integer,String>();
		EmptyTree empty=EmptyTree.getInstance();
		NonEmptyTree<Integer,String> u = new NonEmptyTree(1,"rock",empty,empty);
		u.insert(33, "play");
		u.insert(3, "off");
		u.insert(2, "real");
		u.insert(19, "night");
		ArrayList<Integer> list=new ArrayList<Integer>();
		u.addKeysToCollection(list);
		assertEquals(5,list.size());
		
		
	}
	
	@Test
	public void deleteTest() {
		PolymorphicBST<Integer,String> y=new PolymorphicBST<Integer,String>();
		
		y.put(4, "why");
		y.put(14, "you");
		y.put(2, "stacy");
		y.put(18, "acting");
		y.put(19, "like");
		y.put(21, "that");
		
		y.remove(2);
		int count=y.size();
		assertEquals(5,count);
		y.remove(4);
		count=y.size();
		assertEquals(4,count);
	}
	
	@Test
	public void heightTest() {
		PolymorphicBST<Integer,String> ptree = new PolymorphicBST<Integer,String>();
		
		ptree.put(2,"Dos");
		ptree.put(4, "cuatro");
		ptree.put(6, "seis");
		ptree.put(1,"uno");
		
		assertEquals(3,ptree.height());
		
	}
	
	@Test
	public void inorderTraversalTest() {
		PolymorphicBST<Integer,String> r=new PolymorphicBST<Integer,String>();
		
		r.put(100, "rick");
		r.put(36, "timmy");
		r.put(15, "nine");
		r.put(52, "lola");
		PlaceKeysValuesInArrayLists<Integer, String> task = new PlaceKeysValuesInArrayLists<Integer, String>();
		r.inorderTraversal(task);
		String str= "[nine, timmy, lola, rick]";
		assertEquals(str,task.getValues().toString());
		
	}
	
	@Test
	public void insertTest() {
		PolymorphicBST<Integer,String> t = new PolymorphicBST<Integer,String>();
		t.put(5, "gold");
		t.put(6, "silver");
		t.put(4, "copper");
		t.put(10, "money");
		
		String get=t.get(4);
		assertEquals("copper",get);
		get=t.get(5);
		assertEquals("gold",get);
		get=t.get(10);
		assertEquals("money",get);
		
	}
	
	@Test
	public void maxTest() {
		PolymorphicBST<Integer,String> x = new PolymorphicBST<Integer,String>();
		
		x.put(5, "cinco");
		x.put(1,"blanco");
		x.put(0, "cero");
		x.put(8, "ocho");
		int max=x.getMax();
		assertEquals(8,max);
		
		x.put(17, "deisysiete");
		x.put(12, "doce");
		max=x.getMax();
		assertEquals(17,max);
	}
	
	@Test
	public void minTest() {
		PolymorphicBST<Integer,String> p = new PolymorphicBST<Integer,String>();
	
		p.put(18, "deisyocho");
		p.put(9, "nueve");
		p.put(4,"four");
		int min=p.getMin();
		
		assertEquals(4,min);
		
		p.put(2, "two");
		p.put(7,"siete");
		min=p.getMin();
		assertEquals(2,min);
		
	}
	
	@Test
	public void rightRootLeftTraversalTest() {
		PolymorphicBST<Integer,String> v=new PolymorphicBST<Integer,String>();
		v.put(6, "fire");
		v.put(2, "taste");
		v.put(26, "rotate");
		v.put(13, "dumb");
		PlaceKeysValuesInArrayLists<Integer, String> task = new PlaceKeysValuesInArrayLists<Integer, String>();
		
		v.rightRootLeftTraversal(task);
		String key="[26, 13, 6, 2]";
		String val= "[rotate, dumb, fire, taste]";
		assertEquals(key,task.getKeys().toString());
		assertEquals(val,task.getValues().toString());
		
	
	}
	
	@Test
	public void searchTest() {
		PolymorphicBST<Integer,Integer> m=new PolymorphicBST<Integer,Integer>();
		m.put(3, 33);
		m.put(2, 22);
		m.put(1, 11);
		int la= m.get(3);
		int lo=m.get(2);
		assertEquals(33,la);
		assertEquals(22,lo);
	}
	
	@Test
	public void sizeTest() {
		PolymorphicBST<Integer,String> tree = new PolymorphicBST<Integer,String>();
		
		tree.put(13, "trece");
		tree.put(14, "catorce");
		tree.put(15, "quince");
		tree.put(16, "deisyseis");
		assertEquals(4,tree.size());
	}
	
	@Test
	public void subTreeTest() {
		PolymorphicBST<Integer,String> b=new PolymorphicBST<Integer,String>();
		
		b.put(8, "cheat");
		b.put(1, "alone");
		b.put(21, "chill");
		b.put(71, "right");
		b.put(15, "cheese");
		PolymorphicBST<Integer,String> c =new PolymorphicBST<Integer,String>();
		c=b.subMap(0, 25);
		assertEquals(4,c.size());
		c.remove(21);
		assertEquals(3,c.size());
		
	}
	
	@Test
	public void toStringTest() {
		PolymorphicBST<Integer,String> e=new PolymorphicBST<Integer,String>();
		
		e.put(12, "spider");
		e.put(15, "man");
		e.put(32, "oh");
		e.put(35, "spider");
		e.put(43, "man");
		
		PlaceKeysValuesInArrayLists<Integer, String> task = new PlaceKeysValuesInArrayLists<Integer, String>();
		e.inorderTraversal(task);
		String s=task.getValues().toString();
		assertEquals("[spider, man, oh, spider, man]",s);
		
	}
	
	@Test
	public void subMapTest() {
PolymorphicBST<Integer,String> n = new PolymorphicBST<Integer,String>();
		
		n.put(7, "coke");
		n.put(69, "bang");
		n.put(44, "logic");
		n.put(96, "like a");
		
		PolymorphicBST<Integer,String> g=new PolymorphicBST<Integer,String>();
		
		g=n.subMap(20, 100);
		assertEquals(3,g.size());
		PolymorphicBST<Integer,String> j = new PolymorphicBST<Integer,String>();
		j.put(30, "oh");
		j.put(80, "my");
		j.put(18, "love");
		j.put(40, "gees");
		j.put(25, "kill");
		j.put(10, "fall");
		j.put(88, "peach");
		PolymorphicBST<Integer,String> sub = new PolymorphicBST<Integer,String>();
		sub=j.subMap(0, 29);
		assertEquals(3,sub.size());
	}
	
	@Test
	public void performTaskTest() {
		PolymorphicBST<Integer,String> w=new PolymorphicBST<Integer,String>();
		w.put(8, "pipe");
		w.put(6, "world");
		w.put(22, "owl");
		w.put(19, "tomcat");
		w.put(23, "sun");
		
		
		PlaceKeysValuesInArrayLists<Integer, String> task = new PlaceKeysValuesInArrayLists<Integer, String>();
		w.rightRootLeftTraversal(task);
		String keys= "[23, 22, 19, 8, 6]";
		assertEquals(keys,task.getKeys().toString());
		
		
	}
	
	@Test
	public void getKeysTest() {
		PolymorphicBST<Integer,String> f=new PolymorphicBST<Integer,String>();
		
		f.put(11, "trix");
		f.put(12, "are");
		f.put(14, "for");
		f.put(17, "kids");
		PlaceKeysValuesInArrayLists<Integer, String> task = new PlaceKeysValuesInArrayLists<Integer, String>();
		f.inorderTraversal(task);
		String keys= "[11, 12, 14, 17]";
		String val= "[trix, are, for, kids]";
		assertEquals(keys,task.getKeys().toString());
		assertEquals(val,task.getValues().toString());
		
		
	}
	
	@Test 
	public void getValuesTest() {
		PolymorphicBST<Integer,String> k=new PolymorphicBST<Integer,String>();
		
		k.put(7, "bot");
		k.put(8, "pants");
		k.put(2, "dos");
		PlaceKeysValuesInArrayLists<Integer, String> task = new PlaceKeysValuesInArrayLists<Integer, String>();
		k.rightRootLeftTraversal(task);
		String val="[pants, bot, dos]";
		assertEquals(val,task.getValues().toString());
	}
	
	@Test
	public void placeKeysValuesInArrayListsTest() {
		PolymorphicBST<Integer,String> d= new PolymorphicBST<Integer,String>();
		
		d.put(6, "gross");
		d.put(33, "yessir");
		d.put(9, "joke");
		d.put(5, "mane");
		PlaceKeysValuesInArrayLists<Integer, String> task = new PlaceKeysValuesInArrayLists<Integer, String>();
		d.inorderTraversal(task);
		String keys= "[5, 6, 9, 33]";
		String val= "[mane, gross, joke, yessir]";
		assertEquals(keys,task.getKeys().toString());
		assertEquals(val,task.getValues().toString());
	}
	
	@Test
	public void clearTest() {
		PolymorphicBST<Integer,String> a=new PolymorphicBST<Integer,String>();
		
		a.put(3, "yeah");
		a.put(21, "young");
		a.put(5,"alive");
		a.put(18, "call");
		assertEquals(4,a.size());
		a.clear();
		assertEquals(0,a.size());
		
	}
	
	@Test
	public void getTest() {
		PolymorphicBST<Integer,String> i = new PolymorphicBST<Integer,String>();
		i.put(3, "joker");
		i.put(4, "crazy");
		i.put(15, "yoda");
		i.put(40, "floaty");
		String w=i.get(4);
		assertEquals("crazy",w);
		
	}
	
	@Test
	public void putTest() {
		PolymorphicBST<Integer,String> o = new PolymorphicBST<Integer,String>();
	
		o.put(12, "creme");
		o.put(19, "fortune");
		o.put(15, "power");
		o.put(13, "fame");
		
		assertEquals(4,o.size());
	
	}
	
	@Test
	public void removeTest() {
		PolymorphicBST<Integer,String> l = new PolymorphicBST<Integer,String>();
	
		l.put(6, "corner");
		l.put(82, "block");
		l.put(22, "socks");
		l.put(0, "not");
		l.put(1, "bot");
		l.remove(0);
		assertEquals(4,l.size());
	
	}
	
	@Test
	public void getMaxTest() {
		PolymorphicBST<Integer,String> q = new PolymorphicBST<Integer,String>();
	
		q.put(8, "fly");
		q.put(88, "tooFly");
		q.put(420, "Mars");
		int max=q.getMax();
		assertEquals(420,max);
	
	}
	
	@Test
	public void getMinTest() {
		PolymorphicBST<Integer,String> v = new PolymorphicBST<Integer,String>();
		
		v.put(60, "racks");
		v.put(33, "park");
		v.put(50, "basement");
		v.put(29, "gone");
		v.put(59, "check");
		v.put(48, "james");
		int min=v.getMin();
		assertEquals(29,min);
	}
	
	@Test
	public void keySetTest() {
		PolymorphicBST<Integer,String> z=new PolymorphicBST<Integer,String>();
		z.put(52, "belief");
		z.put(12, "judge");
		z.put(33, "done");
		z.put(62, "back");

		Set<Integer> set=z.keySet();
		assertEquals(4,set.size());
		assertEquals(true,set.contains(12));
		assertEquals(true,set.contains(33));
		
		
	}
	
	
	
}