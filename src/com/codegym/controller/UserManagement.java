package com.codegym.controller;

import com.codegym.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserManagement implements ReadFile, WriteFile {

    private List<User> users = new ArrayList<>();

    public UserManagement() {
        File file = new File("user.txt");
        if (file.exists()) {
            try {
                readFile("user.txt");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();

            }
        }
    }

    public void displayAll() {
        for (User user : users) {
            System.out.println(user);
        }
    }


    public void register(User user) {
        this.users.add(user);
        try {
            writeFile("user.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFile(String path) throws IOException, ClassNotFoundException {
        InputStream is = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(is);
        this.users = (List<User>) ois.readObject();
    }

    @Override
    public void writeFile(String path) throws IOException {
        OutputStream os = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(this.users);
    }

    public boolean checkUsernameExist(String username) {
        boolean isExist = false;
        for (int i = 0; i < users.size(); i++) {
            if (username.equals(users.get(i).getAcount())) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }

    public boolean checkUserLogin(String acount, String passwork) {
        boolean isLogin = false;
        for (int i = 0; i < users.size(); i++) {
            if (acount.equals(users.get(i).getAcount()) && passwork.equals(users.get(i).getPasswork())) {
                isLogin = true;
                break;
            }
        }
        return isLogin;
    }
}
