import java.rmi.Naming;

public class Client {
    public static void main(String[] args){
        try{
            // 查找远程对象
            Calculator calculator = (Calculator) Naming.lookup("rmi://localhost/CalculatorService");

            //调用远程方法
            int result = calculator.add(6, 3);
            System.out.println("Result:" + result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
