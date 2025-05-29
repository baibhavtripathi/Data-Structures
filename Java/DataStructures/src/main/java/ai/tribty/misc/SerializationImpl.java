package ai.tribty.misc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.Objects;

class DataToSerialize implements Serializable {
    private static final long serialVersionUID = 101020303030L;
    String name;
    Integer id;
    transient String password;

    public DataToSerialize(String name, Integer id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, password);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof DataToSerialize))
            return false;
        DataToSerialize other = (DataToSerialize) obj;
        return Objects.equals(name, other.name) && Objects.equals(id, other.id)
                && Objects.equals(password, other.password);
    }

    @Override
    public String toString() {
        return "DataToSerialize [name=" + name + ", id=" + id + "]";
    }

    
}


record NonSerializable(String identifier, Integer id) {}

public class SerializationImpl {
    public static void main(String[] args) {
        // NonSerializable ns = new NonSerializable("Alpha", 1);
        String root = System.getProperty("user.dir");
        String filePath = "Dump.txt";
        DataToSerialize ds = new DataToSerialize("Alpha", 1, "hidden");

        // Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(ds);
        } catch (NotSerializableException nse) {
            nse.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }

        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            // NonSerializable get_ns = (NonSerializable) ois.readObject();
            // System.out.println("Identifier: " + get_ns.identifier());
            DataToSerialize deserialized_ds = (DataToSerialize) ois.readObject();
            System.out.println(deserialized_ds);
        } catch (NotSerializableException nse) {
            nse.printStackTrace();
        } catch (IOException | ClassNotFoundException ie) {
            ie.printStackTrace();
        }
    }
}

/*
 * Error in case of no implementation of Serializable interface
java.io.NotSerializableException: ai.tribty.misc.NonSerializable
        at java.base/java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1200)
        at java.base/java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:358)
        at ai.tribty.misc.SerializationImpl.main(SerializationImpl.java:36)
java.io.WriteAbortedException: writing aborted; java.io.NotSerializableException: ai.tribty.misc.NonSerializable
        at java.base/java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1769)
        at java.base/java.io.ObjectInputStream.readObject(ObjectInputStream.java:540)
        at java.base/java.io.ObjectInputStream.readObject(ObjectInputStream.java:498)
        at ai.tribty.misc.SerializationImpl.main(SerializationImpl.java:45)
Caused by: java.io.NotSerializableException: ai.tribty.misc.NonSerializable
        at java.base/java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1200)
        at java.base/java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:358)
        at ai.tribty.misc.SerializationImpl.main(SerializationImpl.java:36)

 */