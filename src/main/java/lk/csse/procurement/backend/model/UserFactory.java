package lk.csse.procurement.backend.model;

public class UserFactory {
    public User createUsers(String channel)
    {
        if (channel == null || channel.isEmpty())
            return null;
        if ("MANAGER".equals(channel)) {
            return new Manager();
        }
        else if ("SITEMANAGER".equals(channel)) {
            return new SiteManager();
        }
        else if ("SUPPLIER".equals(channel)) {
            return new Supplier();
        }
        return null;
    }
}
