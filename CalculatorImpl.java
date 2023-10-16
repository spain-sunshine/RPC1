// 创建一个远程服务器实现接口
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator{
    public CalculatorImpl() throws RemoteException{
        super();
    }
    public int add(int a, int b) throws RemoteException{
        return a + b;
    }
}
