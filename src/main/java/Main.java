import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;

import com.codecool.shop.controller.ProductController;
import com.codecool.shop.dao.*;
import com.codecool.shop.dao.implementation.*;
import com.codecool.shop.model.*;
import spark.Request;
import spark.Response;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

public class Main {

    public static void main(String[] args) {

        // default server settings
        exception(Exception.class, (e, req, res) -> e.printStackTrace());
        staticFileLocation("/public");
        port(8888);

        // populate some data for the memory storage
        populateData();

        // Always start with more specific routes
        get("/hello", (req, res) -> "Hello World");

        // Always add generic routes to the end
        get("/", ProductController::renderProducts, new ThymeleafTemplateEngine());
        // Equivalent with above
        get("/index", (Request req, Response res) -> {
           return new ThymeleafTemplateEngine().render( ProductController.renderProducts(req, res) );
        });

        // Add this line to your project to enable the debug screen
        enableDebugScreen();
    }

    public static void populateData() {

        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        //setting up a new supplier
        Supplier amazon = new Supplier("Amazon", "Digital content and services");
        supplierDataStore.add(amazon);
        Supplier lenovo = new Supplier("Lenovo", "Computers");
        supplierDataStore.add(lenovo);

        //setting up a new product category
        ProductCategory tablet = new ProductCategory("Tablet", "Hardware", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        productCategoryDataStore.add(tablet);

        //setting up products and printing it
        //Tablet
        productDataStore.add(new Product("Amazon Fire", 49.9f, "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", tablet, amazon));
        productDataStore.add(new Product("Lenovo IdeaPad Miix 700", 479, "USD", "Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.", tablet, lenovo));
        productDataStore.add(new Product("Amazon Fire HD 8", 89, "USD", "Amazon's latest Fire HD 8 tablet is a great value for media consumption.", tablet, amazon));
        //Phone
        productDataStore.add(new Product("ASUS ZenFone 3 MAX ZC520TL Mobiltelefon", 202.46f, "USD", "Dual SIM, 32GB, LTE, Silver", phone, asus));
        productDataStore.add(new Product("Lenovo A2010", 83.57f, "USD", "Dual SIM, 8GB, LTE, Black", phone, lenovo));
        productDataStore.add(new Product("Nokia 3310", 10, "USD", "You can play snake on it, Blue", phone, nokia));
        //Laptop
        productDataStore.add(new Product("Acer Aspire ES1-571-370P laptop", 384.29f, "USD", "ntel® Core™ i3-5005U 2.00 GHz, 4GB DDR3, 1TB, Intel® HD 5500, Linux®", laptop, acer));
        productDataStore.add(new Product("Asus Transformer Mini T102HA-GR022T laptop", 506.68f, "USD", "Intel® Atom™ x5-Z8350 1.44 GHz, HD, 4GB DDR3, 128GB SSD, Intel® HD, Microsoft® Windows® 10 Home", laptop, asus));
        productDataStore.add(new Product("Lenovo 110-15IBR laptop", 244.42f, "USD", " Intel® Celeron N3060 1.6GHz, HD, 2GB, 500GB, Intel HD Graphics, Free Dos", laptop, lenovo));
        //PC
        productDataStore.add(new Product("Acer M2-601", 384.29f, "USD", "Intel® Core™ i3 6100U 2.30GHz, Skylake™, 8GB, 128 GB SSD, Intel® HD Graphics, Free DOS, Black", pc, acer));
        productDataStore.add(new Product("ASUS K31CD-RO021D", 506.68f, "USD", "Intel® Core™ i3-6100 3.70GHz, Skylake™, 4GB, 1TB, DVD-RW, nVIDIA GeForce GT 730 2GB, Free DOS, Black", pc, asus));
        productDataStore.add(new Product("Lenovo IdeaCentre 300-20ISH MT", 400, "USD", "Intel® Core™ i3-6100 3.7GHz, Skylake™, 8GB, 1TB, DVD-RW, nVidia GT730 2GB, Free DOS, Black", pc, lenovo));
        //Monitor
        productDataStore.add(new Product("Samsung LS24F350FH LED monitor", 150.01f, "USD", "24\", Full HD, D-Sub, HDMI, Fekete", monitor, samsung));
        productDataStore.add(new Product("Philips 276E6ADSS/00 LED IPS-ADS monitor", 219.95f, "USD", "27\", Full HD, DVI, HDMI, Black", monitor, philips));
        productDataStore.add(new Product("LG 24UD58-B gaming LED monitor", 324.85f, "USD", "24\", Ultra HD, 4K, FreeSync, HDMI, Display port, Black", monitor, lg));
        //Accessories
        productDataStore.add(new Product("Trust ClassicLine", 6.96f, "USD", "Hungarian layout", accessories, trust));
        productDataStore.add(new Product("HAMA Urage Reaper NXT gaming mouse", 24.44f, "USD", "Black with led", accessories, hama));
        productDataStore.add(new Product("Maxtor M3 portable mass storage", 69.59f, "USD", "1 TB, 2.5\", USB 3.0, Black", accessories, maxtor));

    }


}
