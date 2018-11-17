### 项目目标
手写 LinkedList，并实现 add 、remove 、get 方法

### 项目代码
```
package cn.szxy;

import java.util.AbstractSequentialList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 手写 LinkList，并实现 add 、remove 、get方法
 * @author Administrator
 *
 */
public class TestLinkedList<E> {	
	 int size = 0;  //节点的个数
	 Node<E> first; //前驱
	 Node<E> last;  //后继
	  
	public TestLinkedList() {//无参构造方法
		
    }
	public boolean add(E e) {//添加元素
        linkLast(e);
        return true;
    }
	void linkLast(E e) {//在链尾添加新的元素
        final Node<E> l = last;       //指向前面的指针 元素的值 指向后面的指针 
        final Node<E> newNode = new Node<>(l, e, null);//新的节点对象
        last = newNode;
        if (l == null) {//最开始没有元素的情况下，即没有前继
            first = newNode;
        }
        else {
            l.next = newNode;
        }
        size++;//节点的个数加 1
    }
	//根据 元素 移除 节点
	public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }
	E unlink(Node<E> x) { //去除节点
        final E element = x.item; // 保存被去除节点元素的值
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--; //节点的个数 减一
        return element; // 返回被移除节点的值
    }
	
	 public Object[] toArray() {//遍历双链表，返回节点的值
	        Object[] result = new Object[size];
	        int i = 0;
	        //将首指针 first 赋给节点 x ，用 x 遍历 双链表，从头到尾
	        for (Node<E> x = first; x != null; x = x.next) {
	            result[i++] = x.item;
	        	//System.out.println("指针x："+x.item);
	        }
	        return result;
	  }
	 // 根据 索引 获的 元素
	 public E get(int index) {
	        checkElementIndex(index);//检查元素是否越界
	        return node(index).item;
	    }
	 private void checkElementIndex(int index) {
	        if (!isElementIndex(index))
	            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	    }
	 private String outOfBoundsMsg(int index) {
	        return "Index: "+index+", Size: "+size;
	    }
	 private boolean isElementIndex(int index) {
	        return index >= 0 && index < size;
	    }
	 Node<E> node(int index) {//根据索引获的对应的节点元素的值
	        if (index < (size >> 1)) {
	            Node<E> x = first;
	            for (int i = 0; i < index; i++)
	                x = x.next;
	            return x;
	        } else {
	            Node<E> x = last;
	            for (int i = size - 1; i > index; i--)
	                x = x.prev;
	            return x;
	        }
	    }
	
	//静态内部类  节点类  双链表结构
	 private static class Node<E> {
	        E item; // 元素的值
	        Node<E> next;//指向后一个节点 前驱
	        Node<E> prev;//指向前一个节点 后继

	        Node(Node<E> prev, E element, Node<E> next) {
	            this.item = element;
	            this.next = next;
	            this.prev = prev;
	        }
	    }
	public static void main(String[] args) {
			TestLinkedList<String> t = new TestLinkedList<String>();
			System.out.println("1 通过 add 方法添加节点元素：");
			t.add("HelloWorld");
			t.add("XML");
			t.add("Schema");
			t.add("Mysql");
			t.add("Struct of Data");
			System.out.println(Arrays.toString(t.toArray())+"\n");
			
			System.out.println("2 通过 remove 方法删除节点元素 XML ：");
			System.out.println(Arrays.toString(t.toArray())+"\n");
			
			System.out.println("3 通过 get方法 获取元素 HelloWorld");
			System.out.println("调用 get方法 获的: "+t.get(0)+"\n");
	}
}

```

### 项目运行结果
```
1 通过 add 方法添加节点元素：
[HelloWorld, XML, Schema, Mysql, Struct of Data]

2 通过 remove 方法删除节点元素 XML ：
[HelloWorld, XML, Schema, Mysql, Struct of Data]

3 通过 get方法 获取元素 HelloWorld
调用 get方法 获的: HelloWorld

```

### 项目心得
  首先明确 Java 中的 LinkedList 的底层数据结构是链表，而且是双链表结构，也就是<br />
  每个双链表中的节点都有一个前驱和一个后继，并且可以正向遍历，也可以返回遍历。
  - 1 add 方法编写，先判断是否存在节点，若不存在节点，则第一个放入的元素当做首节点，
  若存在节点，则将最后的节点指向新节点的前驱，并将新节点的后继设为 null，最后
  节点的个数加 1.
  - 2 remove 方法编写，先将整个双链表遍历，找到与要移除值相等的节点，然后将其移除，
  最后节点的个数减 1。
  - 3 get方法的编写，是根据索引获的对应位置的节点中的值。先将双链表遍历，找到索引元素所在的
  位置，然后将其取出并返回。


