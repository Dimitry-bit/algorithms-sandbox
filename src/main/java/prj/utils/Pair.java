package prj.utils;

public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj instanceof Pair otherPair) {
            if (this.getKey().equals(otherPair.getKey())
                    && this.getValue().equals(otherPair.getValue())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return this.getKey() + " " + this.getValue();
    }
}
