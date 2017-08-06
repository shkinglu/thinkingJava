package general;

public interface GenericGetter<T extends GenericGetter<T>> {
  T get();
}
