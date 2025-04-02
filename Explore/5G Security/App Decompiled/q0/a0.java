package q0;

import java.util.Iterator;

public abstract class a0 implements Iterator<Integer> {
   public abstract int nextInt();

   public void remove() {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
   }
}
