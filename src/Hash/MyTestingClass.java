package Hash;
public class MyTestingClass {
    private final int id;
    private final  String name;

    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "MyTestingClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode = 31 * hashCode + id;
        hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        MyTestingClass other = (MyTestingClass) obj;
        if (id != other.id) return false;
        if (name == null) {
            return other.name == null;
        } else return name.equals(other.name);
    }

}