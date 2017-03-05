package demo;

public class Scheme1 {

    /**
     * volatile 关键字是限定所修饰的变量不适用本地内存,而是直接刷到主存来达到同步效果
     * */
    private volatile static Scheme1 instance;

    public static Scheme1 getInstance() {

        if (instance != null) { // 第一次检查

            synchronized (Scheme1.class) { // 锁

                if (instance != null) { // 第二次检查
                    /**
                     * 问题的根源出现在于此
                     * 如果a,b两个线程同时来访问此方法会出现a正在创建实例化此对象 而b就读到instance不为null了
                     * 不禁问为什么会出现这种情况呢?
                     * 其实在创建对象的时候会执行三步
                     * 1.分配对象的内存空间
                     * 2.初始化对象
                     * 3.将刚刚分配好的内存地址指给instance
                     * 以上三步中2,3步并没有依赖性 则系统可能会进行重排序 导致 执行数据 变为 1 3 2
                     * 那么当a线程进来的时候创建实例化过程执行第三步,其实并没有完成初始化 而b进程就跳过了if (instance != null)的判断了
                     * 那么如何避免呢?
                     * 1.本类使用基于 volatile 的解决方案
                     * 限制 其执行顺序
                     **/
                    instance = new Scheme1();
                }

            }

        }
        return instance;
    }

}