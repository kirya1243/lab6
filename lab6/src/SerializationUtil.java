import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SerializationUtil {

    public static byte[] serialize(Object object) throws IOException{
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try (ObjectOutputStream stream = new ObjectOutputStream(output)){
                stream.writeObject(object);
                stream.flush();
            return output.toByteArray();
        }
    }

    public static Object deserialize(byte[] array) throws IOException, ClassNotFoundException, EOFException {
        ByteArrayInputStream bis = new ByteArrayInputStream(array);
        try (ObjectInputStream in = new ObjectInputStream(bis)) {
            List<Object> ret = new ArrayList<Object>();
            while (in.available() > 0) {
                 ret.add(in.readObject());
            }
            return ret.stream().map(Object::toString)
                    .collect(Collectors.joining(", "));
        }
    }
}