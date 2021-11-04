import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.spi.CachingProvider;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;

@WebServlet(value = "/hang", loadOnStartup = 1)
public class HangServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        System.out.println("Init " + getClass());
        printCacheManagers(System.out);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printCacheManagers(new PrintStream(resp.getOutputStream()));
    }

    public void printCacheManagers(PrintStream out) {
        for(final CachingProvider provider : Caching.getCachingProviders()) {
            final CacheManager manager = provider.getCacheManager();
            out.println("Got CacheManager " + manager);
        }
    }
}
