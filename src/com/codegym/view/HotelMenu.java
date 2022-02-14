package com.codegym.view;

import com.codegym.controller.HotelManagement;
import com.codegym.model.HotelRoom;
import com.codegym.model.Person;

import java.util.Scanner;


public class HotelMenu {
    public Scanner scanner = new Scanner(System.in);

    public void run() {
        HotelManagement hotelManagement = new HotelManagement();
        int choice = -1;
        do {
            menu();
            System.out.println("");
            System.out.println("Nhập lựa chọn của bạn");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    showAllStudent(hotelManagement);
                    break;
                }
                case 2: {
                    showCreateHotel(hotelManagement);
                    break;
                }
                case 3: {
                    showUpdateHotel(hotelManagement);
                    break;
                }
                case 4: {
                    showDeleteHotel(hotelManagement);
                    break;
                }
                case 5: {
                    showFindHotel(hotelManagement);
                    break;
                }
            }
        } while (choice != 0);
    }

    private void showFindHotel(HotelManagement hotelManagement) {
        System.out.println("---Tìm kiếm thông tin phòng---");
        System.out.println("Nhập số phòng cần tìm");
        String id = scanner.nextLine();
        int index = hotelManagement.findHotelRoomsByID(id);
        if (index != -1) {
            System.out.println("Thông tin phòng cần tìm cần tìm: " + hotelManagement.getById(id));
        } else {
            System.out.println("Không tìm thấy");
        }
    }


    private void showDeleteHotel(HotelManagement hotelManagement) {
        System.out.println("Xóa thông tin khách sạn");
        System.out.println("Nhập số phòng cần xóa thông tin");
        String id = scanner.nextLine();
        boolean isDeleted = hotelManagement.deleteById(id);
        if (isDeleted) {
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Xóa không thành công");
        }
    }

    private void showUpdateHotel(HotelManagement hotelManagement) {
        System.out.println("Chỉnh sửa thông tin khách sạn");
        System.out.println("Nhập mã khách sạn cần chỉnh sửa thông tin");
        String id = scanner.nextLine();
        int index = hotelManagement.findHotelRoomsByID(id);
        if (index != -1) {
            HotelRoom hotelRoom = getHotel();
            hotelManagement.updateById(id, hotelRoom);
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Cập nhật bị lỗi do không tồn tại mã học viên cần tìm!");
        }
    }

    private void showCreateHotel(HotelManagement hotelManagement) {
        System.out.println("Thêm thông tin khách sạn");
        HotelRoom hotelRoom = getHotel();
        hotelManagement.addNew(hotelRoom);
    }

    private void showAllStudent(HotelManagement hotelManagement) {
        int size = hotelManagement.size();
        if (size == 0) {
            System.out.println("Danh sách rỗng");
        } else {
            System.out.println("Danh sách khách sạn");
            hotelManagement.displayAll();
        }
    }

    private HotelRoom getHotel() {
        System.out.println("Nhập số phòng: ");
        String id = scanner.nextLine();
        System.out.println("Nhập loại phòng");
        String type = scanner.nextLine();
        System.out.println("Nhập số ngày trọ: ");
        int rentDays = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập trạng thái của phòng: ");
        String status = scanner.nextLine();
        System.out.println("Nhập giá phòng");
        double price = scanner.nextDouble();
        Person person = getPerson();
        return new HotelRoom(id, type, rentDays, status, price, person);
    }

    private Person getPerson() {
        System.out.println("Nhập thông tin khách trọ");
        scanner.nextLine();
        System.out.println("Nhập họ tên khách trọ: ");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày sinh: ");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Nhập căn cước: ");
        String identity = scanner.nextLine();
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = scanner.nextLine();
        return new Person(name, dateOfBirth, identity, phoneNumber);
    }


    private static void menu() {
        System.out.println("1. Hiển thị danh sách phòng");
        System.out.println("2. Thêm thông tin khách sạn");
        System.out.println("3. Cập nhật thông tin khách sạn");
        System.out.println("4. Xóa thông tin khách sạn");
        System.out.println("5. Tìm kiếm thông tin khách sạn ");
        System.out.println("0. Quay lại");
    }
}

