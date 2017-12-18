package com.javarush.task.task20.task2012;

import java.io.*;

/* 
OutputToConsole
Найди и исправь ошибку.


Требования:
1. Класс Solution.OutputToConsole должен поддерживать интерфейс Externalizable.
2. Класс OutputToConsole должен быть создан в классе Solution.
3. Класс OutputToConsole должен быть публичным.
4. Класс OutputToConsole должен быть статическим.
*/
public class Solution {
    public static String greeting = "Hello world";

    /**
     * OutputToConsole is the inner base class for improving your attentiveness.
     * An OutputToConsole object encapsulates the information needed
     * for the displaying [greeting] variable to the console.
     * @author JavaRush
     */
    public static class OutputToConsole implements Externalizable {
        private int counter;

        /**
         * @param out A stream for an externalization
         * @throws java.io.IOException
         */
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(counter);
        }

        /**
         * @param in A stream for a de-externalization
         * @throws java.io.IOException
         * @throws ClassNotFoundException
         */
        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            counter = in.readInt();
        }

        /**
         * Class constructor specifying fake private field [i].
         */
        public OutputToConsole(int counter) {
            this.counter = counter;
        }

        /**
         * Prints greeting message to console counter times.
         */
        public void printMessage() {
            for (int i = 0; i < counter; i++) {
                System.out.println(greeting);
            }
        }

        public OutputToConsole() {
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        OutputToConsole otc = new OutputToConsole(5);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/task2012.dat"));
        oos.writeObject(otc);
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/task2012.dat"));
        OutputToConsole otcRestored = (OutputToConsole) ois.readObject();
        ois.close();
        otcRestored.printMessage();

    }
}
