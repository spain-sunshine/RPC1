// 创建一个接口，定义要在远程服务器上调用的方法
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote{
    int add(int a, int b) throws RemoteException;
}