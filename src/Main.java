import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class Main {

    /***
     * 本例其实就是提供两个延迟加载的双重检查线程安全的单例模式
     * ps IDEA 真是太好用了
     * */
    public static void main(String[] args) {
//        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
//        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
//        for(ThreadInfo threadInfo:threadInfos) {
//            System.out.println("["+threadInfo.getThreadId()+"] "+ threadInfo.getThreadName());
//        }
    }
}
