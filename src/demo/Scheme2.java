package demo;

public class Scheme2 {

    /**
     * 个人更推荐方案2
     * **/
    private static class InstanceHolder {
        public static Scheme2 instance = new Scheme2();
    }

    /***
     * 此方案是允许其 重排序但不允许非构造线程 "看到"重排序 也就是如同 Scheme1 中的 1 2 3 步都执行完了才清楚instance是否为null
     * */
    public static Scheme2 getInstance() {
        return InstanceHolder.instance;
    }
}
