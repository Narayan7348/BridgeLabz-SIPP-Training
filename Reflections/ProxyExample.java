import java.lang.reflect.*;

// Interface
interface Greeting {
    void sayHello(String name);
}

// Implementation
class GreetingImpl implements Greeting {
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}

// Logging Proxy
class LoggingHandler implements InvocationHandler {
    private Object target;

    public LoggingHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("LOG: Method called -> " + method.getName());
        return method.invoke(target, args);
    }
}

public class ProxyExample {
    public static void main(String[] args) {
        Greeting realObj = new GreetingImpl();

        Greeting proxy = (Greeting) Proxy.newProxyInstance(
            Greeting.class.getClassLoader(),
            new Class[]{Greeting.class},
            new LoggingHandler(realObj)
        );

        proxy.sayHello("Narayan"); // method call proxy ke through jayega
    }
}
