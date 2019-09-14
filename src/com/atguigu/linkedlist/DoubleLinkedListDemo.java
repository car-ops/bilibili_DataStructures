package com.atguigu.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表的一个测试");
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.add(hero1);
//        doubleLinkedList.add(hero2);
//        doubleLinkedList.add(hero3);
//        doubleLinkedList.add(hero4);

        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero3);

        doubleLinkedList.list();

        //修改测试
        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表情况");
        doubleLinkedList.list();

        //测试删除
        doubleLinkedList.del(3);
        System.out.println("删除后的链表情况");
        doubleLinkedList.list();
    }

}

//创建一个双向链表的类
class DoubleLinkedList {
    //先初始化一个头节点，头节点不要动,不存放具体的数据
    private HeroNode2 head = new HeroNode2(0,"","");

    //返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    //遍历双向链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //添加一个节点到双向链表最后
    public void add(HeroNode2 heroNode) {
        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode2 temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp指向了链表的最后
        //形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //修改一个节点的内容，可以看到双向链表的修改和单向链表一样
    //只是节点的类型改成了heroNode2
    public void update(HeroNode2 newHeroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no
        //定义一个辅助变量
        HeroNode2 temp = head.next;
        boolean flag = false;//是否找到该节点
        while (true) {
            if (temp == null) {
                break;//已经遍历完链表
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到编号为%d的节点，不能修改/n", newHeroNode.no);
        }
    }

    //从双向链表中删除一个节点
    //说明
    //1对于双向链表，我们可以直接找到要删除的这个节点
    //2找到后，自我删除即可
    public void del(int no) {
        //判断当前链表是否为空
        if (head.next == null) {//空链表
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode2 temp = head.next;//辅助变量
        boolean flag = false;//是否找到待删除节点
        while (true) {
            if (temp == null) {//已经到链表的最后节点的next
                break;
            }
            if (temp.no == no) {
                //找到待删除节点的前一个节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag == true) {
            temp.pre.next = temp.next;
            //这里我们的代码有问题
            //如果是最后一个节点，就不需要执行下面这句话，否则出现空指针异常
            //temp.next = null(temp为最后一个节点)
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除的%d节点不存在", no);
        }
    }

    //双向链表按顺序加入
    public void addByOrder(HeroNode2 heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针（变量）来帮助找到添加的位置
        //因为单链表，因此我们找的temp是位于添加位置的前一个节点，否则加不进去
        HeroNode2 temp = head;
        boolean flag = false;//标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) {//说明到了链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) {//位置找到，就在temp的后面插入
                break;
                //heroNode.next = temp.next;
                //temp.next = heroNode;
            } else if (temp.next.no == heroNode.no) {//说明添加的编号已然存在
                flag = true;
                break;
            }
            temp = temp.next;//后移，遍历当前链表
        }
        //判断flag的值
        if (flag) {
            System.out.printf("准备插入的英雄的编号%d已经存在了，不能加入\n",heroNode.no);
        } else {
            //插入到链表中,temp
            heroNode.pre = temp;
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

}

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;//指向下一个节点，默认为空
    public HeroNode2 pre;//指向前一个节点，默认为空

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode [no="+ no +", name =" +name + "nickname="+ nickname+"]";
    }
}
