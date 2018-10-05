package com.example.ri1.ejerciciojorge;

class Person {
    String name;
    String age;
    int photoId;
    int ID;

    Person(String name, String age, int photoId,int i) {
        this.name = name;
        this.age = age;
        this.photoId = photoId;
        this.ID = i;
    }

    public String toString(){

        return "Nombre: "+name+" - Edad: "+age;
    }
}
