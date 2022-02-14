package com.codegym.controller;

import com.codegym.model.HotelRoom;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HotelManagement implements GeneralManagement<HotelRoom>, WriteFile, ReadFile {
    private List<HotelRoom> hotelRooms = new ArrayList<>();

    public int size() {
        return hotelRooms.size();
    }

    public HotelRoom getHotelRoom(int index) {
        return hotelRooms.get(index);
    }


    public int findHotelRoomsByID(String id) {
        int index = -1;
        for (int i = 0; i < hotelRooms.size(); i++) {
            if (hotelRooms.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }


    @Override
    public void displayAll() {
        for (HotelRoom hotelRoom : hotelRooms) {
            System.out.println(hotelRoom);
        }
    }

    @Override
    public void addNew(HotelRoom hotelRoom) {
        hotelRooms.add(hotelRoom);
    }



    @Override
    public boolean updateById(String id, HotelRoom hotelRoom) {
        int index = findHotelRoomsByID(id);
        hotelRooms.set(index, hotelRoom);
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        int index = findHotelRoomsByID(id);
        if (index != -1) {
            hotelRooms.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public HotelRoom getById(String id) {
        int index = findHotelRoomsByID(id);
        return hotelRooms.get(index);
    }

    @Override
    public void readFile(String path) throws IOException, ClassNotFoundException {
        InputStream is = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(is);
        this.hotelRooms = (List<HotelRoom>) ois.readObject();
    }

    @Override
    public void writeFile(String path) throws IOException {
        OutputStream os = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(this.hotelRooms);
    }
}
