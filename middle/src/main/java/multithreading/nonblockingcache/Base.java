package multithreading.nonblockingcache;

import java.util.Objects;

public class Base {
    private final int id;
    private String name;
    private int version = 0;

    public Base(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }


    public void setName(String newName) {
        this.name = newName;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int newVersion) {
        this.version = newVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Base base = (Base) o;
        return id == base.id
                && version == base.version
                && Objects.equals(name, base.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, version);
    }
}
