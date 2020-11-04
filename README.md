# designModel

设计模式学习

## 1.简单工厂模式

### 定义：
实质是由一个工厂类根据传入的参数，动态决定应该创建哪一个产品类（这些产品类继承自一个父类或接口）的实例。简单工厂模式的创建目标，所有创建的对象都是充当这个角色的某个具体类的实例。

### 模式结构：
![image](https://raw.githubusercontent.com/Blankwei/folder/master/simple_factory_uml.png)

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
![image](https://raw.githubusercontent.com/Blankwei/folder/master/method_factory_uml.jpg)

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

## 4.策略模式

### 定义：
是指，定义一组算法，并把其封装到一个对象中。然后在运行时，可以灵活的使用其中的一个算法。本模式使得算法可独立于使用它的客户而变化。

### 模式结构：（参考以下）
![Image](https://raw.githubusercontent.com/Blankwei/folder/master/strategy.png)


### 具体实例：
上下文切换
```
public class DiscountContext {

    // 持有某个策略
    private DiscountStrategy strategy;

    // 设置新策略
    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public void excute(BigDecimal total){
        System.out.println("金额：" + strategy.getPrice(total));
    }
}
```
抽象策略
```
public interface DiscountStrategy {

    // 满足于各种打折如八折、五折、一折、满减等活动
    // 计算打折后的价格
    BigDecimal getPrice(BigDecimal total);
}
```

具体策略：八折
```
public class BazheStrategy implements DiscountStrategy {

    @Override
    public BigDecimal getPrice(BigDecimal total) {
        System.out.println("此次账单打八折：");
        // 设置八折并四舍五入保留两位小数
        return total.multiply(new BigDecimal("0.8").setScale(2,RoundingMode.HALF_UP));
    }
}

```
具体策略：满减
```
public class FullDecrementStrategy implements DiscountStrategy{

    @Override
    public BigDecimal getPrice(BigDecimal total) {
        System.out.println("此次账单满200减20: ");
        // 满200减20
        return total.compareTo(BigDecimal.valueOf(200)) >= 0 ? total.subtract(BigDecimal.valueOf(20)).setScale(2) : total;
    }
}
```
创建一个测试函数
```
public class Main {

    public static void main(String[] args) {
        DiscountContext context = new DiscountContext();
        // 八折
        context.setStrategy(new BazheStrategy());
        context.excute(new BigDecimal(180));

        // 满减
        context.setStrategy(new FullDecrementStrategy());
        context.excute(new BigDecimal(250));
    }
}

```

## 5.单例模式

### 定义：
单例模式（Singleton）的目的是为了保证在一个进程中，某个类有且仅有一个实例。

### 单例模式的六种实现方式：
* 懒汉式
* 饿汉式
* 加锁的懒汉式
* 双重加锁懒汉式
* 内部静态类实现的懒汉式
* 枚举

### 具体实例：

#### 懒汉式：
```
public class LazySingleton {

    private static LazySingleton INSTANCE = null;

    /**
     * 私有构造方法(防止外部通过new创建对象)
     */
    private LazySingleton(){

    }

    /**
     * 懒汉式单例模式
     * @return
     */
    public static LazySingleton getInstance(){
        if(null == INSTANCE){
            // 当为空时 在类内部通过new创建实例
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }
}
```
#### 懒汉式优缺点以及适用场景：  
优点：单例对象是在应用需要时才去构造，可以提高应用的启动速度。  
缺点：不是*线程安全*的,多线程同时调用getInstance方法，有可能会生成多个单例对象。  
适用场景：单例对象功能复杂，占用内存大，对应用的启动速度有要求。  
不适用：多线程条件。  

#### 饿汉式：
```
public class HungrySingleton {

    private static HungrySingleton INSTANCE = new HungrySingleton();

    /**
     * 私有构造方法(防止外部通过new创建对象)
     */
    private HungrySingleton(){

    }

    /**
     * 饿汉式单例模式
     * @return
     */
    public static HungrySingleton getInstance(){
        return INSTANCE;
    }
}
```
#### 饿汉式优缺点以及适用场景：  
优点：简单方便。  
缺点：不管程序中是否使用到了单例对象，都会生成单例对象，并且由于静态对象是在类加载时就需要生成，会降低应用的启动速度。  
适用场景：类对象功能简单，占用内存小，使用频繁。  
不适用：类对象复杂，占用内存大，使用概率低。  

#### 同步方法的懒汉式：
```
public class SyncSingleton {

    private static SyncSingleton singleton;

    /**
     * 私有构造方法(防止外部通过new创建对象)
     */
    private SyncSingleton(){

    }

    /**
     * 带有同步方法的懒汉式单例
     * @return
     */
    public static synchronized SyncSingleton getInstance(){
        if(null == singleton){
            singleton = new SyncSingleton();
        }
        return singleton;
    }
}

```
#### 同步懒汉式优缺点以及适用场景：  
优点：同懒汉式。  
缺点：加锁有了额外的消耗。

#### 双重检查懒汉式：
```
public class DoubleCheckLockSingleton {

    private static DoubleCheckLockSingleton singleton = null;

    private static final Byte[] bytes = new Byte[0];

    /**
     * 私有构造方法(防止外部通过new创建对象)
     */
    private DoubleCheckLockSingleton(){

    }

    /**
     * 双重效验+锁模式
     * @return
     */
    public static DoubleCheckLockSingleton getInstance(){
        if(null == singleton){
            // 锁字节 提升效率
            synchronized(bytes){
                if(null == singleton){
                    singleton = new DoubleCheckLockSingleton();
                }
            }
        }
        return singleton;
    }
}
```
#### 双重检查懒汉式优缺点以及适用场景：  
优点：懒加载、线程安全、效率高。  
缺点：代码设计复杂。 

#### 静态内部类：
```
public class StaticInnerSingleton {

    /**
     * 私有构造方法(防止外部通过new创建对象)
     */
    private StaticInnerSingleton(){

    }

    /**
     * 内部静态类
     */
    private static class SingletonInstance{
        private static final StaticInnerSingleton SINGLETON = new StaticInnerSingleton();
    }

    /**
     * 内部静态实例获取
     * @return
     */
    public static StaticInnerSingleton getInstance(){
        return SingletonInstance.SINGLETON;
    }
}

```
#### 静态内部类优缺点以及适用场景：  
优点：实现简单、懒加载、线程安全。  

#### 枚举类：
```
public enum EnumSingleton {

    /**
     * 枚举实例
     */
    SINGLETON
}
```
#### 枚举类优缺点以及适用场景：  
优点：线程安全，不担心序列化和反射问题。  
缺点：枚举占用的内存会多一点。

## 6.原型模式

### 定义：
是用于创建重复的对象，同时又能保证性能。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。

### 模式结构：（参考以下）
![Image](https://raw.githubusercontent.com/Blankwei/folder/master/propotype.jpg)


### 具体实例：
创建一个实现了 Cloneable 接口的抽象类
```
public abstract class ClassInfo implements Cloneable{

    private String id;

    protected String classType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassType(){
        return classType;
    }

    abstract void print();

    @Override
    public Object clone(){
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
```
创建扩展实体类
```
/**
 * Author: created by savoidage
 * CreateTime: 2020-08-14 15:49
 * Description: 智慧班
 */
@Slf4j
public class WisdomClass extends ClassInfo {

    public WisdomClass(){
        classType = "wisdom";
    }

    @Override
    public void print() {
        log.info("excute wisdom::print() method...");
    }

}
```
```
/**
 * Author: created by savoidage
 * CreateTime: 2020-08-14 15:52
 * Description: 长期班
 */
@Slf4j
public class LongTermClass extends ClassInfo{

    public LongTermClass(){
        classType = "long-term";
    }

    @Override
    public void print() {
        log.info("excute longTerm::print() method...");
    }
}
```
创建一个类，把扩展类存储至Hashtable中
```
public class ClassInfoPrototype {

    private static Hashtable<String,ClassInfo> classInfoHashtable = new Hashtable<>();

    public static ClassInfo getClassInfo(String id){
        ClassInfo classInfo = classInfoHashtable.get(id);
        return (ClassInfo) classInfo.clone();
    }

    // 默认添加班级类型
    public static void loadCache(){
        WisdomClass wisdomClass = new WisdomClass();
        wisdomClass.setId("1");
        classInfoHashtable.put(wisdomClass.getId(),wisdomClass);

        LongTermClass longTermClass = new LongTermClass();
        longTermClass.setId("2");
        classInfoHashtable.put(longTermClass.getId(),longTermClass);
    }
}
```
创建一个测试函数
```
@Slf4j
public class Main {

    public static void main(String[] args) {
        // 加载数据
        ClassInfoPrototype.loadCache();

        ClassInfo wisdomClassInfo = ClassInfoPrototype.getClassInfo("1");
        log.info("classInfo: " + wisdomClassInfo.getClassType());

        ClassInfo longTermClassInfo = ClassInfoPrototype.getClassInfo("2");
        log.info("classInfo: " + longTermClassInfo.getClassType());
    }
}
```
打印结果:
```
16:29:47.747 [main] INFO com.savoidage.designmodel.prototype.example.Main - classInfo: wisdom
16:29:47.761 [main] INFO com.savoidage.designmodel.prototype.example.Main - classInfo: long-term
```


## 7.观察者模式

### 定义：
定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。

### 模式结构：（参考以下）
![Image](https://raw.githubusercontent.com/Blankwei/folder/master/oberver.jpg)


### 具体实例：
创建一个subject类
```
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    // 添加observer
    public void attach(Observer observer) {
        observers.add(observer);
    }

    // 通知所有observer
    public void notifyAllObservers() {
        observers.forEach(Observer::update);
    }
}

```
创建扩展Observer类
```
public abstract class Observer {

    protected Subject subject;

    public abstract void update();
}
```
创建具体被观察者类实现抽象observer
```
@Slf4j
public class Service1Observer extends Observer {

    public Service1Observer(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        log.info("Service1Observer : " + subject.getState());
    }
}
```
创建一个测试函数
```
public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new Service1Observer(subject);
        new Service2Observer(subject);
        new Service3Observer(subject);

        System.out.println("state being setted: 11");
        subject.setState(11);

        System.out.println("then state being changed: 13");
        subject.setState(13);

    }
}

```

## 8.代理模式

### 定义：
由于某些原因需要给某对象提供一个代理以控制对该对象的访问。这时，访问对象不适合或者不能直接引用目标对象，代理对象作为访问对象和目标对象之间的中介。
### 模式结构：（参考以下）
![Image](https://raw.githubusercontent.com/Blankwei/folder/master/proxy.gif)


### 具体实例：
创建一个Image接口
```
public interface Image {

    void display();
}

```
创建RealImage类继承image接口
```
public class RealImage implements Image{

    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);
    }
}

```
创建ProxyImage类
```
public class ProxyImage implements Image{

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

```
创建一个测试函数
```
public class Main {

    public static void main(String[] args) {
        Image image = new ProxyImage("1111.jpg");

        // 图像将从磁盘加载
        image.display();
        System.out.println("");
        // 图像不需要从磁盘加载
        image.display();
    }
}

```

输出结果

```
Loading 1111.jpg
Displaying t1111.jpg

Displaying 1111.jpg

```

## 9.状态模式

### 定义：
当一个对象的内在状态改变时允许改变其行为，这个对象看起来像是改变了其类。
### 模式结构：（参考以下）
![Image](https://raw.githubusercontent.com/Blankwei/folder/master/)


### 具体实例：
创建一个state抽象类
```
public abstract class State {

    /**
     * 提交审核
     *
     * @param invoiceOrderId 发货单id
     * @param currentStatus  当前状态
     * @return 返回模组结果
     */
    public abstract ResultModel editCheck(Integer invoiceOrderId, Enum<Status> currentStatus);

    /**
     * 审核通过
     *
     * @param invoiceOrderId 发货单id
     * @param currentStatus  当前状态
     * @return 返回模组结果
     */
    public abstract ResultModel checkPass(Integer invoiceOrderId, Enum<Status> currentStatus);

    /**
     * 审核拒绝
     *
     * @param invoiceOrderId 发货单id
     * @param currentStatus  当前状态
     * @return 返回模组结果
     */
    public abstract ResultModel checkRefuse(Integer invoiceOrderId, Enum<Status> currentStatus);

    /**
     * 审核通过后取消
     *
     * @param invoiceOrderId 发货单id
     * @param currentStatus  当前状态
     * @return 返回模组结果
     */
    public abstract ResultModel passCancel(Integer invoiceOrderId, Enum<Status> currentStatus);

    /**
     * 审核拒绝后取消
     *
     * @param invoiceOrderId 发货单id
     * @param currentStatus  当前状态
     * @return 返回模组结果
     */
    public abstract ResultModel refuseCancel(Integer invoiceOrderId, Enum<Status> currentStatus);

    /**
     * 编辑取消
     *
     * @param invoiceOrderId 发货单id
     * @param currentStatus  当前状态
     * @return 返回模组结果
     */
    public abstract ResultModel editCancel(Integer invoiceOrderId, Enum<Status> currentStatus);
}


```
创建具体类继承自state并实现其方法
```
public class CheckState extends State {

    @Override
    public ResultModel editCheck(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return new ResultModel("0000","待审核状态不可重复提审");
    }

    @Override
    public ResultModel checkPass(Integer invoiceOrderId, Enum<Status> currentStatus) {
        InvoiceOrderService.changeStatus(invoiceOrderId,currentStatus,Status.Pass);
        return new ResultModel("0000","发货单审核状态完成");
    }

    @Override
    public ResultModel checkRefuse(Integer invoiceOrderId, Enum<Status> currentStatus) {
        InvoiceOrderService.changeStatus(invoiceOrderId,currentStatus,Status.Refuse);
        return new ResultModel("0000","发货单审核被拒绝");
    }

    @Override
    public ResultModel passCancel(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return new ResultModel("0000","未审核通过不可取消");
    }

    @Override
    public ResultModel refuseCancel(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return new ResultModel("0000","未拒绝审核不可取消");
    }

    @Override
    public ResultModel editCancel(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return new ResultModel("0000","未拒绝审核不可取消");
    }
}

```
提供具体逻辑处理类
```
public class InvoiceOrderService {

    private static Map<String, Enum<Status>> statusMap = new ConcurrentHashMap<>();

    public static void init(Integer invoiceOrderId, Enum<Status> status) {
        // 模拟查询发货单信息
        InvoiceOrderInfo invoiceOrderInfo = new InvoiceOrderInfo();
        invoiceOrderInfo.setInvoiceOrderId(invoiceOrderId);
        invoiceOrderInfo.setInvoiceOrderName("深圳发往杭州货件");
        invoiceOrderInfo.setStatus(status);
        invoiceOrderInfo.setCreateDate(new Date());
        invoiceOrderInfo.setUpdateDate(new Date());
        statusMap.put(String.valueOf(invoiceOrderId), status);
    }

    /**
     * 查询发货单信息
     *
     * @param invoiceOrderId 发货单id
     * @return 查询结果
     */
    public static InvoiceOrderInfo queryInvoiceOrderInfo(Integer invoiceOrderId) {
        // 模拟查询发货单信息
        InvoiceOrderInfo invoiceOrderInfo = new InvoiceOrderInfo();
        invoiceOrderInfo.setInvoiceOrderId(invoiceOrderId);
        invoiceOrderInfo.setInvoiceOrderName("深圳发往杭州货件");
        invoiceOrderInfo.setStatus(statusMap.get(invoiceOrderId.toString()));
        invoiceOrderInfo.setCreateDate(new Date());
        invoiceOrderInfo.setUpdateDate(new Date());
        return invoiceOrderInfo;
    }

    /**
     * 变更状态
     *
     * @param invoiceOrderId 发货单id
     * @param beforeStatus   变更前状态
     * @param afterStatus    变更后状态
     */
    public static synchronized void changeStatus(Integer invoiceOrderId, Enum<Status> beforeStatus, Enum<Status> afterStatus) {
        if (!beforeStatus.equals(statusMap.get(invoiceOrderId.toString()))) {
            return;
        }
        statusMap.put(invoiceOrderId.toString(), afterStatus);
    }
}
```
创建一个状态控制器用于统一处理各种状态的流转控制
```
public class StateHandler {

    private Map<Enum<Status>,State> stateMap = new ConcurrentHashMap<>();

    public StateHandler(){
        stateMap.put(Status.Editing,new EditingState()); // 创建/编辑
        stateMap.put(Status.Check,new CheckState()); // 待审核
        stateMap.put(Status.Pass,new PassState()); // 审核通过
        stateMap.put(Status.Refuse,new RefuseState()); // 审核被拒绝
    }

    public ResultModel editCheck(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).editCheck(invoiceOrderId,currentStatus);
    }

    public ResultModel editCancel(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).editCancel(invoiceOrderId,currentStatus);
    }

    public ResultModel checkPass(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).checkPass(invoiceOrderId,currentStatus);
    }

    public ResultModel checkRefuse(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).checkRefuse(invoiceOrderId,currentStatus);
    }

    public ResultModel passCancel(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).passCancel(invoiceOrderId,currentStatus);
    }

    public ResultModel refuseCancel(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).refuseCancel(invoiceOrderId,currentStatus);
    }
}

```
创建一个测试函数
```
@Slf4j
public class Main {
//    public static void main(String[] args) {
//        // 初始化数据
//        Integer invoiceOrderId = 100001;
//        InvoiceOrderService.init(invoiceOrderId,Status.Editing);
//
//        InvoiceOrderChangeStatusController controller = new InvoiceOrderChangeStatusController();
//        ResultModel resultModel = controller.changeStatus(invoiceOrderId, Status.Editing, Status.Check);
//        log.info("测试结果(创建/编辑中To审核中)：{}",JSON.toJSONString(resultModel));
//
//        ResultModel model = controller.changeStatus(invoiceOrderId, Status.Editing, Status.Pass);
//        log.info("测试结果(创建/编辑中To审核通过)：{}",JSON.toJSONString(model));
//    }

    public static void main(String[] args) {
        // 初始化数据
        Integer invoiceOrderId1 = 100001;
        InvoiceOrderService.init(invoiceOrderId1,Status.Editing);

        StateHandler handler1 = new StateHandler();
        ResultModel model1 = handler1.editCheck(invoiceOrderId1, Status.Editing);

        log.info("测试结果(编辑中To待审核)：{}", JSON.toJSONString(model1));
        log.info("活动信息：{} 状态：{}", JSON.toJSONString(InvoiceOrderService.queryInvoiceOrderInfo(invoiceOrderId1)), JSON.toJSONString(InvoiceOrderService.queryInvoiceOrderInfo(invoiceOrderId1).getStatus()));


        // 初始化数据
        Integer invoiceOrderId2 = 100002;
        InvoiceOrderService.init(invoiceOrderId2,Status.Check);

        StateHandler handler2 = new StateHandler();
        ResultModel model2 = handler2.checkPass(invoiceOrderId2, Status.Check);

        log.info("测试结果(待审核To审核通过)：{}", JSON.toJSONString(model2));
        log.info("活动信息：{} 状态：{}", JSON.toJSONString(InvoiceOrderService.queryInvoiceOrderInfo(invoiceOrderId2)), JSON.toJSONString(InvoiceOrderService.queryInvoiceOrderInfo(invoiceOrderId2).getStatus()));

        Integer invoiceOrderId3 = 100003;
        InvoiceOrderService.init(invoiceOrderId3,Status.Pass);

        StateHandler handler3 = new StateHandler();
        ResultModel model3 = handler3.passCancel(invoiceOrderId3, Status.Pass);

        log.info("测试结果(审核通过To取消)：{}", JSON.toJSONString(model3));
        log.info("活动信息：{} 状态：{}", JSON.toJSONString(InvoiceOrderService.queryInvoiceOrderInfo(invoiceOrderId3)), JSON.toJSONString(InvoiceOrderService.queryInvoiceOrderInfo(invoiceOrderId3).getStatus()));
    }
}


```

输出结果

```
15:10:47.763 [main] INFO com.savoidage.designmodel.status.example.Main - 测试结果(编辑中To待审核)：{"code":"0000","message":"待审核状态更改成功"}
15:10:47.771 [main] INFO com.savoidage.designmodel.status.example.Main - 活动信息：{"createDate":1604473847766,"invoiceOrderId":100001,"invoiceOrderName":"深圳发往杭州货件","status":"Check","updateDate":1604473847766} 状态："Check"
15:10:47.772 [main] INFO com.savoidage.designmodel.status.example.Main - 测试结果(待审核To审核通过)：{"code":"0000","message":"发货单审核状态完成"}
15:10:47.772 [main] INFO com.savoidage.designmodel.status.example.Main - 活动信息：{"createDate":1604473847772,"invoiceOrderId":100002,"invoiceOrderName":"深圳发往杭州货件","status":"Pass","updateDate":1604473847772} 状态："Pass"
15:10:47.772 [main] INFO com.savoidage.designmodel.status.example.Main - 测试结果(审核通过To取消)：{"code":"0000","message":"状态取消成功"}
15:10:47.772 [main] INFO com.savoidage.designmodel.status.example.Main - 活动信息：{"createDate":1604473847772,"invoiceOrderId":100003,"invoiceOrderName":"深圳发往杭州货件","status":"cancel","updateDate":1604473847772} 状态："cancel"
```