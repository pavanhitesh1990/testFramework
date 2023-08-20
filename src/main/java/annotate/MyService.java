package annotate;

public class MyService {
    @Page
    private static MyDependency myDependency;

    public void doSomething() {
        myDependency.doWork();
    }
}

