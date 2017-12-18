package com.javarush.task.task20.task2007;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* 
Как сериализовать JavaRush?
Сделай так, чтобы сериализация класса JavaRush была возможной.


Требования:
1. Класс JavaRush должен существовать внутри класса Solution.
2. Класс JavaRush должен быть статическим.
3. Класс JavaRush должен быть публичным.
4. Класс JavaRush должен поддерживать интерфейс Serializable.
*/
public class Solution {
    public static class JavaRush implements Serializable{
        public List<User> users = new ArrayList<>();
        public JavaRush() {

        }
        public JavaRush(List<User> list){
            if (list != null) {
                this.users.addAll(list);
            }
        }
    }

    public static void main(String[] args) throws IOException {

    }
}
