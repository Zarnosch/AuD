package aud;

import aud.adt.AbstractQueue;
import java.util.NoSuchElementException;

/**
 *  Impementation of AbstractQueue as a (dynamically resized)
 *  circular buffer based on array.<p>
 *
 *  Note on use of method {@link #wrap}: There is strictly no reason for
 *  having this method here. As long as you always move an index {@code i}
 *  "forward" you could just use {@code (i+1)%n}. However, this does
 *  <em>not</em> work when moving "backward": {@code (i-1)%n} yields a
 *  <em>wrong</em> result for {@code i<=0} in Java (and C/C++/... but not
 *  Python/Ruby/...) due to Java's definition of the remainder operator.
 *  The correct way is adding a <em>positive</em> number {@code (i+n-1)%n}.
 *  The {@link #wrap} method does the "{@code +n}".<p>
 *  In summary: Be aware of the definition of the remainder for negative
 *  numbers, this definition differs for different programming languages.
 */
//@<queue:class
public class Queue<T> extends AbstractQueue<T> {

  T[] data_;
  int head_ = 0;
  int tail_ = 0;
  //@>queue:class

  static final int DEFAULT_SIZE = 16;

  /** create empty queue */
  public Queue() {
    this(DEFAULT_SIZE);
  }
  /** create empty queue and reserve storage */
  @SuppressWarnings("unchecked")
  //@<queue:ctor
  public Queue(int capacity) {
    data_=(T[]) new Object[capacity];
    head_=tail_=0;
  }
  //@>queue:ctor

  @Override
  //@<queue:empty
  public boolean is_empty() {
    return head_==tail_;
  }
  //@>queue:empty

  @Override
  //@<queue:front
  public T front() {
    if (is_empty())
      throw new NoSuchElementException();
    return data_[head_];
  }
  //@>queue:front

  /** Compute real index (modulo buffer size).
      Make sure we can handle "slighly negative" indices
      ({@code index>=-data_.length}) correctly. Mind behavior of
      %-Operator for negative values!
   */
  //@<queue:dequeue
  int wrap(int index) {
    return (index+data_.length) % data_.length;
  }

  @Override public T dequeue() {
    if (is_empty())
      throw new NoSuchElementException();
    T obj=data_[head_];
    data_[head_]=null; // "free" entry (for GC)
    head_=wrap(head_+1);
    return obj;
  }
  //@>queue:dequeue

  @Override
  //@<queue:enqueue1
  public void enqueue(T x) {
    int newtail=wrap(tail_+1);

    if (newtail!=head_) {
      // no "overrun" we just advance an index.
      data_[tail_]=x;
      tail_=newtail;
    }
    else {
      //@>queue:enqueue1
      //System.err.println("enlarge buffer of size "+data_.length);

      // detected "overrun": the new head "hits" tail --
      // This means the alloacted buffer data is too small!

      // get larger buffer q
      Queue<T> q=new Queue<T>(data_.length*2);

      // copy data into q
      while (!is_empty())
        q.enqueue(dequeue());
      q.enqueue(x);

      // "steal" state of temporary object q
      data_=q.data_;
      head_=q.head_;
      tail_=q.tail_;
      assert(head_==0 && tail_<data_.length);
    }
  }

  @Override
  public String toString() {
    if (is_empty())
      return "<";

    String s="";
    int t=wrap(tail_+data_.length-1);
    for (;;) {
      s=data_[t]+"<"+s;
      if (t==head_)
        break;
      t=wrap(t+data_.length-1);
    }
    return s;
  }
}
