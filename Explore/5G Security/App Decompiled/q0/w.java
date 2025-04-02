package q0;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public final class w implements ListIterator {
   public static final w e = new w();

   private w() {
   }

   public Void a() {
      throw new NoSuchElementException();
   }

   public Void b() {
      throw new NoSuchElementException();
   }

   public boolean hasNext() {
      return false;
   }

   public boolean hasPrevious() {
      return false;
   }

   public int nextIndex() {
      return 0;
   }

   public int previousIndex() {
      return -1;
   }

   public void remove() {
      throw new UnsupportedOperationException("Operation is not supported for read-only collection");
   }
}
