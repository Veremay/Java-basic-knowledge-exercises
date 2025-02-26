package service;

import model.House;

/**
 * 业务层
 * 定义House[]，保存House对象
 * 1.响应HouseView的调用
 * 2.完成对房屋信息的各种操作（CRUD）
 */
public class HouseService {
    private House[] houses;//保存House对象
    private int houseNum = 1; //记录当前有多少个房屋信息
    private int idCounter = 1;//记录当前的id增长到哪个值

    // 构造器
    public HouseService(int size) {
        houses = new House[size];//当创建HouseService对象，指定数组大小
        // 为了配合测试列表信息，这里初始化一个House对象
        houses[0] = new House(1, "jack", "112", "海淀区", 2000, "未出租");
    }

    //add方法，添加新对象，返回boolean
    public boolean add(House newHouse) {
        //判断是否还可以继续添加(我们暂时不考虑数组扩容的问题)
        if (houseNum == houses.length) {
            System.out.println("已满，无法添加");
            return false;
        }

        houses[houseNum++] = newHouse; //注意是后++，相等于先赋值之后，再执行houseNum++

        newHouse.setId(++idCounter);
        return true;
    }

    //del方法，删除一个房屋信息
    public boolean del(int delId) {
        //应当先找到要删除的房屋信息对应的下标
        //一定要搞清楚下标和房屋的编号不是一回事
        int index = -1;
        for (int i = 0; i < houseNum; i++) {
            if (delId == houses[i].getId()) {//要删除的房屋(id),是数组下标为i的元素
                index = i;//就使用index记录i
            }
        }

        if (index == -1) {//说明delId在数组中不存在(有点绕..)
            return false;
        }
        //如果找到
        for (int i = index; i < houseNum - 1; i++) {
            houses[i] = houses[i + 1];
        }

        //把当有存在的房屋信息的最后一个 设置null
        houses[houseNum - 1] = null;
        houseNum--;
        return true;
    }

    //findById方法,返回House对象或者null
    public House findById(int findId) {
        //遍历数组
        for (int i = 0; i < houseNum; i++) {
            if (findId == houses[i].getId()) {
                return houses[i];
            }
        }
        return null;
    }

    //list方法，返回houses
    public House[] list() {
        return houses;
    }
}


