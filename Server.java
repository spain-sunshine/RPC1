// 创建一个服务端程序，将远程对象绑定到RMI注册表
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args){
        try{
            // 创建RMI注册表，指定端口号
            LocateRegistry.createRegistry(1099);

            // 创建远程对象实例
            Calculator calculator = new CalculatorImpl();

            // 绑定远程对象到RMI注册表
            Naming.rebind("CalculatorService",calculator);

            System.out.println("Service is ready...");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
