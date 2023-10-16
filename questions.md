# java rpc1
简单的加法

## 启动server
## 启动client

## 问题
** 问题1. **：public CalculatorImpl() throws RemoteException 

** 答案 ** ：这是 CalculatorImpl 类的构造函数。构造函数在对象创建时被调用。构造函数声明了可能会抛出 RemoteException 异常，这是因为远程对象的创建可能涉及到网络通信，而网络通信可能会引发异常。

** 问题2. **：super();

**答案 **：super() 调用了父类 UnicastRemoteObject 的构造函数。这是必要的，因为 UnicastRemoteObject 类的构造函数可能会执行一些初始化工作，以便将 CalculatorImpl 对象暴露为远程对象。这一行代码确保了正确的初始化。

** 问题2. **：不继承UnicastRemoteObject可以吗，直接implements

**答案 **：当然可以，但如果你不继承 UnicastRemoteObject，则需要手动导出对象（即手动将对象准备好供远程访问）。这通常是通过使用 UnicastRemoteObject.exportObject() 方法来完成的。

```
//Manually export the server object
Calculator stub = (Calculator) UnicastRemoteObject.
exportObject(server, 0);
```

** 问题3. **:stub

**答案 **：

"Stub" 在远程方法调用（Remote Method Invocation，RMI）中是一个非常重要的概念。简而言之，它是客户端的代理，用于代表远程服务对象。

当我们在客户端上进行远程方法调用时，实际上是在调用Stub对象的方法。Stub对象负责将这些方法调用转换为网络请求，然后发送到远程服务器。一旦服务器处理了这个请求并返回了结果，Stub对象再将这个结果转换回方法调用的返回值，返回给客户端代码。

以下是Stub在RMI中的作用：

序列化参数：当你在客户端上调用一个远程方法并传递参数时，这些参数必须转换为可以通过网络发送的格式。这个转换过程称为序列化。Stub负责序列化方法调用的参数。

网络通信：Stub知道如何通过网络与远程服务器通信。它将序列化后的方法调用请求发送到远程服务器，并等待服务器的响应。

反序列化返回值：一旦服务器处理了方法调用并返回了结果，Stub负责将这个结果（通常是以序列化形式的）转换回方法调用的返回值或异常。这个转换过程称为反序列化。

在Java RMI中，Stub是自动生成的。当你编译和运行RMI服务器时，RMI系统会自动为你的远程对象生成一个Stub类。客户端代码使用这个Stub类与远程服务器通信。

与Stub相对的是另一个组件，称为"Skeleton"，它存在于服务器端。Skeleton负责接收来自Stub的请求、反序列化参数、调用实际的远程对象方法、然后序列化并返回结果。但在现代Java RMI实现中，Skeleton的概念已经不再显式存在，因为这些功能都被整合到了远程对象的实现中。