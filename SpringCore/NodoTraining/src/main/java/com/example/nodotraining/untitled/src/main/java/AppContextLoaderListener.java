import org.springframework.web.context.ContextLoaderListener;

public class AppContextLoaderListener extends ContextLoaderListener {
    @Override
    public void contextDestroyed(javax.servlet.ServletContextEvent event) {
        System.out.println("================> dang khoi tao ung dung");
    }

    @Override
    public void contextInitialized(javax.servlet.ServletContextEvent event) {
        System.out.println("================> da khoi tao ung dung");
    }
}
