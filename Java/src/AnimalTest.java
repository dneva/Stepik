import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class AnimalTest {
    static class Animal implements Serializable {
        private final String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Animal) {
                return Objects.equals(name, ((Animal) obj).name);
            }
            return false;
        }
    }
    public static Animal[] deserializeAnimalArray(byte[] data) throws IllegalArgumentException{
        try(ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))){
            int size= ois.readInt();
            Animal[] animals=new Animal[size];
            for (int i = 0; i < size; i++) {
                Object read=ois.readObject();
                animals[i]=(Animal) read;
            }
            return animals;
        }catch (Exception e){
            throw new IllegalArgumentException(e);

        }
    }
//ClassCastException EOFException
    public static void main(String[] args) {
        Animal animal=new Animal("Dog");
        byte[] data;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(1);
            out.writeObject(animal);
            out.flush();
            data = bos.toByteArray();
            Animal[] animals=deserializeAnimalArray(data);
            System.out.println(Arrays.toString(animals));
        } catch (IOException e) {
            e.printStackTrace();
        }







    }

}
