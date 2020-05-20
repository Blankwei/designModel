# designModel

设计模式学习

## 1.简单工厂模式

### 定义：
实质是由一个工厂类根据传入的参数，动态决定应该创建哪一个产品类（这些产品类继承自一个父类或接口）的实例。简单工厂模式的创建目标，所有创建的对象都是充当这个角色的某个具体类的实例。

### 模式结构：
![Image text] (https://raw.githubusercontent.com/Blankwei/folder/master/simple_factory_uml.png)

### 具体实例：
创建父类
```
public abstract class Monitor {

    protected String name;

    /**
     * 生产方法
     */
    public void produce(){
        System.out.println("生产了" + name + "显示器");
    }
}
```
创建具体具体子类
```
public class PCMonitor extends Monitor {

    public PCMonitor(){
        this.name = "PC：电脑";
    }
}
```

创建一个简单工厂类
```
public class MonitorFactory {
    public Monitor createMonitor(String type){
        Monitor monitor = null;
        switch (type){
            // pc
            case "pc":
                monitor = new PCMonitor();
                break;
            // ipad
            case "ipad":
                monitor = new IpadMonitor();
                break;
            // tele
            case "tele":
                monitor = new TelevisionMonitor();
                break;
            default:
                // 默认pc
                monitor = new PCMonitor();
        }
        return monitor;
    }
}
```
创建一个测试函数
```
public class Main {
    public static void main(String[] args) {
        MonitorFactory factory = new MonitorFactory();
        // 生产pc
        Monitor monitor = factory.createMonitor("pc");
        monitor.produce();
        // 生产ipad 
        factory.createMonitor("ipad").produce();
    }
}
```

## 2.工厂方法模式

### 定义：
定义一个创建产品对象的工厂接口，将产品对象的实际创建工作推迟到具体子工厂类当中。这满足创建型模式中所要求的“创建与使用相分离”的特点。

### 模式结构：
![add image](https://raw.githubusercontent.com/Blankwei/folder/master/method_factory_uml.jpg)

工厂方法模式的主要角色如下：

* 抽象工厂（my Factory）：提供了创建产品的接口，调用者通过它访问具体工厂的工厂方法 createMonitor() 来创建产品。
* 具体工厂（IpadMonitorFactory）：主要是实现抽象工厂中的抽象方法，完成具体产品的创建。
* 抽象产品（Monitor）：定义了产品的规范，描述了产品的主要特性和功能。
* 具体产品（IpadMonitor）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间一一对应。


### 具体实例：
创建抽象工厂
```
public interface MyFactory {

    // 生产一个显示器
    Monitor createMonitor();
}
```
创建具体工厂
```
public class IpadMonitorFactory implements MyFactory {
    @Override
    public Monitor createMonitor() {
        return new IpadMonitor();
    }
}
```

创建一个抽象产品
```
public abstract class Monitor {

    protected String name;

    /**
     * 生产方法
     */
    public void produce(){
        System.out.println("生产了" + name + "显示器");
    }
}

```
创建一个具体产品
```
public class IpadMonitor extends Monitor{

    public IpadMonitor(){
        this.name = "Ipad：平板";
    }
}
```
创建一个测试函数
```
public class Main {

    // 工厂方法模式
    public static void main(String[] args) {
        // ipad工厂
        MyFactory factory = new IpadMonitorFactory();
        Monitor monitor = factory.createMonitor();
        monitor.produce();
    }
}
```

## 3.抽象工厂模式

### 定义：
是一种为访问类提供一个创建一组相关或相互依赖对象的接口，且访问类无须指定所要产品的具体类就能得到同族的不同等级的产品的模式结构。

### 模式结构：（参考以下）
![Image text]()

工厂方法模式的主要角色如下：

* 抽象工厂（AbstractFactory）：提供了创建产品的接口，调用者通过它访问具体工厂的工厂方法 createUser() 来创建产品。
* 具体工厂（MysqlFactory）：主要是实现抽象工厂中的抽象方法，完成具体产品的创建。
* 抽象产品（IUser）：定义了产品的规范，描述了产品的主要特性和功能。
* 具体产品（MysqlUser）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间一一对应。


### 具体实例：
创建抽象工厂
```
public interface AbstractFactory {

    IUser createUser();
}
```
创建具体工厂
```
public class MysqlFactory implements AbstractFactory {
    @Override
    public IUser createUser() {
        return new MysqlUser();
    }
}
```

创建一个抽象产品
```
public interface IUser {

    void insert(User user);

    User getUser(int id);
}
```
创建一个具体产品
```
public class MysqlUser implements IUser {

    @Override
    public void insert(User user) {
        System.out.println("mysql 中添加一条user记录");
    }

    @Override
    public User getUser(int id) {
        System.out.println("mysql 中获取user记录");
        return null;
    }
}
```
创建一个测试函数
```
public class Main {

    // 抽象工厂模式
    public static void main(String[] args) {
        User user = new User();
        AbstractFactory factory = new MysqlFactory();
        IUser iUser = factory.createUser();
        iUser.insert(user);
        iUser.getUser(1);

        factory = new OracleFactory();
        IUser user1 = factory.createUser();
        user1.insert(user);
        user1.getUser(1);
    }
}
```
