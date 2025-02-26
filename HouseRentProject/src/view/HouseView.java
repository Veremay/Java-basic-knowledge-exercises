package view;

import model.House;
import service.HouseService;
import utils.Utility;

/**
 * 1.显示界面
 * 2.接受用户输入
 * 3.调用HouseService完成对房屋信息的各种操作
 */

public class HouseView {
    private boolean loop = true;//控制显示菜单
    private char key;//接收用户选择
    private HouseService houseService = new HouseService(2);


    //编写delHouse()接收输入的id,调用Service 的del方法
    public void delHouse() {
        System.out.println("=======删除房屋信息=======");
        System.out.print("请输入待删除房屋的编号(-1退出):");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("=============放弃删除房屋信息==========");
            return;
        }

        //注意该方法本身就有循环判断的逻辑,必须输出Y/N
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {//真的删除
            if (houseService.del(delId)) {
                System.out.println("=============删除房屋信息成功============");
            } else {
                System.out.println("=============编号不存在，删除失败============");
            }
        } else {
            System.out.println("=============放弃删除房屋信息============");
        }
    }


    //添加
    public void addHouse() {
        System.out.println("=============添加房屋===========");
        System.out.print("姓名:");
        String name = Utility.readString(8);
        System.out.print("电话:");
        String phone = Utility.readString(12);
        System.out.print("地址:");
        String address = Utility.readString(16);
        System.out.print("月租:");
        int rent = Utility.readInt();
        System.out.print("状态:");
        String state = Utility.readString(3);

        //创建一个House对象，注意id是系统分配的，用户不能输入
        House newHouse = new House(0, name, phone, address, rent, state);
        if (houseService.add(newHouse)) {
            System.out.println("=============添加房屋成功===========");
        } else {
            System.out.println("=============添加房屋失败===========");
        }
    }

    //根据id查找房屋信息
    public void findHouse() {
        System.out.println("=======查找房屋信息=======");
        System.out.print("请输入待查找房屋的编号(-1退出):");
        int findId = Utility.readInt();
        House house = houseService.findById(findId);
        if(house != null){
            System.out.println(house);
        }else{
            System.out.println("=======查找房屋信息不存在！=======");
        }

    }

    //根据id修改房屋信息
    public void updateHouse() {
        System.out.println("=======修改房屋信息=======");
        System.out.print("请输入待修改房屋的编号(-1退出):");
        int updateId = Utility.readInt();
        if(updateId == -1){
            System.out.println("=======放弃修改房屋信息=======");
            return;
        }

        House house = houseService.findById(updateId);
        if(house == null){
            System.out.println("=======要修改的房屋信息编号不存在！=======");
            return;
        }

        System.out.print("姓名("+ house.getName()+"):");
        String name = Utility.readString(8,house.getName());//这里如果用户直接回车表示不修改该信息,默认原来的
        house.setName(name);

        System.out.print("电话("+house.getPhone()+"):");
        String phone = Utility.readString(12,house.getPhone());
        house.setPhone(phone);

        System.out.print("地址("+house.getAddress()+"):");
        String address = Utility.readString(18, house.getAddress());
        house.setAddress(address);

        System.out.print("租金("+house.getRent()+"):");
        int rent = Utility.readInt(house.getRent());
        house.setRent(rent);

        System.out.print("状态("+house.getState()+"):");
        String state = Utility.readString(3, house.getState());
        house.setState(state);

        System.out.println("=======修改成功=======");

    }


    //显示房屋列表
    public void listHouses() {
        System.out.println("=============房屋列表============");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        House[] houses = houseService.list();//得到所有房屋信息
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                continue;
            }
            System.out.println(houses[i]);
        }

    }


    //完成退出确认
    public void exit() {
        //这里我们使用Utility提供方法，完成确认
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        }
    }

    public void mainMenu() {
        do {
            System.out.println("\n\t=========房屋出租系统菜单========");
            System.out.println("\t\t\t1新增房源");
            System.out.println("\t\t\t2查找房屋");
            System.out.println("\t\t\t3删除房屋信息");
            System.out.println("\t\t\t4修改房屋信息");
            System.out.println("\t\t\t5房屋列表");
            System.out.println("\t\t\t6退出");
            System.out.print("请输入你的选择(1-6):");
            key = Utility.readChar();

            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    updateHouse();
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    exit();
                    break;
            }
        } while (loop);
    }

}
